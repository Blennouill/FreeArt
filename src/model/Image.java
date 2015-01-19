package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the image database table.
 * 
 */
@Entity
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codeImage;

	private Timestamp datePublication;

	private String nomCategorie;

	private String nomImage;

	private String tag;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="CodeAuteur")
	private Utilisateur utilisateur;

	public Image() {
	}

	public int getCodeImage() {
		return this.codeImage;
	}

	public void setCodeImage(int codeImage) {
		this.codeImage = codeImage;
	}

	public Timestamp getDatePublication() {
		return this.datePublication;
	}

	public void setDatePublication(Timestamp datePublication) {
		this.datePublication = datePublication;
	}

	public String getNomCategorie() {
		return this.nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public String getNomImage() {
		return this.nomImage;
	}

	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}