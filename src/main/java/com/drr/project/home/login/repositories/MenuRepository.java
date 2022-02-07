package com.drr.project.home.login.repositories;

import javax.persistence.EntityManager;

import com.drr.project.db.repositories.CrudRepositoryImpl;
import com.drr.project.home.login.entity.MenuEntity;

public class MenuRepository extends CrudRepositoryImpl<MenuEntity> {

	public MenuRepository(EntityManager entityManager) {
		super(entityManager);
	}

}
