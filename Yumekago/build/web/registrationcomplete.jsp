<%@page 
    import="kagoyume.YumeHelper"
    import="kagoyume.UserData"      
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    YumeHelper yh = YumeHelper.getInstance();
    UserData ud = (UserData) request.getAttribute("ud");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Complete</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3">

                    <div class="page-header">
                        <h2>会員登録完了</h2>
                    </div>

                    <form action="top.jsp" method="post">
                        <div class="form-group">
                            <label>ユーザー名</label>
                            <p><%=ud.getName()%></p>   
                        </div>
                        <div class="form-group">
                            <label>パスワード</label>
                            <p><%=ud.getPassword()%></p>
                        </div>
                        <div class="form-group">
                            <label>メールアドレス</label>
                            <p><%=ud.getMail()%></p>
                        </div>
                        <div class="form-group">
                            <label>住所</label>
                            <p><%=ud.getAddress()%></p>
                        </div>
                        <div class="form-group">
                            <small>以上の内容で登録しました。</small><br>
                            <%=yh.topP()%>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
