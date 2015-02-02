package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the panier database table.
 * 
 */
@Entity
@Table(name="panier")
@NamedQuery(name="Panier.findAll", query="SELECT p FROM Panier p")
public class Panier implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PanierPK id;

	//bi-directional many-to-one association to Image
	@ManyToOne
	@JoinColumn(name="CodeImage", nullable=false)
	private Image image;

	public Panier() {
	}

	public PanierPK getId() {
		return this.id;
	}

	public void setId(PanierPK id) {
		this.id = id;
	}

	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}