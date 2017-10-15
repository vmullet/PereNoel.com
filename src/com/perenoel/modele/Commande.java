package com.perenoel.modele;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.sql.rowset.CachedRowSet;

public class Commande {

	public static String modepaiement()
	{
		CachedRowSet re=Connexion.recup_data("Select * from paiement");
		
		String template="<div class='funkyradio'>";
		try {
			while(re.next())
			{
				template+="<div>"
						+ "<input type='radio' name='paiement' id='radio"+re.getString(1)+"' value='"+re.getString(1)+"' />"
						+ " <label class='myradio' for='radio"+re.getString(1)+"'>"+re.getString(2)+"</label>"
						+ "</div>";
		       
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		template+="</div>";
		return template;
	}
	
	public static String verification(Panier p)
	{
		
		String defaut="<div id='container_jsp'>"
				+ "<h2>Votre panier est vide</h2>"
				+ "<a href='#' onClick='dynamic_div(&quot;catalogue&quot;);return false;' class='btn btn-warning'><i class='fa fa-angle-left'></i> Continuer le shopping</a>"
				+ "</div>";
		if (p.getSize()!=0)
		{
		float sous_total=0;
		String template_head=
				
				"<div class='container'>"
				+ "<table id='cart' class='table table-hover table-condensed'>"
				+ "<thead>"
				+ "<tr>"
				+ "<th style='width:50%'>Produit</th>"
				+  "<th style='width:10%'>Prix</th>"
				+  "<th style='width:8%'>Quantité</th>"
				+  "<th style='width:22%' class='text-center'>Sous-Total</th>"
				+  "<th style='width:10%'></th>"
				+  "</tr>"
				+  "</thead>";
		
				String template_body="<tbody>";
				for (Produit prod:p.getLst_prod())
				{
					sous_total=prod.getPrix()*prod.getQuantite();
				template_body+=
				  "<tr>"
				+ "<td data-th='Produit'>"
				+ "<div class='row'>"
				+ "<div class='col-sm-2 hidden-xs'><img src='"+prod.getLien_image()+"'"+" width='210' height='180' alt='...' class='img-responsive'/></div>"
				+ "<div class='col-sm-10'>"
				+ "<h4 class='nomargin'>"+prod.getLibelle()+"</h4>"
				+ "<p>"+prod.getDescription()+"</p>"
				+ "</div>"
				+ "</div>"
			    + "</td>"
				+ "<td data-th='Prix' id='px_prod_"+prod.getId()+"' >"+prod.getPrix()+"</td>"
				+ "<td data-th='Quantité'>"
				+ "<input data-mode='quantite_panier' data-id='"+prod.getId()+"' name='pan_qte_"+prod.getId()+"' id='pan_qte_"+prod.getId()+"' type='number' class='form-control text-center' value='"+prod.getQuantite()+"' min='1' max='"+prod.getStock()+"' disabled>"
				+ "</td>"
				+ "<td data-th='Sous-Total' name='ss_totaux' id='pan_ss_"+prod.getId()+"'  class='text-center'>"+sous_total+"</td>"
				+ "<td class='actions' data-th=''>"
				+ "</td>"
				+ "</tr>";
				}
				
				String template_foot=
				"</tbody>"
				+"<tfoot>"
				+	"<tr>"
				+   "<td colspan='3' class='hidden-xs'></td>"
				+   "<td class='hidden-xm' id='total_panier'><h2>Total: <strong>"+p.getTotal()+" &euro;"+"</strong></h2></td>"
				+   "<td colspan='1' class='hidden-xs'></td>"
				+    "</tr>"
				+     "</tfoot>"
				+  "</table>"
				+  "</div>"
				;					
		return template_head+template_body+template_foot;
		}
		else
		{	
		return defaut;
		}
	}
	
	
	
	
	
	public static String gen_mes_commandes(Profil cl)
	{
		
		int id_cl=cl.getId();
		String template_foot="";
		CachedRowSet re=Connexion.recup_data("Select commande.id,commande.total,commande.date,paiement.libelle from commande,client,paiement where commande.id_client=client.id and commande.id_paiement=paiement.id  and client.id='"+id_cl+"' order by commande.id asc");
		
		String defaut="<div id='container_jsp'>"
				+ "<h2>Vous n'avez pas de commandes</h2>"
				+ "<a href='#' onClick='dynamic_div(&quot;client_menu&quot;);return false;' class='btn btn-warning'><i class='fa fa-angle-left'></i>Retour au menu</a>"
				+ "</div>";
		int rowcount = 0;
		try {
			if (re.last()) {
			  rowcount = re.getRow();
			  re.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (rowcount!=0)
		{
		
		String template_head=
				"<a href='#' onClick='dynamic_div(&quot;client_menu&quot;);return false;' class='btn btn-default'>Retour au menu</a>"
				+"<br><br><br>"
				+"<div class='container'>"
				+ "<table id='cart' class='table table-hover table-condensed'>"
				+ "<thead>"
				+ "<tr>"
				+ "<th style='width:15%' class='text-center'>Commande n°</th>"
				+  "<th style='width:25%' class='text-center'>Date</th>"
				+  "<th style='width:10%' class='text-center'>Total</th>"
				+  "<th style='width:10%' class='text-center'>Mode de Paiement</th>"
				+  "<th style='width:45%' class='text-center'>Produits</th>"
				+  "</tr>"
				+  "</thead>";
		
				String template_body="<tbody>";
				try {
					while(re.next())
					{
						CachedRowSet recup_produit=Connexion.recup_data("Select produit.*,contenir.quantite from contenir,produit where contenir.id_produit=produit.id and contenir.id_commande='"+re.getString(1)+"'");
					template_body+=
					  "<tr>"
					+ "<td data-th='Commande n°: '>"
					+ "<div class='row'>"
					+ "<h2 class='nomargin'>"+re.getString(1)+"</h2>"
					+ "<p>"+""+"</p>"
					+ "</div>"
					+ "</div>"
					+ "</td>"
					+ "<td data-th='Date: ' id='px_prod_"+""+"' ><h2>"+convert_data(re.getString(3))+"</h2></td>" //Conversion de la date
					+ "<td data-th='Total: '><h2>"
					+ re.getString(2)
					+ " &euro;</h2></td>"
					+ "<td data-th='Mode de Paiement' name='ss_totaux' id='pan_ss_"+"'  class='text-center'><h2>"+re.getString(4)+"</h2></td>"
					+ "<td data-th='Produits' class='text-center'>";
				
					while(recup_produit.next())
					{
					template_body+=
							
							"<div class='col-xs-6'>"
							+"<h3>"+recup_produit.getString(2)+"</h3>"
					  +"<img src='"+recup_produit.getString(6)+"' width='100' height='125' alt='...' />"+"<br><h3>Quantité: "+recup_produit.getString(7)+"</h3>"
					  +"<hr>"
					+"</div>";
				
					}
					template_body+=
					 "</td>"
					+ "</tr>";
					
					template_foot = "</tbody>"
							+"<tfoot>"
							+	"<tr>"
							+   "<td colspan='3' class='hidden-xs'></td>"
							+   "<td class='hidden-xm' id='total_panier'></td>"
							+   "<td colspan='1' class='hidden-xs'></td>"
							+    "</tr>"
							+     "</tfoot>"
							+  "</table>"
							+  "</div>";
					}
					
								
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		return template_head+template_body+template_foot;
		}
		else
		{	
		return defaut;
		}
		
			
	}
	
	
	
	
	
	
	public static void commander(HttpSession sess,Profil cl,Panier p,String mode_paiement)
	{
		int id=cl.getId();
		float total=Float.parseFloat(Integer.toString(p.getTotal()));
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		Connexion.exec_req("Insert into commande(`id_client`,`id_paiement`,`total`,`date`) values('"+id+"','"+mode_paiement+"','"+total+"','"+currentTime+"')");
		String id_commande_gen=Connexion.recup_commande(id,mode_paiement,total,currentTime);
		sess.setAttribute("command_gen",id_commande_gen);
		System.out.println(id_commande_gen);
		for (Produit prod:p.getLst_prod())
		{
			int id_prod=prod.getId();
			int nv_stock=prod.getStock()-prod.getQuantite();
			Connexion.exec_req("Insert into contenir values('"+id_commande_gen+"','"+id_prod+"','"+prod.getQuantite()+"')");
			Connexion.exec_req("Update Produit set stock='"+nv_stock+"' where id='"+id_prod+"'");
		}
		
	}
	
	public static String convert_data(String bdd)
	{
		
       String ldate="";
	    SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy HH:mm");
	    
		try {
			ldate = sf.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(bdd));
			 System.out.println(ldate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   return ldate;
	}
	
	
		
}
