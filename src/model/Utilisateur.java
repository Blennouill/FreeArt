package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@Table(name="utilisateur")
@NamedQueries({	@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u"),
				@NamedQuery(name="Utilisateur.FindForConnection", 
							query="SELECT u FROM Utilisateur u WHERE u.nomUtilisateur = :nom AND u.motDePasse = :mdp")})
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int codeUtilisateur;

	@Column(nullable=false, length=50)
	private String motDePasse;

	@Column(nullable=false, length=100)
	private String nomUtilisateur;

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

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNomUtilisateur() {
		return this.nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
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