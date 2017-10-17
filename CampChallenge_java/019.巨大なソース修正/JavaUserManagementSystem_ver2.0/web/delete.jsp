<%@page import="jums.JumsHelper"
        import="javax.servlet.http.HttpSession"
        import="jums.UserDataDTO"
        import="jums.UserDataBeans"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultData");
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>削除確認</h1>
    以下の内容を削除します。よろしいですか？<br>
    名前:<%= udd.getName()%><br>
    生年月日:<%= udd.getBirthday()%><br>
    種別:<%= jh.exTypenum(udd.getType())%><br>
    電話番号:<%= udd.getTell()%><br>
    自己紹介:<%= udd.getComment()%><br>
    登録日時:<%= udd.getNewDate()%><br>
    
    <form action="DeleteResult" method="POST">
        <input type="hidden" name="resultData" value="<%= hs.getAttribute("ResultData")%>">
        <input type="submit" name="YES" value="はい" style="width:100px">
    </form><br>
    <form action="ResultDetail" method="POST">
        <input type="hidden" name="resultData" value="<%= hs.getAttribute("ResultData")%>">
        <input type="hidden" name="udb" value="<%= hs.getAttribute("udb")%>">
        <input type="submit" name="NO" value="詳細画面に戻る" style="width:100px">
    </form>
        <%=jh.home()%>
    </body>
</html>
