/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.arnx.jsonic.JSON;

/**
 *
 * @author ryokato
 */
@WebServlet(name = "Item", urlPatterns = {"/Item"})
public class Item extends HttpServlet {

    String urlString = "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup?";
    String yID = "dj00aiZpPUpFdUx2eDJ6VjMwcCZzPWNvbnN1bWVyc2VjcmV0Jng9OWY-";
    String code;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        UserDataDTO udd = (UserDataDTO) session.getAttribute("udd");
        session.setAttribute("udd", udd);

        code = request.getParameter("code");

        if (code == null || code.equals("")) { //
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            String codeURL = urlString + "appid=" + yID + "&responsegroup=medium&itemcode=" + code;
            URL url = new URL(codeURL);
            HttpURLConnection urlCon = null;
            try {
                urlCon = (HttpURLConnection) url.openConnection();
                urlCon.setConnectTimeout(100000);
                urlCon.setReadTimeout(100000);
                urlCon.setRequestMethod("GET");
                urlCon.setDoOutput(false);
                urlCon.setDoInput(true);
                urlCon.connect();

                BufferedReader br = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));

                StringBuilder sb = new StringBuilder();

                while (true) {
                    String line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                }
                br.close();;
                urlCon.disconnect();

                String resJson = sb.toString();

                ShopBean good = new ShopBean();
                good = parse(resJson);
                session.setAttribute("good", good);
                request.getRequestDispatcher("item.jsp").forward(request, response);

            } catch (IOException e) {
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        }

    }

    private ShopBean parse(String jsonTxt) {

        Map<String, Map<String, Object>> json = JSON.decode(jsonTxt);

        //JSONテキストからデータを取得
        //データはShopBeanに格納、共通部分はresultとしてまとめる
        ShopBean good = new ShopBean();
        Map<String, Object> result
                = ((Map<String, Object>) ((Map<String, Map<String, Object>>) json.get("ResultSet").get("0")).get("Result").get("0"));
        good.setCode(result.get("Code").toString());
        good.setName(result.get("Name").toString());
        good.setScript(result.get("Description").toString());
        good.setPrice(((Map<String, Object>) result.get("Price")).get("_value").toString());
        good.setImgMd(((Map<String, Object>) result.get("Image")).get("Medium").toString());
        good.setReview(((Map<String, Object>) result.get("Review")).get("Rate").toString());
        good.setRevcnt(((Map<String, Object>) result.get("Review")).get("Count").toString());       
        return good;

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
