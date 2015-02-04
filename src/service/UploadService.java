package service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import outil.ConstanteFreeArt;
import outil.Utilitaire;
import ejb.FacadeImage;

/**
 * Classe regroupant des services rendus à UploadServlet
 * @author KB
 *
 */
public class UploadService {
	
	public UploadService(){}
	
	public boolean UploaderImage(FacadeImage fi, HttpServletRequest poRequest, String chemin) throws IOException, ServletException{
		//Initisalisation des variables
		ImageService is = new ImageService();
	    String nomImage = poRequest.getParameter("NomImage");
	    String tag = poRequest.getParameter("Tag");
		Calendar calendar = Calendar.getInstance();
	    Timestamp datePublication = new Timestamp(calendar.getTime().getTime());
	    //Traitement de la fonction
	    //Les données reçues sont multipart, on doit donc utiliser la méthode getPart() pour traiter le champ d'envoi de fichiers.
	    Part part = poRequest.getPart("Upload");

	    // Il faut déterminer s'il s'agit d'un champ classique ou d'un champ de type fichier : on délègue cette opération à la méthode utilitaire getNomFichier().
	    String nomFichier = getNomFichier(part);
	
	    // Si la méthode a renvoyé quelque chose, il s'agit donc d'un champ de type fichier (input type="file").
	    if (nomFichier != null && !nomFichier.isEmpty()) {
	        String nomChamp = part.getName();
	        /*
	         * Antibug pour Internet Explorer, qui transmet pour une raison
	         * mystique le chemin du fichier local à la machine du client...
	         * Ex : C:/dossier/sous-dossier/fichier.ext
	         * On doit donc faire en sorte de ne sélectionner que le nom et
	         * l'extension du fichier, et de se débarrasser du superflu.
	         */
	         nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1).substring(nomFichier.lastIndexOf('\\') + 1);

	        // Écriture du fichier sur le disque
            try {
            	// Concatenation du timestamp pour rendre chaque upload unique.
            	chemin.concat(datePublication.toString());
    	        ecrireFichier(part, nomFichier, chemin);
    	        is.AjoutImage(fi, ConstanteFreeArt.CONSTANTE_CHEMIN_UPLOAD+nomFichier, datePublication, tag, nomImage, Utilitaire.U);
    	        return true;
            } 
            catch (Exception e) {
            	return false;
            }
	    }
	    else
	    	return false;
	}
	
	/**
	 * Méthode utilitaire qui a pour unique but d'analyser l'en-tête "content-disposition",
	 * et de vérifier si le paramètre "filename"  y est présent. Si oui, alors le champ traité
	 * est de type File et la méthode retourne son nom, sinon il s'agit d'un champ de formulaire 
	 * classique et la méthode retourne null. 
	 * @param part
	 * @return
	 */
	private static String getNomFichier( Part part ) {
		//Traitement de la fonction
	    // Boucle sur chacun des paramètres de l'en-tête "content-disposition".
	    for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
	    	// Recherche de l'éventuelle présence du paramètre "filename".
	        if ( contentDisposition.trim().startsWith("filename") ) {
	            // Si "filename" est présent, alors renvoi de sa valeur, c'est-à-dire du nom de fichier.
	            return contentDisposition.substring(contentDisposition.indexOf( '=' ) + 2, contentDisposition.length()-1).toString();
	        }
	    }
	    //Si rien trouvé
	    return null;
	}
	
	/**
	 * Méthode utilitaire qui a pour but d'écrire le fichier passé en paramètre
	 * sur le disque, dans le répertoire donné et avec le nom donné.
	 * @param part
	 * @param nomFichier
	 * @param chemin
	 * @throws IOException
	 */
	private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
		//Initialisation des variables
	    BufferedInputStream entree = null;
	    BufferedOutputStream sortie = null;
	    try {
	        // Ouvre les flux.
	        entree = new BufferedInputStream( part.getInputStream(), ConstanteFreeArt.CONSTANTE_TAILLE_TAMPON );
	        sortie = new BufferedOutputStream( new FileOutputStream(new File(chemin + nomFichier)),ConstanteFreeArt.CONSTANTE_TAILLE_TAMPON );
	        // Lit le fichier reçu et écrit son contenu dans un fichier sur le disque.
	        byte[] tampon = new byte[ConstanteFreeArt.CONSTANTE_TAILLE_TAMPON];
	        int longueur;
	        while ( ( longueur = entree.read( tampon ) ) > 0 ) {
	            sortie.write( tampon, 0, longueur );
	        }
	    }
	    catch (IOException ioe){
	    	ioe.toString();
	    }
	    finally {
	        try {
	            sortie.close();
	        } 
	        catch ( IOException ignore ) {
	        }
	        try {
	            entree.close();
	        } 
	        catch ( IOException ignore ) {
	        }
	    }
	}
}
