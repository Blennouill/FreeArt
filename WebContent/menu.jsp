<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav>
    <div class="ten columns header_nav">
		<div class="row">
        <ul id="menu-header" class="nav-bar horizontal">
			<li class="active"><a href="<c:url value="accueil.html"/>">Accueil</a></li>
			<li class=""><a href="<c:url value="gallerie.jsp"/>">Gallerie</a></li>
			<li class=""><a href="<c:url value="contact.jsp"/>">Contact</a></li>      
        </ul>
		
        <script type="text/javascript">
         //<![CDATA[
         $('ul#menu-header').nav-bar();
          //]]>
        </script>
		</div> 
		<div class="two columns">
            <p style="margin: 6px 0">
				<a href="#" class="button radius">S'inscrire !</a> 
				<a href="#" class="button secondary radius">Se connecter !</a>
            </p>
        </div>	  
    </div>   
</nav>