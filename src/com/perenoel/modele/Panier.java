package com.perenoel.modele;

import java.util.ArrayList;
import java.util.List;

public class Panier {

	private List<Produit> lst_prod=new ArrayList<Produit>();

	public List<Produit> getLst_prod() {
		return lst_prod;
	}

	public void setLst_prod(List<Produit> lst_prod) {
		this.lst_prod = lst_prod;
	}
	
	public void ajouter(Produit prod)
	{
		lst_prod.add(prod);
	}
	
	public void supprimer(Produit prod)
	{
		lst_prod.remove(prod);
	}
	
	public boolean exist(Produit prod)
	{
		boolean b=false;
		for (Produit p:lst_prod)
		{
			if (p.getId()==prod.getId())
			{
				return true;
			}
		}
		return b;
	}
	
	public void vider()
	{
		lst_prod.clear();
	}
	
	

	public int getTotal()
	{
		int total=0;
		
		for (Produit prod:lst_prod)
		{
			total+=prod.getPrix()*prod.getQuantite();
		}
		return total;
	}
	
	public int getSize()
	{
		return lst_prod.size();
	}
	
	public String gen_panier()
	{
		
		String defaut="<div id='container_jsp'>"
				+ "<h2>Votre panier est vide</h2>"
				+ "<a href='#' onClick='dynamic_div(&quot;catalogue&quot;);return false;' class='btn btn-warning'><i class='fa fa-angle-left'></i> Continuer le shopping</a>"
				+ "</div>";
		if (this.getSize()!=0)
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
				for (Produit prod:lst_prod)
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
				+ "<form id='ajax_quantite_"+prod.getId()+"'>"
				+ "<input type='hidden' name='action' id='action' value='ajax_quantite'>"
				+ "<input type='hidden' name='id_produit' id='id_produit' value='"+prod.getId()+"'>"
				+ "<input data-mode='quantite_panier' data-id='"+prod.getId()+"' name='pan_qte_"+prod.getId()+"' id='pan_qte_"+prod.getId()+"' type='number' class='form-control text-center' value='"+prod.getQuantite()+"' min='1' max='"+prod.getStock()+"'>"
				+ "</form>"
				+ "</td>"
				+ "<td data-th='Sous-Total' name='ss_totaux' id='pan_ss_"+prod.getId()+"'  class='text-center'>"+sous_total+"</td>"
				+ "<td class='actions' data-th=''>"
				//+ "<button class='btn btn-info btn-sm'><i class='fa fa-refresh'></i></button>"
				+ "<form action='Servlet_panier' method='post' id='form_"+prod.getId()+"'>"
				+ "<input type='hidden' name='action' value='supprimer_panier'>"
				+ "<input type='hidden' name='id_produit' value='"+prod.getId()+"'>"
				+ "<button type='button' class='btn btn-danger btn-sm' id='btn_suppr_"+prod.getId()+"'  data-title='Etes-vous sûr ?' data-btnOkLabel='Oui' data-btnCancelLabel='Non' data-placement='right' data-toggle='confirmation' data-id='"+prod.getId()+"' ><i class='fa fa-trash-o'></i></button>"
				+ "</form>"
				+ "</td>"
				+ "</tr>";
				}
				
				
				String template_foot=
				"</tbody>"
				+"<tfoot>"
				
				+	"<tr>"
				+   "<td><a href='#' onClick='dynamic_div(&quot;catalogue&quot;);return false;' class='btn btn-warning'><i class='fa fa-angle-left'></i> Continuer le shopping</a></td>"
				+   "<td colspan='1' class='hidden-xs'><form action='Servlet_panier' method='post' id='form_vide_panier'>"
				+   "<input type='hidden' name='action' value='vider_panier'>"
				+   "<button type='button' class='btn btn-danger btn-block' id='btn_suppr_-1'  data-title='Etes-vous sûr ?' data-btnOkLabel='Oui' data-btnCancelLabel='Non' data-placement='bottom' data-id='-1' data-toggle='confirmation'>Vider le panier</button>"
				+   "</form></td>"
				+   "<td colspan='1' class='hidden-xs'></td>"
				
				+   "<td class='hidden-xs text-center' id='total_panier'><strong>Total: "+getTotal()+" &euro;"+"</strong></td>"
				+   "<td><a href='#' onClick='dynamic_div(&quot;commander&quot;);return false;' class='btn btn-success btn-block'>Commander <i class='fa fa-angle-right'></i></a></td>"
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
	
	public Produit recup_produit(Produit prod)
	{
		
		for (Produit p:lst_prod)
		{
			if (p.getId()==prod.getId())
			{
				return p;
			}
			
		}
		return new Produit(-1,"","",0,0,"");
	}
	
	public Panier() {
		super();
	}

	public Panier(List<Produit> lst_prod) {
		super();
		this.lst_prod = lst_prod;
	}
	
}
