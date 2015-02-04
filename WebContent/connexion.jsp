<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>
<section class="section_light">
        <div class="row">
        <div class="four columns">
	      <div class="signup-panel">
	        <h4 class="welcome">Connexion</h4>
	        <form data-abide method="post" action="Connexion">
	          <div class="row collapse">
	            <div class="small-12  columns">
	              <input name="NomUtilisateur" type="text" placeholder="Username" required>
	            </div>
	          </div>
	          <div class="row collapse">
	            <div class="small-12 columns ">
	              <input name="MotDePasse" type="password" placeholder="Password" required>
	            </div>
          	</div>
            <input type="submit" class="round button" value="Se connecter"/>
        </form>
      </div>
    </div>
   </div>
   </section>