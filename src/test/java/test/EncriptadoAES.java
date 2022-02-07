package test;

import com.drr.project.db.security.EncryptAES;

public class EncriptadoAES {

	public static void main(String[] args) {
		
		try {
			final String claveEncriptacion = "Dravenylucian2021.*";
			String datosOriginales = "laPutaMadre";
			EncryptAES encryptAES = new EncryptAES();
			String encriptado = encryptAES.encript(datosOriginales, claveEncriptacion);
			String desencriptado = encryptAES.decrypt(encriptado, claveEncriptacion);
			System.out.println("Cadena Original: " + datosOriginales);
            System.out.println("Escriptado     : " + encriptado);
            System.out.println("Desencriptado  : " + desencriptado); 
            
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
	}

}
