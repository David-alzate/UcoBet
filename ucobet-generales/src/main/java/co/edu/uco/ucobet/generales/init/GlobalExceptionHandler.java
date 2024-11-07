package co.edu.uco.ucobet.generales.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		logger.error("Unhandled exception: ", ex);
		String errorMessage = "An error occurred: " + ex.getMessage();
		return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RuleUcobetException.class)
	public ResponseEntity<String> handleRuleUcobetException(RuleUcobetException ex) {
		logger.error("Rule error: ", ex);
		String userMessage = ex.getUserMessage(); // Mensaje para el usuario
		return new ResponseEntity<>(userMessage, HttpStatus.BAD_REQUEST);
	}
}
