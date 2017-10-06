package cn.sinjinsong.eshop.common.controller.advice;


import cn.sinjinsong.eshop.common.exception.base.BaseRESTException;
import cn.sinjinsong.eshop.common.exception.domain.RESTError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RESTExceptionHandler {
	
	@ExceptionHandler(BaseRESTException.class)
	public ResponseEntity<RESTError> handle(BaseRESTException e) {
		return new ResponseEntity<>(new RESTError(e.getStatus(), e.getCode(), e.getErrors(), e.getMoreInfoURL()), e.getStatus());
	}
	
}
