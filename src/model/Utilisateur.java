package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codeUtilisateur;

	private String cookie;

	private String mail;

	private int motDePasse;

	//bi-directional many-to-one association to Image
	@OneToMany(mappedBy="utilisateur")
	private List<Image> images;

	public Utilisateur() {
	}

	public int getCodeUtilisateur() {
		return this.codeUtilisateur;
	}

	public void setCodeUtilisateur(int codeUtilisateur) {
		this.codeUtilisateur = codeUtilisateur;
	}

	public String getCookie() {
		return this.cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(int motDePasse) {
		this.motDePasse = motDePasse;
	}

	public List<Image> getImages() {
		return this.images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Image addImage(Image image) {
		getImages().add(image);
		image.setUtilisateur(this);

		return image;
	}

	public Image removeImage(Image image) {
		getImages().remove(image);
		image.setUtilisateur(null);

		return image;
	}

}