package com.demo;

import com.demo.daoImpl.ProductTypeDAOImpl;
import com.demo.model.ProductType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "indexservlet",
        urlPatterns = ""
)
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<ProductType> allProductTypes = new ProductTypeDAOImpl().getAll();
        getServletContext().setAttribute("productTypes", allProductTypes);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
