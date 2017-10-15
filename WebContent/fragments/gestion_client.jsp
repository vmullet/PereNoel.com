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
 
 <%if (session.getAttribute("admin")!=null)
		 {%>
		  <%
   String ad=Admin.aff_clients();
   %>
   <%=ad %>
		 <%} else
			 {
			 session.setAttribute("redirect","gestion_client");
			 %>
			 <jsp:include page="login.jsp" />
			 <%} %>
		 
  