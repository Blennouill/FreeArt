package outil;

/**
 * Objet représentant une erreur.
 * @author KB
 *
 */
public class Message {

	/**
	 * Type du message
	 */
	public String typeMessage;
	/**
	 * Contenu du message
	 */
	public String message;
	
	/**
	 * 
	 * @param tm
	 * @param m
	 */
	public Message(String tm, String m){
		this.typeMessage=tm;
		this.message=m;
	}
	
	/**
	 * Getteur essentiel pour utilisation de l'objet dans les JSP
	 */
	public String getMessage(){
		return this.message;
	}
}
