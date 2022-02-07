package com.drr.project.home.login.services.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.drr.project.home.login.entity.MenuEntity;
import com.drr.project.home.login.repositories.MenuRepository;
import com.drr.project.home.login.services.IMenuService;
import com.drr.util.JpaUtil;

public class MenuServicImpl implements IMenuService {
	
	EntityManager em = JpaUtil.getEntityManager();
	
	private MenuRepository menuRepository;
	
	public MenuServicImpl(EntityManager em) {
		this.em = em;
		this.menuRepository = new MenuRepository(em);
	}

	@Override
	public List<MenuEntity> findAll() {
		List<MenuEntity> list;
		try {
			list = (List<MenuEntity>) menuRepository.findAll();
			return list;
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return null;
	}

	@Override
	public MenuEntity findById(Integer id) {
		try {
			MenuEntity menuEntity = menuRepository.findById(id);
			return menuEntity;
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return null;
	}

	@Override
	public boolean save(MenuEntity menuEntity) {
		try {
			em.getTransaction().begin();
			if(menuEntity.getId() != null || menuEntity.getId() > 1) {
				menuRepository.update(menuEntity);
			} else {
				menuRepository.create(menuEntity);
			}
			em.getTransaction().commit();;
		} catch (Exception e) {
			e.printStackTrace(System.out);
			em.getTransaction().rollback();
		}
		return false;
	}

	@Override
	public boolean deleteById(Integer id) {
		try {
			em.getTransaction().begin();
			menuRepository.delete(id);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace(System.out);
			em.getTransaction().rollback();
		}
		return false;
	}

}
