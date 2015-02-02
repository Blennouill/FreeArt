package service;

import java.util.HashMap;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import model.Utilisateur;
import outil.ConstanteFreeArt;
import ejb.FacadeUtilisateur;

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
        /* Récupération des champs du formulaire */
        String email = getValeurChamp( poRequest, ConstanteFreeArt.CONSTANTE_FORM_CHAMP_EMAIL);
        String motDePasse = getValeurChamp( poRequest, ConstanteFreeArt.CONSTANTE_FORM_CHAMP_MDP);
        /* Validation du champ email. */
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( ConstanteFreeArt.CONSTANTE_FORM_CHAMP_EMAIL, e.getMessage() );
        }
        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse( motDePasse );
        } catch ( Exception e ) {
            setErreur( ConstanteFreeArt.CONSTANTE_FORM_CHAMP_MDP, e.getMessage() );
        }
        
        /* Initialisation du résultat global de la validation. */
        if ( listeErreurs.isEmpty() ) {
        	return fu.findForConnection(email, motDePasse);
            
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
	public boolean CreationUtilisateur(FacadeUtilisateur fu, String mail, String motDePasse){
		Utilisateur u = new Utilisateur();
		u.setMail(mail);
		u.setMotdepasse(motDePasse);
		fu.create(u);
		return true;
	}
	
    /**
     * Valide l'adresse email saisie.
     * @param email
     * @throws Exception
     */
    private void validationEmail( String email ) throws Exception {
        if ( email != null) {
        	if ( email.length() < 3 ) {
                throw new Exception( "Le mail doit contenir au moins 3 caractères.");
            }
        }else {
            throw new Exception("Merci de saisir votre mail.");
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
