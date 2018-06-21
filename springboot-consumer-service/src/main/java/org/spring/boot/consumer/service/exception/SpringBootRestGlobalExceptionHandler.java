package org.spring.boot.consumer.service.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(annotations = Controller.class)
@Order(1)
public class SpringBootRestGlobalExceptionHandler
{

	private static final Logger LOGGER = LogManager.getLogger(SpringBootRestGlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public ModelAndView handleCustomException(Throwable ex, HttpServletRequest request)
	{
		LOGGER.error("Exception Occured in URL= {}, Exception: ", request.getRequestURI(), ex);
		ModelAndView model = new ModelAndView("error");
		model.addObject("error", "Something Went Wrong. Please try Again!!!");

		return model;
	}

	@ExceptionHandler(RestClientException.class)
	public ModelAndView handleRestClientException(Throwable ex, HttpServletRequest request)
	{
		LOGGER.error("Exception Occured in URL= {}, Exception: ", request.getRequestURI(), ex);
		ModelAndView model = new ModelAndView("error");
		model.addObject("error", "Something Went Wrong. Please try Again!!!");

		return model;
	}

	@ExceptionHandler(SpringBootException.class)
	public ModelAndView handleSpringBootException(Throwable ex, HttpServletRequest request)
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

}
