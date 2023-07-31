/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Order;
import Model.OrderItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class reportOrder extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fromDate = req.getParameter("fromdate");
        String toDate = req.getParameter("todate");

        OrderItem oi = new OrderItem();
        List<OrderItem> list = oi.getListOrderByDate(fromDate, toDate);

        Order o = new Order();
        List<Order> listO = o.getListOrder(fromDate, toDate);
        
        OrderItem oi1 = new OrderItem();
//        for (int i = 0; listO.size()>i; i++) {
//            List<OrderItem> listO1 = new ArrayList<>();
//                   listO1.add(oi1.getOrderItemByOrderID(listO.get(i).getOrderID()));
//        }
//        
//        req.setAttribute("listO1", listO1);
        req.setAttribute("list", list);
        req.setAttribute("listO", listO);
        
         
        req.setAttribute("fromdate", fromDate);
        req.setAttribute("todate", toDate);
        req.getRequestDispatcher("reportOrder.jsp").forward(req, resp);
    }

}
