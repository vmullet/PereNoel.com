  <%@ page language="java" contentType="text/html" session="true" %>
 <head>
    <jsp:include page="head.jsp" />
   <script src="js/jquery1.11.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-confirmation.min.js"></script>
<script src="js/edit.js"></script>
  
   </head>
   <%@ page import="com.perenoel.modele.Profil" %>
   <%@ page import="com.perenoel.modele.Commande" %>
   <% if (session.getAttribute("profil")!=null)
{	
	Profil p=(Profil) session.getAttribute("profil");
%>
<jsp:include page="message.jsp" />
<jsp:include page="modal.jsp" />


 <%=Commande.gen_mes_commandes(p) %>



<%
}
   else
   {

	   session.setAttribute("redirect","client_commandes");
%>
<jsp:include page="login.jsp" />

<%

   }



%>