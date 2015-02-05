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
		<a href="#">Voir panier</a>
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
</div>
<section class="section_dark"><div class="row"><div class="three columns centered" style="text-align: center"><h3 style="color:white">Gallerie</h3></div></div></section>   
<div class="row">
	<div class="twelve columns">
		<div id="container" class="row">
		<c:forEach var="image" items="${ListeImages}">
			<!-- photo -->
			<div class='box photo col2'>
				<img id=<c:out value="${image.codeImage}"/> src=<c:out value="${image.chemin}"/> alt="desc"/>
                <h4><strong><c:out value="${image.nomImage}"/></strong></h4>
                <p><span class="lsf-icon" title="tag"></span><c:out value="${image.tag}"/><br/>
                <span class="lsf-icon" title="user"></span><c:out value="${image.utilisateur.nomUtilisateur}"/></br>
                <a href ="Panier" class="addPanier lsf-icon" title="add"></a></p>
			</div>
		</c:forEach>
		</div> <!-- end Masonry container -->
    </div>
 </div>

<%@ include file="footer.jsp" %>
<!-- ######################## Scripts ######################## --> 

	<!-- Masonry for galleries -->
	<script src="javascripts/masonry.js" type="text/javascript">
	</script>
	<script type="text/javascript">
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
