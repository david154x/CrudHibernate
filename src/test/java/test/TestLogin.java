package test;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.drr.project.home.login.services.IUserService;
import com.drr.project.home.login.services.impl.UserServiceImpl;
import com.drr.util.JpaUtil;

public class TestLogin {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		EntityManager em = JpaUtil.getEntityManager();
		IUserService service = new UserServiceImpl();
		boolean existe;
		System.out.println("Ingrese el usuario");
		String usuario = sc.nextLine();
		System.out.println("Ingrese la contraseña");
		String contrasena = sc.nextLine();
		existe = service.consultarUsuario(usuario, contrasena);
		if(existe) {
			System.out.println("Es correcto, puedes ingresar");
		} else {
			System.out.println("Error, las credenciales son invalidas");
		}
		em.close();
		sc.close();
		
	}

}
