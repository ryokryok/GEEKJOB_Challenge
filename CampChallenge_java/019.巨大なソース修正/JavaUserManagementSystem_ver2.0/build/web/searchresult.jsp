<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO"
        import="jums.UserDataBeans"
        import="java.util.ArrayList"
        import="javax.servlet.http.HttpSession" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    ArrayList resultData = (ArrayList)hs.getAttribute("resultData");
    UserDataDTO udd = new UserDataDTO();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <% if(resultData.size() == 0){ out.print("No Data");} 
        else{ %>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
                <% for(Object o : resultData) {
                    //object型データをUserDataDTO型データに変換
                    udd = (UserDataDTO)o;
                %>
            <tr>
                <td><a href="ResultDetail?id=<%= udd.getUserID() %>"><%= udd.getName()%></a></td>
                <td><%= udd.getBirthday()%></td>
                <td><%= jh.exTypenum(udd.getType())%></td>
                <td><%= udd.getNewDate()%></td>
            </tr>
                <% } %>
        </table>
        <% } %>
        <form action="Search" method="POST">
            <input type="hidden" name="mode" value="REINPUT">
            <input type="hidden" name="udb" value="<%=hs.getAttribute("udb")%>">
            <input type="submit" name="btnSubmit" value="検索" style="width:100px">
        </form>
        <%=jh.home()%>
    </body>
    
</html>
