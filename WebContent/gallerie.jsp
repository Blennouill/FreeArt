<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>

<!-- ######################## Corps ######################## --> 
<header>
<c:if test="${!empty sessionScope.SessionUtilisateur}">
	<form method="post" action="Upload" enctype="multipart/form-data">
		<div class="row">
			<div class="row">
				<div>
					<label>Nom de l'image</label>
					<input type="text" placeholder="" name="NomImage">
		   			<label>Tag de l'image </label>
					<input type="text" placeholder="" name="Tag">
		   			<input type="file" name="Upload"><br><br>
		  			<input type="submit" class="round button" value="Choisir">
		  		</div>
			</div>
		</div>
	</form>
</c:if>
</header>
	
<section class="section_light"><br></section>      
	<div class="twelve columns">
		<div id="container" class="row">
		<c:forEach var="image" items="${ListeImages}">
			<!-- photo -->
			<div class='box photo col2'>
				<a href="#"><img src=<c:out value="${image.chemin}"/> alt="desc"/></a>
                <h4><strong><c:out value="${image.nomImage}"/></strong></h4>
                <p><span class="dropcap_red lsf-icon-dropcap" title="tag"></span><c:out value="${image.tag}"/></p>
			</div>
		</c:forEach>
		</div> <!-- end Masonry container -->
    </div>

<!-- ######################## Scripts ######################## --> 

	<!-- end page wrap) -->
	<!-- Included JS Files (Compressed) -->
	<script src="javascripts/foundation.min.js" type="text/javascript">
	</script>
	<!-- Initialize JS Plugins -->
	<script src="javascripts/app.js" type="text/javascript">
	</script>
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
