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
	public String TypeMessage;
	/**
	 * Contenu du message
	 */
	public String Message;
	
	/**
	 * 
	 * @param tm
	 * @param m
	 */
	public Message(String tm, String m){
		this.TypeMessage=tm;
		this.Message=m;
	}
	
}
