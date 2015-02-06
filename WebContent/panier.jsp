<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>

<div id="imgPanierContainer">
	<div id="panierImgs">
		<!-- example:
			//class panierImg = affiche l'image en super petit pour quel puisse etre afficher dans le panier
			 <div class="img_in_panier">
			 	<img class="panierImg">
			 	<a class="deleteImgCookie">
			 		<i class="fi-x"></i>
			 	<a>
		 </div> -->
	</div>
	<a id="deleteAllImgCookies">Tout Supprimer</a>
	<a href="#">Telecharge tout en .zip</a>
</div>
<%@ include file="footer.jsp" %>
<!-- ######################## Scripts ######################## --> 

	<script type="text/javascript" src="javascripts/jquery.cookie.js"></script>
	<script type="text/javascript" src="javascripts/cookieHandler.js"></script>
	
	<!-- Masonry for galleries -->
	<script src="javascripts/masonry.js" type="text/javascript"></script>
	<script>
		//<![CDATA[
		      $(function(){
		        var $container = $('#container');
		        $container.imagesLoaded( function(){
		          $container.masonry({
		            itemSelector : '.box',
		                        isFitWidth: true,
		                        isAnimated: true
		          });
		        });
		      });
		  //]]>
	  </script>
