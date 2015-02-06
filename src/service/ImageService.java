package service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import outil.MEnumeration.ENUMTypeRecherche;
import model.Image;
import model.Utilisateur;
import ejb.FacadeImage;
/**
 * Classe regroupant des services rendus à ImageServlet
 * @author KB
 *
 */
public class ImageService {
    
    public ImageService(){
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
	 * Renvoie
	 * @param fi
	 * @param tag
	 * @return
	 */
	public List<Image> RenvoyerListeImageRechercherParTypeRecherche(FacadeImage fi, String type, String valeur){
		//Declaration des variables
		List<Image> ListeImages = new ArrayList<Image>();
		//Traitement de la fonction
		for( Image i : ListeImages(fi)){
			switch (type){
				case "Auteur":
					if (i.getUtilisateur().getNomUtilisateur().contains(valeur))
						ListeImages.add(i);
					break;
				case "Tag":
					if (i.getTag().contains(valeur))
						ListeImages.add(i);
					break;
				case "NomImage":
					if (i.getNomImage().contains(valeur))
						ListeImages.add(i);
					break;
			}
		}
		return ListeImages;
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
    
    /**
     * Change le format de la date pour l'affichage.
     * @param i
     * @return
     */
    private String ConvertDate(Image i) {
    	//Declaration des varaibles
    	DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    	//Traitement de la fonction
    	return format.format(i.getDatePublication());
    	
    }
}