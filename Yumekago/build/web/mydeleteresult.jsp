<%@page 
    import="kagoyume.YumeHelper"  
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    YumeHelper yh = YumeHelper.getInstance();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>MyDelete</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3">
                    <div class="page-header">
                        <h2>会員削除完了</h2>
                    </div>
                    <p class="h4">削除しました</p>
                    <form action="top.jsp">
                        <div class="form-group">
                            <button type="submit" class="btn btn-default">トップページに戻る</button>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </body>
</html>
