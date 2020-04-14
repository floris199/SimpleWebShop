package com.demo;

import com.demo.daoImpl.CartDAOImpl;
import com.demo.model.Item;
import com.demo.model.Product;
import com.demo.service.CartService;
import com.demo.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "cartservlet",
            urlPatterns = "/Cart")
public class CartServlet extends HttpServlet {

    public CartServlet() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            displayCart(req, resp);
        } else {
            if (action.equalsIgnoreCase("buy")) {
                buy(req, resp);
            } else if (action.equalsIgnoreCase("remove")) {
                remove(req, resp);
            }
        }
    }

    protected void displayCart(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("cart.jsp").forward(req, resp);
    }

    protected void remove(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int index = isExists(req.getParameter("id"), cart);
        new CartService().removeItem(cart.get(index).getProduct());
        cart.remove(index);

        session.setAttribute("cart", cart);

        resp.sendRedirect("Cart");
    }

    protected void buy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductService();
        HttpSession session = req.getSession();
        List<Item> cart = new ArrayList<>();
        int index = -1;

        if (session.getAttribute("cart") == null) {
            cart.add(new Item(productService.getProduct(req.getParameter("id")), 1));
            index = 0;
        } else {
            cart = (List<Item>) session.getAttribute("cart");
            index = isExists(req.getParameter("id"), cart);
            if (index == -1) {
                cart.add(new Item(productService.getProduct(req.getParameter("id")), 1));
                index = cart.size() - 1;
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
        }

        session.setAttribute("cart", cart);
        new CartService().saveItem(cart.get(index).getProduct());

        resp.sendRedirect("Cart");
    }

    private int isExists(String id, List<Item> cart) {
        for (int index = 0; index < cart.size(); index++) {
            if (cart.get(index).getProduct().getId().equalsIgnoreCase(id)) {
                return index;
            }
        }
        return -1;
    }
}
