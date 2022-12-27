package com.tiago.bookstore.resource.exception;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tiago.bookstore.services.exception.DataIntegrityVaiolationException;
import com.tiago.bookstore.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request){
		StandardError error = new StandardError
				(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	/*Standarderror foi instanciado com os Três Atributos*/

	@ExceptionHandler(DataIntegrityVaiolationException.class)
	public ResponseEntity<StandardError> dataIntegrityVaiolationException(DataIntegrityVaiolationException e, ServletRequest request){
		StandardError error = new StandardError
				(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		/*Este manipulador StandarError retorna um HttpStatus.BAD_REQUEST
		 * Sua classe de parametro é o DataIntegrityVaiolationException e um ServletRequest*/
	}


}
