package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Utilisateur;
import outil.ConstanteFreeArt;
import service.UtilisateurService;
import ejb.FacadeUtilisateur;

/**
 * Servlet implementation class UtilisateurServlet
 */
@WebServlet(name = "UtilisateurServlet")
public class UtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private FacadeUtilisateur facadeUtilisateur;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest poRequest, HttpServletResponse poResponse) throws ServletException, IOException {
		switch(poRequest.getServletPath()){
		case "/Connexion":
			this.getServletContext().getRequestDispatcher(ConstanteFreeArt.CONSTANTE_CHEMIN_VUE_CONNEXION).forward(poRequest, poResponse);
			break;
		case "/Inscription":
			this.getServletContext().getRequestDispatcher(ConstanteFreeArt.CONSTANTE_CHEMIN_VUE_INSCRIPTION).forward( poRequest, poResponse );
			break;	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest poRequest, HttpServletResponse poResponse) throws ServletException, IOException {
		// Traitement de la fonction
		switch(poRequest.getServletPath()){
		case "/Connexion":
			Connexion(poRequest, poResponse);
			break;
		case "/Inscription":
			Inscription(poRequest, poResponse);
			break;	
		}
	}
	
	/**
	 * 
	 * @param poRequest
	 * @param poResponse
	 */
	private void Connexion(HttpServletRequest poRequest, HttpServletResponse poResponse){
		// Declaration de variables
		HttpSession loSession;
		UtilisateurService loUtilisateurService;
		Utilisateur utilisateurCourant;
		// Initialisation des variables
		loSession = poRequest.getSession();
		loUtilisateurService = new UtilisateurService();
		//Traitement de la fonction
		utilisateurCourant = loUtilisateurService.ConnexionUtilisateur(poRequest, facadeUtilisateur);
		if (utilisateurCourant != null){
	         /* Si aucune erreur de validation n'a eu lieu, alors ajout du bean
	        	Utilisateur à la session, sinon suppression du bean de la session. */
	        if ( loUtilisateurService.getErreurs().isEmpty() ){
	            loSession.setAttribute(ConstanteFreeArt.CONSTANTE_SESSION_UTILISATEUR, utilisateurCourant);
	        } else {
	            loSession.setAttribute(ConstanteFreeArt.CONSTANTE_SESSION_UTILISATEUR, null);
	        }
		}
		else{
		}
	    // Attribution
		try {
			this.getServletContext().getRequestDispatcher(ConstanteFreeArt.CONSTANTE_CHEMIN_VUE_ACCUEIL).forward( poRequest, poResponse );
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param poRequest
	 * @param poResponse
	 */
	private void Inscription(HttpServletRequest poRequest, HttpServletResponse poResponse){
		// Déclaration des variables
		UtilisateurService loUtilisateurService;
		// Initialisation ds variables
		String action = poRequest.getParameter("action");
		// Traitement de la fonction
		if (action.compareTo("inscription") == 0){
			loUtilisateurService = new UtilisateurService();
			loUtilisateurService.CreationUtilisateur(facadeUtilisateur, poRequest.getParameter("MailUtilisateur").toString(), poRequest.getParameter("MotDePasse").toString());
		}
	}
}
