package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the image database table.
 * 
 */
@Entity
@Table(name="image")
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int codeImage;

	@Column(nullable=false, length=150)
	private String chemin;

	@Column(nullable=false)
	private Timestamp datePublication;

	@Column(nullable=false, length=150)
	private String nomImage;

	@Column(nullable=false, length=50)
	private String tag;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="CodeAuteur", nullable=false)
	private Utilisateur utilisateur;

	//bi-directional many-to-one association to Panier
	@OneToMany(mappedBy="image")
	private List<Panier> paniers;

	public Image() {
	}

	public int getCodeImage() {
		return this.codeImage;
	}

	public void setCodeImage(int codeImage) {
		this.codeImage = codeImage;
	}

	public String getChemin() {
		return this.chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public Timestamp getDatePublication() {
		return this.datePublication;
	}

	public void setDatePublication(Timestamp datePublication) {
		this.datePublication = datePublication;
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

	public List<Panier> getPaniers() {
		return this.paniers;
	}

	public void setPaniers(List<Panier> paniers) {
		this.paniers = paniers;
	}

	public Panier addPanier(Panier panier) {
		getPaniers().add(panier);
		panier.setImage(this);

		return panier;
	}

	public Panier removePanier(Panier panier) {
		getPaniers().remove(panier);
		panier.setImage(null);

		return panier;
	}

}