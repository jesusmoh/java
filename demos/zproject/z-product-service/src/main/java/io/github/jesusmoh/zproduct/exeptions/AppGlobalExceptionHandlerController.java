package io.github.jesusmoh.zproduct.exeptions;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class AppGlobalExceptionHandlerController {

    @ExceptionHandler(AppException.class)
    public void handleCustomUrpException(HttpServletResponse res, AppException ex) throws IOException {
        res.sendError(HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage());
    }

}