 package ejb;

import java.util.ArrayList;

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
	 *  Méthode de recherche d'un utilisateur a partir du mail et du mot de passe.
	 * @param mail
	 * @param mdp
	 * @return
	 */
	public Utilisateur findForConnection(String mail, String mdp) {
		// Declaration des variables
		ArrayList<Utilisateur> lUsers = new ArrayList<Utilisateur>();
		
		Query query = em.createNamedQuery("Utilisateur.FindForConnection");
		query.setParameter("mail", mail) ;
		query.setParameter("mdp", mdp) ;

		lUsers = (ArrayList<Utilisateur>) query.getResultList();
		
		return lUsers.get(0);
	}
}