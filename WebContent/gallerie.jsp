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

<section class="section_dark" style="color:white">
	<fieldset>
		<form method="post" action="Recherche">
			<ul class="inline-list">
			    <li>
				    <div class="row">
					    <div class="large-12 columns">
					      <label style="color:white">Chercher des images par:
					        <select name="ChoixSelect">
					          <option value="Auteur">Leur auteur</option>
					          <option value="NomImage">Leur nom</option>
					          <option value="Tag">Leur tag</option>
					        </select>
					      </label>
					    </div>
				  	</div>
					<div class="row">
					    <div class="large-4 columns">
					      <label style="color:white">Mot clé recherché:
					        <input type="text" placeholder="Mot" name="ValeurRecherche">
					      </label>
					    </div>
					</div>
					<div class="row">
					    <div class="large-4 columns">
					        <input type="Submit" value="Rechercher" class="button">
						</div>
					</div>
				</li>
				<div class="three columns centered" style="text-align: center">
					<h3 style="color:white">Gallerie</h3>
				</div>	  
			</ul>
		</form>
	</fieldset>
</section>   
<div class="row">
	<div class="twelve columns">
		<div id="container" class="row">
		<c:forEach var="image" items="${ListeImages}">
			<!-- photo -->
			<div class='box photo col2'>
				<img id=<c:out value="${image.codeImage}"/> src=<c:out value="${image.chemin}"/> alt="desc"/>
                <h4><strong><c:out value="${image.nomImage}"/></strong></h4>
                <p><span class="lsf-icon" title="tag"></span><c:out value="${image.tag}"/><br/>
                <span class="lsf-icon" title="user"></span><c:out value="${image.utilisateur.nomUtilisateur}"/><br/>
                <span class="lsf-icon" title="calender"></span><c:out value="${image.datePublication}"/><br/>
                <a href ="#" class="addPanier lsf-icon" title="add"></a></p>
			</div>
		</c:forEach>
		</div> <!-- end Masonry container -->
    </div>
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
