package com.api.web.model;
import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="wwa_usuario_dispositivo")
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
	 public Integer getId() {
		return id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public DeviceCatalog getDeviceCatalog() {
		return deviceCatalog;
	}
	public String getId_detectid() {
		return id_detectid;
	}
	public String getEstado_detectid() {
		return estado_detectid;
	}
	public String getEstado_mantenimiento() {
		return estado_mantenimiento;
	}
	public String getNombre_dispositivo() {
		return nombre_dispositivo;
	}
	public String getUsuario_ingresa() {
		return usuario_ingresa;
	}
	public String getUsuario_modifica() {
		return usuario_modifica;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void setDeviceCatalog(DeviceCatalog deviceCatalog) {
		this.deviceCatalog = deviceCatalog;
	}
	public void setId_detectid(String id_detectid) {
		this.id_detectid = id_detectid;
	}
	public void setEstado_detectid(String estado_detectid) {
		this.estado_detectid = estado_detectid;
	}
	public void setEstado_mantenimiento(String estado_mantenimiento) {
		this.estado_mantenimiento = estado_mantenimiento;
	}
	public void setNombre_dispositivo(String nombre_dispositivo) {
		this.nombre_dispositivo = nombre_dispositivo;
	}
	public void setUsuario_ingresa(String usuario_ingresa) {
		this.usuario_ingresa = usuario_ingresa;
	}
	public void setUsuario_modifica(String usuario_modifica) {
		this.usuario_modifica = usuario_modifica;
	}
	@Column(length = 50) private String usuario_ingresa;
	 //@Temporal(TemporalType.TIMESTAMP) @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") private Date fecha_ingresa; 
	 @Column(length = 50) private String usuario_modifica;
	 //@Temporal(TemporalType.TIMESTAMP) @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") private Date fecha_modifica; 
}
