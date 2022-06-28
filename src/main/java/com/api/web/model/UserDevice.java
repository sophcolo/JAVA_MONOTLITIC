package com.api.web.model;


import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
@Table(name="wwa_usuario_dispositivo")
public class UserDevice {
	 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)  private Integer id; 
	 @ManyToOne(optional = false)  @JoinColumn(name="usuario") private Usuario usuario;
	 @ManyToOne(optional = false) @JoinColumn(name="id_dispositivo") private DeviceCatalog deviceCatalog;
	 @Column(length = 50) private String id_detectid;
	 @Column(length = 4) private String estado_detectid;
	 @Column(length = 4) private String estado_mantenimiento;
	 @Column(length = 50) private String nombre_dispositivo;
	 @Column(length = 50) private String usuario_ingresa; 
	 @Column(length = 50) private String usuario_modifica; 
}
