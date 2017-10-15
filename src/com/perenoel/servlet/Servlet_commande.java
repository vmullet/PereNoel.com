package com.perenoel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perenoel.modele.Commande;
import com.perenoel.modele.Panier;
import com.perenoel.modele.Profil;

/**
 * Servlet implementation class Servlet_commande
 */
@WebServlet("/Servlet_commande")
public class Servlet_commande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_commande() {
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
		Profil client=(Profil)s.getAttribute("profil");
		Panier p=(Panier) s.getAttribute("panier");
		String paiement=request.getParameter("paiement").toString();
		Commande.commander(s,client,p,paiement);
		s.setAttribute("interaction","confirm");
		s.removeAttribute("panier");
		response.sendRedirect("action.jsp");
	}

}
