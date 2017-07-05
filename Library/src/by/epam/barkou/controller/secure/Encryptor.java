package by.epam.barkou.controller.secure;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import by.epam.barkou.controller.exception.ControllerException;

public class Encryptor {

	public static String encrypt(String passwordToHash) throws ControllerException {

		String generatedPassword = null;
		try {

			MessageDigest md = MessageDigest.getInstance("MD5");

			md.update(passwordToHash.getBytes());

			byte[] bytes = md.digest();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new ControllerException(e.getMessage());
		}
		return generatedPassword;
	}
}