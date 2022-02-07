package test;

import java.util.List;

import javax.persistence.EntityManager;

import com.drr.bean.model.Persona;
import com.drr.bean.repositories.PersonaRepository;
import com.drr.util.JpaUtil;

public class TestList {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		PersonaRepository repository = new PersonaRepository(em);
		List<Persona> listaPersonas;
		listaPersonas = (List<Persona>) repository.findAll();
		System.out.println(listaPersonas);
	}

}
