<%@page 
    import="kagoyume.YumeHelper"
    import="kagoyume.UserData"     
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    YumeHelper yh = YumeHelper.getInstance();
    UserData ud = (UserData) session.getAttribute("ud");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Confirm</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3">

                    <div class="page-header">
                        <h2>会員登録確認</h2>
                    </div>

                    <form action="RegistrationComplete" method="post">
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
                            <small>上記の内容で登録いたします。よろしいですか？</small><br>
                            <button type="submit" class="btn btn-primary">はい</button>
                        </div>
                    </form>
                    <br>
                    <form action="Registration">
                        <div class="form-group">
                            <input type="hidden" name="back" value="true">
                            <button type="submit" class="btn btn-danger">いいえ</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
