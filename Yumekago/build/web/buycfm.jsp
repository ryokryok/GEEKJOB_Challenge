<%@page 
    import="kagoyume.YumeHelper"
    import="kagoyume.UserDataDTO"
    import="kagoyume.ShopBean"
    import="java.util.ArrayList"
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% YumeHelper yh = YumeHelper.getInstance();
    UserDataDTO udd = (UserDataDTO) session.getAttribute("udd");

    ArrayList<ShopBean> cart;
        String id = String.valueOf(udd.getUserID());
        cart = (ArrayList) session.getAttribute("cart" + id);
    int total = Integer.parseInt(request.getParameter("total"));
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
        <div class="container">
            <h3>カートの中の商品</h3>
            <ul class="list-group">
                <% if (cart.size() > 0) {%>

                <% for (ShopBean good : cart) {
                %>
                <li class="list-group-item">
                    <p class="h4 text-left"><%=good.getName()%></p>
                    <p class="h3 text-right"><%=good.getPrice()%> 円</p>
                </li>
                <%
                    ;
                    }%>
            </ul>
            <hr>
            <p class="text-right h3">小計(<%=cart.size()%>点):合計金額 <%=total%> 円</p>
            <div class="form-group">
                <form action="BuyComp" class="form-inline" method="POST">
                    <p class="h5">配達方法</p>
                    <div class="radio">
                        <label>
                            <input type="radio"  name="delivery" id="radio1" value="1" required>
                            ヤマト
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio"  name="delivery" id="radio2" value="2" required>
                            佐川
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio"  name="delivery" id="radio3" value="3" required>
                            日本郵便
                        </label>
                    </div>
                    <input type="hidden" name="total" value="<%=total%>">
                    <button type="submit" class="btn btn-success" name="buy" value="">上記の内容で購入する</button>
                </form>
                <form action="Cart" class="form-inline" method="POST">
                    <button class="btn btn-default">カートに戻る</button>
                </form>
            </div>
            <% ;
            } else {%>
            <h4>お客様のカートに商品はありません。</h4>
            <%;
                }%>


        </div>
    </body>
</html>
