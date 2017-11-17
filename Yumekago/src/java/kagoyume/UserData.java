/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author ryokato
 */
public class UserData implements Serializable{
    private int userID;
    private String name;
    private String password;
    private String mail;
    private String address;
    
    public void setUserID(int id){
        this.userID = id;
    }
    public int getUserID(){
        return this.userID;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    
    public void setPassword(String pass){
        this.password = pass;
    }
    public String getPassword(){
        return this.password;
    }
    
    public void setMail(String mail){
        this.mail = mail;
    }
    public String getMail(){
        return this.mail;
    }
    
    public void setAdress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
    
    public UserData DTO2UD(UserDataDTO udd){
        UserData ud = new UserData();
        ud.setUserID(udd.getUserID());
        ud.setName(udd.getName());
        ud.setPassword(udd.getPassword());
        ud.setMail(udd.getMail());
        ud.setAdress(udd.getAddress());
        return ud;
    }
    
    public UserDataDTO UD2DTO(UserData ud,UserDataDTO udd){
        udd.setName(ud.getName());
        udd.setPassword(ud.getPassword());
        udd.setMail(ud.getMail());
        udd.setAdress(ud.getAddress());
        return udd;
    }
}
