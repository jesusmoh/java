package io.github.jesusmoh.zproduct.common.util;

import java.util.Enumeration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.servlet.http.HttpServletRequest;

public class RequestToJsonConverter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String convertToJson(HttpServletRequest request) {
        ObjectNode requestJson = objectMapper.createObjectNode();

        // Add request properties to the JSON object
        requestJson.put("requestURI", request.getRequestURI());
        requestJson.put("requestMethod", request.getMethod());
        requestJson.put("remoteAddr", request.getRemoteAddr());
        requestJson.put("remoteHost", request.getRemoteHost());

        // Add request headers to the JSON object
        ObjectNode headersJson = objectMapper.createObjectNode();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headersJson.put(headerName, request.getHeader(headerName));
        }
        requestJson.set("headers", headersJson);

        // Add request parameters to the JSON object
        ObjectNode parametersJson = objectMapper.createObjectNode();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            parametersJson.put(parameterName, request.getParameter(parameterName));
        }
        requestJson.set("parameters", parametersJson);

        return requestJson.toString();
    }
}
