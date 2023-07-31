/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class OrderItem {

    private int OrderID, ProductID, Quantity;
    private String name;
    private Date date;
    private float amount;

    public OrderItem() {
        connect();
    }

    public OrderItem(int OrderID, int ProductID, int Quantity, Date date, float amount) {
        this.OrderID = OrderID;
        this.ProductID = ProductID;
        this.Quantity = Quantity;
        this.date = date;
        this.amount = amount;
        connect();
    }

    public OrderItem(int OrderID, int ProductID, int Quantity, String name, Date date, float amount) {
        this.OrderID = OrderID;
        this.ProductID = ProductID;
        this.Quantity = Quantity;
        this.name = name;
        this.date = date;
        this.amount = amount;
        connect();
    }

    public OrderItem(int ProductID,String name, int Quantity) {
        this.ProductID = ProductID;
        this.Quantity = Quantity;
        this.name = name;
        connect();
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "ProductID=" + ProductID + ", Quantity=" + Quantity + ", name=" + name + ", date=" + date + ", amount=" + amount + '}';
    }

    Connection cnn; // kếtối db
    Statement stm; // Thực thi câu lệnh
    ResultSet rs; // Lưu trữ và xử lý dữ liệu
    PreparedStatement pstm;

    private void connect() {
        try {
            cnn = (new DBContext()).connection;
            if (cnn != null) {
                System.out.println("Connect success");
            } else {
                System.out.println("Connect fail");
            }
        } catch (Exception e) {
        }
    }

    public List<OrderItem> getListOrderByDate(String fromDate, String toDate) {
        List<OrderItem> list = new ArrayList<>();
        try {
            connect();
            String strSelect = "select o.OrderID,oi.ProductID, oi.Quantity, p.name, o.Date, oi.SellPrice*oi.Quantity \n"
                    + "as Amount from OrderItems oi join Orders o on oi.OrderID = o.OrderID join product p on p.id = oi.ProductID \n"
                    + "where o.Date between ? and ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, fromDate);
            pstm.setString(2, toDate);
            rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new OrderItem(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDate(5), rs.getFloat(6)));
            }
        } catch (Exception e) {
            System.out.println("getListOrderByDate:" + e.getMessage());
        }

        return list;
    }


    public List<OrderItem> getOrderItemByOrderID(String orderID) {
        List<OrderItem> listO1 = new ArrayList<>();
        try {
            connect();
            String strSelect = "select ProductID, p.name, Quantity\n"
                    + "from OrderItems oi join product p on p.id = oi.ProductID \n"
                    + "where OrderID=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, orderID);
            rs = pstm.executeQuery();
            while (rs.next()) {
                listO1.add(new OrderItem(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (Exception e) {
            System.out.println("getOrderItemByOrderID:" + e.getMessage());
        }

        return listO1;
    }
    public static void main(String[] args) {
        OrderItem oi = new OrderItem();
        List<OrderItem> listO1 = oi.getOrderItemByOrderID("11");
        System.out.println(listO1);
    }
}
