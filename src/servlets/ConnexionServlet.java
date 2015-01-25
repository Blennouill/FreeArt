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

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet(name = "ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest poRequest, HttpServletResponse poResponse) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(ConstanteFreeArt.CONSTANTE_CHEMIN_VUE_CONNEXION).forward(poRequest, poResponse);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest poRequest, HttpServletResponse poResponse) throws ServletException, IOException {
		// Declaration de variables
		HttpSession loSession;
		UtilisateurService loUtilisateurService;
		Utilisateur utilisateurCourant;
		// Initialisation des variables
		loSession = poRequest.getSession();
		loUtilisateurService = new UtilisateurService();
		//Traitement de la fonction
		utilisateurCourant = loUtilisateurService.ConnexionUtilisateur(poRequest);
		/* Mise en session du nom de l'utilisateur */
		loSession.setAttribute(ConstanteFreeArt.CONSTANTE_SESSION_UTILISATEUR, utilisateurCourant);

         /* Si aucune erreur de validation n'a eu lieu, alors ajout du bean
        	Utilisateur à la session, sinon suppression du bean de la session. */
        if ( loUtilisateurService.getErreurs().isEmpty() ){
            loSession.setAttribute(ConstanteFreeArt.CONSTANTE_SESSION_UTILISATEUR, utilisateurCourant);
        } else {
            loSession.setAttribute(ConstanteFreeArt.CONSTANTE_SESSION_UTILISATEUR, null);
        }
        // Attribution 
        this.getServletContext().getRequestDispatcher(ConstanteFreeArt.CONSTANTE_CHEMIN_VUE_ACCUEIL).forward( poRequest, poResponse );
	}

}
