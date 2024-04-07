package io.github.jesusmoh;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String incomingURI = ((HttpServletRequest) request).getRequestURI();
        System.out.println("incomingURI : " + incomingURI);
        if (incomingURI.contains("/user/login")) {
            Long startTime = System.currentTimeMillis();
            chain.doFilter(request, response);
            Long endTime = System.currentTimeMillis();
            System.out.println("Total time taken = " + (endTime - startTime) + " ms");
        } else {
            try {
                throw new Exception("Invalid URL, please enter valid URL.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
