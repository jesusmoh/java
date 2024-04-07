package io.github.jesusmoh;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            ServletContext context = getServletContext();
            String topicName = context.getInitParameter("topicName");
            writer.println("topicName : " + topicName);
            String userName = req.getParameter("userName");
            writer.println("userName : " + userName);
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
