package core.exceptions;

import java.io.IOException;
import java.util.logging.Level;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.servlet.http.HttpServletResponse;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;

@RestControllerAdvice
public class UrpGlobalExceptionHandlerController {

	static final Logger log = Logger.getLogger(UrpGlobalExceptionHandlerController.class.getName());

	@ExceptionHandler(UrpException.class)
	public void handleCustomUrpException(HttpServletResponse res, UrpException ex) throws IOException {
		res.sendError(HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage());
	}

}
