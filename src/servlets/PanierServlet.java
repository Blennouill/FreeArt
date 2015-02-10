package servlets;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import outil.ConstanteFreeArt;
import outil.Message;
import outil.MEnumeration.ENUMTypeMessage;
import service.PanierService;

/**
 * Servlet implementation class PanierServlet
 */
@WebServlet(name = "PanierServlet")
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(ConstanteFreeArt.CONSTANTE_CHEMIN_VUE_PANIER).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest poRequest, HttpServletResponse poResponse) throws ServletException, IOException {
		//Declaration des variables
		PanierService ps = new PanierService();
		ArrayList<String> listeURLImages = new ArrayList<String>();
		String cheminTmp = "D:/Privee/Projet/P52/Projet/App/WebContent/tmp/";
		Message m;
		String typeFichier;
		// Lecture du paramètre 'Chemin' passé à la servlet via la déclaration dans le web.xml
	    String chemin = this.getServletConfig().getInitParameter("Chemin");
		//Traitement de la fonction
		if (poRequest.getParameter("action").compareTo(ConstanteFreeArt.CONSTANTE_PANIER_REQUETE_ACTION_TELECHARGER) == 0){
			//Initialisation des arguments
			//TODO --> Recuperer l'objet JSON et ses URL !
			//Affectation du type
			typeFichier = "application/zip";
			// Initialise la réponse HTTP
			poResponse.reset();
			poResponse.setBufferSize(ConstanteFreeArt.CONSTANTE_TAILLE_TAMPON);
			poResponse.setContentType(typeFichier);
			poResponse.setHeader( "Content-Disposition", "attachment; filename=\"" + "FreeArtPackImage" + "\"" );
			ps.DownloadImages(poResponse, cheminTmp, listeURLImages);
			m = new Message(ENUMTypeMessage.AfficheSucces.toString(), ConstanteFreeArt.CONSTANTE_SUCCES_TELECHARGEMENT);
			poRequest.setAttribute(ENUMTypeMessage.AfficheSucces.toString(), true);
			poRequest.setAttribute(ConstanteFreeArt.CONSTANTE_OBJET_MESSAGE, m);
		}
		this.getServletContext().getRequestDispatcher(ConstanteFreeArt.CONSTANTE_CHEMIN_VUE_PANIER).forward(poRequest, poResponse);
	}

}
