package com.drr.project.db.repositories;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CrudRepositoryImpl<T> implements ICrudRepository<T> {

	private EntityManager entityManager;

	private Class<T> type;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CrudRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	@Override
	public Iterable<T> findAll() {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = cb.createQuery(type);
		Root<T> root = criteriaQuery.from(type);
		criteriaQuery.select(root);
		TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public T findById(Object id) {
		return entityManager.find(type, id);
	}
	
	@Override
	public T create(T t) {
		entityManager.persist(t);
        return t;
	}
	
	@Override
	public T update(T t) {
		return entityManager.merge(t);
	}

	@Override
	public void delete(Object obj) {
		entityManager.remove(entityManager.merge(obj));
	}

}
