package service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Image;
import model.Utilisateur;
import ejb.FacadeImage;
/**
 * Classe regroupant des services rendus à ImageServlet
 * @author KB
 *
 */
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
	public boolean AjoutImage(FacadeImage fi, String chemin, Timestamp datePublication, String tag, String nomImage, Utilisateur u){
		Image i = new Image();
		i.setChemin(chemin);
		i.setTag(tag);
		i.setDatePublication(datePublication);
		i.setNomImage(nomImage);
		i.setUtilisateur(u);
		fi.create(i);
		return true;
	}
	
	/**
	 * 
	 * @param fi
	 * @return
	 */
	public List<Image> ListeImages(FacadeImage fi){
		//Declaration des variables
		//Traitement de la fonction
		return fi.findAll();
	}
	
	/**
	 * 
	 * @param fi
	 * @param tag
	 * @return
	 */
	public List<Image> RenvoyerListeImageRechercherParTag(FacadeImage fi, String tag){
		//Declaration des variables
		List<Image> ListeImages = new ArrayList<Image>();
		//Traitement de la fonction
		for( Image i : ListeImages(fi)){
			if (i.getTag() != tag){
				ListeImages.add(i);
			}
		}
		return ListeImages;
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