 <%@ page language="java" contentType="text/html" session="true" %>
  <head>
    <jsp:include page="head.jsp" />
   
    <script src="js/step.js"></script>
   </head>
<%if (session.getAttribute("profil")==null)
{
	session.setAttribute("redirect","step_order");
	%>
	<jsp:include page="login.jsp" />
	<%
	
}
else
{
	%>
	<jsp:include page="step_order.jsp" />
	<%
	
}


%>