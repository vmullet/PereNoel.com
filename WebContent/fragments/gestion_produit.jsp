 <%@ page language="java" contentType="text/html" session="true" %>
    <head>
    <jsp:include page="head.jsp" />
   
    <script src="js/jquery1.11.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
    <script src="js/bootstrap-confirmation.min.js"></script>
   
    <script src="js/edit.js"></script>
    <script src="js/admin.js"></script>
   </head>
   <jsp:include page="message.jsp" />
   
 <%@ page import="com.perenoel.modele.Admin" %>
 <div class="se-pre-con">
 <i class="fa fa-cog fa-spin fa-5x"></i>
 
 </div>
 
 <%if (session.getAttribute("admin")!=null)
		 {%>
		 <div id="container_jsp">
		  <%
   String ad=Admin.aff_produits();
   %>
   <%=ad %>
   </div>
		 <%} else
			 {
			 session.setAttribute("redirect","gestion_produit");
			 %>
			 
			 <jsp:include page="login.jsp" />
			 <%} %>
		 
<jsp:include page="modal.jsp" />  