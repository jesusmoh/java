package io.github.jesusmoh;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletApp", urlPatterns = { "/ServletApp" }, initParams = {
        @WebInitParam(name = "driverName", value = "sun.jdbc.odbc.JdbcOdbcDriver"),
        @WebInitParam(name = "userName", value = "System"),
        @WebInitParam(name = "password", value = "Oracle")
})
public class ServletApp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        ServletConfig servletConfig = getServletConfig();
        writer.println("<html><body>");
        writer.println("driverName : " + servletConfig.getInitParameter("driverName") + "<br>");
        writer.println("userName : " + servletConfig.getInitParameter("userName") + "<br>");
        writer.println("password : " + servletConfig.getInitParameter("password") + "<br>");
        writer.println("Welcome to..." + LocalDate.now());
        writer.println("</body></html>");
        writer.close();
    }
}
