<%if (session.getAttribute("modif")=="success")
{
session.removeAttribute("modif");
%>
<div class="alert alert-success">
  <strong>Modification</strong> Effectuée avec succès
</div>

<%}
if (session.getAttribute("modif")=="fail")
{
%>

<div class="alert alert-danger">
  <strong>Erreur</strong> La modification a échoué
</div>
<%} %>
   <%
if (session.getAttribute("supp")=="success")
{
session.removeAttribute("supp");
%>
<div class="alert alert-success">
  <strong>Suppression</strong> Effectuée avec succès
</div>

<%}
if (session.getAttribute("supp")=="fail")
   {%>
   <div class="alert alert-danger">
  <strong>Erreur</strong> La suppression a échoué
</div>
   <%}%>
 
 <%if (session.getAttribute("ajout")=="fail")
   {%>
   <div class="alert alert-danger">
  <strong>Erreur</strong> L'ajout a échoué
</div>
   <%}%>
   
  <% if (session.getAttribute("ajout")=="success")
   {%>
   <div class="alert alert-success">
  <strong>Ajout</strong> effectué avec succès
</div>
   <%}%>
   
<%
session.removeAttribute("modif");
session.removeAttribute("supp");
session.removeAttribute("ajout");
%>
