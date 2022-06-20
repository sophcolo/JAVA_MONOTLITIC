package com.api.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="wwa_catalogo_dispositivo")
public class DeviceCatalog extends BaseEntity{

	  @Id @Column(length = 50) private String id_dispositivo; 
	  @Column(nullable = false) private String agente;
	  @Column(nullable = false) private String identificador;
	  @Column(length = 20) private String numero_telefono;
	  @Column(length = 50) private String operador_telefonico;
	  @Column(nullable = false,length = 50) private String sistema_operativo;
	  @Column(nullable = false,length = 50) private String version_sistema;
	  @Column(nullable = false,length = 50) private String modelo_dispositivo;
	  @Column(nullable = false,length = 25) private String estado_dispositivo;
	  @Column(nullable = false,length = 50) private String usuario_ingresa; 
	  @Column(length = 50) private String usuario_modifica; 
	  @Column(length = 15) private String numero_imei;
	  @Column(length = 17) private String direccion_wifi;
	  @Column(length = 17) private String direccion_bluetooth;
	  @Column(length = 20) private String numero_serie;
}