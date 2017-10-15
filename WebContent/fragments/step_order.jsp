 <%@page import="com.perenoel.modele.Commande"%>
<head>
    <jsp:include page="head.jsp" />
    <link rel="stylesheet" href="css/commande.css">
    <script src="js/jquery1.11.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
    <script src="js/bootstrap-confirmation.min.js"></script>
   
    <script src="js/edit.js"></script>
    <script src="js/commande.js"></script>
</head>
  <%@ page import="com.perenoel.modele.Profil" %> 
   <%@ page import="com.perenoel.modele.Panier" %> 
 <% if (session.getAttribute("profil")!=null)
{	
	Profil p=(Profil) session.getAttribute("profil");
%>  
<form action='Servlet_commande' method='post' id='form_commander'>
<input type='hidden' name='action' value='commander'>

<div class="container" style="margin-top: 100px; margin-bottom: 100px;">
    <div class="row">
        <div class="progress" id="progress1">
            <div class="progress-bar" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 25%;">
            </div>
            <span class="progress-completed">25%</span>
        </div>
    </div>
    <div class="row" >
        <div class="row step" id="steps">
            <div id="div_step-1" class="col-md-2" onclick="javascript: resetActive(event, 25, 'step-1');">
                <span class="fa fa-pencil"></span>
                <p>Adresse de livraison</p>
            </div>
            <div id="div_step-2" class="col-md-2" onclick="javascript: resetActive(event, 50, 'step-2');">
                <span class="fa fa-euro"></span>
                <p>Mode de paiement</p>
            </div>
            <div id="div_step-3" class="col-md-2" onclick="javascript: resetActive(event, 75, 'step-3');">
                <span class="fa fa-refresh"></span>
                <p>Vérification</p>
            </div>
            <div id="div_step-4" class="col-md-2" onclick="javascript: resetActive(event, 100, 'step-4');">
                <span class="fa fa-check"></span>
                <p>Confirmation</p>
            </div>
           
            
        </div>
    </div>
    <div class="row setup-content step hiddenStepInfo" id="step-1">
        <div class="col-xs-12">
            <div class="col-md-12 text-center">
                <h2>Votre adresse de livraison</h2>
               
                <div class="row">
        <div class="col-xs-6 form-group">
            <label>Nom :</label>
            <input class="form-control text-center" name="nom" type="text" value='<%=p.getNom()%>' required/>
        </div>
        <div class="col-xs-6 form-group">
            <label>Prénom :</label>
            <input class="form-control text-center" name="prenom" type="text" value='<%=p.getPrenom()%>' required/>
        </div>
        <div class="col-xs-12 form-group">
            <label>Adresse :</label>
            <input class="form-control text-center" name="adresse" type="text" value='<%=p.getAdresse()%>' required/>
        </div>
        <div class="col-xs-6 form-group">
            <label>Code Postal :</label>
            <input class="form-control text-center" name="cp" type="number" value='<%=p.getCp()%>' maxlength="5" required/>
        </div>
        <div class="col-xs-6 form-group">
            <label>Ville :</label>
            <input class="form-control text-center" name="ville" type="text" value='<%=p.getVille()%>' required/>
        </div>
         <div class="col-xs-6 form-group">
            <label>Téléphone :</label>
            <input class="form-control text-center" name="tel" type="number" maxlength="10" value='<%=p.getTelephone()%>' required/>
        </div>
        <div class="col-xs-6 form-group">
            <label>E-mail :</label>
            <input class="form-control text-center" name="mail" type="email" value='<%=p.getMail()%>' required/>
        </div>
        <button type="button" class="btn btn-lg btn-default" id="btn_s_enregistrer" onClick="javascript: resetActive(event, 50, 'step-2');"  >Suivant</button>
        </div>
        <br>
            
            </div>
        </div>
    </div>
    <div class="row setup-content step hiddenStepInfo" id="step-2">
        <div class="col-xs-12">
            <div class="col-md-12 text-center">
                <h1></h1>
                <h3 class="underline">Mode de Paiement</h3>
                <%=Commande.modepaiement() %>
                <br>
                <button type="button" class="btn btn-lg btn-default" id="btn_precedent" onClick="javascript: resetActive(event, 25, 'step-1');"  >Précédent</button>
                <button type="button" class="btn btn-lg btn-default" id="btn_suivant" onClick="javascript: resetActive(event, 75, 'step-3');"  >Suivant</button>
        </div>
    </div>
    </div>
    <div class="row setup-content step hiddenStepInfo" id="step-3">
        <div class="col-xs-12">
            <div class="col-md-12 text-center">
                <h1></h1>
                <h3 class="underline">Vérification</h3>
                
                <%=Commande.verification((Panier)session.getAttribute("panier")) %>
                <button type="button" class="btn btn-lg btn-default" id="btn_precedent" onClick="javascript: resetActive(event, 50, 'step-2');"  >Précédent</button>
                <button type="Submit" class="btn btn-lg btn-default" id="btn_suivant" onClick="javascript: resetActive(event, 100, 'step-4');"  >Confirmer</button>
            </div>
        </div>
        
    </div>
    <div class="row setup-content step hiddenStepInfo" id="step-4">
        <div class="col-xs-12">
            <div class="col-md-12 text-center">
                <h1></h1>
                <h3 class="underline">Traitement en cours</h3>
                
                
            </div>
        </div>
    </div>
    
   
</div>
</form>
<jsp:include page="modal.jsp" />

<%}
 else
 {
	 
  
  
%>


<jsp:include page="./login.jsp" />

<%}%>