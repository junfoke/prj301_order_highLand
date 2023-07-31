/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Category {
    private String cateID;
    private String cname;

    public Category() {
        connect();
    }

    public Category(String cateID, String cname) {
        this.cateID = cateID;
        this.cname = cname;
        connect();
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Category{" + "cateID=" + cateID + ", cname=" + cname + '}';
    }
    //Khai bao cac thanh phan xu li DB
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

    public ArrayList<Category> getListCategory() {
        ArrayList<Category> dataCate = new ArrayList<Category>();
        try {
            String strSelect = "select * from dbo.Category ";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while(rs.next()){
                String cateID1 = rs.getString(1);
                String cname1 = rs.getString(2);
                dataCate.add(new Category(cateID1, cname1));
            }
        } catch (Exception e) {
            System.out.println("getCategory: "+e.getMessage());
        }
        return dataCate;
    }
    
    
}
