<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <head>
  <jsp:include page="head.jsp" />
  <script src="js/edit.js"></script>
   </head>
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
   