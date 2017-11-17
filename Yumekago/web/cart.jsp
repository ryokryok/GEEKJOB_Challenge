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
    if (udd != null){
        String id = String.valueOf(udd.getUserID());
        cart = (ArrayList) session.getAttribute("cart" + id);
    }else{
        cart = (ArrayList) session.getAttribute("cart");
    }
    int pkg = 0;
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
        <div class="container-fluid">
            <div class="page-header">
                <%=yh.header()%>
                <%=yh.msg(udd)%>
            </div>
            <%=yh.search()%>
        </div> 
        <div class="container">
            <div class="row">
                <h3>カートの中の商品</h3>
                <% if (cart.size() > 0) {%>
                <% for (ShopBean good : cart) {
                        good.setID(pkg);
                %>
                <div class="col-md-12">
                    <a href="Item?code=<%=good.getCode()%>">
                        <img src="<%=good.getImgMd()%>" alt="goodsImage"
                             class="pull-left img-responsive" style="margin: 0 15px;">
                    </a>
                    <a href="Item?code=<%=good.getCode()%>">
                        <p class="h4"><%=good.getName()%></p>
                    </a>
                    <p class="h3"><%=good.getPrice()%> 円</p>
                    <div class="form-group clearfix">
                        <form action="Cart" class="form-inline" method="POST">
                            <button class="btn btn-danger"
                                    name="delID" value="<%=good.getID()%>">削除</button>
                        </form>
                    </div>
                </div>
                <% ;
                        pkg++;
                        total += good.getPrice();
                    }%>
                <hr>
                <p class="text-right h3">小計(<%=cart.size()%>点):合計金額 <%=total%>円</p>
                <div class="form-group text-right">
                    <%if (udd != null) {%>
                    <form action="BuyCfm" class="form-inline" method="POST">
                        <button class="btn btn-success" name="total" value="<%=total%>">購入する</button>
                    </form>
                    <% } else {%>
                    <small>ログインを忘れていませんか?</small>
                    <form action="Login" class="form-inline">
                        <button class="btn btn-primary">ログイン</button>
                    </form>
                    <% } %>
                </div>
                <% ;
                } else {%>
                <h4>お客様のカートに商品はありません。</h4>
                <%;
                    }%>

            </div>
        </div>
    </body>
</html>
