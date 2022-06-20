package com.api.web.requests;

import org.springframework.stereotype.Component;

import com.api.web.dtos.DeviceCatalogRequest;
import com.api.web.exceptions.ApiUnprocessableEntity;

@Component
public class DeviceCatalogValidator implements DeviceCatalogValidatorInterface{

	@Override
	public void validator(DeviceCatalogRequest request) throws ApiUnprocessableEntity {
		if(request.getAgente() == null || request.getAgente().isEmpty()) {
			message("El Agente es obligatorio");
		}
		if(request.getIdentificador() == null || request.getIdentificador().isEmpty()) {
			message("El Identificador es obligatorio");
		}
		if(request.getOperador_telefonico()== null || request.getOperador_telefonico().isEmpty()) {
			message("El Operador Telefónico  es obligatorio");
		}
		if(request.getSistema_operativo()== null || request.getSistema_operativo().isEmpty()) {
			message("El Sistema Operativo es obligatorio");
		}
		if(request.getVersion_sistema()== null || request.getVersion_sistema().isEmpty()) {
			message("La Versión del Sistema Operativo es obligatoria");
		}
		if(request.getEstado_dispositivo()== null || request.getEstado_dispositivo().isEmpty()) {
			message("El Estado del Sistema Operativo es obligatorio");
		}
	}
	
	private void message(String message) throws ApiUnprocessableEntity{
		throw new ApiUnprocessableEntity(message);
	}
}
