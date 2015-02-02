package service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

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
	
	/*public ArrayList<Image> ListeImages(){
		//Declaration des variables
		ArrayList<Image> ListeImages = new ArrayList<Image>();
	}*/

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String pChamp, String pMessage ) {
        listeErreurs.put( pChamp, pMessage );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
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