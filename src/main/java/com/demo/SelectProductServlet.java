package com.demo;

import com.demo.daoImpl.ProductTypeDAOImpl;
import com.demo.model.ProductType;
import com.demo.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(
        name = "selectproductservlet",
        urlPatterns = "/SelectProduct"
)

public class SelectProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String productType = req.getParameter("Type");
        List products = new ArrayList();
        String act = req.getParameter("productSelected");
        ProductService productService = new ProductService();

        if (act != null) {
            products = productService.getAvailableProducts( act );
        }

        HttpSession session = req.getSession();
        session.setAttribute("products", products);

        req.setAttribute("products", products);
        RequestDispatcher view = req.getRequestDispatcher("result.jsp");
        view.forward(req, resp);
    }
}
