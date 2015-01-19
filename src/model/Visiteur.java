package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the visiteur database table.
 * 
 */
@Entity
@NamedQuery(name="Visiteur.findAll", query="SELECT v FROM Visiteur v")
public class Visiteur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String adresseIP;

	private String cookieAssocie;

	public Visiteur() {
	}

	public String getAdresseIP() {
		return this.adresseIP;
	}

	public void setAdresseIP(String adresseIP) {
		this.adresseIP = adresseIP;
	}

	public String getCookieAssocie() {
		return this.cookieAssocie;
	}

	public void setCookieAssocie(String cookieAssocie) {
		this.cookieAssocie = cookieAssocie;
	}

}