package com.jesusmoh.exceptions;

import java.io.IOException;
import java.util.logging.Level;
//import javax.servlet.http.HttpServletResponse;
//import javax.validation.ConstraintViolation;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletResponse;

//import javax.validation.ConstraintViolationException;
import java.util.logging.Logger;
//import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

	static final Logger log = Logger.getLogger(GlobalExceptionHandlerController.class.getName());

	@ExceptionHandler(UrpException.class)
	public void handleCustomUrpException(HttpServletResponse res, UrpException ex) throws IOException {
		res.sendError(HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage());
	}

}
