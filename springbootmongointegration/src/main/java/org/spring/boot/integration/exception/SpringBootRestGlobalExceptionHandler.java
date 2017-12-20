package org.spring.boot.integration.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.StaleObjectStateException;
import org.hibernate.StaleStateException;
import org.springframework.core.annotation.Order;
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
	public String handleCustomException(Throwable ex, HttpServletRequest request)
	{
		LOGGER.error("Exception Occured in URL= {} Exception: ", request.getRequestURI(), ex);
		return "\"Something Went Wrong. Please try Again!!!\"";
	}

	@ExceptionHandler(HibernateOptimisticLockingFailureException.class)
	public String handleHibernateOptimisticLockingFailureException(Throwable ex, HttpServletRequest request)
	{
		LOGGER.error("Exception Occured in URL= {} Exception: ", request.getRequestURI(), ex);
		return "\"Something Went Wrong. Please try Again!!!\"";
	}

	@ExceptionHandler(SpringBootException.class)
	public String handleEEHeraldException(Throwable ex, HttpServletRequest request)
	{
		LOGGER.error("Exception Occured in URL= {} Exception: ", request.getRequestURI(), ex);
		return "\"Something Went Wrong. Please try Again!!!\"";
	}

	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(Throwable ex, HttpServletRequest request)
	{
		LOGGER.error("Exception Occured in URL= {} Exception: ", request.getRequestURI(), ex);
		return "\"Something Went Wrong. Please try Again!!!\"";
	}

	@ExceptionHandler(StaleObjectStateException.class)
	public String handleStaleObjectStateException(Throwable ex, HttpServletRequest request)
	{
		LOGGER.error("Exception Occured in URL= {} Exception: ", request.getRequestURI(), ex);
		return "\"Something Went Wrong. Please try Again!!!\"";
	}

	@ExceptionHandler(StaleStateException.class)
	public String handleStaleStateException(Throwable ex, HttpServletRequest request)
	{
		LOGGER.error("Exception Occured in URL= {} Exception: ", request.getRequestURI(), ex);
		return "\"Something Went Wrong. Please try Again!!!\"";
	}

}
