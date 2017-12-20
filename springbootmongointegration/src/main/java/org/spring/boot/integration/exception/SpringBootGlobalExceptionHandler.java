package org.spring.boot.integration.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.StaleObjectStateException;
import org.hibernate.StaleStateException;
import org.springframework.core.annotation.Order;
import org.springframework.orm.hibernate4.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * Global Exception Handler to handle all the Exceptions
 * 
 * @author visakh
 *
 */
@ControllerAdvice(annotations = Controller.class)
@Order(2)
public class SpringBootGlobalExceptionHandler extends SimpleMappingExceptionResolver
{

	private static final Logger LOGGER = LogManager.getLogger(SpringBootGlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public ModelAndView handleCustomException(Throwable ex, HttpServletRequest request)
	{
		LOGGER.error("Exception Occured in URL= {}, Exception: ", request.getRequestURI(), ex);
		ModelAndView model = new ModelAndView("error");
		model.addObject("error", "Something Went Wrong. Please try Again!!!");

		return model;
	}

	@ExceptionHandler(HibernateOptimisticLockingFailureException.class)
	public ModelAndView handleHibernateOptimisticLockingFailureException(Throwable ex, HttpServletRequest request)
	{
		LOGGER.error("Exception Occured in URL= {}, Exception: ", request.getRequestURI(), ex);
		ModelAndView model = new ModelAndView("error");
		model.addObject("error", "Someone has updated the table. Please get the latest content to proceed further");

		return model;
	}

	@ExceptionHandler(SpringBootException.class)
	public ModelAndView handleEEHeraldException(Throwable ex, HttpServletRequest request)
	{
		LOGGER.error("Exception Occured in URL= {}, Exception: ", request.getRequestURI(), ex);
		ModelAndView model = new ModelAndView("error");
		model.addObject("error", ex.getMessage());

		return model;
	}

	@ExceptionHandler(RuntimeException.class)
	public ModelAndView handleRuntimeException(Throwable ex, HttpServletRequest request)
	{
		LOGGER.error("Exception Occured in URL= {} Exception: ", request.getRequestURI(), ex);
		ModelAndView model = new ModelAndView("error");
		model.addObject("error", "Something went wrong. Please try again!!!");

		return model;
	}

	@ExceptionHandler(StaleObjectStateException.class)
	public ModelAndView handleStaleObjectStateException(Throwable ex, HttpServletRequest request)
	{
		LOGGER.error("Exception Occured in URL= {}, Exception: ", request.getRequestURI(), ex);
		ModelAndView model = new ModelAndView("error");
		model.addObject("error", "Something went wrong. Please try again!!!");

		return model;
	}

	@ExceptionHandler(StaleStateException.class)
	public ModelAndView handleStaleStateException(Throwable ex, HttpServletRequest request)
	{
		LOGGER.error("Exception Occured in URL= {}, Exception: ", request.getRequestURI(), ex);
		ModelAndView model = new ModelAndView("error");
		model.addObject("error", "Something went wrong. Please try again!!!");

		return model;
	}

}
