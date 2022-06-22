package com.api.web.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeviceCatalogDTO{
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
	  @JsonProperty("usuario_modifica")
	  private String usuario_modifica;
	  @JsonProperty("numero_imei")
	  private String numero_imei;
	  @JsonProperty("direccion_wifi")
	  private String direccion_wifi;
	  @JsonProperty("direccion_bluetooth")
	  private String direccion_bluetooth;
	  @JsonProperty("numero_serie")
	  private String numero_serie;
}