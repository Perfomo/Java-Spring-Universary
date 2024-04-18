package com.toleyko.servlets;

import com.toleyko.service.FontServiveImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "FontExamples", urlPatterns = "/fontExamples/*")
public class FontExamples extends HttpServlet {

    private FontServiveImpl fontServive = new FontServiveImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp-resources/getFontSizeAndAmount.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(Integer.parseInt(req.getParameter("textAmount")));
        System.out.println(Integer.parseInt(req.getParameter("textSize")));
        String[] res = fontServive.generateRows(Integer.parseInt(req.getParameter("textAmount")));
        System.out.println(res.length);
        req.setAttribute("rows", res);
        req.setAttribute("fontSize", req.getParameter("textSize"));
        req.getRequestDispatcher("jsp-resources/showFont.jsp").forward(req, resp);
    }
}
