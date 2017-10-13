package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;
import jums.JumsHelper;
import jums.JumsHelper;

public final class insert_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      jums.UserDataBeans udb = null;
      synchronized (session) {
        udb = (jums.UserDataBeans) _jspx_page_context.getAttribute("udb", PageContext.SESSION_SCOPE);
        if (udb == null){
          udb = new jums.UserDataBeans();
          _jspx_page_context.setAttribute("udb", udb, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');

    HttpSession hs = request.getSession();
    
    String uName = udb.getName();
    String uYear = udb.getYear();
    String uMonth = udb.getMonth();
    String uDay = udb.getDay();
    String uType = udb.getType();
    String uTell = udb.getTell();
    String uComment= udb.getComment();
    

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JUMS登録画面</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    <form action=\"insertconfirm\" method=\"POST\">\n");
      out.write("        名前:\n");
      out.write("        <input type=\"text\" name=\"name\"\n");
      out.write("               value=\"");
 if (uName != null) { out.print(uName); } else { out.print("");}
      out.write("\">\n");
      out.write("        \n");
      out.write("        <br><br>\n");
      out.write("        生年月日:　\n");
      out.write("        <select name=\"year\">\n");
      out.write("            <option value=\"\">");
if (uYear != null) { out.print(uYear); } else { out.print("----"); }
      out.write("</option>\n");
      out.write("            ");

            for(int i=1950; i<=2010; i++){ 
      out.write("\n");
      out.write("            <option \n");
      out.write("                value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</option>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </select>年\n");
      out.write("        <select name=\"month\">\n");
      out.write("            <option value=\"");
if (uMonth != null) { out.print(uMonth); } 
      out.write("\">\n");
      out.write("            ");
if (uMonth != null) { out.print(uMonth); } 
                    else { out.print("--"); }
      out.write("</option>\n");
      out.write("            ");

            for(int i = 1; i<=12; i++){ 
      out.write("\n");
      out.write("            <option value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</option>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </select>月\n");
      out.write("        <select name=\"day\">\n");
      out.write("            <option value=\"");
if (uDay != null) { out.print(uDay); } 
      out.write("\">\n");
      out.write("                ");
if (uDay != null) { out.print(uDay); }
                    else { out.print("--"); }
      out.write("</option>\n");
      out.write("            ");

            for(int i = 1; i<=31; i++){ 
      out.write("\n");
      out.write("            <option value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</option>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </select>日\n");
      out.write("        <br><br>\n");
      out.write("\n");
      out.write("        種別:\n");
      out.write("        <br>\n");
      out.write("        <input type=\"radio\" name=\"type\" value=\"1\"　\n");
      out.write("               ");
 if ("1".equals(uType)) { out.print("checked"); }
      out.write(" >エンジニア<br>\n");
      out.write("        <input type=\"radio\" name=\"type\" value=\"2\"\n");
      out.write("               ");
 if ("2".equals(uType)) { out.print("checked"); }
      out.write(">営業<br>\n");
      out.write("        <input type=\"radio\" name=\"type\" value=\"3\"\n");
      out.write("               ");
 if ("3".equals(uType)) { out.print("checked"); }
      out.write(">その他<br>\n");
      out.write("        <br>\n");
      out.write("\n");
      out.write("        電話番号:\n");
      out.write("        <input type=\"text\" name=\"tell\" \n");
      out.write("               value=\"");
 if (uTell != null) { out.print(uTell); }
      out.write("\">\n");
      out.write("        <br><br>\n");
      out.write("\n");
      out.write("        自己紹介文\n");
      out.write("        <br>\n");
      out.write("        <textarea name=\"comment\" rows=10 cols=50 style=\"resize:none\"\n");
      out.write("                  wrap=\"hard\">");
 if (uComment != null) { out.print(uComment); }
      out.write("</textarea><br><br>\n");
      out.write("        \n");
      out.write("        <input type=\"hidden\" name=\"ac\"  value=\"");
      out.print( hs.getAttribute("ac"));
      out.write("\">\n");
      out.write("        <input type=\"submit\" name=\"btnSubmit\" value=\"確認画面へ\">\n");
      out.write("    </form>\n");
      out.write("        <br>\n");
      out.write("        ");
      out.print(JumsHelper.getInstance().home());
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
