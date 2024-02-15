package com.toleyko.servlets;

import com.toleyko.dao.CollectionSearchDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CollectionSearch", urlPatterns = "/collectionSearch/*")
public class CollectionSearch extends HttpServlet {

    private CollectionSearchDAOImpl collectionSearchDAO = new CollectionSearchDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp-resources/getChangeCollectionValue.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String findInfo = req.getParameter("findText");
        String isChange = req.getParameter("ifChange");
        String res;
        if (findInfo.isEmpty()) {
            req.setAttribute("res", "Error: empty 'input key' field");
            req.getRequestDispatcher("jsp-resources/showWordFreq.jsp").forward(req, resp);
        }
        else {
            if (isChange == null) {
                String infoVal = collectionSearchDAO.findInfo(findInfo);
                if (infoVal == null) {
                    res = "No such key: " + findInfo;
                }
                else {
                    res = findInfo + " value is " + infoVal;
                }
                req.setAttribute("res", res);
                req.getRequestDispatcher("jsp-resources/showWordFreq.jsp").forward(req, resp);
            }
            else {
                String newValueInfo = req.getParameter("changeText");
                if (newValueInfo.isEmpty()) {
                    req.setAttribute("res", "Error: empty 'input change info' field");
                    req.getRequestDispatcher("jsp-resources/showWordFreq.jsp").forward(req, resp);
                }
                else {
                    String prevInfoVal = collectionSearchDAO.findInfo(findInfo);
                    if (prevInfoVal == null) {
                        res = "No such key: " + findInfo;
                    }
                    else {
                        collectionSearchDAO.changeInfo(findInfo, newValueInfo);
                        res = "Info from key '" + findInfo + "' changed from " + prevInfoVal + " to " + newValueInfo;
                    }
                    req.setAttribute("res", res);
                    req.getRequestDispatcher("jsp-resources/showWordFreq.jsp").forward(req, resp);
                }
            }
        }
    }
}
