package com.api.web.model;

import java.util.Date;
//import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;

@Entity
@Table(name="catalogo_dispositivo")
public class DeviceCatalog{
	  @Id @Column(length = 50) private String id_dispositivo;
	  @Column(nullable = false) private String agente;
	  @Column(nullable = false) private String identificador;
	  @Column(length = 20) private String numero_telefono;
	  @Column(length = 50) private String operador_telefonico;
	  public String getId_dispositivo() {
		return id_dispositivo;
	}
	public String getAgente() {
		return agente;
	}
	public String getIdentificador() {
		return identificador;
	}
	public String getNumero_telefono() {
		return numero_telefono;
	}
	public String getOperador_telefonico() {
		return operador_telefonico;
	}
	public String getSistema_operativo() {
		return sistema_operativo;
	}
	public String getVersion_sistema() {
		return version_sistema;
	}
	public String getModelo_dispositivo() {
		return modelo_dispositivo;
	}
	public String getEstado_dispositivo() {
		return estado_dispositivo;
	}
	public String getUsuario_ingresa() {
		return usuario_ingresa;
	}
	public Date getFecha_ingresa() {
		return fecha_ingresa;
	}
	public String getUsuario_modifica() {
		return usuario_modifica;
	}
	public Date getFecha_modifica() {
		return fecha_modifica;
	}
	public String getNumero_imei() {
		return numero_imei;
	}
	public String getDireccion_wifi() {
		return direccion_wifi;
	}
	public String getDireccion_bluetooth() {
		return direccion_bluetooth;
	}
	public String getNumero_serie() {
		return numero_serie;
	}
	public void setId_dispositivo(String id_dispositivo) {
		this.id_dispositivo = id_dispositivo;
	}
	public void setAgente(String agente) {
		this.agente = agente;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public void setNumero_telefono(String numero_telefono) {
		this.numero_telefono = numero_telefono;
	}
	public void setOperador_telefonico(String operador_telefonico) {
		this.operador_telefonico = operador_telefonico;
	}
	public void setSistema_operativo(String sistema_operativo) {
		this.sistema_operativo = sistema_operativo;
	}
	public void setVersion_sistema(String version_sistema) {
		this.version_sistema = version_sistema;
	}
	public void setModelo_dispositivo(String modelo_dispositivo) {
		this.modelo_dispositivo = modelo_dispositivo;
	}
	public void setEstado_dispositivo(String estado_dispositivo) {
		this.estado_dispositivo = estado_dispositivo;
	}
	public void setUsuario_ingresa(String usuario_ingresa) {
		this.usuario_ingresa = usuario_ingresa;
	}
	public void setFecha_ingresa(Date fecha_ingresa) {
		this.fecha_ingresa = fecha_ingresa;
	}
	public void setUsuario_modifica(String usuario_modifica) {
		this.usuario_modifica = usuario_modifica;
	}
	public void setFecha_modifica(Date fecha_modifica) {
		this.fecha_modifica = fecha_modifica;
	}
	public void setNumero_imei(String numero_imei) {
		this.numero_imei = numero_imei;
	}
	public void setDireccion_wifi(String direccion_wifi) {
		this.direccion_wifi = direccion_wifi;
	}
	public void setDireccion_bluetooth(String direccion_bluetooth) {
		this.direccion_bluetooth = direccion_bluetooth;
	}
	public void setNumero_serie(String numero_serie) {
		this.numero_serie = numero_serie;
	}
	@Column(nullable = false,length = 50) private String sistema_operativo;
	  @Column(nullable = false,length = 50) private String version_sistema;
	  @Column(nullable = false,length = 50) private String modelo_dispositivo;
	  @Column(nullable = false,length = 25) private String estado_dispositivo;
	  @Column(nullable = false,length = 50) private String usuario_ingresa;
	  @Temporal(TemporalType.TIMESTAMP) @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") private Date fecha_ingresa; 
	  @Column(length = 50) private String usuario_modifica;
	  @Temporal(TemporalType.TIMESTAMP) @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") private Date fecha_modifica; 
	  @Column(length = 15) private String numero_imei;
	  @Column(length = 17) private String direccion_wifi;
	  @Column(length = 17) private String direccion_bluetooth;
	  @Column(length = 20) private String numero_serie;
	  
	  /*@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="deviceCatalog")
	  private List<UserDevice> userDevices;*/
}