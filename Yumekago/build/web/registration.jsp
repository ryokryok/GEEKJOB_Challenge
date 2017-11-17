<%@page 
    import="kagoyume.YumeHelper"
    import="kagoyume.UserData"       
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    YumeHelper yh = YumeHelper.getInstance();
    UserData ud = new UserData();
    ud = (UserData) session.getAttribute("ud");
    
    boolean flag = false;
    //未入力でこのページに戻るとflagがtrueになる
    if (request.getAttribute("back") != null) {
        flag = true;
    }
    //confirmでこのページに戻るとreinputがfalseになる
    boolean reinput = true;
    if(request.getAttribute("reinput") != null){
        reinput = false;
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Login</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3">

                    <div class="page-header">
                        <h2>アカウントを作成</h2>
                    </div>
                    <% if (flag && reinput) {%>
                    <p style="color: red">入力内容に不備があります。</p>
                    <%;
                        }%>
                    <br>
                    <form action="RegistrationConfirm" method="post">
                        <div class="form-group">
                            <label>ユーザー名(半角英数)</label>
                            <input type="text" name="name"
                                   value="<% if (flag && ud.getName() != null) {
                                           out.print(ud.getName());
                                       }%>"
                                   class="form-control" placeholder="<% if (flag && ud.getName().equals("")) {%>未記入です<%;
                                       }%>">   
                        </div>

                        <div class="form-group">
                            <label>パスワード(半角英数)</label>
                            <input type="password" name="password"
                                   value="<% if (flag && ud.getPassword() != null) {
                                           out.print(ud.getPassword());
                                       }%>"
                                   class="form-control" placeholder="<% if (flag && ud.getPassword().equals("")) {%> 未記入です <%;
                                       }%> ">
                        </div>

                        <div class="form-group">
                            <label>メールアドレス(xxxx@example.com)</label>
                            <input type="email" name="mail"
                                   value="<% if (flag && ud.getMail() != null) {
                                           out.print(ud.getMail());
                                       }%>"
                                   class="form-control" placeholder="<% if (flag && ud.getMail().equals("")) {%>未記入です<%;
                                       }%>">
                        </div>
                        <div class="form-group">
                            <label>住所(実際には使いません)</label>

                            <input type="text" name="address"
                                   value="<% if (flag && ud.getAddress() != null) {
                                           out.print(ud.getAddress());
                                       }%>"
                                   class="form-control" placeholder="<% if (flag && ud.getAddress().equals("")) {%>未記入です<%;
                                       }%>">
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">入力確認画面へ</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
