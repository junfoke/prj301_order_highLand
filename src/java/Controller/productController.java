/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Category;
import Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class productController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cateID1 = req.getParameter("cateID");
        Category category = new Category();
        ArrayList<Category> dataCate = category.getListCategory();
        req.setAttribute("dataCate", dataCate);

        Product product = new Product();
        ArrayList<Product> dataPro = product.getListProductByCate(cateID1);

        req.setAttribute("dataPro", dataPro);

        req.getRequestDispatcher("home.jsp").forward(req, resp);

    }

}
