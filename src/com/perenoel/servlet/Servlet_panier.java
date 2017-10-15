package com.perenoel.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perenoel.modele.Panier;
import com.perenoel.modele.Produit;

/**
 * Servlet implementation class Servlet_panier
 */
@WebServlet("/Servlet_panier")
public class Servlet_panier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_panier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("toto");
		HttpSession s=request.getSession();
		String action=request.getParameter("action").toString();
		switch(action)
		{
	case "ajax_quantite":
		Panier p2=(Panier) s.getAttribute("panier");
		int id_modif=Integer.parseInt(request.getParameter("id_produit").toString());
		int quantite_modif=Integer.parseInt(request.getParameter("pan_qte_"+id_modif).toString());
		Produit po=p2.recup_produit(new Produit(id_modif,"","",0,0,""));
		if (po.getId()!=-1)
		{
			po.setQuantite(quantite_modif);
		}
		break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s=request.getSession();
		String action=request.getParameter("action").toString();
		switch(action)
		{
		case "ajout_panier":
			int id=Integer.parseInt(request.getParameter("id_produit").toString());
			String nom=request.getParameter("nom_produit").toString();
			String description=request.getParameter("description_produit").toString();
			int stock=Integer.parseInt(request.getParameter("stock_produit").toString());
			int quantite= Integer.parseInt(request.getParameter("quant["+id+"]").toString());
			float prix=Float.parseFloat(request.getParameter("prix_produit").toString());
			String lien_image=request.getParameter("lien_image_produit").toString();
			Produit prod=new Produit(id,nom,description,stock,quantite,prix,lien_image);
			if (s.getAttribute("panier")==null)
			{
				
				Panier pan=new Panier();
				pan.ajouter(prod);
				s.setAttribute("panier",pan);
				
			}
			else
			{
				Panier p=(Panier) s.getAttribute("panier");
				if (!p.exist(prod))
				{
				((Panier) s.getAttribute("panier")).ajouter(prod);
				}
				
				else
				{
					Produit po=p.recup_produit(prod);
					po.setQuantite(po.getQuantite()+quantite);
				    
				}
				
			}
			
			break;
			
		case "supprimer_panier":
			Panier p=(Panier) s.getAttribute("panier");
			if (p!=null)
			{
			int id_supp=Integer.parseInt(request.getParameter("id_produit").toString());
			Produit po=p.recup_produit(new Produit(id_supp,"","",0,0,""));
			if (po.getId()!=-1)
			p.supprimer(po);
			}
			break;
			
		case "vider_panier":
			Panier p1=(Panier) s.getAttribute("panier");
			p1.vider();
			break;
			
		
			
		
		}
		if (action!="ajax_quantite")
		{
		s.setAttribute("interaction","panier");
		response.sendRedirect("action.jsp");
		}
		
	}

}
