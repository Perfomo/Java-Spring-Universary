package org.toleyko.servlets;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/ServletSynchronization")

public class ServletSynchronization extends HttpServlet {
    // Синхронизируемый объект
    private final StringBuilder locked = new StringBuilder();
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        Writer out = res.getWriter();
        out.write(makeString());
        out.flush();
    }
    private String makeString() {
// Оригинал строки
        final String SYNCHRO = "SYNCHRONIZATION";
        synchronized (locked) {
            try {
                for (int i = 0; i < SYNCHRO.length(); i++) {
                    locked.append(SYNCHRO.charAt(i));
                    Thread.sleep(500); }
            }
            catch (InterruptedException e) {
// Пустой
            }
            String result = locked.toString();
            locked.delete(0, SYNCHRO.length());
            return result;
        } // Ending synchronized block
    }
}