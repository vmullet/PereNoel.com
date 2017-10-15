$("#admin_aj_nv_client").click(function()
{	
var tp_client=
	   "<tr>"
	+  "<td data-th='Nom Prenom'>"
	+  "<h4 class='nomargin'>"+"<div class='col-xs-6 form-group'>"+"<input type='text' class='form-control text-center' name='nom_"+"-1"+"'  value='"+""+"' placeholder='Votre nom' ></div><div class='col-xs-6 form-group'>"+""+"<input type='text' class='form-control text-center' name='prenom_"+"-1"+"'  value='"+""+"' placeholder='Votre prénom'>"+"</div></h4>"
	+  "<input type='text' class='form-control text-center' name='adresse_"+"-1"+"'  value='"+""+"' placeholder='Votre adresse'>"+"<input type='text' class='form-control text-center' name='cp_"+"-1"+"' value='"+""+"' placeholder='Votre code postal'>"+"<input type='text' class='form-control text-center' name='ville_"+"-1"+"' value='"+""+"' placeholder='Votre ville'>"
    +  "</td>"
	+  "<td data-th='Tel'>"+"<input type='text' class='form-control text-center' name='tel_"+"-1"+"'  value='"+""+"' placeholder='Votre téléphone'>"+"</td>"
	+  "<td data-th='Mail'>"
	+  "<input type='text' class='form-control text-center' name='mail_"+"-1"+"' value='"+""+"' placeholder='Votre E-mail'>"
	+  "</td>"
	+  "<td data-th='Login' class='text-center'>"+"<input type='text' class='form-control text-center' name='login_"+"-1"+"' value='"+""+"' placeholder='Votre login'>"+"</td>"
	+  "<td data-th='Mot de Passe' class='text-center'>"+"<input type='password' class='form-control text-center' name='pass_"+"-1"+"' value='"+""+"' placeholder='Votre mot de passe'>"+"<input type='password' class='form-control text-center' name='pass_confirm_"+"-1"+"' value='"+""+"' placeholder='Confirmez votre mot de passe'>"+"</td>"
	+  "<td data-th='Admin' class='text-center'>"
	+  "<select class='form-control' name='admin_"+"-1"+"'>"
	+  "<option selected='selected' value='"+"0"+"'>"+"Non"+"</option>"
	+  "<option value='"+"1"+"'>"+"Oui"+"</option>"
	+  "</select></td>"
	+  "<td class='actions' data-th=''>"
	+  "<form action='Servlet_admin' method='post' id='form_aj_client_"+"-1"+"'>"
	+  "<input type='hidden' name='action' value='ajouter_admin_client'>"
	+  "<input type='hidden' name='nom_hid_"+"-1"+"' value=''>"
	+  "<input type='hidden' name='prenom_hid_"+"-1"+"' value=''>"
	+  "<input type='hidden' name='adresse_hid_"+"-1"+"' value=''>"
	+  "<input type='hidden' name='cp_hid_"+"-1"+"' value=''>"
	+  "<input type='hidden' name='ville_hid_"+"-1"+"' value=''>"
	+  "<input type='hidden' name='tel_hid_"+"-1"+"' value=''>"
	+  "<input type='hidden' name='mail_hid_"+"-1"+"' value=''>"
	+  "<input type='hidden' name='login_hid_"+"-1"+"' value=''>"
	+  "<input type='hidden' name='pass_hid_"+"-1"+"' value=''>"
	+  "<input type='hidden' name='admin_hid_"+"-1"+"' value=''>"
	+  "<button type='button' data-mode='aj_admin_client'  data-id='"+"-1"+"' name='valide' id='nv_client' class='btn btn-success btn-sm'><i class='glyphicon glyphicon-ok'></i></button>"
	+  "</form>"
	+  "<button type='button' class='btn btn-danger btn-sm' name='supprime' id='nv_client'  data-title='Etes-vous sûr ?' data-btnOkLabel='Oui' data-btnCancelLabel='Non' data-placement='bottom' data-toggle='confirmation' data-id='"+"1"+"' ><i class='glyphicon glyphicon-remove'></i></button>"
	+  "</td>"
	+  "</tr>"
	;
	
var tableRef = document.getElementById('tab_clients').getElementsByTagName('tbody')[0];

//Insère une nouvelle ligne dans le tableau

var newRow   = tableRef.insertRow(0);

newRow.innerHTML=tp_client;
	
$('#admin_aj_nv_client').prop('disabled',true);

//Supprime le script 

$("head script").remove();
var newScript;
newScript = document.createElement('script');
newScript.type = 'text/javascript';
newScript.src = 'js/dyn.js';
document.getElementsByTagName("head")[0].appendChild(newScript);
newScript.src = 'js/edit.js';
document.getElementsByTagName("head")[0].appendChild(newScript);
});


