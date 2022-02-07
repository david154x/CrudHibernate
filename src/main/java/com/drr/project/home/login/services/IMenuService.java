package com.drr.project.home.login.services;

import java.util.List;

import com.drr.project.home.login.entity.MenuEntity;

public interface IMenuService {
	
	public List<MenuEntity> findAll();
	
	public MenuEntity findById(Integer id);
	
	public boolean save(MenuEntity menuEntity);
	
	public boolean deleteById(Integer id);

}
