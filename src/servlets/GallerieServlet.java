package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Image;
import outil.ConstanteFreeArt;
import service.ImageService;
import service.UtilisateurService;
import ejb.FacadeImage;

/**
 * Servlet implementation class GallerieServlet
 */
@WebServlet(name = "GallerieServlet")
public class GallerieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private FacadeImage facadeImage;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GallerieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Utiliser pour les appels via le menu
	 * @see HttpServlet#doGet(HttpServletRequest poRequest, HttpServletResponse poResponse)
     */
	protected void doGet(HttpServletRequest poRequest, HttpServletResponse poResponse) throws ServletException, IOException {
		// Declaration des variables
		ImageService is = new ImageService();
		List<Image> ListeImages; 	
		// Traitement de la fonction
		// -> Chargement des images
		ListeImages = is.ListeImages(facadeImage);
		poRequest.setAttribute("ListeImages", ListeImages);
		this.getServletContext().getRequestDispatcher(ConstanteFreeArt.CONSTANTE_CHEMIN_VUE_GALLERIE).forward( poRequest, poResponse );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest poRequest, HttpServletResponse poResponse)
	 */
	protected void doPost(HttpServletRequest poRequest, HttpServletResponse poResponse) throws ServletException, IOException {
		//Declaration des variables
		List<Image> ListeImages;
		ImageService is = new ImageService();
		String typeRecherche = poRequest.getParameter(ConstanteFreeArt.CONSTANTE_FORM_CHAMP_TYPERECHERCHE);
		String valeurRecherche = poRequest.getParameter( ConstanteFreeArt.CONSTANTE_FORM_CHAMP_VALEURRECHERCHE);
		//Traitement de la fonction
		if (poRequest.getServletPath().compareTo("/Recherche") == 0){
			ListeImages = is.RenvoyerListeImageRechercherParTypeRecherche(facadeImage, typeRecherche, valeurRecherche);
			poRequest.setAttribute("ListeImages", ListeImages);
			this.getServletContext().getRequestDispatcher(ConstanteFreeArt.CONSTANTE_CHEMIN_VUE_GALLERIE).forward( poRequest, poResponse );
		}
		else {
			this.doGet(poRequest, poResponse);		
		}
	}

}
