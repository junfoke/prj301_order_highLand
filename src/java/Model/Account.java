/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class Account {

    private int uID;
    private String username, pass, name;

    public Account(int uID, String username, String pass, String name) {
        this.uID = uID;
        this.username = username;
        this.pass = pass;
        this.name = name;
        connect();
    }

    public Account(String username, String pass, String name) {
        this.username = username;
        this.pass = pass;
        this.name = name;
        connect();
    }

    public Account(String username, String pass) {
        this.username = username;
        this.pass = pass;
        connect();
    }

    public Account() {
        connect();
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" + "uID=" + uID + ", username=" + username + ", pass=" + pass + ", name=" + name + '}';
    }
    Connection cnn;//ket noi DB
    Statement stm;//thuc thi cau lenh sql
    PreparedStatement pstm;
    ResultSet rs;//luu tru va xu li du lieu

    private void connect() {
        try {
            cnn = (new DBContext()).connection;
            if (cnn != null) {
                System.out.println("Success");
            } else {
                System.out.println("Fail");
            }

        } catch (Exception e) {

        }
    }

    public Account getAccount(String username, String pass) {

        try {
            String query = "select * from Account where [username] = ? and pass = ?";
            pstm = cnn.prepareStatement(query);
            pstm.setString(1, username);
            pstm.setString(2, pass);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String username1 = rs.getString(2);
                String pass1 = rs.getString(3);
                String name = rs.getString(4);
                Account a = new Account(username1, pass1, name);
                return a;
            }
        } catch (Exception e) {
            System.out.println("getAccount: " + e.getMessage());
        }
        return null;
    }


    public boolean checkUser() {
        try {
            String strSelect = "select * from Account where [username] = ? and pass = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, username);
            pstm.setString(2, pass);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkUser:" + e.getMessage());
        }
        return false;
    }

    public Object getAccountByUser(String user) {
        String query = "select * from Account where [username] = ?";
        try {
            pstm = cnn.prepareStatement(query);
            pstm.setString(1, user);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getString(2), rs.getString(3));
                return a;
            }
        } catch (Exception e) {
            System.out.println("getAccountByUser: "+e.getMessage());
        }
        return null;
    }

    public void insertAccount(String user, String pass) {
        String query = "INSERT INTO Account (username, pass) VALUES (?, ?)";
        //INSERT INTO Account (username, pass) VALUES (?, ?)
        try {
            pstm = cnn.prepareStatement(query);
            pstm.setString(1, user);
            pstm.setString(2, pass);
            pstm.executeUpdate();
        } catch (Exception e) {
             System.out.println("insertAccount: "+e.getMessage());
        }
    }

}
