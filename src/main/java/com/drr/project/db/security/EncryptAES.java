package com.drr.project.db.security;

import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class EncryptAES {
	
	public SecretKeySpec createKey(String key) {
		byte[] claveEncriptacion;
		MessageDigest sha;
		SecretKeySpec secretKey;
		try {
			claveEncriptacion = key.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-256");
			claveEncriptacion = sha.digest(claveEncriptacion);
			claveEncriptacion = Arrays.copyOf(claveEncriptacion, 16);
			secretKey = new SecretKeySpec(claveEncriptacion, "AES");
			return secretKey;
		} catch (Exception e) {
			e.printStackTrace(System.out);
			
		}
		return null;
	}
	
	public String encript(String datos, String claveSecreta) {
		SecretKeySpec secretKey;
		try {
			secretKey = this.createKey(claveSecreta);
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] datosEncriptar = datos.getBytes("UTF-8");
			byte[] bytesEncriptados = cipher.doFinal(datosEncriptar);
			String cadenaEncriptada = Base64.encodeBase64String(bytesEncriptados);
			return cadenaEncriptada;
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return null;
	}
	
	public String decrypt(String datosEncriptados, String claveSecreta) {
		SecretKeySpec secretKey;
		try {
			secretKey = this.createKey(claveSecreta);
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] bytesEncriptados = Base64.decodeBase64(datosEncriptados);
			byte[] datosDesencriptados = cipher.doFinal(bytesEncriptados);
			String cadenaDesencriptada = new String(datosDesencriptados);
			return cadenaDesencriptada;
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return null;
	}

}
