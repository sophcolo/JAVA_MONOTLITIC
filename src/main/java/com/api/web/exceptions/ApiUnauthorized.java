package com.api.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Personality Exception of Status 401
 * @author Jonathan Colorado
 * @date 19-06-2022
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ApiUnauthorized extends Exception{
	/**
	 * 
	*/
	private static final long serialVersionUID = 1L;

	public ApiUnauthorized(String message) {
		super(message);
	}
}
