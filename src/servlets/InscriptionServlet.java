package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utilisateur;
import ejb.FacadeUtilisateur;
import outil.ConstanteFreeArt;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet(name = "InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	@EJB
	private FacadeUtilisateur facadeUtilisateur;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(ConstanteFreeArt.CONSTANTE_CHEMIN_VUE_INSCRIPTION).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.compareTo("inscription") == 0){
			CreationUtilisateur(request.getParameter("MailUtilisateur").toString(), request.getParameter("MotDePasse").toString());
		}
	}
	
	@SuppressWarnings("unchecked")
	private void CreationUtilisateur(String mail, String motDePasse){
		Utilisateur u = new Utilisateur(mail, motDePasse);
		facadeUtilisateur.create(u);
	}
	

}
