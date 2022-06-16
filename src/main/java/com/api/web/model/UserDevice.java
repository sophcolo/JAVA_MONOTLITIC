package com.api.web.model;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="usuario_dispositivo")
public class UserDevice{
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Integer id;
	 @ManyToOne(optional = false)
	 @JoinColumn(name="usuario")
	 private Usuario usuario;
	 @ManyToOne(optional = false)
	 @JoinColumn(name="id_dispositivo")
	 private DeviceCatalog deviceCatalog;
	 /*@ManyToOne(optional=false)
	 @JoinColumn(name="usuario", referencedColumnName="usuario")
	 private User user;*/
	 /*@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL,optional=false)
	 @JoinColumn(name="id_dispositivo", referencedColumnName="id_dispositivo")
	 private DeviceCatalog deviceCatalog;*/
	 @Column(length = 50) private String id_detectid;
	 @Column(length = 4) private String estado_detectid;
	 @Column(length = 4) private String estado_mantenimiento;
	 @Column(length = 50) private String nombre_dispositivo;
	 @Column(length = 50) private String usuario_ingresa;
	 @Temporal(TemporalType.TIMESTAMP) @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") private Date fecha_ingresa; 
	 @Column(length = 50) private String usuario_modifica;
	 @Temporal(TemporalType.TIMESTAMP) @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") private Date fecha_modifica; 
}
