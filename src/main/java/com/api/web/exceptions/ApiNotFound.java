package com.api.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Personality Exception of Status 404
 * @author Jonathan Colorado
 * @date 19-06-2022
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiNotFound extends Exception{
	/**
	 * 
	*/
	private static final long serialVersionUID = 860706628677333883L;

	public ApiNotFound(String message) {
		super(message);
	}
}