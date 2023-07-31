/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Cart;
import Model.Category;
import Model.Item;
import Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class orderController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Category c= new Category();
        Product p=new Product();
        ArrayList<Product> dataP = p.getListProduct();
        ArrayList<Category> dataCate1 = c.getListCategory();
        req.setAttribute("listP", dataP);
        req.setAttribute("listC", dataCate1);
        
        String cateID1 = req.getParameter("cateID");
        Category category = new Category();
        ArrayList<Category> dataCate = category.getListCategory();
        req.setAttribute("dataCate", dataCate);

        Product product = new Product();
        ArrayList<Product> dataPro = product.getListProductByCate(cateID1);
        req.setAttribute("dataPro", dataPro);
        
        
        HttpSession session = req.getSession(true);
        Cart cart = null;
        Object o = session.getAttribute("cart");
        if(o!=null){
            cart = (Cart)o;
        }else{
            cart= new Cart();
        }
        String ProductCode = req.getParameter("ProductCode");
        p.getProductByID(ProductCode); 
        double price = p.getPrice();
        Item t = new Item(p,0,price);
        cart.addItemToCard(t);
        List<Item> list = cart.getItem();
        session.setAttribute("cart", cart);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    
}
