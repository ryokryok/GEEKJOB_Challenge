<%@page import="kagoyume.YumeHelper"
        %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% YumeHelper yh = YumeHelper.getInstance();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Error</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3">
                    <div class="page-header">
                        <%=yh.header()%>
                    </div>
                    <p>すみません。エラーが発生しました。再度トップページからアクセスお願いします。</p>
                    <%=yh.topP()%>
                </div>
            </div>
        </div>
    </body>
</html>
