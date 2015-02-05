<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav>
<div class="twelve columns header_nav_fullwidth">
	<div class="five columns" style="padding-top:8px">
		<ul id="menu-header" class="nav-bar horizontal">
			<li class="active"><a href="Accueil">Accueil</a></li>
			<li class=""><a href="Gallerie">Gallerie</a></li>
		</ul>
		<script type="text/javascript">
		//<![CDATA[
		$('ul#menu-header').nav-bar();
		 //]]>
		</script>
	</div>
	<div class="two columns">
		<%-- Vérification de la présence d'un objet utilisateur en session --%>
		<c:choose>
			<c:when test="${!empty sessionScope.SessionUtilisateur}">
				<%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
				<h4 class="succes">Bonjour ${sessionScope.SessionUtilisateur.nomUtilisateur} !</h4>
				<a href="Panier" class="dropcap_red lsf-icon-dropcap" title="cart"></a>
				<form id="formDeco" method="post" action="Deconnexion"><input type="submit" hidden="true"/></form>
				<a href="Deconnexion" id="aDeco" class="dropcap_red lsf-icon-dropcap" title="logout"></a>
			</c:when>
			<c:otherwise>
				<p style="margin: 6px 0">
					<a href="Inscription" class="button radius">S'inscrire !</a> 
					<a href="Connexion" class="button secondary radius">Se connecter !</a>
				</p>
			</c:otherwise>
		</c:choose>
   	</div>
</div> 
</nav>
<script>
$(document).ready(function(){
	$('#aDeco').on('click', function(){
 						$('#formDeco')[0].submit();
	});
});
 </script>
