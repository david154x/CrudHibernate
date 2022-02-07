package com.drr.project.home.login.backing;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.drr.project.home.login.entity.MenuEntity;
import com.drr.project.home.login.services.IMenuService;
import com.drr.project.home.login.services.impl.MenuServicImpl;
import com.drr.util.JpaUtil;

import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class MenuMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	EntityManager em = JpaUtil.getEntityManager();
	
	private IMenuService menuService;
	
	@Getter @Setter
	private MenuModel model;
	
	@Getter @Setter
	private List<MenuEntity> listMenu;
	
	@PostConstruct
	public void init() {
		this.listarMenu();
		model = new DefaultMenuModel();
		this.establecerPermisos();
	}
	
	public void listarMenu() {
		try {
			menuService = new MenuServicImpl(em);
			listMenu = menuService.findAll();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	public void establecerPermisos() {
		for(MenuEntity m : listMenu) {
			if(m.getTipo().equals("S")) {
				DefaultSubMenu firstSubmenu =  DefaultSubMenu.builder().label(m.getNombre()).build();
				for(MenuEntity i : listMenu) {
					MenuEntity subMenu = i.getSubMenu();
					if(subMenu != null) {
						if(subMenu.getId() == m.getId()) {
							 DefaultMenuItem item = DefaultMenuItem.builder()
									 .value(subMenu.getNombre())
									 .icon(subMenu.getIcono())
									 .ajax(false)
									 .command(null)
									 .update("messages")
									 .build();
							 firstSubmenu.getElements().add(item);
						}
					}
				}
				model.getElements().add(firstSubmenu);
			} else {
				DefaultMenuItem item = DefaultMenuItem.builder()
						 .value(m.getNombre())
						 .icon(m.getIcono())
						 .ajax(false)
						 .command(null)
						 .update("messages")
						 .build();
				model.getElements().add(item);
			}
		}
	}

}
