<%@ page import="com.perenoel.modele.Panier" %>

   
<%
boolean logged=false; 
boolean admin=false;
String aff;
if (session.getAttribute("profil")==null)
	{
	aff="";
	logged=false;
	}
	else
	{
	aff=session.getAttribute("profil").toString() ;
	logged=true;
	}
	if (session.getAttribute("admin")=="true")
	{
	
		admin=true;
	}
	else
	{
		admin=false;
	}
		
%>

<%

int taille;
if (((Panier) session.getAttribute("panier"))==null)
	taille=0;
else
	taille=((Panier) session.getAttribute("panier")).getSize();

%>

<header>
  
<div  class="sectionhead" id="client_menu">        
            <a href="#" onClick="dynamic_div('register');return false;" class="btn btn-default">S'inscrire</a>
            <%if (admin)
            {
            %>
             <a href="#" onClick="dynamic_div('admin_menu');return false;" class="btn btn-default">Admin</a>
            <% }%>
            <%if (logged)
            {
            %>
             <a href="#" onClick="dynamic_div('client_menu');return false;" class="btn btn-default">Mon Compte</a>
            <% }
            else
            { %>
              <a href="#" onClick="dynamic_div('login');return false;" class="btn btn-default">Se Connecter</a>
            <%} %>
            
            <a href="#" onClick="dynamic_div('panier');return false;" class="btn btn-default">Mon Panier(<%=taille %>)</a>
             <%if (logged)
            	 { %>
            	 <form method="post" id="client_menu" action="Servlet_destroy">
            	 <input type="hidden" name="action" value="profil">
				<input  class="btn btn-default" type="submit" value="Déconnexion">
				</form>
            	 <% } %>
             
</div>
          <hr> 
        <!--SECTIONHEAD END-->
    <!-- ===========================
    HERO SECTION
    =========================== -->
    <div id="hero">
        <div class="redoverlay">
            <div class="container">
                <div class="row">
                    <div class="herotext">
                        <h2 class="wow zoomInDown" data-wow-duration="3s">HoHo Ho Les ventes de noël commencent!</h2>
                        <h1 class="wow flipInY">PereNoel.com</h1>

                        <a class="btn btn-reverse wow zoomIn" href="#" onClick="dynamic_div('catalogue');return false;">
                            <h3>Decouvrez notre <span class="optional">catalogue !</span></h3>                            
                        </a><!--#NOTE: texts inside the OPTIONAL tag above would be hidden on smaller mobile screens -->

                        <p class="wow fadeInUp" data-wow-duration="2s">L'offre prend fin le mercredi 31 décembre</p>

                        <img class="bigbell wow tada infinite" data-wow-duration="30s" src="img/bell.png" alt="">
                    </div>

                    <div class="santa wow bounceInDown" data-wow-duration="2s">
                        <img src="img/santa.png" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div><!--HERO SECTION END-->
    
    <!-- ===========================
    OVERVIEW SECTION
    =========================== --> 
    <div id="overview" class="container">       
        <!--SECTIONHEAD START-->
        <div class="sectionhead">            
            <h2>Meilleur <span class="highlight">Site</span> de décorations de noël</h2>
            <p>PereNoel.com est le meilleur choix pour trouver les produits de noël au meilleur prix. N'hésitez plus !</p>
            <hr>
        </div><!--SECTIONHEAD END-->
        </div>
       
    
    
    
    
    
        </header>