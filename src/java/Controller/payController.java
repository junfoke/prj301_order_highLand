/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Cart;
import Model.Category;
import Model.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class payController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //new order
        Order order=new Order();
        HttpSession session = req.getSession(true);
        Cart cart = null;
        Object o = session.getAttribute("cart");
        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }

        
        String tt = req.getParameter("tt");
        if (tt != null) {
            session.removeAttribute("cart");
            //add vào database(khóa de test front end)
            order.addOrder(cart);
            
            Category category=new Category();
            ArrayList<Category> dataCate= category.getListCategory();
            req.setAttribute("dataCate", dataCate);
            
            
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        } else {
            Category category=new Category();
            ArrayList<Category> dataCate= category.getListCategory();
            req.setAttribute("dataCate", dataCate);
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Category category=new Category();
            ArrayList<Category> dataCate= category.getListCategory();
            req.setAttribute("dataCate", dataCate);
            
            req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
    
}
