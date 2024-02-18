package kz.bitlab.shop.items.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.shop.items.service.ItemService;

import java.io.IOException;

@WebServlet("/topSales")
public class TopSalesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("itemList", ItemService.findTopSales());
        req.getRequestDispatcher("/topSales.jsp").forward(req, resp);
    }

}