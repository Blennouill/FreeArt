<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>
<!-- ######################## Header ######################## -->
        
<header>
	<h1 class="heading_supersize">FreeArt</h1>
	<h2 class="welcome_text">Pour le libre partage de votre expression !</h2>    
</header>
        
<!-- ######################## Section ######################## -->
     
   <section class="section_light">
		<c:choose>
			<c:when test="${empty sessionScope.SessionUtilisateur}">
				<div id="myModal" class="reveal-modal" data-reveal>
					<p class="lead">La connexion a échouée !</p>
					<a class="close-reveal-modal">&#215;</a>
				</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
			<div class="row">
				 <div class="four columns">
					<h3><span class="dropcap_red lsf-icon-dropcap" title="pen"></span>Dessiner !</h3>
					<p>Dessinez, créez toutes vos envies</p>
				 </div>
				 
				  <div class="four columns">
					<h3><span class="dropcap_black lsf-icon-dropcap" title="upload"></span>Uploader</h3>
					<p> Puis venez les partager sur notre plate-forme</p>
				  </div>
				  
				  <div class="four columns">
					<h3><span class="dropcap_black lsf-icon-dropcap" title="save"></span>Telecharger</h3>
					<p>Contribuez à la liberté d'expression, contribuez au partage de la culture et de la créativité à  travers le monde !</p>
				  </div>
			</div>
    </section>
    <%@ include file="footer.jsp" %>