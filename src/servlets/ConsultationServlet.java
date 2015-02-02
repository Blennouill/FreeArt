package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import outil.ConstanteFreeArt;
import service.ImageService;
import service.UtilisateurService;

/**
 * Servlet implementation class ConsultationServlet
 */
@WebServlet(name = "ConsultationServlet")
public class ConsultationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Utiliser pour les appels via le menu
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Declaration des variables
		UtilisateurService us = new UtilisateurService();
		ImageService is = new ImageService();
		// Traitement de la fonction
		// -> Chargement des images
		is.ListeImages();
		this.getServletContext().getRequestDispatcher(ConstanteFreeArt.CONSTANTE_CHEMIN_VUE_GALLERIE).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
