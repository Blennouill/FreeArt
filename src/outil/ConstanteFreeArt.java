package outil;

/**
 * Classe contentant les diff�rentes constantes utilis�s au sein de l'application.
 * @author Kevin Blenner
 *
 */
public final class ConstanteFreeArt {

	// Nom des diff�rents servlet pour les redirections du servlet principal
	public static final String CONSTANTE_NOM_SERVLET_GALLERIE = "/GallerieServlet";
	public static final String CONSTANTE_NOM_SERVLET_UPLOAD = "/UploadServlet";
	public static final String CONSTANTE_NOM_SERVLET_UTILISATEUR = "/UtilisateurServlet";
	public static final String CONSTANTE_NOM_SERVLET_PANIER = "/PanierServlet";
	public static final String CONSTANTE_NOM_SERVLET_ACCUEIL= "/AccueilServlet";
	
	// Chemin vers les vues
	public static final String CONSTANTE_CHEMIN_VUE_ACCUEIL = "/accueil.jsp";
	public static final String CONSTANTE_CHEMIN_VUE_INSCRIPTION = "/inscription.jsp";
	public static final String CONSTANTE_CHEMIN_VUE_CONNEXION = "/connexion.jsp";
	public static final String CONSTANTE_CHEMIN_VUE_MENU = "/menu.jsp";
	public static final String CONSTANTE_CHEMIN_VUE_GALLERIE = "/gallerie.jsp";
	public static final String CONSTANTE_CHEMIN_VUE_PANIER = "/panier.jsp";
	
	// Constante li�s aux utilisateurs
	public static final String CONSTANTE_SESSION_UTILISATEUR = "SessionUtilisateur";
	public static final String CONSTANTE_FORM_CHAMP_NOM = "NomUtilisateur";
	public static final String CONSTANTE_FORM_CHAMP_MDP = "MotDePasse";
	
	// Constante li�s aux uploads
	public static final String CONSTANTE_CHEMIN_UPLOAD = "/images/";
	public static final int CONSTANTE_TAILLE_TAMPON = 10240; // 10 ko
	
	// Constante message
	public static final String CONSTANTE_SUCCES_CONNEXION = "Vous �tes � pr�sent connect�s !";
	public static final String CONSTANTE_SUCCES_INSCRIPTION = "Votre inscription a bien �t� prise en compte, veuillez vous connecter...";
	public static final String CONSTANTE_ERREUR_CONNEXION = "La tentative de connexion a echou�e.";
	public static final String CONSTANTE_ERREUR_INSCRIPTION = "La tentative d'inscription a echou�e.";
	public static final String CONSTANTE_SUCCES_DECONNEXION = "Vous �tes deconnect�.";
	public static final String CONSTANTE_SUCCES_TELECHARGEMENT = "Le telechargement a r�ussi.";
	public static final String CONSTANTE_SUCCES_UPLOAD = "L'image a bien �t� ajout�e.";
	public static final String CONSTANTE_ERREUR_UPLOAD = "Il y a eu un probl�me lors de l'upload. Veuillez r�essayer...";
	
	// Constante diverse
	public static final String CONSTANTE_OBJET_MESSAGE= "Message";
	public static final String CONSTANTE_PANIER_REQUETE_ACTION_TELECHARGER = "Telecharger";
}
