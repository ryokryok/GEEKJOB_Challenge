/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

/**
 *
 * @author ryokato
 */
public class YumeHelper {

    private final String logLnk = "Login";
    private final String topLnk = "top.jsp";
    private final String dataLnk = "MyData";
    private final String cartLnk = "Cart";

    public static YumeHelper getInstance() {
        return new YumeHelper();
    }

    public String topP() {
        return "<a href=\"" + topLnk + "\">" + "トップページへ" + "</a>";
    }

    public String header() {
        return "<h1><a href=\"" + topLnk + "\">" + "Kagoyume" + "</a></h1>"
                + "<small>買った気にさせてくれるサイトです</small>";
    }

    public String userP(String userName) {
        return "ようこそ <a href=\"" + topLnk + "\">" + userName + "</a>さん"
                + " <a href=\"" + dataLnk + "\">" + "会員情報" + "</a>"
                + " <a href=\"" + cartLnk + "\">" + "買い物かご" + "</a>"
                + " <a href=\"" + logLnk + "\">" + "ログアウト" + "</a>";
    }

    public String guestP() {
        return "<a href=\"" + logLnk + "\">" + "サインイン" + "</a>" 
                + " <a href=\"" + logLnk + "\">" + "買い物かご" + "</a>";
    }

    public String search() {
        return "<form action=\"Search\" method=\"GET\" class=\"form-inline\">\n"
                + "                <div class=\"form-group\">\n"
                + "                    <input type=\"text\" name=\"search\"\n"
                + "                           value=\"\" class=\"form-control\">\n"
                + "                </div>\n"
                + "                <button class=\"btn btn-primary\" type=\"submit\">\n"
                + "                    Search\n"
                + "                </button>\n"
                + "            </form>";
    }

    public String search(String s) {
        return "<form action=\"Search\" method=\"GET\" class=\"form-inline\">\n"
                + "                <div class=\"form-group\">\n"
                + "                    <input type=\"text\" name=\"search\"\n"
                + "                           value=\"" + s + "\" class=\"form-control\">\n"
                + "                </div>\n"
                + "                <button class=\"btn btn-primary\" type=\"submit\">\n"
                + "                    Search\n"
                + "                </button>\n"
                + "            </form>";
    }

    public String msg(UserDataDTO udd) {
        if (udd != null) {
            return userP(udd.getName());
        } else {
            return guestP();
        }
    }
}
