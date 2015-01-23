<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav>
<div class="twelve columns header_nav_fullwidth">
	<div class="ten columns" style="padding-top:8px">
		<ul id="menu-header" class="nav-bar horizontal">
			<li class="active"><a href="Accueil">Accueil</a></li>
			<li class=""><a href="Consultation">Gallerie</a></li>
			<li class=""><a href="Contact">Contact</a></li>
		</ul>
		<script type="text/javascript">
		//<![CDATA[
		$('ul#menu-header').nav-bar();
		 //]]>
		</script>
	</div>
	<div class="two columns">
		<p style="margin: 6px 0">
			<a href="Inscription" class="button radius">S'inscrire !</a> 
			<a href="Connexion" class="button secondary radius">Se connecter !</a>
        </p>
	</div>

</div> 
</nav>