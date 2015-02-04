package servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import outil.ConstanteFreeArt;
import outil.Utilitaire;
import service.ImageService;
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
		//Traitement de la fonction
	    if (us.UploaderImage(fi, poRequest, chemin)){
	    	// Pas d'erreur
	    }
	    else
	    	// Erreur !
	    this.getServletContext().getRequestDispatcher(ConstanteFreeArt.CONSTANTE_CHEMIN_VUE_GALLERIE).forward( poRequest, poResponse );
	}
	
}
