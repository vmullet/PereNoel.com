package com.perenoel.modele;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

public class Admin {
	
	public static String aff_clients() //Méthode qui affiche tous les clients pour l'admin
	{
                String template_head="<a href='#' style='text-align: left' onClick='dynamic_div(&quot;admin_menu&quot;);return false;' class='btn btn-default'>Retour au Menu</a>"
                +"<br>"
                +"<button id='admin_aj_nv_client' class='btn btn-default'>Ajouter un nouveau client</button>"
                +"<h2>Liste des clients</h2>"
                + "<br>"
				+ "<div class='container'>"
				+ "<table id='tab_clients' class='table table-hover table-condensed'>"
				+ "<thead>"
				+ "<tr>"
				+  "<th style='width:30%'>Infos Clients</th>"
				+  "<th style='width:12%'>Tel</th>"
				+  "<th style='width:15%'>Mail</th>"
				+  "<th style='width:10%' class='text-center'>Login</th>"
				+  "<th style='width:15%' class='text-center'>Mot de Passe</th>"
				+  "<th style='width:10%' class='text-center'>Admin</th>"
				+  "<th style='width:8%'></th>"
				+  "</tr>"
				+  "</thead>"
				+  "<tbody >"
				;
                
                String template_foot=
        				    "</tbody>"
        				+   "<tfoot>"
        				+	"<tr>"
        				+   "<td></td>"
        				+   "<td colspan='2' class='hidden-xs'></td>"
        				+   "<td colspan='2' class='hidden-xs'></td>"
        				+   "<td class='hidden-xs text-center'></td>"
        				+   "<td></td>"
        				+    "</tr>"
        				+    "</tfoot>"
        				+    "</table>"
        				+    "</div>"
        				;
        				
                
		     String template_lst_client="";
		     CachedRowSet re=Connexion.recup_data("Select * from client");
		try 
		{
			while(re.next())
			{
				String autre="";
				String autre_texte="";
				String texte="";
				if (re.getString(11).equals("0"))
				{
					autre="1";
					autre_texte="Oui";
					texte="Non";
				}
				else
				{
					autre="0";
					autre_texte="Non";
					texte="Oui";
				}
				
				                template_lst_client+=		
						           "<tr>" 
								+  "<td data-th='Nom Prenom'>"
								+  "<h4 class='nomargin'>"+re.getString(2)+" "+re.getString(3)+"</h4>"
								+  "<input type='text' class='form-control text-center' name='adresse_"+re.getString(1)+"'  value='"+re.getString(4)+"'>"+"<input type='text' class='form-control text-center' name='cp_"+re.getString(1)+"' value='"+re.getString(5)+"'>"+"<input type='text' class='form-control text-center' name='ville_"+re.getString(1)+"' value='"+re.getString(6)+"'>"
							    +  "</td>"
								+  "<td data-th='Tel'>"+"<input type='text' class='form-control text-center' name='tel_"+re.getString(1)+"'  value='"+re.getString(7)+"'>"+"</td>"
								+  "<td data-th='Mail'>"
								+  "<input type='text' class='form-control text-center' name='mail_"+re.getString(1)+"' value='"+re.getString(8)+"'>"
								+  "</td>"
								+  "<td data-th='Login' class='text-center'>"+"<input type='text' class='form-control text-center' name='login_"+re.getString(1)+"' value='"+re.getString(9)+"'>"+"</td>"
								+  "<td data-th='Mot de Passe' class='text-center'>"+"<input type='password' class='form-control text-center' name='pass_"+re.getString(1)+"' value='"+re.getString(10)+"'>"+"<input type='password' class='form-control text-center' name='pass_confirm_"+re.getString(1)+"' value='"+re.getString(10)+"'>"+"</td>"
								+  "<td data-th='Admin' class='text-center'>"
								+  "<select class='form-control' name='admin_"+re.getString(1)+"'>"
								+  "<option selected='selected' value='"+re.getString(11)+"'>"+texte+"</option>"
								+  "<option value='"+autre+"'>"+autre_texte+"</option>"
								+  "</select></td>"
								+  "<td class='actions' data-th=''>"
								+  "<form action='Servlet_admin' method='post' id='form_mod_"+re.getString(1)+"'>"
								+  "<input type='hidden' name='action' value='modifier_client'>"
								+  "<input type='hidden' name='id_client' value='"+re.getString(1)+"'>"
								+  "<input type='hidden' name='adresse_hid_"+re.getString(1)+"' value=''>"
								+  "<input type='hidden' name='cp_hid_"+re.getString(1)+"' value=''>"
								+  "<input type='hidden' name='ville_hid_"+re.getString(1)+"' value=''>"
								+  "<input type='hidden' name='tel_hid_"+re.getString(1)+"' value=''>"
								+  "<input type='hidden' name='mail_hid_"+re.getString(1)+"' value=''>"
								+  "<input type='hidden' name='login_hid_"+re.getString(1)+"' value=''>"
								+  "<input type='hidden' name='pass_hid_"+re.getString(1)+"' value=''>"
								+  "<input type='hidden' name='admin_hid_"+re.getString(1)+"' value=''>"
								+  "<button type='button' data-mode='modif_client' data-id='"+re.getString(1)+"' class='btn btn-info btn-sm'><i class='fa fa-refresh'></i></button>"
								+  "</form>"
								+  "<form action='Servlet_admin' method='post' id='form_"+re.getString(1)+"'>"
								+  "<input type='hidden' name='action' value='supprimer_client'>"
								+  "<input type='hidden' name='id_client' value='"+re.getString(1)+"'>"
								+  "<button type='button' class='btn btn-danger btn-sm' id='btn_suppr_"+re.getString(1)+"'  data-title='Etes-vous sûr ?' data-btnOkLabel='Oui' data-btnCancelLabel='Non' data-placement='bottom' data-toggle='confirmation' data-id='"+re.getString(1)+"' ><i class='fa fa-trash-o'></i></button>"
								+  "</form>"
								+  "</td>"
								+  "</tr>"
								;
				                
			}
		} catch (SQLException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
		return template_head+template_lst_client+template_foot;
	}
	
	public static String aff_produits() //Méthode qui affiche tous les produits pour l'admin
	{
		String template_head="<a href='#'  onClick='dynamic_div(&quot;admin_menu&quot;);return false;' class='btn btn-default'>Retour au Menu</a>"
				+"<br><button id='admin_aj_nv_produit' class='btn btn-default'>Ajouter un nouveau produit</button>"
				+"<br><br>"
				+"<h2>Liste des Produits</h2>"
                + "<br>"
				+ "<div class='container'>"
				+ "<table id='tab_produits' class='table table-hover table-condensed'>"
				+ "<thead>"
				+ "<tr>"
				+ "<th style='width:20%'>Libellé</th>"
				+  "<th style='width:25%'>Description</th>"
				+  "<th style='width:10%'>Stock</th>"
				+  "<th style='width:10%' class='text-center'>Prix</th>"
				+  "<th style='width:25%'>Image</th>"
				+  "<th style='width:10%'></th>"
				+  "</tr>"
				+  "</thead>";
                
                String template_foot=
        				    "</tbody>"
        				+   "<tfoot>"
        				+	"<tr>"
        				+   "<td></td>"
        				+   "<td colspan='2' class='hidden-xs'></td>"
        				+   "<td colspan='2' class='hidden-xs'></td>"
        				+   "<td class='hidden-xs text-center'></td>"
        				+   "<td></td>"
        				+    "</tr>"
        				+    "</tfoot>"
        				+    "</table>"
        				+    "</div>";
        				
		String template_lst_produit="";
		CachedRowSet re=Connexion.recup_data("Select * from produit");
		try {
			while(re.next())
			{
				template_lst_produit+=
				           "<tr>"
						+  "<div id='new_line_-1'>"
						+  "</div>"
						+  "<td data-th='Libellé'>"
						+  "<h4 class='nomargin'><input type='text' class='form-control text-center' name='libelle_"+re.getString(1)+"' value='"+re.getString(2)+"'></h4>"
					    +  "</td>"
						+  "<td data-th='Tel'>"+"<textarea rows='4' cols='50' name='description_"+re.getString(1)+"'  >"+re.getString(3)+"</textarea>"+"</td>"
						+  "<td data-th='Stock'>"
						+  "<input type='number' class='form-control text-center' name='stock_"+re.getString(1)+"' value='"+re.getString(4)+"'>"
						+  "</td>"
						+  "<td data-th='Prix' class='text-center'>"+"<input type='number' class='form-control text-center' name='prix_"+re.getString(1)+"' value='"+re.getString(5)+"'>"+"</td>"
						+  "<td data-th='Image' class='text-center'>"+"<img class='productimg' id='img_"+re.getString(1)+"' src='"+re.getString(6)+"' alt='' height='150' width='120'>"
						+  "<form action='Servlet_upload' method='post' id='img_form_"+re.getString(1)+"' enctype='multipart/form-data'>"
						+ "<input type='file' accept='image/*' data-id='"+re.getString(1)+"' class='form-control text-center' id='select_img_"+re.getString(1)+"' name='file'>"
						+ "<input type='hidden' name='id_produit' value='"+re.getString(1)+"'>"
						+ "</form>"
						+ "</td>"
						+  "<td data-th='' class='text-center'>"
						+  "<td class='actions' data-th=''>"
						+  "<form action='Servlet_admin' method='post' enctype='multipart/form-data' id='form_mod_"+re.getString(1)+"'>"
						+  "<input type='hidden' name='action' value='modifier_produit'>"
						+  "<input type='hidden' name='id_produit' value='"+re.getString(1)+"'>"
						+  "<input type='hidden' name='libelle_produit_hid_"+re.getString(1)+"' value=''>"
						+  "<input type='hidden' name='description_produit_hid_"+re.getString(1)+"' value=''>"
						+  "<input type='hidden' name='prix_produit_hid_"+re.getString(1)+"' value=''>"
						+  "<input type='hidden' name='stock_produit_hid_"+re.getString(1)+"' value=''>"
						+  "<input type='hidden' name='image_produit_hid_"+re.getString(1)+"' id='image_produit_hid_"+re.getString(1)+"' value=''>"
						
						+  "<button type='button' data-mode='modif_produit' data-id='"+re.getString(1)+"' class='btn btn-info btn-sm'><i class='fa fa-refresh'></i></button>"
						+  "</form>"
						+  "<form action='Servlet_admin' method='post' id='form_"+re.getString(1)+"'>"
						+  "<input type='hidden' name='action' value='supprimer_produit'>"
						+  "<input type='hidden' name='id_produit' value='"+re.getString(1)+"'>"
						+  "<button type='button' class='btn btn-danger btn-sm' id='btn_suppr_"+re.getString(1)+"'  data-title='Etes-vous sûr ?' data-btnOkLabel='Oui' data-btnCancelLabel='Non' data-placement='bottom' data-toggle='confirmation' data-id='"+re.getString(1)+"' ><i class='fa fa-trash-o'></i></button>"
						+  "</form>"
						+  "</td>"
						+  "</tr>";
			}
		} catch (SQLException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
		return template_head+template_lst_produit+template_foot;
	}

}
