package com.ubots.winesale.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WineSaleRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<WineSaleErrorResponse> handleException(ListNotFoundException exc) {

		WineSaleErrorResponse error = new WineSaleErrorResponse();

		error.setStatus(HttpStatus.NO_CONTENT.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NO_CONTENT);
	}
}
