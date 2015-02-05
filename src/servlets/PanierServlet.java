package servlets;

import java.io.IOException;

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
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(ConstanteFreeArt.CONSTANTE_CHEMIN_VUE_PANIER).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest poRequest, HttpServletResponse poResponse) throws ServletException, IOException {
		//Declaration des variables
		PanierService ps = new PanierService();
		Message m;
		//Traitement de la fonction
		if (poRequest.getParameter("action").compareTo(ConstanteFreeArt.CONSTANTE_PANIER_REQUETE_ACTION_TELECHARGER) == 0){
			if(ps.DownloadImages(poRequest)){
				m = new Message(ENUMTypeMessage.AfficheSucces.toString(), ConstanteFreeArt.CONSTANTE_SUCCES_TELECHARGEMENT);
				poRequest.setAttribute(ENUMTypeMessage.AfficheSucces.toString(), true);
				poRequest.setAttribute(ConstanteFreeArt.CONSTANTE_OBJET_MESSAGE, m);
				this.getServletContext().getRequestDispatcher(ConstanteFreeArt.CONSTANTE_CHEMIN_VUE_PANIER).forward(poRequest, poResponse);
			}
		}
	}

}
