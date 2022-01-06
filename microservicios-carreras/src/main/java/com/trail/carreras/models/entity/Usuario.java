package com.trail.carreras.models.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario")
public class Usuario {

	private Long id;

	private String nombre;

	private String apellido;

	@NotNull
	private String user;

	@NotNull
	private String password;

	private String image;

	private boolean status;

	private Long idpost;

	public Usuario(Long id, String nombre, String apellido, @NotNull String user, @NotNull String password,
			String image, boolean status, Long idpost) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.user = user;
		this.password = password;
		this.image = image;
		this.status = status;
		this.idpost = idpost;
	}

	public Usuario() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Long getIdpost() {
		return idpost;
	}

	public void setIdpost(Long idpost) {
		this.idpost = idpost;
	}

}
