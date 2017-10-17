<%@page 
      import="jums.JumsHelper"
      import="javax.servlet.http.HttpSession"
      import="jums.UserDataDTO"
      import="jums.UserDataBeans" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultData");
    UserDataBeans udb =(UserDataBeans)hs.getAttribute("udb");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <h1>変更結果</h1><br>
        名前:<%=udb.getName()%><br>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= jh.exTypenum(udb.getType())%><br>
        電話番号:<%=udb.getTell()%><br>
        自己紹介:<%=udb.getComment()%><br>
        以上の内容で登録しました。<br>
        <form action="ResultDetail" method="POST">
            <input type="submit" name="btnSubmit" value="詳細画面に戻る">
            <input type="hidden" name="resultData"  value="<%=hs.getAttribute("resultData")%>">
            <input type="hidden" name="back"  value="back">
        </form> 
    <%=jh.home()%>
    </body>
</html>
