package com.api.web.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DeviceCatalogRequest {

	  @JsonProperty("id_dispositivo")
	  private String id_dispositivo;
	  @JsonProperty("identificador")
	  private String identificador;
	  @JsonProperty("agente")
	  private String agente;
	  @JsonProperty("numero_telefono")
	  private String numero_telefono;
	  @JsonProperty("operador_telefonico")
	  private String operador_telefonico;
	  @JsonProperty("sistema_operativo")
	  private String sistema_operativo;
	  @JsonProperty("version_sistema")
	  private String version_sistema;
	  @JsonProperty("modelo_dispositivo")
	  private String modelo_dispositivo;
	  @JsonProperty("estado_dispositivo")
	  private String estado_dispositivo;
	  @JsonProperty("usuario_ingresa")
	  private String usuario_ingresa;
}