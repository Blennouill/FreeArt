package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Image;

/**
 * EJB session pour la classe Image
 */
@Stateless
public class FacadeImage extends FacadeAbstraite {
	@PersistenceContext(unitName = "FreeArt")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	public FacadeImage() {
		super(Image.class);
	}
}