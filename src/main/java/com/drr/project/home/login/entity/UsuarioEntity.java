package com.drr.project.home.login.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="tipo_usuario")
	private String tipoUsuario;
	
	@Column(name="de_usua")
	private String usuario;
	
	@Column(name="de_pass_usua")
	private String contrasena;

	@Column(name="de_email")
	private String email;
	
	@Column(name="fe_crea")
	private Date fechaCreacion;
	
}
