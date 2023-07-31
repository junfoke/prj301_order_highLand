/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author DELL
 */
public class signupController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        
        Account ac=new Account();
        String user = req.getParameter("user");
        String pass = req.getParameter("pass");
        String re_pass = req.getParameter("repass");
        
        
        if(!pass.equals(re_pass)){
            req.setAttribute("error", "Pass and Re_Pass is different!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }else{
            
            if((ac.getAccountByUser(user))!=null){
                req.setAttribute("error", "This account is existed!");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }else{
                ac.insertAccount(user, pass);
                req.setAttribute("error", "Sign Up Success!");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }
        

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
    }
    
}
