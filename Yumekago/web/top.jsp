<%@page 
    import="kagoyume.YumeHelper"
    import="kagoyume.UserDataDTO"      
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% YumeHelper yh = YumeHelper.getInstance();
    UserDataDTO udd = (UserDataDTO) session.getAttribute("udd");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Yumekago</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="page-header">
                <%=yh.header()%>
                <%=yh.msg(udd)%>
            </div>
            <%=yh.search()%>
        </div>  
    </body>
</html>
