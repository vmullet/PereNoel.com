package com.perenoel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.CachedRowSet;

import com.perenoel.modele.Connexion;

/**
 * Servlet implementation class Servlet_catalogue
 */
@WebServlet("/servlet_catalogue")
public class Servlet_catalogue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_catalogue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		CachedRowSet re=Connexion.recup_data("Select * from produit where stock>0");
		String id="";
		String catalogue="<div class='row moreitems' >";
		String nom_produit="";
		String description_produit="";
		int stock_produit=0;
		String couleur="";
		String qte_template="";
               
		String prix_produit="";
		String lien_image="";
		int i=1;
		
		
		try {
			while(re.next())
			{
				id=re.getString(1);
				nom_produit=re.getString(2);
				description_produit=re.getString(3);
				stock_produit=re.getInt(4);
				if (stock_produit<10)
					couleur="style='color:red'";
				if (stock_produit>=10&&stock_produit<=30)
					couleur="style='color:orange'";
				if (stock_produit>30)
					couleur="style='color:green'";
				prix_produit=re.getString(5);
				lien_image=re.getString(6);
				qte_template="<div class='center'><div class='input-group'>"
						+ "<span class='input-group-btn'>"
						+ "<button type='button' class='btn btn-danger btn-number'  data-type='minus' data-field='quant["+id+"]'>"
		                + "<span class='glyphicon glyphicon-minus'></span>"
						+ " </button>"
						+ "</span>"
						+ "<input type='text' name='quant["+id+"]' min='1' max='"+stock_produit+"' class='form-control input-number' id='qte_prod' value='1' min='1' max='100'>"
						+ "<span class='input-group-btn'>"
						+ "<button type='button' class='btn btn-success btn-number' data-type='plus' data-field='quant["+id+"]'>"
						+ " <span class='glyphicon glyphicon-plus'></span>"
						+ "</button>"
						+ " </span>"
						+ " </div></div>";
				catalogue+=
						"<!--SMALL ITEM 1 START-->"
						+"<div class='col-md-6'>"
						+ "<div class='col-md-4 text-center'>"
						+ "<a href=''>"
						+ "<img class='productimg' src='"+lien_image+"' alt='' height='210' width='180'>"
						+ "</a><!--DISCOUNT TAG-->"
								+ "<div class='smalltag offertag fixedoffer'>"
								+ "<h4>"+i+"€</h4>"
								+ "<p>off</p>"
								+ "</div><!--DISCOUNT TAG END-->"
								+ "</div><!--PRODUCT IMAGE END-->"
								+ "<!--SMALL PRODUCT DESCRIPTION START-->"
								+ " <div class='col-md-8'>"
								+ "<h4><a href=''>"+nom_produit+"</a></h4>"
								
								+ "<p>"+description_produit+"</p>"
								+ "<p class='price'>€ <span class='highlight'>"+prix_produit+"</span> / piece</p>"
								+ "<p>Prix original: "+((Float.parseFloat(prix_produit)+3))+"€ , Vous économisez :3€</p>"
								+ "Stock : <span class='glyphicon glyphicon-signal' "+couleur+" ></span>"
								+ "<form method='post' id='ajout_panier_"+id+"' action='Servlet_panier'>"
								+ "<input type='hidden' name='action' value='ajout_panier'>"
								+ "<input type='hidden' name='id_produit' value='"+id+"'>"
								+ "<input type='hidden' name='nom_produit' value='"+nom_produit+"'>"
								+ "<input type='hidden' name='description_produit' value='"+description_produit+"'>"
								+ "<input type='hidden' name='stock_produit' value='"+stock_produit+"'>"
								+ "<input type='hidden' name='prix_produit' value='"+prix_produit+"'>"
								+ "<input type='hidden' name='lien_image_produit' value='"+lien_image+"'>"
							    +  qte_template
								+ "<input type='Submit' class='btn btn-default'  value='Ajouter au panier'>"
								+ "</form>"
								+ " </div><!--SMALL PRODUCT DESCRIPTION END-->"
								+ "</div><!--SMALL ITEM 1 END-->";
				i++;
				if (i>2)
				{
					catalogue+="</div><div class='row moreitems'><!--Fin ligne-->";
					i=1;
				}
			}
			catalogue+="</div>";
			re.close();
			
		} catch (SQLException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
		request.setAttribute("catalogue", catalogue);
		//request.getRequestDispatcher("index.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
