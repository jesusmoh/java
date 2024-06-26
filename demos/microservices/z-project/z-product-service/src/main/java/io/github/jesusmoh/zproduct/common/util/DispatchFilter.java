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

    private static String dispatchFilter = "DispatchFilter >> ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        long startTime = System.currentTimeMillis();
        final String data = RequestToJsonConverter.convertToJson(request);

        // Process the request
        filterChain.doFilter(request, response);

        long endTime = System.currentTimeMillis();
        long processingTime = endTime - startTime;

        log.info(dispatchFilter.concat("IN/OUT : " + processingTime + " ms. Data >> ").concat(data));
    }
}