//Ajout d'une nouvelle ligne au tableau des produits

$("#admin_aj_nv_produit").click(function()
{		

var tp_produit="<tr>"
	+  "<td data-th='Libellé'>"
	+  "<h4 class='nomargin'><input type='text' class='form-control text-center' name='libelle_"+"-1"+"' value='"+""+"'></h4>"
    +  "</td>"
	+  "<td data-th='Tel'>"+"<textarea rows='4' cols='50' name='description_"+"-1"+"'  >"+""+"</textarea>"+"</td>"
	+  "<td data-th='Stock'>"
	+  "<input type='number' class='form-control text-center' name='stock_"+"-1"+"' value='"+""+"'>"
	+  "</td>"
	+  "<td data-th='Prix' class='text-center'>"+"<input type='number' class='form-control text-center' name='prix_"+"-1"+"' value='"+""+"'>"+"</td>"
	+  "<td data-th='Image' class='text-center'>"+"<img class='productimg' id='img_"+"-1"+"' src='"+""+"' alt='' height='150' width='120'>"
	+  "<form action='Servlet_upload' method='post' id='img_form_"+"-1"+"' enctype='multipart/form-data'>"
	+ "<input type='file' accept='image/*' data-id='"+"-1"+"' class='form-control text-center' id='select_img_"+"-1"+"' name='file'>"
	+ "<input type='hidden' name='id_produit' value='"+"-1"+"'>"
	+ "</form>"
	+ "</td>"
	+  "<td data-th='' class='text-center'>"
	+  "<td class='actions' data-th=''>"
	+  "<form action='Servlet_admin' method='post' id='form_aj_produit_"+"-1"+"'>"
	+  "<input type='hidden' name='action' value='ajouter_admin_produit'>"
	+  "<input type='hidden' name='libelle_produit_hid_"+"-1"+"' value=''>"
	+  "<input type='hidden' name='description_produit_hid_"+"-1"+"' value=''>"
	+  "<input type='hidden' name='prix_produit_hid_"+"-1"+"' value=''>"
	+  "<input type='hidden' name='stock_produit_hid_"+"-1"+"' value=''>"
	+  "<input type='hidden' name='image_produit_hid_"+"-1"+"' id='image_produit_hid_"+"-1"+"' value=''>"
	+  "<button type='button' data-mode='modif_client'  data-id='"+"1"+"' name='valide' id='nv_produit' class='btn btn-success btn-sm'><i class='glyphicon glyphicon-ok'></i></button>"
	+  "</form>"
	+  "<form action='Servlet_admin' method='post' id='form_"+""+"'>"
	+  "<input type='hidden' name='action' value='supprimer_produit'>"
	+  "<input type='hidden' name='id_produit' value='"+""+"'>"
	+  "<button type='button' class='btn btn-danger btn-sm' name='supprime' id='nv_produit'  data-title='Etes-vous sûr ?' data-btnOkLabel='Oui' data-btnCancelLabel='Non' data-placement='bottom' data-toggle='confirmation' data-id='"+"1"+"' ><i class='glyphicon glyphicon-remove'></i></button>"
	+  "</form>"
	+  "</td>"
	+  "</tr>";

var tableRef = document.getElementById('tab_produits').getElementsByTagName('tbody')[0];

//Insère une nouvelle ligne dans le tableau

var newRow   = tableRef.insertRow(0);

newRow.innerHTML=tp_produit;
	
$('#admin_aj_nv_produit').prop('disabled',true);

//Supprime le script 

$("head script").remove();
var newScript;
newScript = document.createElement('script');
newScript.type = 'text/javascript';
newScript.src = 'js/dyn.js';
document.getElementsByTagName("head")[0].appendChild(newScript);


});

