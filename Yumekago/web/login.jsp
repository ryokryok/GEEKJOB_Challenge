<%@page 
    import="kagoyume.YumeHelper"
    import="kagoyume.UserData"  
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    YumeHelper yh = YumeHelper.getInstance();
    UserData ud = new UserData();
    ud = (UserData) session.getAttribute("ud");
    //ログインメッセージ用フラグ。ログイン失敗するとエラーメッセージ表示。
    boolean flag = false;
    if (request.getAttribute("error") != null) {
        flag = true;
    }
    boolean delFlg = false;
    if (request.getAttribute("delFlg") != null) {
        delFlg = true;
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
                        <h2>ログイン</h2>
                    </div>
                    <% if (flag) {%>
                    <p style="color: red">ユーザー名とパスワードが一致しません。再度入力してください。</p>
                    <%;
                        }%>
                    <% if (delFlg) {%>
                    <p style="color: red">入力されたユーザーは削除されています。</p>
                    <%;
                        }%>
                    <br>
                    <form action="LoginCheck" method="post">
                        <div class="form-group">
                            <label>ユーザー名</label>
                            <input type="text" name="name"
                                   value="<% if (flag && ud.getName() != null) {
                                           out.print(ud.getName());
                                       } %>"
                                   class="form-control" placeholder="<% if (flag && ud.getName().equals("")) {%>未記入です<%;
                                       }%>">  
                        </div>
                        <div class="form-group">
                            <label>パスワード</label>
                            <input type="text" name="password"
                                   value="<% if (flag && ud.getPassword() != null) {
                                           out.print(ud.getPassword());
                                       } %>"
                                   class="form-control" placeholder="<% if (flag && ud.getPassword().equals("")) {%>未記入です<%;
                                       }%>">
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">ログイン</button>
                        </div>
                        <br>
                    </form>
                    <p>会員登録はこちらから</p>
                    <form action="Registration" class="form-group">
                        <button type="submit" class="btn btn-default">新規会員登録</button>
                    </form>
                </div>
                <%=yh.topP()%>
            </div>
        </div>
    </body>
</html>
