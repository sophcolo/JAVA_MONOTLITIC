package com.api.web.dtos;

import java.util.Date;

import lombok.*;

import com.api.web.model.DeviceCatalog;
import com.api.web.model.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDeviceRequest {
	 @JsonProperty("id") private Integer id;
	 @JsonProperty("usuario_id") private String usuario_id;
	 @JsonProperty("usuario") private Usuario usuario;
	 @JsonProperty("device_id") private String device_id;
	 @JsonProperty("deviceCatalog") private DeviceCatalog deviceCatalog;
	 @JsonProperty("id_detectid") private String id_detectid;
	 @JsonProperty("estado_detectid") private String estado_detectid;
	 @JsonProperty("estado_mantenimiento") private String estado_mantenimiento;
	 @JsonProperty("nombre_dispositivo") private String nombre_dispositivo;
	 @JsonProperty("usuario_ingresa") private String usuario_ingresa;
	 @JsonProperty("fecha_ingresa") private Date fecha_ingresa; 
	 @JsonProperty("usuario_modifica") private String usuario_modifica;
	 @JsonProperty("fecha_modifica") private Date fecha_modifica;
}
