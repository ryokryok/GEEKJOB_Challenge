<%@page 
    import="kagoyume.YumeHelper"
    import="kagoyume.UserDataDTO"
    import="kagoyume.ShopBean"
    import="java.util.ArrayList"
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% YumeHelper yh = YumeHelper.getInstance();
    UserDataDTO udd = (UserDataDTO) session.getAttribute("udd");
    ArrayList<ShopBean> history = (ArrayList) session.getAttribute("history");
    int total = 0;
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
            <div class="row">
                <div class="col-md8">
                    <div class="page-header">
                        <h3>購入履歴</h3>
                    </div>
                    <ul class="list-group">
                        <% if (history.size() > 0) {%>
                        <% for (ShopBean good : history) {
                        %>
                        <li class="list-group-item">
                            <p class="h4 text-left"><%=good.getName()%></p>
                            <p class="h3 text-right"><%=good.getPrice()%> 円</p>
                        </li>
                        <% total += good.getPrice();
                            ;}%>
                    </ul>
                    <hr>
                    <p class="text-right h3">小計(<%=history.size()%>点):合計金額 <%=total%> 円</p>
                        <form action="MyData" class="form-inline" method="POST">
                            <button class="btn btn-default">会員情報に戻る</button>
                        </form>
                    </div>
                    <% ;
                } else {%>
                    <h4>購入した商品はありません。</h4>
                    <%;
                    }%>
                </div>
            </div>
        
    </body>
</html>
