<form  action="Servlet_connexion" method="post" >
<h2>Formulaire de Connexion</h2>
<%
if (session.getAttribute("login_etat")=="fail")
{
session.removeAttribute("login_etat");
%>
<div class="alert alert-danger">
  <h2><strong>Erreur</strong> Vos identifiants sont incorrects</h2>
</div>
<%} %>

<%
if (session.getAttribute("register")=="success")
{
session.removeAttribute("register");
%>
<div class="alert alert-success">
  <strong>Félicitations</strong> Votre inscription a été effectuée avec succès.
</div>

<%} %>


<p>Nom d'utilisateur : </p> <input type="text" class="form-control text-center" name="username" placeholder="Votre Login"></input>
<p>Mot de passe : </p> <input type="password"  class="form-control text-center" name="password" placeholder="Votre mot de passe"></input>
<br><br>
<input type="submit" class="btn btn-lg btn-default" id="btn" value="Valider">
</form>
