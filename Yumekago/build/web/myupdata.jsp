<%@page 
    import="kagoyume.YumeHelper"
    import="kagoyume.UserData"
    import="kagoyume.UserDataDTO"
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    YumeHelper yh = YumeHelper.getInstance();
    UserData ud = (UserData) session.getAttribute("ud");
    UserDataDTO udd = (UserDataDTO) session.getAttribute("udd");
    boolean flag = false;
    //未入力でこのページに戻るとflagがtrueになる
    if (request.getAttribute("error") != null) {
        flag = true;
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
                        <h2>会員情報更新</h2>
                    </div>
                    <% if (flag) {%>
                    <p style="color: red">入力内容に不備があります。</p>
                    <%;
                        }%>
                    <br>
                    <form action="MyUpdataResult" method="post">
                        <div class="form-group">
                            <label>ユーザー名(半角英数)</label>
                            <input type="text" name="name" value="<%=ud.getName()%>"
                                   class="form-control" placeholder="<% if (flag && ud.getName().equals("")) {%>未記入です<%;
                                       }%>">   
                        </div>

                        <div class="form-group">
                            <label>パスワード(半角英数)</label>
                            <input type="password" name="password" value="<%=ud.getPassword()%>"
                                   class="form-control" placeholder="<% if (flag && ud.getPassword().equals("")) {%> 未記入です <%;
                                       }%> ">
                        </div>

                        <div class="form-group">
                            <label>メールアドレス(xxxx@example.com)</label>
                            <input type="email" name="mail" value="<%=ud.getMail()%>"
                                   class="form-control" placeholder="<% if (flag && ud.getMail().equals("")) {%>未記入です<%;
                                       }%>">
                        </div>
                        <div class="form-group">
                            <label>住所(実際には使いません)</label>
                            <input type="text" name="address" value="<%=ud.getAddress()%>"
                                   class="form-control" placeholder="<% if (flag && ud.getAddress().equals("")) {%>未記入です<%;
                                       }%>">
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">会員情報更新</button>
                        </div>
                    </form>
                    <form action="MyData">
                        <div class="form-group">
                            <button type="submit" class="btn btn-default">会員情報ホームに戻る(データ更新は行われません。)</button>
                        </div>
                    </form>
                    <form action="top.jsp">
                        <div class="form-group">
                            <button type="submit" class="btn btn-default">トップページへ戻る</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
