<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>

<section class="section_dark"><div class="row"><div class="three columns centered" style="text-align: center"><h3 style="color:white">Download</h3></div></div></div><br>
	<a href="" id="deleteAllImgCookies" class="dropcap_red lsf-icon-dropcap" title="delete"></a>
	<a href="Download" id="download" class="dropcap_red lsf-icon-dropcap" title="save"></a>
	<br>
</section>
<br>
<div id="imgPanierContainer">
	<div id="panierImgs" class="row">
		<!-- example:
			//class panierImg = affiche l'image en super petit pour quel puisse etre afficher dans le panier
			 <div class="img_in_panier">
			 	<img class="panierImg">
			 	<a class="deleteImgCookie">
			 		<i class="fi-x"></i>
			 	<a>
		 </div> -->
	</div>
</div>
<br>
<%@ include file="footer.jsp" %>
<!-- ######################## Scripts ######################## --> 
	
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
