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
    private final String logLnk = "login.jsp";
    
    public static YumeHelper getInstance(){
        return new YumeHelper();
    }
    
    public String loginP(String nameU){
        return "ようこそ <a href=\"" + logLnk + "\">" + nameU + "</a>さん";
    }
}
