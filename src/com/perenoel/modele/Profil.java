package com.perenoel.modele;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

public class Profil {
			
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String cp;
	private String ville;
	private String telephone;
	private String mail;
	private String login;
	private String mdp;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public Profil(int id, String nom, String prenom, String adresse, String cp,
			String ville, String telephone, String mail, String login) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.telephone = telephone;
		this.mail = mail;
		this.login = login;
	}
	
	public Profil(int id, String nom, String prenom, String adresse, String cp,
			String ville, String telephone, String mail,String login, String mdp) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.telephone = telephone;
		this.mail=mail;
		this.login = login;
		this.mdp = mdp;
	}
	
	public static void act_profil(Profil p)
	{
		
		CachedRowSet re=Connexion.recup_data("Select * from Client where id='"+p.getId()+"'");
		try {
			if (re.next())
			{
				p.setNom(re.getString(2));
				p.setPrenom(re.getString(3));
				p.setAdresse(re.getString(4));
				p.setCp(re.getString(5));
				p.setVille(re.getString(6));
				p.setTelephone(re.getString(7));
				p.setMail(re.getString(8));
				p.setLogin(re.getString(9));
				
				
			}
		} catch (SQLException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
		
	}
	
}
