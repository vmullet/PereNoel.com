 <%@ page language="java" contentType="text/html" session="true" %>
<head>

<script src="js/jquery1.11.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-confirmation.min.js"></script>
<script src="js/edit.js"></script>
     
</head>  

<%@ page import="com.perenoel.modele.Profil" %>

<% if (session.getAttribute("profil")!=null)
{	
	Profil p=(Profil) session.getAttribute("profil");
%>
<jsp:include page="message.jsp" />
<jsp:include page="modal.jsp" />

<form action="Servlet_enregistrement" method="post">
<a href='#' style='text-align: left' onClick='dynamic_div(&quot;client_menu&quot;);return false;' class='btn btn-default'>Retour au Menu</a>
<br>
<h2>Vos informations</h2>

<input type="hidden" name="action" value="modifier_profil">

<br>

<div class="row">
        <div class="col-xs-6 form-group">
            <label>Nom :</label>
            <input class="form-control text-center" name="nom" type="text" value='<%=p.getNom()%>' required/>
        </div>
        <div class="col-xs-6 form-group">
            <label>Prénom :</label>
            <input class="form-control text-center" name="prenom" type="text" value='<%=p.getPrenom()%>' required/>
        </div>
        <div class="col-xs-12 form-group">
            <label>Adresse :</label>
            <input class="form-control text-center" name="adresse" type="text" value='<%=p.getAdresse()%>' required/>
        </div>
        <div class="col-xs-6 form-group">
            <label>Code Postal :</label>
            <input class="form-control text-center" name="cp" type="number" value='<%=p.getCp()%>' maxlength="5" required/>
        </div>
        <div class="col-xs-6 form-group">
            <label>Ville :</label>
            <input class="form-control text-center" name="ville" type="text" value='<%=p.getVille()%>' required/>
        </div>
         <div class="col-xs-6 form-group">
            <label>Téléphone :</label>
            <input class="form-control text-center" name="tel" type="number" maxlength="10" value='<%=p.getTelephone()%>' required/>
        </div>
        <div class="col-xs-6 form-group">
            <label>E-mail :</label>
            <input class="form-control text-center" name="mail" type="email" value='<%=p.getMail()%>' required/>
        </div>
        <button type="submit" class="btn btn-lg btn-default" id="btn_s_enregistrer" >Valider</button>
        </div>
        <br>
        
</form>

<form action="Servlet_enregistrement" id="form_modif_cl_pass" method="post">
		<div class="row">
		<h2>Modifier mon mot de passe</h2>
		<input type="hidden" name="action" value="modifier_pass">
		<br>
		
		<div class="col-xs-4 form-group">
            <label>Mot de Passe actuel:</label>
            <input class="form-control text-center" name="pass_actuel" type="password" required/>
        </div>
        <div class="col-xs-4 form-group">
            <label>Mot de Passe :</label>
            <input class="form-control text-center" name="nv_pass" id="nv_pass" type="password" required/>
        </div>
        <div class="col-xs-4 form-group">
            <label>Confirmez le mot de passe :</label>
            <input class="form-control text-center" name="nv_pass_confirm" id="nv_pass_confirm" type="password" required/>
        </div>
          
    </div>
    <button type="button" class="btn btn-lg btn-default" id="btn_modif_cl_pass" >Valider</button>
</form>

<%
}
else
{
	session.setAttribute("redirect","client_infos");
%>
<jsp:include page="login.jsp" />
<%
}
%>