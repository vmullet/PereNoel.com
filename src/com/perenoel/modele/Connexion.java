package com.perenoel.modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;


public class Connexion {
	public static String serveur="localhost";
	public static String db="santa_claus";
	public static String user="pere_noel";
	public static String mdp="pere_noel";
	
	public static void exec_req(String req)
	{
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =  DriverManager.getConnection(
					"jdbc:mysql://"+serveur+"/"+db,user,mdp);
			st = con.createStatement() ;
			st.executeUpdate(req);
			System.out.println(req+ " successfully executed");
			
		} catch (Exception e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
		finally
		{
			
			close_all(st,con);
		}
	}
	
	public static CachedRowSet recup_data(String req)
	{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		CachedRowSet rowset=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =  DriverManager.getConnection(
					"jdbc:mysql://"+serveur+"/"+db,user,mdp);
			st = con.createStatement() ;
            rs = st.executeQuery(req) ;
           rowset = new CachedRowSetImpl();
            rowset.populate(rs);
		} catch (Exception e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
		finally
		{
			close_all(rs,st,con);
			
		}
		return rowset;
            
	}
	
	public static String recup_commande(int num_client,String mode_paiement,float total,String date)
	{
		String num="";
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		CachedRowSet rowset=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =  DriverManager.getConnection(
					"jdbc:mysql://"+serveur+"/"+db,user,mdp);
			st = con.createStatement() ;
            rs = st.executeQuery("Select * from commande where id_client='"+num_client+"' and id_paiement='"+mode_paiement+"' and total='"+total+"' and date='"+date+"'") ;
           rowset = new CachedRowSetImpl();
            rowset.populate(rs);
            if (rowset.next())
    		{
    			num=rowset.getString(1);
    		}
		} catch (Exception e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
		finally
		{
			close_all(rs,st,con);
			
		}
		try {
			rowset.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	public static void close_all(ResultSet rs,Statement st,Connection con)
	{
		
		try { if (rs != null) rs.close(); } catch (Exception e) {};
		try { if (st != null) st.close(); } catch (Exception e) {};
	    try { if (con != null) con.close(); } catch (Exception e) {};
	    
	}
	
	public static void close_all(Statement st,Connection con)
	{
		try { if (st != null) st.close(); } catch (Exception e) {};
	    try { if (con != null) con.close(); } catch (Exception e) {};
	}
		
}
