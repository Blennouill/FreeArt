package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the panier database table.
 * 
 */
@Embeddable
public class PanierPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private int codePanier;

	@Column(unique=true, nullable=false)
	private int codeUtilisateur;

	public PanierPK() {
	}
	public int getCodePanier() {
		return this.codePanier;
	}
	public void setCodePanier(int codePanier) {
		this.codePanier = codePanier;
	}
	public int getCodeUtilisateur() {
		return this.codeUtilisateur;
	}
	public void setCodeUtilisateur(int codeUtilisateur) {
		this.codeUtilisateur = codeUtilisateur;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PanierPK)) {
			return false;
		}
		PanierPK castOther = (PanierPK)other;
		return 
			(this.codePanier == castOther.codePanier)
			&& (this.codeUtilisateur == castOther.codeUtilisateur);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codePanier;
		hash = hash * prime + this.codeUtilisateur;
		
		return hash;
	}
}