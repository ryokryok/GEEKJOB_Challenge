/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import base.DBmanager;
import kagoyume.ShopBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author ryokato
 */
public class UserDataDAO {

    public static UserDataDAO getInstance() {
        return new UserDataDAO();
    }

    /**
     * *
     * ユーザー情報DB操作系をまとめたクラス。新規登録、更新、削除担当。 This is Operating class for UserData on
     * DataBase.Insert,Update,Delete.
     *
     * @param ud
     * @throws java.sql.SQLException
     */
    public void Insert(UserData ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            Timestamp now = new Timestamp(System.currentTimeMillis());
            con = DBmanager.getConnection();
            st = con.prepareStatement("INSERT INTO user_t (name,password,mail,address,newDate) values (?,?,?,?,?) ");
            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            st.setString(3, ud.getMail());
            st.setString(4, ud.getAddress());
            st.setTimestamp(5, now);
            st.executeUpdate();
            System.out.println("Insert complete!");
            con.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public boolean Check(UserData ud) throws SQLException {
        //入力が空の場合はfalseを返す
        if (ud.getName() == null || ud.getName().length() == 0
                || ud.getPassword() == null || ud.getPassword().length() == 0) {
            return false;
        }

        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBmanager.getConnection();
            st = con.prepareStatement("SELECT * FROM user_t WHERE name = ? && password = ?");
            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            ResultSet rs = st.executeQuery();

            //該当するデータが1件でもあれば認証OK
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                st.close();
                con.close();
            }
        }
    }

    //Checkにてtrue判定になった場合、ログインチェック時に使った名前から全データを取得する
    public UserDataDTO Login(String name) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        UserDataDTO user = new UserDataDTO();
        try {
            con = DBmanager.getConnection();
            st = con.prepareStatement("SELECT * FROM user_t WHERE name = ?");
            st.setString(1, name);
            rs = st.executeQuery();
            while (rs.next()) {
                user.setUserID(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setMail(rs.getString(4));
                user.setAdress(rs.getString(5));
                user.setTotal(rs.getInt(6));
                user.setNewDate(rs.getDate(7));
                user.setDeleteFlg(rs.getInt(8));
            }
            user.setLogin(true);
            System.out.println("Login is OK!");
            con.close();
            st.close();
            return user;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public void Update(UserData ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;

        try {
            con = DBmanager.getConnection();
            st = con.prepareStatement("UPDATE user_t SET name = ?, password = ?,mail = ?,address = ? WHERE userID = ?");
            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            st.setString(3, ud.getMail());
            st.setString(4, ud.getAddress());
            st.setInt(5, ud.getUserID());
            st.executeUpdate();
            System.out.print("Update successed");
            con.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public void Delete(int id) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;

        try {
            con = DBmanager.getConnection();
            st = con.prepareStatement("UPDATE user_t SET deleteFlg = ? WHERE userID = ?");
            st.setInt(1, 1);
            st.setInt(2, id);
            st.executeUpdate();
            System.out.print("DelteFlg updated");
            con.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public void Buy(UserDataDTO udd, ArrayList<ShopBean> cart, int type,int total) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        String code = "";
        Timestamp now = new Timestamp(System.currentTimeMillis());
        try {
            con = DBmanager.getConnection();
            
            for (ShopBean good : cart) {
                code = good.getCode();
                st = con.prepareStatement("INSERT INTO buy_t (userID,itemCode,type,buyDate) values (?,?,?,?)");
                st.setInt(1, udd.getUserID());
                st.setString(2, code);
                st.setInt(3, type);
                st.setTimestamp(4, now);
                st.executeUpdate();
            }
            
            st = con.prepareStatement("UPDATE user_t SET total = total + ? WHERE userID = ?");
            st.setInt(1, total);
            st.setInt(2, udd.getUserID());
            st.executeUpdate();
            
            System.out.print("BuyData updated");
            con.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
    public ArrayList<String> BuyLog(int id) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<String> buylog = new ArrayList();
        try {
            con = DBmanager.getConnection();
            st = con.prepareStatement("SELECT * FROM buy_t WHERE userID = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                buylog.add(rs.getString("itemCode"));
            }
            System.out.println("get buylog!");
            con.close();
            st.close();
            return buylog;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
}
