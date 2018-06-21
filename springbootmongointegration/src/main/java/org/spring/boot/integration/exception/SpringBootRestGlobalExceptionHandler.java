package org.spring.boot.integration.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.StaleObjectStateException;
import org.hibernate.StaleStateException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate4.HibernateOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
@Order(1)
public class SpringBootRestGlobalExceptionHandler
{

	private static final Logger LOGGER = LogManager.getLogger(SpringBootRestGlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleCustomException(Throwable ex, HttpServletRequest request)
	{
		LOGGER.error("Exception Occured in URL= {} Exception: ", request.getRequestURI(), ex);

		String errorMessage = "\"Something Went Wrong. Please try Again!!!\"";

		ResponseEntity<Object> response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		return response;
	}

	@ExceptionHandler(HibernateOptimisticLockingFailureException.class)
	public ResponseEntity<Object> handleHibernateOptimisticLockingFailureException(Throwable ex,
			HttpServletRequest request)
	{
		LOGGER.error("Exception Occured in URL= {} Exception: ", request.getRequestURI(), ex);

		String errorMessage = "\"Please get the latest data from database before updating!!!\"";
		ResponseEntity<Object> response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);

		return response;
	}

	@ExceptionHandler(SpringBootException.class)
	public ResponseEntity<Object> handleEEHeraldException(Throwable ex, HttpServletRequest request)
	{
		LOGGER.error("Exception Occured in URL= {} Exception: ", request.getRequestURI(), ex);

		String errorMessage = "\"Something Went Wrong. Please try Again!!!\"";
		ResponseEntity<Object> response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);

		return response;
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> handleRuntimeException(Throwable ex, HttpServletRequest request)
	{
		LOGGER.error("Exception Occured in URL= {} Exception: ", request.getRequestURI(), ex);

		String errorMessage = "\"Something Went Wrong. Please try Again!!!\"";
		ResponseEntity<Object> response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);

		return response;
	}

	@ExceptionHandler(StaleObjectStateException.class)
	public ResponseEntity<Object> handleStaleObjectStateException(Throwable ex, HttpServletRequest request)
	{
		LOGGER.error("Exception Occured in URL= {} Exception: ", request.getRequestURI(), ex);

		String errorMessage = "\"Something Went Wrong. Please try Again!!!\"";
		ResponseEntity<Object> response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);

		return response;
	}

	@ExceptionHandler(StaleStateException.class)
	public ResponseEntity<Object> handleStaleStateException(Throwable ex, HttpServletRequest request)
	{
		LOGGER.error("Exception Occured in URL= {} Exception: ", request.getRequestURI(), ex);

		String errorMessage = "\"Something Went Wrong. Please try Again!!!\"";
		ResponseEntity<Object> response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);

		return response;
	}

}
