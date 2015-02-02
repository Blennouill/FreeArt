<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>
<section class="section_light">
<div class="center row">
    <div class="large-6 columns">
      <div class="content" data-section-content>
          <div class="row">
            <div class="large-12 columns">
              <div class="signup-panel">
                <p class="welcome">Inscription</p>
                <form method="post" action="Inscription">
                <fieldset>
                  <div class="row collapse">
                    <div class="small-12  columns">
                      <input name="MailUtilisateur" type="text" placeholder="Email">
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="small-12 columns ">
                      <input name="MotDePasse" type="password" type="text" placeholder="Password">
                    </div>
                  </div>
                  <input type="hidden" name="action" value="inscription"/> 
                  <input class="round button" type="submit" value="Valider" name="submit"/>
                  <br />
                  <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            	</fieldset>
                </form>
              </div>
            </div>
           </div>
      </div>
    </div>
   </div>
   </section>