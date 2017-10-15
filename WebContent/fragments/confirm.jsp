<head>
    <jsp:include page="head.jsp" />
   <script src="js/jquery1.11.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-confirmation.min.js"></script>
<script src="js/edit.js"></script>
  
   </head>
 
   <% if (session.getAttribute("profil")!=null)
{	
	
%>
<jsp:include page="message.jsp" />
<jsp:include page="modal.jsp" />

<div class='text-center'>
 <h2>Félicitations !</h2>
 <h3>Votre commande a été validée. Votre numéro de commande est le suivant :</h3>
 <h3>N° <%=session.getAttribute("command_gen").toString() %></h3>
 <h4>Vous pouvez suivre l'évolution de votre commande depuis votre compte.</h4>
  <br>
  <a href="#" onClick="dynamic_div('client_commandes');return false;" class="btn btn-default">Suivre Mes commandes</a>
  <br><br>
  <a href="#" onClick="dynamic_div('catalogue');return false;" class="btn btn-default">Retourner à l'accueil</a>
</div>

<%
}
   else
   {
%>
<jsp:include page="login.jsp" />

<%

   }



%>