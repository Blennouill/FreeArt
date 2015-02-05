package service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import model.Utilisateur;
import outil.ConstanteFreeArt;
import outil.Hashage;
import ejb.FacadeUtilisateur;
/**
 * Classe regroupant des services rendus à UtilisateurServlet
 * @author KB
 *
 */
public class UtilisateurService {
    
    public UtilisateurService(){
    }
    
    /**
     * 
     * @param poRequest
     * @param fu
     * @return
     */
    public Utilisateur ConnexionUtilisateur(HttpServletRequest poRequest, FacadeUtilisateur fu) {
    	//Initialisation des variables
        String nom = getValeurChamp( poRequest, ConstanteFreeArt.CONSTANTE_FORM_CHAMP_NOM);
        String motDePasse = getValeurChamp( poRequest, ConstanteFreeArt.CONSTANTE_FORM_CHAMP_MDP);
    	Hashage hashMdp;
    	//Traitement de la fonction
        // Initialisation du résultat global de la validation.
    	hashMdp = new Hashage(motDePasse);
    	return fu.findForConnection(nom, hashMdp.GetChaineHashe());
    }
    
    /**
     * Creation d'un utilisateur
     * @param mail
     * @param motDePasse
     */
	public boolean CreationUtilisateur(FacadeUtilisateur fu, String nomUtilisateur, String motDePasse){
		//Initialisation des varaibles
		Hashage hashMdp = new Hashage(motDePasse);
		//Traitement de la fonction
		Utilisateur u = new Utilisateur();
		u.setNomUtilisateur(nomUtilisateur);
		u.setMotDePasse(hashMdp.GetChaineHashe());
		fu.create(u);
		return true;
	}

    /**
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     * @param poRequest
     * @param pNomChamp
     * @return
     */
    private static String getValeurChamp( HttpServletRequest poRequest, String pNomChamp ) {
        String valeur = poRequest.getParameter( pNomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}
