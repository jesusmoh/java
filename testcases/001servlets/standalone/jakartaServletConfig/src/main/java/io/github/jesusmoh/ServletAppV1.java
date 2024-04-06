package io.github.jesusmoh;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletAppV1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        ServletConfig servletConfig = getServletConfig();
        writer.println("<html><body>");
        writer.println("driverName : " + servletConfig.getInitParameter("driverNameV1") + "<br>");
        writer.println("userName : " + servletConfig.getInitParameter("userNameV1") + "<br>");
        writer.println("password : " + servletConfig.getInitParameter("passwordV1") + "<br>");
        writer.println("Welcome to..." + LocalDate.now());
        writer.println("</body></html>");
        writer.close();
    }
}
