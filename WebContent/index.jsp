<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//FR" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
   
<jsp:include page="fragments/head.jsp" /> 
  <title>PereNoel.com</title>
</head>

<body>
   
 <jsp:include page="fragments/header.jsp" />
 <div class="se-pre-con">
	<i class="fa fa-cog fa-spin fa-5x"></i>
	
	</div>
 	<div id="container_jsp">
    <!-- ===========================
    PRODUCTS SECTION
    =========================== -->
    <div id="products" class="container">

        <!--SECTIONHEAD START-->
        <div class="sectionhead text-center">
            <h2>Des produits <span class="highlight">en promo</span> régulièrement</h2>
            <p>Ne ratez pas les meilleures affaires du moment !</p>
            <hr>
        </div><!--SECTIONHEAD END-->

        <hr><!--SEPARETOR LINE-->
	
	<jsp:include page='/servlet_catalogue' />
	<div id="catalogue">
	${catalogue}
	</div>
        
    </div><!--PRODUCTS SECTION END-->
    </div>
    
     <jsp:include page='fragments/modal.jsp' />
<% if (session.getAttribute("interaction")!=null){  %>
    <input type="hidden" id="interaction" value='<%=(session.getAttribute("interaction")).toString()%>'>
    <%session.removeAttribute("interaction"); %>
    <%} %>
   <jsp:include page="fragments/footer.jsp" />    
</body>
</html>
