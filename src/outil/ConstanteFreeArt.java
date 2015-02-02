package outil;

/**
 * Classe contentant les différents constantes utilisés au sein de l'application.
 * @author Kevin Blenner
 *
 */
public final class ConstanteFreeArt {

	// Nom des différents servlet pour les redirections du servlet principal
	public static final String CONSTANTE_NOM_SERVLET_CONSULTATION = "/ConsultationServlet";
	public static final String CONSTANTE_NOM_SERVLET_DEPOSE = "/DeposeServlet";
	public static final String CONSTANTE_NOM_SERVLET_INSCRIPTION = "/InscriptionServlet";
	public static final String CONSTANTE_NOM_SERVLET_PANIER = "/PanierServlet";
	public static final String CONSTANTE_NOM_SERVLET_ACCUEIL= "/AccueilServlet";
	
	// Chemin vers les vues
	public static final String CONSTANTE_CHEMIN_VUE_ACCUEIL = "/accueil.jsp";
	public static final String CONSTANTE_CHEMIN_VUE_INSCRIPTION = "/inscription.jsp";
	public static final String CONSTANTE_CHEMIN_VUE_CONNEXION = "/connexion.jsp";
	public static final String CONSTANTE_CHEMIN_VUE_MENU = "/menu.jsp";
	public static final String CONSTANTE_CHEMIN_VUE_GALLERIE = "/gallerie.jsp";
	
	// Constante liés aux utilisateurs
	public static final String CONSTANTE_SESSION_UTILISATEUR = "SessionUtilisateur";
	public static final String CONSTANTE_FORM_CHAMP_EMAIL = "MailUtilisateur";
	public static final String CONSTANTE_FORM_CHAMP_MDP = "MotDePasse";
	
	// Constante liés aux images
}