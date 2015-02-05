package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import outil.ConstanteFreeArt;
import outil.MEnumeration.ENUMTypeMessage;
import outil.Message;
import service.UploadService;
import ejb.FacadeImage;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet(name = "UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FacadeImage fi;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest poRequest, HttpServletResponse poResponse)
	 */
	protected void doGet(HttpServletRequest poRequest, HttpServletResponse poResponse) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest poRequest, HttpServletResponse poResponse)
	 */
	protected void doPost(HttpServletRequest poRequest, HttpServletResponse poResponse) throws ServletException, IOException {
		//Déclaration des variables
		UploadService us = new UploadService();
		String chemin = this.getServletConfig().getInitParameter("Chemin");
		Message m;
		//Traitement de la fonction
	    if (us.UploaderImage(fi, poRequest, chemin)){
			m = new Message(ENUMTypeMessage.AfficheSucces.toString(), ConstanteFreeArt.CONSTANTE_SUCCES_UPLOAD);
			poRequest.setAttribute(ENUMTypeMessage.AfficheSucces.toString(), true);
			poRequest.setAttribute(ConstanteFreeArt.CONSTANTE_OBJET_MESSAGE, m);
	    }
	    else{
			m = new Message(ENUMTypeMessage.AfficheErreur.toString(), ConstanteFreeArt.CONSTANTE_ERREUR_UPLOAD);
			poRequest.setAttribute(ENUMTypeMessage.AfficheErreur.toString(), true);
			poRequest.setAttribute(ConstanteFreeArt.CONSTANTE_OBJET_MESSAGE, m);
	    }
	    this.getServletContext().getRequestDispatcher("Gallerie").forward( poRequest, poResponse );
	}
	
}
