package servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import outil.ConstanteFreeArt;
import service.ImageService;
import ejb.FacadeImage;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet(name = "UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FacadeImage fi = new FacadeImage();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//D�claration des variables
		ImageService is = new ImageService();
		Calendar calendar = Calendar.getInstance();
	    Timestamp datePublication = new Timestamp(calendar.getTime().getTime());
		//Initisalisation des variables
	    String nomImage = request.getParameter("NomImage");
	    String tag = request.getParameter("Tag");
	    //Traitement de la fonction
	    //Les donn�es re�ues sont multipart, on doit donc utiliser la m�thode getPart() pour traiter le champ d'envoi de fichiers.
	    Part part = request.getPart("Upload");

	    // Il faut d�terminer s'il s'agit d'un champ classique ou d'un champ de type fichier : on d�l�gue cette op�ration � la m�thode utilitaire getNomFichier().
	    String nomFichier = getNomFichier(part);
	
	    // Si la m�thode a renvoy� quelque chose, il s'agit donc d'un champ de type fichier (input type="file").
	    if ( nomFichier != null && !nomFichier.isEmpty() ) {
	        String nomChamp = part.getName();
	        /*
	         * Antibug pour Internet Explorer, qui transmet pour une raison
	         * mystique le chemin du fichier local � la machine du client...
	         * Ex : C:/dossier/sous-dossier/fichier.ext
	         * On doit donc faire en sorte de ne s�lectionner que le nom et
	         * l'extension du fichier, et de se d�barrasser du superflu.
	         */
	         nomFichier = nomFichier.substring( nomFichier.lastIndexOf( '/' ) + 1 )
	                .substring( nomFichier.lastIndexOf( '\\' ) + 1 );

	        // �criture du fichier sur le disque
            try {
    	        ecrireFichier(part, nomFichier, ConstanteFreeArt.CONSTANTE_CHEMIN_UPLOAD);
    	        is.AjoutImage(fi, ConstanteFreeArt.CONSTANTE_CHEMIN_UPLOAD+nomFichier, datePublication, tag, nomImage);
            } 
            catch ( Exception e ) {
            }
	    }
	    this.getServletContext().getRequestDispatcher(ConstanteFreeArt.CONSTANTE_CHEMIN_VUE_GALLERIE).forward( request, response );
	}
	
	/**
	 * M�thode utilitaire qui a pour unique but d'analyser l'en-t�te "content-disposition",
	 * et de v�rifier si le param�tre "filename"  y est pr�sent. Si oui, alors le champ trait�
	 * est de type File et la m�thode retourne son nom, sinon il s'agit d'un champ de formulaire 
	 * classique et la m�thode retourne null. 
	 * @param part
	 * @return
	 */
	private static String getNomFichier( Part part ) {
	    /* Boucle sur chacun des param�tres de l'en-t�te "content-disposition". */
	    for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
	    	/* Recherche de l'�ventuelle pr�sence du param�tre "filename". */
	        if ( contentDisposition.trim().startsWith("filename") ) {
	            /* Si "filename" est pr�sent, alors renvoi de sa valeur, c'est-�-dire du nom de fichier. */
	            return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 );
	        }
	    }
	    /* Et pour terminer, si rien n'a �t� trouv�... */
	    return null;
	}
	
	/**
	 * M�thode utilitaire qui a pour but d'�crire le fichier pass� en param�tre
	 * sur le disque, dans le r�pertoire donn� et avec le nom donn�.
	 * @param part
	 * @param nomFichier
	 * @param chemin
	 * @throws IOException
	 */
	private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
	    /* Pr�pare les flux. */
	    BufferedInputStream entree = null;
	    BufferedOutputStream sortie = null;
	    try {
	        /* Ouvre les flux. */
	        entree = new BufferedInputStream( part.getInputStream(), ConstanteFreeArt.CONSTANTE_TAILLE_TAMPON );
	        sortie = new BufferedOutputStream( new FileOutputStream(new File(chemin + nomFichier)),ConstanteFreeArt.CONSTANTE_TAILLE_TAMPON );
	        // Lit le fichier re�u et �crit son contenu dans un fichier sur le disque.
	        byte[] tampon = new byte[ConstanteFreeArt.CONSTANTE_TAILLE_TAMPON];
	        int longueur;
	        while ( ( longueur = entree.read( tampon ) ) > 0 ) {
	            sortie.write( tampon, 0, longueur );
	        }
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
