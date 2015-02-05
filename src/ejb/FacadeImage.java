package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Image;
import model.Utilisateur;

/**
 * EJB session pour la classe Image
 */
@Stateless
public class FacadeImage extends FacadeAbstraite {
	@PersistenceContext(unitName = "FreeArtDB")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	public FacadeImage() {
		super(Image.class);
	}
	
	public List<Image> findImagesParTag(String tag){
		// Declaration des variables
		List<Image> lImages;
		// Traitement de la fonction
		Query query = em.createNamedQuery("Utilisateur.findImagesParTag");
		query.setParameter("tag", tag) ;

		lImages = query.getResultList();
		
		return lImages;
	}
}