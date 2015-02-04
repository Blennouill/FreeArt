package outil;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe permettant de generer un hash d'une chaine.
 * @author KB
 *
 */
public class Hashage {
	
	private String chaineHashe;
	
	public Hashage(String chaine) {
		Hash(chaine);
	}
	
	public void Hash(String pass){
		byte[] passBytes = pass.getBytes();
		try {
			MessageDigest algorithm = MessageDigest.getInstance("SHA1");
			algorithm.reset();
			algorithm.update(passBytes);
			MessageDigest md = MessageDigest.getInstance("SHA1");
			byte[] messageDigest = md.digest(passBytes);
			BigInteger number = new BigInteger(1, messageDigest);
			this.chaineHashe = number.toString(16);
		} 
		catch (NoSuchAlgorithmException e) {
			throw new Error(e);
	}
}
	public String GetChaineHashe(){
		return this.chaineHashe;
	}
}
