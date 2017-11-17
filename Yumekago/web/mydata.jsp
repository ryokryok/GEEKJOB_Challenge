<%@page 
    import="kagoyume.YumeHelper"
    import="kagoyume.UserDataDTO"      
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    YumeHelper yh = YumeHelper.getInstance();
    UserDataDTO udd = (UserDataDTO)session.getAttribute("udd");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Mydata</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3">

                    <div class="page-header">
                        <h2>会員情報</h2>
                    </div>

                    <div class="form-group">
                        <label>ユーザー名</label>
                        <p><%=udd.getName()%></p>   
                    </div>
                    <div class="form-group">
                        <label>パスワード</label>
                        <p><%=udd.getPassword()%></p>
                    </div>
                    <div class="form-group">
                        <label>メールアドレス</label>
                        <p><%=udd.getMail()%></p>
                    </div>
                    <div class="form-group">
                        <label>住所</label>
                        <p><%=udd.getAddress()%></p>
                    </div>
                    <div class="form-group">
                        <label>購入合計金額(もし実際に購入した場合)</label>
                        <p><%=udd.getTotal()%> 円</p>
                    </div>
                    <div class="form-group">
                        <label>会員登録日時</label>
                        <p><%=udd.getNewDate()%></p>
                    </div>
                    <form action="MyHistory">
                        <div class="form-group">
                            <button type="submit" class="btn btn-default">購入履歴</button>
                        </div>
                    </form>
                    <form action="MyUpdata">
                        <div class="form-group">
                            <button type="submit" class="btn btn-default">会員情報更新</button>
                        </div>
                    </form>
                    <form action="top.jsp">
                        <div class="form-group">
                            <button type="submit" class="btn btn-default">トップページへ戻る</button>
                        </div>
                    </form>
                    <br>
                    <form action="MyDelete">
                        <div class="form-group">
                            <button type="submit" class="btn btn-danger">退会する</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
