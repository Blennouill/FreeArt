package service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import model.Image;
import ejb.FacadeImage;

public class ImageService {

	private String messageResultat;
    private HashMap<String, String> listeErreurs = new HashMap<String, String>();
    
    public ImageService(){
    }
    
    public String getResultat() {
        return messageResultat;
    }
    
    public HashMap<String, String> getErreurs() {
        return listeErreurs;
    }
    
    /*public Image SauvegardeImage(HttpServletRequest poRequest) {
    }.*/
    
    /**
     * Creation d'une image
     * @param chemin
     * @param datePublication
     * @param tag
     * @param nomImage
     * @return
     */
	public boolean AjoutImage(FacadeImage fi, String chemin, Timestamp datePublication, String tag, String nomImage){
		Image i = new Image();
		i.setChemin(chemin);
		i.setDatePublication(datePublication);
		i.setTag(tag);
		i.setNomImage(nomImage);
		fi.create(i);
		return true;
	}
	
	/**
	 * 
	 * @param fi
	 * @return
	 */
	public List ListeImages(FacadeImage fi){
		//Declaration des variables
		//Traitement de la fonction
		return fi.findAll();
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