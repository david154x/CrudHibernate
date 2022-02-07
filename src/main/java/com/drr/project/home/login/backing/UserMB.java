package com.drr.project.home.login.backing;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.drr.project.home.login.entity.UsuarioEntity;
import com.drr.project.home.login.services.IUserService;
import com.drr.project.home.login.services.impl.UserServiceImpl;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class UserMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Produces
	@Model
	public String titulo() {
		return "Hola mundo desde el backed";
	}
	
	private IUserService userService;
	
	@Inject
	@Getter @Setter
	private UsuarioEntity usuario;
	
	public void iniciarSesion() {
		userService = new UserServiceImpl();
		boolean acces;
		FacesContext fc = FacesContext.getCurrentInstance();
		String redireccion = null;
		String visible = "?faces-redirect=true"; 
		try {
			acces = userService.consultarUsuario(usuario.getUsuario(), usuario.getContrasena());
			if(acces) {
				redireccion = "./template/templateDashboard.xhtml";
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info","Bienvenido: "+usuario.getUsuario()));
				fc.getExternalContext().getSessionMap().put("usuario", usuario);
				fc.getExternalContext().redirect(redireccion);
			}
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
}
