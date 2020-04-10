package com.ubots.winesale.exception;

public class ListNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -9059350717044785065L;

	public ListNotFoundException() {
	}

	public ListNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ListNotFoundException(String message) {
		super(message);
	}

	public ListNotFoundException(Throwable cause) {
		super(cause);
	}
}
