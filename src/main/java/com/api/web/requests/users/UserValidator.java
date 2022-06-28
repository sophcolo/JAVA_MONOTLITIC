package com.api.web.requests.users;
import org.springframework.stereotype.Component;

import com.api.web.dtos.UserRequest;
import com.api.web.exceptions.ApiUnprocessableEntity;


@Component
public class UserValidator implements EntityValidatorInterface<UserRequest>{
	
	@Override
	public void validatorRequest(UserRequest request ) throws ApiUnprocessableEntity {
		if(request.getUsr() == null || request.getUsr().isEmpty()) {
			message("El Identificador del Usuario 'usr' es Obligatorio");
		}
		
		if(request.getTen() == null || request.getTen().isEmpty()) {
			message("El Campo 'ten' es Obligatorio");
		}
		
		
		if(request.getEnt() == null || request.getEnt().isEmpty()) {
			message("El campo 'ent' es Obligatorio");
		}
		
		if(request.getTfa() == null) {
			message("El campo 'tfa' es Obligatorio");
		}
		
		
		if(request.getScl() == null) {
			message("El campo 'scl' es Obligatorio");
		}
		
		
		if(request.getSse() == null) {
			message("El campo 'sse' es Obligatorio");
		}
		
		if(request.getSco() == null || request.getSco().isEmpty()) {
			message("El campo 'sco' es Obligatorio");
		}
	}
	
	private void message(String message) throws ApiUnprocessableEntity{
		throw new ApiUnprocessableEntity(message);
	}
}