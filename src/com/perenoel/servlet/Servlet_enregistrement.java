package com.perenoel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.CachedRowSet;

import com.perenoel.modele.Connexion;
import com.perenoel.modele.Profil;

/**
 * Servlet implementation class Servlet_enregistrement
 */
@WebServlet("/Servlet_enregistrement")
public class Servlet_enregistrement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_enregistrement() {
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
		String type="";
		String req="";
		String action=request.getParameter("action");
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String adresse=request.getParameter("adresse");
		String cp=request.getParameter("cp");
		String ville=request.getParameter("ville");
		String tel=request.getParameter("tel");
		String mail=request.getParameter("mail");
		
		switch (action)
		{
		
		case "enregistrer":
			String password=request.getParameter("pass");
			String password_confirm=request.getParameter("pass_confirm");
			req="INSERT INTO `client`(`nom`, `prenom`, `adresse`, `cp`, `ville`,  `tel`, `email`, `login`, `pass`) VALUES "
					+ "('"+nom+"',"
							+ "'"+prenom+"',"
							+ "'"+adresse+"',"
							+ "'"+cp+"',"
							+ "'"+ville+"',"
							+ "'"+tel+"',"
							+ "'"+mail+"',"
							+ "'"+mail+"',"
							+"'"+password+"')";
			
			if (password.equals(password_confirm))
			{
				try
				{
					Connexion.exec_req(req);
					s.setAttribute("register","success");
					s.setAttribute("interaction","register");
					
				}
				catch (Exception e)
				{
					s.setAttribute("register","fail");
				}
					
			}
			else
			{
				s.setAttribute("pass","fail");
			}
			
			break;
			
		case "modifier_profil":
			
			type="modif";
			int id=((Profil)s.getAttribute("profil")).getId();
			req="Update Client set nom='"+nom+"',prenom='"+prenom+"',adresse='"+adresse+"',cp='"+cp+"',ville='"+ville+"',tel='"+tel+"',email='"+mail+"' where id='"+id+"'";
			System.out.println(req);
			try
			{
				Connexion.exec_req(req);
				s.setAttribute(type,"success");
				Profil.act_profil((Profil) s.getAttribute("profil"));
				s.setAttribute("interaction","modif_profil");
				
			}
			catch(Exception e)
			{
				s.setAttribute(type,"fail");
			}
			break;
			
		case "modifier_pass":
			
			id=((Profil)s.getAttribute("profil")).getId();
			type="modif";
			
			try {
				CachedRowSet pass_recup=Connexion.recup_data("Select pass from client where id='"+id+"'");
				String pass_actuel=request.getParameter("pass_actuel");
				pass_recup.next();
				String pass_actuel_bdd=pass_recup.getString(1);
				String nv_pass=request.getParameter("nv_pass");
				System.out.println(pass_actuel+" "+pass_actuel_bdd+" ");
				if (pass_actuel.equals(pass_actuel_bdd))
				{
				req="Update Client set pass='"+nv_pass+"' where id='"+id+"'";
				Connexion.exec_req(req);
				s.setAttribute(type,"success");
				}
				else
				{
					s.setAttribute(type,"fail");
				}
			}
				catch(Exception e)
				{
					e.printStackTrace();
					s.setAttribute(type,"fail");	
				}
			s.setAttribute("interaction", "modif_profil");
				break;	
		}
		response.sendRedirect("action.jsp");	
	}

}
