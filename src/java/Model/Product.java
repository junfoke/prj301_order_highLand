/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Product {

    private int id, cateID;
    private String name, size;
    private double price;

    public Product(int id, int cateID, String name, String size, double price) {
        this.id = id;
        this.cateID = cateID;
        this.name = name;
        this.size = size;
        this.price = price;
        connect();
    }

    public Product() {
        connect();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", cateID=" + cateID + ", name=" + name + ", size=" + size + ", price=" + price + '}';
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

    public ArrayList<Product> getListProductByCate(String cateID1) {
        ArrayList<Product> dataPro = new ArrayList<Product>();
        try {
            String strSelect1 = "select * from product where cateID=?";
            pstm = cnn.prepareStatement(strSelect1);
            pstm.setString(1, cateID1);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int cateID = rs.getInt(2);
                String name = rs.getString(3);
                String size = rs.getString(4);
                double price = rs.getDouble(5);

                dataPro.add(new Product(id, cateID, name, size, price));
            }
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());
        }
        return dataPro;
    }

    public static void main(String[] args) {
        
    }

    public ArrayList<Product> getListProduct() {
        ArrayList<Product> data = new ArrayList<Product>();
        try {
            String strSelect1 = "select * from product";
            pstm = cnn.prepareStatement(strSelect1);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //(int id, int cateID, String name, String size, double price) 
                int id = rs.getInt(1);
                int cateID = rs.getInt(2);
                String name = rs.getString(3);
                String size = rs.getString(4);
                double price = rs.getDouble(5);

                data.add(new Product(id, cateID, name, size, price));
            }
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());
        }
        return data;
    }

    public Product getProductByID(String ProductCode1) {
        try {
            String strSelect = "select * from product \n"
                    + "where id = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, ProductCode1);
            rs = pstm.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
                cateID = rs.getInt(2);
                name = rs.getString(3);
                size = rs.getString(4);
                price = rs.getDouble(5);
            }
        } catch (Exception e) {
            System.out.println("getProductByID:" + e.getMessage());
        }
        return null;
    }

}
