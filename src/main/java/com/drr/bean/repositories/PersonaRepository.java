package com.drr.bean.repositories;

import javax.persistence.EntityManager;

import com.drr.bean.model.Persona;
import com.drr.project.db.repositories.CrudRepositoryImpl;

public class PersonaRepository extends CrudRepositoryImpl<Persona> {

	public PersonaRepository(EntityManager entityManager) {
		super(entityManager);
	}

}
