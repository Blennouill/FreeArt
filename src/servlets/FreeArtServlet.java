package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import outil.ConstanteFreeArt;

/**
 * Servlet implementation class FreeArtServlet.
 * Point d'entr�e de l'application web
 */
@WebServlet(name = "FreeArtServlet")
public class FreeArtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeArtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest poRequest, HttpServletResponse poResponse)
	 */
	protected void doGet(HttpServletRequest poRequest, HttpServletResponse poResponse) throws ServletException, IOException {
		//->D�claration des variables
		RequestDispatcher loRequestDispatcher = poRequest.getRequestDispatcher("/error404.html");
		//->Traitement de la fonction
		// le param�tre action permet de savoir ce qu'il faut faire
		try{
			// redirection de la requ�te
			
			loRequestDispatcher.forward(poRequest, poResponse);
		}
		catch (ServletException se) {
			System.out.println(se.toString());
		}
		catch (IOException ioe){
			System.out.println(ioe.toString());
		}
	}

	/** Fonction r�pondant aux requ�tes de type post
	 * @see HttpServlet#doPost(HttpServletRequest poRequest, HttpServletResponse poResponse)
	 */
	protected void doPost(HttpServletRequest poRequest, HttpServletResponse poResponse) throws ServletException, IOException {
		//->D�claration des variables
		RequestDispatcher loRequestDispatcher = poRequest.getRequestDispatcher("/error404.html");
		//->Traitement de la fonction
		// le param�tre action permet de savoir ce qu'il faut faire
		try{
			String lstrTypeAction = poRequest.getParameter("action");
	
			// le contr�leur principal redirige la requ�te vers la servlet g�rant l'action � r�aliser
			switch (lstrTypeAction){
				case "1":
					loRequestDispatcher = poRequest.getRequestDispatcher(ConstanteFreeArt.CONSTANTE_NOM_SERVLET_CONSULTATION);
					break;
				case "2":
					loRequestDispatcher = poRequest.getRequestDispatcher(ConstanteFreeArt.CONSTANTE_NOM_SERVLET_DEPOSE);
					break;
				case "3":
					loRequestDispatcher = poRequest.getRequestDispatcher(ConstanteFreeArt.CONSTANTE_NOM_SERVLET_INSCRIPTION);
					break;
				case "4":
					loRequestDispatcher = poRequest.getRequestDispatcher(ConstanteFreeArt.CONSTANTE_NOM_SERVLET_PANIER);
					break;
				default:
					loRequestDispatcher = poRequest.getRequestDispatcher(ConstanteFreeArt.CONSTANTE_NOM_SERVLET_ACCUEIL);
					break;
				
			}
			// redirection de la requ�te
			loRequestDispatcher.forward(poRequest, poResponse);
		}
		catch (ServletException se) {
			System.out.println(se.toString());
		}
		catch (IOException ioe){
			System.out.println(ioe.toString());
		}
	}

}