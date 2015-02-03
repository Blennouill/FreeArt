package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();
		int count = 1;
		//getCookies returns null if nothing was found
		if(cookies != null){
			count += cookies.size();
		}
		String image_url = request.getParameter("image_url");
		//TODO: Check to see if the image_url is a valid url from this server.

		Cookie imageUrlCook = new Cookie("image_url_"+count, image_url);
		response.addCookie(imageUrlCook);
	}

}

/*
VOICI LA FONCTION POUR RECUPERER TOUT LE PANIER DU CLIENT POUR AFFICHER DANS SOIT LA GALLERIE OU/ET LE PANIER
	Cookie[] cookies = request.getCookies();
	HashMap<String, Cookie> cookiesMap = new HashMap<String, Cookie>();
	if(cookies != null){
		//quelquechose dans le panier
		for(Cookie c: cookies){
			cookiesMap.put(c.getName(), c);
		}
		//donc voila tout est dans cookiesMap
	}else{
		//rien dans le paneir... 
	}
	//send cookiesMap a n'importe quel page jsp pour l'affichage
*/
