    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <head>
    <jsp:include page="head.jsp" />
   
    <script src="js/jquery1.11.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
    <script src="js/bootstrap-confirmation.min.js"></script>
   
    <script src="js/edit.js"></script>
    <script src="js/panier.js"></script>
   
   </head>
<% if (session.getAttribute("panier")!=null)
{ %>

${panier.gen_panier()}
<% }
else
   {%>
   				<div id='container_jsp'>
				<h2>Votre panier est vide</h2>
				<a href='#' onClick="dynamic_div(&quot;catalogue&quot;);return false;" class='btn btn-warning'><i class='fa fa-angle-left'></i> Continuer le shopping</a>
				</div>
   <%} %>
   
 
<jsp:include page="modal.jsp" />
  


    