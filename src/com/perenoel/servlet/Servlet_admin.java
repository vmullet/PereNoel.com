package com.perenoel.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.perenoel.modele.Connexion;
import com.perenoel.modele.Profil;

/**
 * Servlet implementation class Servlet_admin
 */
@WebServlet("/Servlet_admin")
@MultipartConfig
public class Servlet_admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s=request.getSession();
		String action=request.getParameter("action").toString();
		String id="";
		String req="";
		String type="";
		System.out.println(action);
		switch(action)
		{
		
		case "modifier_client":
			type="modif";
			id=request.getParameter("id_client");
			String login=request.getParameter("login_hid_"+id).toString();
			String adresse=request.getParameter("adresse_hid_"+id).toString();
			String cp=request.getParameter("cp_hid_"+id).toString();
			String ville=request.getParameter("ville_hid_"+id).toString();
			String tel=request.getParameter("tel_hid_"+id).toString();
			String mail=request.getParameter("mail_hid_"+id).toString();
			String pass=request.getParameter("pass_hid_"+id).toString();
			String admin=request.getParameter("admin_hid_"+id).toString();
			req="Update Client set adresse='"+adresse+"' , cp='"+cp+"' , ville='"+ville+"' , tel='"+tel+"' , email='"+mail+"' , login='"+login+"' ,pass='"+pass+"' ,admin='"+admin+"' where id='"+id+"'";
			s.setAttribute("interaction","gestion_client");
			break;
			
		case "modifier_produit":
			type="modif";
			id=request.getParameter("id_produit");
			String libelle=request.getParameter("libelle_produit_hid_"+id);
			String description=request.getParameter("description_produit_hid_"+id);
			String stock=request.getParameter("stock_produit_hid_"+id);
			String prix=request.getParameter("prix_produit_hid_"+id);
			String lien_image=request.getParameter("image_produit_hid_"+id);
			System.out.println(lien_image);
			if (!lien_image.equals("")||lien_image==null)
				req="Update Produit set libelle='"+libelle+"' , description='"+description+"' , prix='"+prix+"' , stock='"+stock+"',lien_image='"+lien_image+"' where id='"+id+"'";
			else
				req="Update Produit set libelle='"+libelle+"' , description='"+description+"' , prix='"+prix+"' , stock='"+stock+"' where id='"+id+"'";
			
			s.setAttribute("interaction","gestion_produit");
			break;
			
		case "supprimer_client":
			type="supp";
			id=request.getParameter("id_client");
			req="Delete from Client where id='"+id+"'";
			s.setAttribute("interaction","gestion_client");
			break;
			
		case "supprimer_produit":
			type="supp";
			id=request.getParameter("id_produit");
			req="Delete from Produit where id='"+id+"'";
			s.setAttribute("interaction","gestion_produit");
			break;
			
		case "ajouter_admin_client":
			type="ajout";
			String nom=request.getParameter("nom_hid_-1");
			String prenom=request.getParameter("prenom_hid_-1");
			String password=request.getParameter("password_hid_-1");
			admin=request.getParameter("admin_hid_-1");
			adresse=request.getParameter("adresse_hid_-1");
			cp=request.getParameter("cp_hid_-1");
			ville=request.getParameter("ville_hid_-1");
			tel=request.getParameter("tel_hid_-1");
			mail=request.getParameter("mail_hid_-1");
			password=request.getParameter("pass_hid_-1");
			req="INSERT INTO `client`(`nom`, `prenom`, `adresse`, `cp`, `ville`,  `tel`, `email`, `login`, `pass`, `admin`) VALUES "
			+ "('"+nom+"',"
					+ "'"+prenom+"',"
					+ "'"+adresse+"',"
					+ "'"+cp+"',"
					+ "'"+ville+"',"
					+ "'"+tel+"',"
					+ "'"+mail+"',"
					+ "'"+mail+"',"
					+"'"+password+"',"
					+ "'"+admin+"')"
					;
			System.out.println(req);
			s.setAttribute("interaction","gestion_client");
			break;
			
		case "ajouter_admin_produit":
			type="ajout";
			libelle=request.getParameter("libelle_produit_hid_-1");
			description=request.getParameter("description_produit_hid_-1");
			stock=request.getParameter("stock_produit_hid_-1");
			prix=request.getParameter("prix_produit_hid_-1");
			lien_image=request.getParameter("image_produit_hid_-1");
			if (lien_image!="")
			req="INSERT INTO `produit`(`libelle`, `description`, `stock`, `prix`, `lien_image`) values('"+libelle+"','"+description+"','"+stock+"','"+prix+"','"+lien_image+"')";
			System.out.println(req);
			s.setAttribute("interaction","gestion_produit");
			break;
			
		}
		
		try
		{
		Connexion.exec_req(req);
		s.setAttribute(type,"success");
		}
		catch(Exception e)
		{
		s.setAttribute(type,"fail");
		}
		response.sendRedirect("action.jsp");
	}
	
}
