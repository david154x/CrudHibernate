package test;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.drr.bean.model.Persona;
import com.drr.bean.repositories.PersonaRepository;
import com.drr.util.JpaUtil;

public class TestCreate {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		EntityManager em = JpaUtil.getEntityManager();
		PersonaRepository repository = new PersonaRepository(em);
		imprimirTodo();
        System.out.println("Ingrese el id de la persona que desea modificar: ");
        Integer id = s.nextInt();
        Persona personaPrincipal = repository.findById(id);
        System.out.println(personaPrincipal);
        System.out.println("Ingrese el nombre de la persona ");
        String nombre = s.nextLine();
        System.out.println("Ingrese el apellido paterno de la persona ");
        String apellidoPaterno = s.nextLine();
        System.out.println("Ingrese el apellido materno de la persona ");
        String apellidoMaterno = s.nextLine();
        Persona persona = new Persona();
        personaPrincipal.setNombre(nombre);
        personaPrincipal.setApellidoPaterno(apellidoPaterno);
        personaPrincipal.setApellidoMaterno(apellidoMaterno);
        System.out.println("Se va a guardar este objeto: "+persona);
        try {
        	em.getTransaction().begin();
//        	persona = repository.create(persona);
        	repository.update(persona);
        	em.getTransaction().commit();
        	 System.out.println("Se ha guardado correctamente");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace(System.out);
		}
        em.close();
        s.close();
	}
	
	private static void imprimirTodo() {
		EntityManager em = JpaUtil.getEntityManager();
		PersonaRepository repository = new PersonaRepository(em);
		List<Persona> lista = (List<Persona>) repository.findAll();
		for(Persona p : lista) {
			System.out.println(p);
		}
	}

}
