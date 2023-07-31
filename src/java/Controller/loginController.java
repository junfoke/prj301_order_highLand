/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Account;
import Model.Category;
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
public class loginController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("text/html;charset=UTF-8");
        String username1 = req.getParameter("user");
        String pass1 = req.getParameter("pass");
        Account a =  new Account(username1, pass1);
        boolean check=a.checkUser();
        if(check){
            HttpSession session = req.getSession();
            session.setAttribute("account", a);
//            resp.sendRedirect("home.jsp");


            Category category=new Category();
            ArrayList<Category> dataCate= category.getListCategory();
            req.setAttribute("dataCate", dataCate);
            
            req.getRequestDispatcher("home.jsp").forward(req, resp);
            
        }else{
            req.setAttribute("error", "Your account is wrong bro!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }
    
}
