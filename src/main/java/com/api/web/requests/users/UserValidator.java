package com.api.web.requests.users;
import org.springframework.stereotype.Component;

import com.api.web.dtos.UserRequest;
import com.api.web.exceptions.ApiUnprocessableEntity;


@Component
public class UserValidator implements EntityValidatorInterface{
	
	@Override
	public void validatorRequest(UserRequest request ) throws ApiUnprocessableEntity {
		if(request.getAda() == null) {
			message("El Ada es Obligatorio");
		}
	}
	
	private void message(String message) throws ApiUnprocessableEntity{
		throw new ApiUnprocessableEntity(message);
	}
}