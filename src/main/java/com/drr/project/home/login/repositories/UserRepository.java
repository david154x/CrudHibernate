package com.drr.project.home.login.repositories;

import javax.persistence.EntityManager;

import com.drr.project.db.repositories.CrudRepositoryImpl;
import com.drr.project.home.login.entity.UsuarioEntity;

public class UserRepository extends CrudRepositoryImpl<UsuarioEntity> {

	public UserRepository(EntityManager entityManager) {
		super(entityManager);
	}

}
