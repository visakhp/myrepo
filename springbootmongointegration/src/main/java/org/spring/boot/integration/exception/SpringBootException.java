package org.spring.boot.integration.exception;


/**
 * 
 * @author visakh
 *
 */
public class SpringBootException extends Exception {

  private static final long serialVersionUID = 1L;
  
  public SpringBootException(String message){
      super(message);
  }
   

}
