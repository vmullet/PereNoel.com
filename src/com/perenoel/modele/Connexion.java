package com.perenoel.modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class Connexion {
	public static String serveur = "localhost";
	public static String db = "santa_claus";
	public static String user = "santa";
	public static String mdp = "santa";

	public static void exec_req(final String req) {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + serveur + "/" + db, user, mdp);
			st = con.createStatement();
			st.executeUpdate(req);
			System.out.println(req + " successfully executed");

		} catch (final Exception e) {
			// TODO Bloc catch g�n�r� automatiquement
			e.printStackTrace();
		} finally {

			close_all(st, con);
		}
	}

	public static CachedRowSet recup_data(final String req) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		CachedRowSet rowset = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + serveur + "/" + db, user, mdp);
			st = con.createStatement();
			rs = st.executeQuery(req);
			rowset = new CachedRowSetImpl();
			rowset.populate(rs);
		} catch (final Exception e) {
			// TODO Bloc catch g�n�r� automatiquement
			e.printStackTrace();
		} finally {
			close_all(rs, st, con);

		}
		return rowset;

	}

	public static String recup_commande(final int num_client, final String mode_paiement, final float total,
			final String date) {
		String num = "";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		CachedRowSet rowset = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + serveur + "/" + db, user, mdp);
			st = con.createStatement();
			rs = st.executeQuery("Select * from commande where id_client='" + num_client + "' and id_paiement='"
					+ mode_paiement + "' and total='" + total + "' and date='" + date + "'");
			rowset = new CachedRowSetImpl();
			rowset.populate(rs);
			if (rowset.next()) {
				num = rowset.getString(1);
			}
		} catch (final Exception e) {
			// TODO Bloc catch g�n�r� automatiquement
			e.printStackTrace();
		} finally {
			close_all(rs, st, con);

		}
		try {
			rowset.close();
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	public static void close_all(final ResultSet rs, final Statement st, final Connection con) {

		try {
			if (rs != null)
				rs.close();
		} catch (final Exception e) {
		}
		;
		try {
			if (st != null)
				st.close();
		} catch (final Exception e) {
		}
		;
		try {
			if (con != null)
				con.close();
		} catch (final Exception e) {
		}
		;

	}

	public static void close_all(final Statement st, final Connection con) {
		try {
			if (st != null)
				st.close();
		} catch (final Exception e) {
		}
		;
		try {
			if (con != null)
				con.close();
		} catch (final Exception e) {
		}
		;
	}

}
