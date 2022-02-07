package com.drr.bean.model;

import java.io.Serializable;

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
@Table(name="persona")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="de_nomb")
	private String nombre;
	
	@Column(name="de_ape_pat")
	private String apellidoPaterno;
	
	@Column(name="de_ape_mat")
	private String apellidoMaterno;

}
