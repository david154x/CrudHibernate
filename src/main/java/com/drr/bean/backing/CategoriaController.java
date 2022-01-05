package com.drr.bean.backing;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.drr.bean.dao.CategoryDaoImpl;
import com.drr.bean.dao.ICategoryDao;
import com.drr.bean.model.Category;

@Named
@RequestScoped
public class CategoriaController {

	private ICategoryDao categoriaEJB;
	
	@Inject
	private Category categoria;
	
	private List<Category> listaDeCategorias;
	
	public CategoriaController() {
		super();
	}

	public Category getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Category categoria) {
		this.categoria = categoria;
	}
	
	public List<Category> getListaDeCategorias() {
		return listaDeCategorias;
	}

	public void setListaDeCategorias(List<Category> listaDeCategorias) {
		this.listaDeCategorias = listaDeCategorias;
	}

	public void listar() {
		categoriaEJB = new CategoryDaoImpl();
		listaDeCategorias = new ArrayList<>();
		try {
			listaDeCategorias = categoriaEJB.listAll();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}
	
	public void registrar() {
		categoriaEJB = new CategoryDaoImpl();
		try {
			categoriaEJB.insert(categoria);
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}
	
	public void modificar() {
		categoriaEJB = new CategoryDaoImpl();
		try {
			categoriaEJB.update(categoria);
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}
	
	public void eliminar() {
		categoriaEJB = new CategoryDaoImpl();
		try {
			categoriaEJB.delete(categoria);
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}
}
