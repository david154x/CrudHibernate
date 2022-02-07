package com.drr.project.home.login.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_usuario")
    private UsuarioEntity tipoUsuario;
	
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "url")
    private String url;
    
    @Column(name = "icono")
    private String icono;

    @Column(name = "tipo")
    private String tipo;
    
    @ManyToOne
    @JoinColumn(name = "submenu")
    private MenuEntity subMenu;
    
    @Column(name = "estado")
    private String estado;

}
