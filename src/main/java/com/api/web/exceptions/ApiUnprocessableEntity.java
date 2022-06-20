package com.api.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Personality Exception of Status 422
 * @author Jonathan Colorado
 * @date 19-06-2022
 */
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ApiUnprocessableEntity extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApiUnprocessableEntity(String message) {
		super(message);
	}
}
