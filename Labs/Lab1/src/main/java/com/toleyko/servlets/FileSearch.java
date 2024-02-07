package com.toleyko.servlets;

import com.toleyko.dao.FileSearchDAO;
import com.toleyko.dao.FileSearchDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@WebServlet(name = "FileSearch", urlPatterns = "/fileSearch/*")
public class FileSearch extends HttpServlet {

//    @Autowired
    private FileSearchDaoImpl fileSearchDao = new FileSearchDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp-resources/getWordForFileSearch.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int freq = fileSearchDao.findAndGetWordFrequence(req.getParameter("wordAttribute"));
        String res = "Word '" + req.getParameter("wordAttribute") + "' freq is " + freq;
        req.setAttribute("res", res);
        req.getRequestDispatcher("jsp-resources/showWordFreq.jsp").forward(req, resp);
    }
}
