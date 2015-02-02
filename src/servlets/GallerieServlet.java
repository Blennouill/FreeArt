package servlets;

import java.io.IOException;
import java.util.ArrayList;

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
		UtilisateurService us = new UtilisateurService();
		ImageService is = new ImageService();
		ArrayList<Image> ListeImages = new ArrayList<Image>();
		// Traitement de la fonction
		// -> Chargement des images
		ListeImages = (ArrayList<Image>) is.ListeImages(facadeImage);
		poRequest.setAttribute("ListeImages", ListeImages);
		this.getServletContext().getRequestDispatcher(ConstanteFreeArt.CONSTANTE_CHEMIN_VUE_GALLERIE).forward( poRequest, poResponse );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest poRequest, HttpServletResponse poResponse)
	 */
	protected void doPost(HttpServletRequest poRequest, HttpServletResponse poResponse) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
