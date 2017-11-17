/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
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
@WebServlet(name = "Search", urlPatterns = {"/Search"})
public class Search extends HttpServlet {
    String urlString = "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch?";
    String yID = "dj00aiZpPUpFdUx2eDJ6VjMwcCZzPWNvbnN1bWVyc2VjcmV0Jng9OWY-";
    String search;

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
        
        try{
            request.setCharacterEncoding("UTF-8"); //リクエストパラメータの文字コードをUTF-8に変更
            search = request.getParameter("search");
            
            if(search == null || search.equals("")){ //
                request.setAttribute("error", true);
                request.getRequestDispatcher("search.jsp").forward(request, response);
            }else{ //
                String encoded = URLEncoder.encode(search, "UTF-8");
                String searchURL = urlString + "appid=" + yID + "&query=" + encoded;
                URL url = new URL(searchURL);
                HttpURLConnection urlCon = null;
                try{
                    urlCon = (HttpURLConnection)url.openConnection();
                    urlCon.setConnectTimeout(100000);
                    urlCon.setReadTimeout(100000);
                    urlCon.setRequestMethod("GET");
                    urlCon.setDoOutput(false);
                    urlCon.setDoInput(true);
                    urlCon.connect();
                    
                    BufferedReader br = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
                    
                    StringBuilder sb = new StringBuilder();
                    
                    while(true){
                        String line = br.readLine();
                        if(line == null){
                            break;
                        }
                        sb.append(line);
                    }
                    br.close();
                    urlCon.disconnect();
                    
                    String resJson = sb.toString();
                    
                    ArrayList<ShopBean> storeList = new ArrayList();
                    storeList = parse(resJson);
                    
                    request.setAttribute("search", search);
                    session.setAttribute("storeList", storeList);
                    request.getRequestDispatcher("search.jsp").forward(request, response);
                    
                }catch(IOException e){
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                
            }
            
            
        }catch(Exception e){
            
        }finally{
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
    
    private ArrayList<ShopBean> parse(String jsonTxt) {

        ArrayList<ShopBean> storeList = new ArrayList();

        Map<String, Map<String, Object>> json = JSON.decode(jsonTxt);
        
        if (!Integer.valueOf((String) json.get("ResultSet").get("totalResultsAvailable")).equals(0)) {

            for (int i = 0; i < 10; i++) {
                String s = String.valueOf(i);

                //JSONテキストからデータを取得
                //データはShopBeanに格納、共通部分はresultとしてまとめる
                ShopBean shop = new ShopBean();
                Map<String, Object> result = 
                        ((Map<String, Object>) ((Map<String, Map<String, Object>>) json.get("ResultSet").get("0")).get("Result").get(s));
                shop.setCode(result.get("Code").toString());
                shop.setName(result.get("Name").toString());
                shop.setScript(result.get("Description").toString());
                shop.setPrice(((Map<String, Object>) result.get("Price")).get("_value").toString());
                shop.setImgMd(((Map<String, Object>) result.get("Image")).get("Medium").toString());
                shop.setImgSm(((Map<String, Object>) result.get("Image")).get("Small").toString());
                storeList.add(shop);
            }

        }
        return storeList;
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
