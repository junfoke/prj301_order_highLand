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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Order {
    private String OrderID;
    Date date;
    float Ammount;

    public Order() {
        connect();
    }

    public Order(String OrderID, Date date, float Ammount) {
        this.OrderID = OrderID;
        this.date = date;
        this.Ammount = Ammount;
        connect();
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmmount() {
        return Ammount;
    }

    public void setAmmount(float Ammount) {
        this.Ammount = Ammount;
    }

    @Override
    public String toString() {
        return "Order{" + "OrderID=" + OrderID + ", date=" + date + ", Ammount=" + Ammount + '}';
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
    
    
    public void addOrder(Cart cart) {
        LocalDate curDate = java.time.LocalDate.now();
        String date = curDate.toString();
        try {
            String strAdd = "insert into Orders(Date,Amount)\n"
                    + "values (?,?)";
            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, date);
            pstm.setFloat(2, (float) cart.getTotal());
            pstm.execute();
            //Lấy id vừa mới add vào để nối với bảng Id của OrderItems
            String strSelect = "select top 1 Orders.OrderID\n"
                    + "from Orders\n"
                    + "order by Orders.OrderID desc";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();          
            while (rs.next()) {
                int oId = rs.getInt(1);
                for (Item o : cart.getItem()) {
                    String strAdd2 = "insert into OrderItems (OrderID,ProductID,Quantity,SellPrice)\n"
                            + "values(?,?,?,?)";
                PreparedStatement ps2 = cnn.prepareStatement(strAdd2);
                    ps2.setInt(1, oId);
                    ps2.setInt(2, o.getProduct().getId());
                    ps2.setInt(3, o.getQuantity());
                    ps2.setDouble(4, o.getPrice());
                    ps2.execute();
                }
            }
        } catch (Exception e) {
            System.out.println("addOrder:" + e.getMessage());
        }
    }

    public List<Order> getListOrder(String fromDate, String toDate) {
        List<Order> listO = new ArrayList<>();
        try {
            connect();
            String strSelect = "select OrderID,Date, Amount\n"
                    + "from Orders\n"
                    + "where Date between ? and ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, fromDate);
            pstm.setString(2, toDate);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //
                listO.add(new Order(rs.getString(1), rs.getDate(2), rs.getFloat(3)));
            }
        } catch (Exception e) {
            System.out.println("getListOrder:" + e.getMessage());
        }

        return listO;

    }
    public static void main(String[] args) {
        Order o=new Order();
        System.out.println(o.getListOrder("2023-03-17", "2023-03-17"));
    }
    
    
}
