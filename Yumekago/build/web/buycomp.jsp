<%@page 
    import="kagoyume.YumeHelper"
    import="kagoyume.UserDataDTO"
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% YumeHelper yh = YumeHelper.getInstance();
    UserDataDTO udd = (UserDataDTO) session.getAttribute("udd");
    int total = Integer.parseInt(request.getParameter("total"));
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Yumekago</title>
    </head>
    <body>
        <div class="container">
            <div class="page-header">
                <%=yh.header()%>
                <%=yh.msg(udd)%>
            </div>
            <%=yh.search()%>
        </div>
        <div class="container">
            <h3>購入が完了しました</h3>
            <hr>
            <form action="top.jsp" class="form-inline" method="POST">
                <button class="btn btn-default">トップに戻る</button>
            </form>
        </div>
    </body>
</html>
