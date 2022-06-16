package com.api.web.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public abstract class BaseEntity {
    public LocalDateTime getFecha_ingresa() {
		return fecha_ingresa;
	}
	public LocalDateTime getFecha_modifica() {
		return fecha_modifica;
	}
	public void setFecha_ingresa(LocalDateTime fecha_ingresa) {
		this.fecha_ingresa = fecha_ingresa;
	}
	public void setFecha_modifica(LocalDateTime fecha_modifica) {
		this.fecha_modifica = fecha_modifica;
	}
	@Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime fecha_ingresa;
    @UpdateTimestamp
    private LocalDateTime fecha_modifica;
}