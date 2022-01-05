package com.drr.bean.backing;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.drr.bean.dao.IPersonDao;
import com.drr.bean.dao.PersonDaoImpl;
import com.drr.bean.model.Person;
import java.io.Serializable;

@Named
@ViewScoped
public class PersonaMB implements Serializable {
	
	private static final long serialVersionUID = 7655364110656688007L;

	private IPersonDao personaEJB;
	
	private Person persona;
	
	private List<Person> listaDePersonas;
	
	public Person getPersona() {
		return persona;
	}

	public void setPersona(Person persona) {
		this.persona = persona;
	}

	public List<Person> getListDePersonas() {
		return listaDePersonas;
	}

	public void setListDePersonas(List<Person> listaDePersonas) {
		this.listaDePersonas = listaDePersonas;
	}
	
	@PostConstruct
	public void init() {
		//listar();
	}
	
	public void listar() {
		personaEJB = new PersonDaoImpl();
		listaDePersonas = new ArrayList<>();
		try {
			listaDePersonas = personaEJB.listAll();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}
	
	public void registrar() {
		personaEJB = new PersonDaoImpl();
		try {
			personaEJB.insert(persona);
		}catch(SQLException e) {
			e.printStackTrace(System.out);
		}
	}
	
	public void modificar() {
		personaEJB = new PersonDaoImpl();
		try {
			personaEJB.update(persona);
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}
	
	public void eliminar() {
		personaEJB = new PersonDaoImpl();
		try {
			personaEJB.delete(persona);
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}
}
