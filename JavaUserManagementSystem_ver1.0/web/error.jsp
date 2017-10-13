<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>error</title>
    </head>
    <body>
        <%@page import="jums.JumsHelper"%>
        
        エラーが発生しました。以下の項目を確認してください。<br>
        <%=request.getAttribute("error")%>
        
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
