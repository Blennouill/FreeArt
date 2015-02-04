package service;

import java.security.MessageDigest;
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

	private String messageResultat;
    private HashMap<String, String> listeErreurs = new HashMap<String, String>();
    
    public UtilisateurService(){
    }
    
    /**
     * 
     * @return
     */
    public String getResultat() {
        return messageResultat;
    }
    
    /**
     * 
     * @return
     */
    public HashMap<String, String> getErreurs() {
        return listeErreurs;
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

        // Validation du champ nom
        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( ConstanteFreeArt.CONSTANTE_FORM_CHAMP_NOM, e.getMessage() );
        }
        // Validation du champ mot de passe.
        try {
            validationMotDePasse( motDePasse );
        } catch ( Exception e ) {
            setErreur( ConstanteFreeArt.CONSTANTE_FORM_CHAMP_MDP, e.getMessage() );
        }
        
        // Initialisation du résultat global de la validation.
        if ( listeErreurs.isEmpty() ) {
        	hashMdp = new Hashage(motDePasse);
        	return fu.findForConnection(nom, hashMdp.GetChaineHashe());
            
        } else {
            messageResultat = "Échec de la connexion.";
            return null;
        }
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
     * Valide le nom saisie.
     * @param nom
     * @throws Exception
     */
    private void validationNom( String nom ) throws Exception {
        if ( nom != null) {
        	if ( nom.length() < 3 ) {
                throw new Exception( "Le nom doit contenir au moins 3 caractères.");
            }
        }else {
            throw new Exception("Merci de saisir votre nom.");
        }
    }
    
    /**
     * Valide le mot de passe saisi.
     * @param motDePasse
     * @throws Exception
     */
    private void validationMotDePasse( String motDePasse ) throws Exception {
        if ( motDePasse != null ) {
            if ( motDePasse.length() < 3 ) {
                throw new Exception("Le mot de passe doit contenir au moins 3 caractères.");
            }
        } else {
            throw new Exception("Merci de saisir votre mot de passe.");
        }
    }

    /**
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     * @param pChamp
     * @param pMessage
     */
    private void setErreur( String pChamp, String pMessage ) {
        listeErreurs.put( pChamp, pMessage );
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
