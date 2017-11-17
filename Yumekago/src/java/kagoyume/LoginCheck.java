/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ryokato
 */
@WebServlet(name = "LoginCheck", urlPatterns = {"/LoginCheck"})
public class LoginCheck extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        UserData ud = new UserData();
        //ログイン成功時のページ戻り処理
        String referer = String.valueOf(session.getAttribute("referer"));
        if (referer.equals("Login")) {
            referer = "top.jsp";
        }

        try {
            ud.setName(request.getParameter("name"));
            ud.setPassword(request.getParameter("password"));
            session.setAttribute("ud", ud);
            String name = ud.getName();
            boolean check = UserDataDAO.getInstance().Check(ud);
            if (check) {
                UserDataDTO udd = UserDataDAO.getInstance().Login(name);
                if (udd.getDeleteFlag() == 1) {
                    boolean delFlg = true;
                    request.setAttribute("delFlg", delFlg);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
                    session.removeAttribute("ud");
                    session.setAttribute("udd", udd);

                    //ログイン成功時のカート処理
                    String id = String.valueOf(udd.getUserID());
                    ArrayList<ShopBean> cart = new ArrayList();

                    if (session.getAttribute("cart" + id) != null) {
                        cart = (ArrayList) session.getAttribute("cart" + id);
                        if (session.getAttribute("cart") != null) {
                            ArrayList<ShopBean> addCart = (ArrayList) session.getAttribute("cart");
                            for (ShopBean good : addCart) {
                                cart.add(good);
                            }
                        }
                    } else if (session.getAttribute("cart") != null) {
                        cart = (ArrayList)session.getAttribute("cart");
                    } else {
                    }
                    session.setAttribute("cart" + id, cart);
                    session.removeAttribute("cart");
                }
                request.getRequestDispatcher(referer).forward(request, response);

                session.removeAttribute("referer");
            } else {
                boolean error = true;
                request.setAttribute("error", error);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
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
