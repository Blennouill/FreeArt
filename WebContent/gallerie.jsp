<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>

<div style="clear: both"></div>        
	<div class="twelve columns">
		<div id="container">
		<c:forEach var="image" items="${images}">
			<!-- photo -->
			<div class='box photo col2'>
				<a href="#"><c:out <img src="${image.chemin}" alt="desc" /> /></a>
                <h4><strong><c:out value="${image.nomImage}" /></strong></h4>
                <p><span class="dropcap_red lsf-icon-dropcap" title="tag"></span><c:out value="${image.tag}" /></p>
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