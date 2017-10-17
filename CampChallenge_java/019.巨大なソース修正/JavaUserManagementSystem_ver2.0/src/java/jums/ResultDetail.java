package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class ResultDetail extends HttpServlet {

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
        
        //セッションスタート
        HttpSession session = request.getSession();
        
        try{
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更

            UserDataDTO resultData;
            
            //searchresult.jspから来た場合はセッションからデータ受け渡し
            if(request.getParameter("id") != null){
                //IDをページリンクに設定されたparameterから取得
                int id = Integer.parseInt(request.getParameter("id")); 
                //DTOオブジェクトにマッピング。DB専用のパラメータに変換
                UserDataDTO searchData = new UserDataDTO();
                searchData.setUserID(id);
                //検索データを検索メソッドに受け渡し、検索結果を取得
                resultData = UserDataDAO.getInstance().searchByID(searchData);
            } else {
                //delete.jspから来た場合はセッションからデータ受け渡し
                resultData = (UserDataDTO)session.getAttribute("resultData");
                     
            }
            //セッションに登録
            session.setAttribute("resultData", resultData);             
            //検索項目に入力したデータの保持のため、セッションからget後再度set
            UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
            session.setAttribute("udb", udb);
            
            request.getRequestDispatcher("/resultdetail.jsp").forward(request, response);  
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
