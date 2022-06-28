package com.api.web.requests.users;

import org.springframework.stereotype.Component;

import com.api.web.dtos.UserDeviceRequest;
import com.api.web.exceptions.ApiUnprocessableEntity;

@Component
public class UserDeviceValidator implements EntityValidatorInterface<UserDeviceRequest>{
	@Override
	public void validatorRequest(UserDeviceRequest request ) throws ApiUnprocessableEntity {
		if(request.getUsuario_id() == null ) {
			message("El Identificador del usuario es Obligatorio");
		}
		
		if(request.getDevice_id() == null ) {
			message("El Campo device catalog es Obligatorio");
		}
	}
	
	private void message(String message) throws ApiUnprocessableEntity{
		throw new ApiUnprocessableEntity(message);
	}
}
