package com.drr.project.db.repositories;

public interface ICrudRepository<T> {
	
	Iterable<T> findAll();
	
	T findById(Object obj);
	
	T create(T t);
	
	T update(T t);
	
	void delete(Object obj);
	
}
