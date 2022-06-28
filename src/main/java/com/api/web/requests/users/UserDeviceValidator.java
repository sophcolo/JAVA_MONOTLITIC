package com.api.web.requests.users;

import org.springframework.stereotype.Component;

import com.api.web.dtos.UserDeviceRequest;
import com.api.web.exceptions.ApiUnprocessableEntity;

@Component
public class UserDeviceValidator implements EntityValidatorInterface<UserDeviceRequest>{
	@Override
	public void validatorRequest(UserDeviceRequest request ) throws ApiUnprocessableEntity {
		if(request.getUsuario_id() == null || request.getUsuario_id().isEmpty()) {
			message("El Identificador del usuario es Obligatorio");
		}
		
		if(request.getDevice_id() == null  || request.getDevice_id().isEmpty()) {
			message("El Campo device catalog es Obligatorio");
		}
		
		if(request.getNombre_dispositivo() == null  || request.getNombre_dispositivo().isEmpty()) {
			message("El Nombre del Dispositivo es obligatorio");
		}
	}
	
	private void message(String message) throws ApiUnprocessableEntity{
		throw new ApiUnprocessableEntity(message);
	}
}
