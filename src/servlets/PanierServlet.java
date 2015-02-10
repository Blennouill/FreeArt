package servlets;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import outil.ConstanteFreeArt;
import outil.Message;
import outil.MEnumeration.ENUMTypeMessage;
import outil.Utilitaire;
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
	protected void doGet(HttpServletRequest poRequest, HttpServletResponse poResponse) throws ServletException, IOException {
		//Déclaration des variables
		Cookie[] c = poRequest.getCookies();
		String[] temp;
		ArrayList<String> ListeImages = new ArrayList<String>();
		//Verification des arguments
		if (c.length<2 || poRequest.getServletPath().compareTo("/Download") != 0) this.getServletContext().getRequestDispatcher(ConstanteFreeArt.CONSTANTE_CHEMIN_VUE_PANIER).forward(poRequest, poResponse );
		//Traitement de la fonction
		for(Cookie cookie : c){
			if (cookie.getName() != "JSESSIONID"){
		    	temp = cookie.getValue().split("%2F");
		    	ListeImages.add(temp[temp.length-1].toString());
			}
		}
		//Fin de la fonction
		doPost(poRequest, poResponse, ListeImages);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest poRequest, HttpServletResponse poResponse, ArrayList<String> ListeURLImages) throws ServletException, IOException {
		//Declaration des variables
		PanierService ps = new PanierService();
		ArrayList<String> listeURLImages = ListeURLImages;
		String cheminTmp = "D:/Privee/Projet/P52/Projet/App/FreeArt/WebContent/images/";
		Message m;
		String typeFichier;
		// Lecture du paramètre 'Chemin' passé à la servlet via la déclaration dans le web.xml
	    String chemin = this.getServletConfig().getInitParameter("Chemin");
		//Traitement de la fonction
		//Affectation du type
		typeFichier = "application/zip";
		//Initialise la réponse HTTP
		poResponse.reset();
		poResponse.setBufferSize(ConstanteFreeArt.CONSTANTE_TAILLE_TAMPON);
		poResponse.setContentType(typeFichier);
		poResponse.setHeader( "Content-Disposition", "attachment; filename=\"" + "FreeArtPackImage" + "\"" );
		ps.DownloadImages(poResponse, cheminTmp, listeURLImages);
		m = new Message(ENUMTypeMessage.AfficheSucces.toString(), ConstanteFreeArt.CONSTANTE_SUCCES_TELECHARGEMENT);
		poRequest.setAttribute(ENUMTypeMessage.AfficheSucces.toString(), true);
		poRequest.setAttribute(ConstanteFreeArt.CONSTANTE_OBJET_MESSAGE, m);
		//Retour de la fonction
		this.getServletContext().getRequestDispatcher(ConstanteFreeArt.CONSTANTE_CHEMIN_VUE_PANIER).forward(poRequest, poResponse);
	}

}
