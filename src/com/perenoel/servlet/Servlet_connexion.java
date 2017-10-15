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
import com.perenoel.modele.Profil;

/**
 * Servlet implementation class Servlet_connexion
 */
@WebServlet("/Servlet_connexion")
public class Servlet_connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_connexion() {
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
		
		String login=request.getParameter("username");
		String password=request.getParameter("password");
		verif_login(login,password);
		
		HttpSession s=request.getSession();
		Profil p=verif_login(login,password);
					if (p!=null) //Si le profil retourné n'est pas null
					{
						s.setAttribute("profil", p); 
						
						String admin="Select admin from client where login='"+login+"'"+" and pass='"+password+"'";
						boolean res_admin=verif(admin);
						System.out.println(res_admin);
					if(res_admin)
					{
							s.setAttribute("admin", "true");
							System.out.println("J'ai fait");
					}
					
					   if (s.getAttribute("redirect")!=null)
					   {
					    s.setAttribute("interaction",s.getAttribute("redirect"));
					    System.out.println(s.getAttribute("redirect"));
					    s.removeAttribute("redirect");
					   }
					}
					else
					 {
						s.setAttribute("login_etat","fail");
						s.setAttribute("interaction","login");
						
					 }
					response.sendRedirect("index.jsp");
	}
	
	
	public boolean verif(String req)
	{
		boolean b=false;
		CachedRowSet re=Connexion.recup_data(req);
		try {
			if (re.next())
			{
				System.out.println(re.getString(1).toString());
				 if (re.getString(1).contains("1"))
				  {
					 System.out.println("je retourne");
					b=true;
					
					 
				  }
				 else
				 {
					b=false;
				 }
				  
			}
			re.close();
		} catch (SQLException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
		return b;
	}
	
	public Profil verif_login(String login,String pass)
	{
		Profil p=null;
		String req="Select * from client where login='"+login+"'"+" and pass='"+pass+"'";
		CachedRowSet re=Connexion.recup_data(req);
		try {
			re.last();
			int row=re.getRow();
			if(row!=0)
			{
				p=new Profil(re.getInt(1),re.getString(2),re.getString(3),re.getString(4),re.getString(5),re.getString(6),re.getString(7),re.getString(8),re.getString(9));
				return p;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	

}
