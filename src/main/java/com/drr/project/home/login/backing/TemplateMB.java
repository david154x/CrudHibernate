package com.drr.project.home.login.backing;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.drr.project.home.login.entity.UsuarioEntity;

@Named
@ViewScoped
public class TemplateMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 public void verificarSesion() {
		 FacesContext fc = FacesContext.getCurrentInstance();
		 try {
			UsuarioEntity usuario = (UsuarioEntity)fc.getExternalContext().getSessionMap().get("usuario");
			if(usuario == null) {
				fc.getCurrentInstance().getExternalContext().redirect("./../permisos.xhtml");
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	 }
	 
	 public void cerrarSesionMB() {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.getExternalContext().invalidateSession();
			String redireccion = "../index.xhtml?"; 
			String visible = "?faces-redirect=true";
			try {
				fc.getExternalContext().redirect(redireccion);
			} catch (IOException e) {
				e.printStackTrace(System.out);
			}
		}
	 
	 

}
