/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "RegistrationConfirm", urlPatterns = {"/RegistrationConfirm"})
public class RegistrationConfirm extends HttpServlet {

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
            
            //フォーム内容を格納
            UserData ud = new UserData();
            ud.setName(request.getParameter("name"));
            ud.setPassword(request.getParameter("password"));
            ud.setMail(request.getParameter("mail"));
            ud.setAdress(request.getParameter("address"));
            
            //セッションに登録
            session.setAttribute("ud", ud);
            
            try{
                //入力完了の場合は確認画面へ
                if(!(ud.getName().equals("")) && 
                        !(ud.getPassword().equals("")) &&
                        !(ud.getMail().equals("")) &&
                        !(ud.getAddress().equals(""))){
                    request.getRequestDispatcher("registrationconfirm.jsp").forward(request, response);
                }else{
                    //入力不備にある場合は再度入力画面へ、エラーメッセージ表示フラグON
                    boolean back = true;
                    request.setAttribute("back", back);
                    request.getRequestDispatcher("registration.jsp").forward(request, response);
                }
                    
            }catch(Exception e){
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
