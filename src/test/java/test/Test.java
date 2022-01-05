package test;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.drr.bean.model.Person;
import com.drr.util.JpaUtil;

public class Test {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("select p from Person p where p.nameOne=?1", Person.class);
        System.out.println("Ingrese el nombre de la persona que desea buscar: ");
        String nombrePersona = s.next();
        query.setParameter(1, nombrePersona);
//        query.setMaxResults(1);
        Person persona = (Person) query.getSingleResult();
        System.out.println(persona);
        em.close();
        s.close();
	}

}
