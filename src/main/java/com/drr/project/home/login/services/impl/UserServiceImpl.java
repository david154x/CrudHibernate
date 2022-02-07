package com.drr.project.home.login.services.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.drr.project.home.login.entity.UsuarioEntity;
import com.drr.project.home.login.services.IUserService;
import com.drr.util.JpaUtil;

public class UserServiceImpl implements IUserService {

	EntityManager em = JpaUtil.getEntityManager();

	@Override
	public boolean consultarUsuario(String usuario, String contrasena) {
		Query query;
		try {
			query = em.createQuery("select u from UsuarioEntity u where u.usuario = ?1 and u.contrasena =?2", UsuarioEntity.class);
			query.setParameter(1, usuario);
			query.setParameter(2, contrasena);
			System.out.println(query.toString());
			UsuarioEntity user = (UsuarioEntity) query.getSingleResult();
			if (user.getUsuario().equals(usuario) && user.getContrasena().equals(contrasena)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			em.close();
		}
		return false;
	}

}
