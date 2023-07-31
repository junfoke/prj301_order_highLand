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
public class processController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        
        String cateID1 = req.getParameter("cateID");
        Category category = new Category();
        ArrayList<Category> dataCate = category.getListCategory();
        req.setAttribute("dataCate", dataCate);

        Product product = new Product();
        ArrayList<Product> dataPro = product.getListProductByCate(cateID1);
        req.setAttribute("dataPro", dataPro);
        
        
        Cart cart = null;
        Product p=new Product();
        Object o = session.getAttribute("cart");
        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String ProductCode = req.getParameter("ProductCode").trim();
        int id=Integer.parseInt(ProductCode);
        try {
            if (quantity == -1) {
                p.getProductByID(ProductCode);
                double price = p.getPrice();
                Item t = new Item(p, quantity, price);
                cart.divItemToCard(t);
                if (cart.getQuantityByProductCode(id)<= 0) {
                    cart.removeItem(id);
                }
            }
            if (quantity == 1) {
                p.getProductByID(ProductCode);
                double price = p.getPrice();
                Item t = new Item(p, quantity, price);
                cart.addItemToCard(t);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        List<Item> list = cart.getItem();
        session.setAttribute("cart", cart);
        req.getRequestDispatcher("home.jsp").forward(req, resp);

    }
}


