<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>

<!-- ######################## Corps ######################## --> 
<c:if test="${!empty sessionScope.SessionUtilisateur}">
<header>
<div class="section_dark"><div class="row"><div class="three columns centered" style="text-align: center"><h3 style="color:white">Upload</h3></div></div></div><br>
	<form method="post" action="Upload" enctype="multipart/form-data">
		<div class="row">
			<div class="row">
				<div>
					<label>Nom de l'image</label>
					<input type="text" placeholder="" name="NomImage" required>
		   			<label>Tag de l'image </label>
					<input type="text" placeholder="" name="Tag" required>
		   			<input type="file" name="Upload" required><br><br>
		  			<input type="submit" class="round button" value="Choisir">
		  		</div>
			</div>
		</div>
	</form>
</header>
</c:if>
<div id="imgPanierContainer">
	<div>
		<div id="itemCount"></div>
	</div>
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
