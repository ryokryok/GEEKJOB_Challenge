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
public class UserDataDTO implements Serializable{
    private int userID;
    private String name;
    private String password;
    private String mail;
    private String address;
    private int total;
    private Date newDate;
    private int deleteFlg;
    private boolean login;

    public UserDataDTO() {
        this.login = false;
    }
    
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
    
    public void setTotal(int total){
        this.total = total;
    }
    public int getTotal(){
        return this.total;
    }
    
    public void setNewDate(Date newdate){
        this.newDate = newdate;
    }
    public Date getNewDate(){
        return this.newDate;
    }
    
    public void setDeleteFlg(int flag){
        this.deleteFlg = flag;
    }
    public int getDeleteFlag(){
        return this.deleteFlg;
    }
    
    public void setLogin(boolean login){
        this.login = login;
    }
    public boolean isLogin(){
        return this.login;
    }
    
    
}
