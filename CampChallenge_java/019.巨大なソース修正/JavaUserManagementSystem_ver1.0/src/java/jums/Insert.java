package jums;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insert.jspと対応するサーブレット
 * @author hayashi-s
 */
public class Insert extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        session.setAttribute("ac", (int) (Math.random() * 1000));
        
        //インスタンス生成と同時に、sessionに保存したデータを再利用
        UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");

        //初期値nullの場合の入力欄非表示
        if (udb == null ){}
        else{
            if (udb.getName() == null){ udb.setName(""); }
            if (udb.getYear() == null){ udb.setYear("");}
            if (udb.getMonth() == null){ udb.setMonth("");}
            if (udb.getDay() == null){ udb.setDay("");}
            if (udb.getType() == null){ udb.setType(""); }
            if (udb.getTell() == null){ udb.setTell("");}
            if (udb.getComment() == null) { udb.setComment("");}           
        }

        
        session.setAttribute("udb", udb);
        
        request.getRequestDispatcher("/insert.jsp").forward(request, response);   
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
