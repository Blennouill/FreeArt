 package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import javax.persistence.Query;

import model.Utilisateur;

/**
 * EJB session pour la classe Image
 */
@Stateless
public class FacadeUtilisateur extends FacadeAbstraite {
	@PersistenceContext(unitName = "FreeArtDB")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	public FacadeUtilisateur() {
		super(Utilisateur.class);
	}
	
	/**
	 *  M�thode de recherche d'un utilisateur a partir du mail et du mot de passe.
	 * @param mail
	 * @param mdp
	 * @return
	 */
	public Utilisateur findForConnection(String mail, String mdp) {
		// Declaration des variables
		List<Utilisateur> lUsers;
		
		Query query = em.createNamedQuery("Utilisateur.FindForConnection");
		query.setParameter("nom", mail) ;
		query.setParameter("mdp", mdp) ;

		lUsers = query.getResultList();
		
		return lUsers.get(0);
	}
}