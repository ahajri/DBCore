package com.ejb.core.hbase.util;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * Cette Class contient les methodes pour crypter et decrypter des chaines de
 * caracteres. Ces methodes seront essentiellement utilisées pour le systeme
 * d'authentification
 * 
 * @author ahajri
 *
 */
public class EncryptionUtil {
	public static final String IV_STRING = "DLjaHdf4DfmzUfxezKtrad";
	public static final String KEY_STRING = "g9x66L6Wn5Fcgwzu5UrW4t";
	// Cipher en AES128 + CBC + PKCS5
	private static final Cipher cipherAesCbcPkcs5 = getCipherAesCbcPkcs5();

	private static Cipher getCipherAesCbcPkcs5() {
		try {
			return Cipher.getInstance("AES/CBC/PKCS5Padding");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Cette Methode va crypter une chaine de caracteres avec l'algo AES128 +
	 * CBC + PKCS5.
	 * 
	 * @param src
	 *            : La chaine à Crypter
	 * @param keyString
	 *            : La clé de Cryptage
	 * @param ivString
	 *            : iv
	 * @return String crypté en Base64
	 */
	public static String encryptAesCbcPkcs5(String src, String keyString, String ivString) {
		try {
			cipherAesCbcPkcs5.init(Cipher.ENCRYPT_MODE, makeAESKey(keyString), makeIv(ivString));
			return Base64.getEncoder().encodeToString(cipherAesCbcPkcs5.doFinal(src.getBytes()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Cette Methode va decrypter une chaine de caracteres encode en Base64 avec
	 * l'algo AES128 + CBC + PKCS5.
	 * 
	 * @param src
	 *            : La chaine à Crypter
	 * @param keyString
	 *            : La clé de Cryptage
	 * @param ivString
	 *            : iv
	 * @return String decrypté
	 */
	public static String decryptAesCbcPkcs5(String src, String keyString, String ivString) {
		String decrypted = "";
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, makeAESKey(keyString), makeIv(ivString));
			decrypted = new String(cipher.doFinal(Base64.getDecoder().decode(src)));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return decrypted;
	}

	/**
	 * 
	 * @param ivString
	 * @return
	 */
	static AlgorithmParameterSpec makeIv(String ivString) {
		return new IvParameterSpec(Base64.getDecoder().decode(ivString));
	}

	/**
	 * 
	 * @param keyString
	 * @return
	 */
	static Key makeAESKey(String keyString) {
		byte[] key = Base64.getDecoder().decode(keyString);
		return new SecretKeySpec(key, "AES");
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(encryptAesCbcPkcs5("paas_user:paasPreProd2017", KEY_STRING, IV_STRING));
		//System.out.println(decryptAesCbcPkcs5("TsQ7i49ts95Lcmx0AHY9Dw==", "g9x66L6Wn5Fcgwzu5UrW4t", "DLjaHdf4DfmzUfxezKtrad"));
//		if (args[0].equals("encryptAesCbcPkcs5")) {
//			System.out.println(encryptAesCbcPkcs5(args[1], args[2], args[3]));
//		} else if (args[0].equals("decryptAesCbcPkcs5")) {
//			System.out.println(decryptAesCbcPkcs5(args[1], args[2], args[3]));
//		}
	}
}
