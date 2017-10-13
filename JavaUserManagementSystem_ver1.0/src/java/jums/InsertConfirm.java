package jums;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insertconfirm.jspと対応するサーブレット
 * フォーム入力された情報はここでセッションに格納し、以降持ちまわることになる
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertConfirm extends HttpServlet {

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
        try{
            HttpSession session = request.getSession();
            request.setCharacterEncoding("UTF-8");//セッションに格納する文字コードをUTF-8に変更
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            
            //フォームからの入力を取得
            String name = request.getParameter("name");
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            String day = request.getParameter("day");
            String type = request.getParameter("type");
            String tell = request.getParameter("tell");
            String comment = request.getParameter("comment");
            boolean checked;
            String errMsg = "";
            
            //初期値nullの場合の入力欄非表示
            if (name == null){ name = ""; }
            if (year == null){ year = ""; }
            if (month == null){ month = ""; }
            if (day == null){ day = ""; }
            if (type == null){ type = ""; }
            if (tell == null){ tell = ""; }
            if (comment == null){ comment = "";}
            
            //JavaBeansに格納
            UserDataBeans udb = new UserDataBeans();
            udb.setName(name);
            udb.setYear(year);
            udb.setMonth(month);
            udb.setDay(day);
            udb.setType(type);
            udb.setTell(tell);
            udb.setComment(comment);
            
            //入力されたデータのチェック、エラーメッセージ生成
            if(!udb.getName().equals("")
                && !(udb.getYear().equals(""))
                && !(udb.getMonth().equals(""))
                && !(udb.getDay().equals(""))
                && !(udb.getType().equals(""))
                && !(udb.getTell().equals(""))
                && !(udb.getComment().equals(""))) {
                checked = true;
            } else {
                checked = false;
                if (udb.getName().equals("") || udb.getName() == null){
                    errMsg += "名前、";
                }
                if (udb.getYear().equals("") || udb.getYear() == null){
                    errMsg += "年度、";
                }
                if (udb.getMonth().equals("") || udb.getMonth() == null){
                    errMsg += "月、";
                }
                if (udb.getDay().equals("") || udb.getDay() == null){
                    errMsg += "日、";
                }
                if (udb.getType().equals("") || udb.getType() == null){
                    errMsg += "職種、";
                }
                if (udb.getTell().equals("") || udb.getTell() == null){
                    errMsg += "電話番号、";
                }
                if (udb.getComment().equals("") || udb.getComment() == null){
                    errMsg += "自己紹介、";
                }
                errMsg += "が未入力です。";
            }
            udb.setChecked(checked);
            udb.setErrMsg(errMsg);
            
            System.out.println("JavaBeans updated!!");
            
            //セッションにデータを受け渡し
            session.setAttribute("udb", udb);
            
            request.getRequestDispatcher("/insertconfirm.jsp").forward(request, response);
        }catch(Exception e){
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
