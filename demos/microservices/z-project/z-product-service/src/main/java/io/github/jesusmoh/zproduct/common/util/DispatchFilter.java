package io.github.jesusmoh.zproduct.common.util;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Component
public class DispatchFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String uuid = LogAuditFactory.getKey().concat(" ");
        long startTime = System.currentTimeMillis();

        // Process the request
        filterChain.doFilter(request, response);

        long endTime = System.currentTimeMillis();
        long processingTime = endTime - startTime;
        log.info(uuid.concat("IN/OUT processingTime : " + processingTime + " ms"));
    }
}
