package com.perenoel.modele;

public class Produit {

	private int id;
	private String libelle;
	private String description;
	private int stock;
	private int quantite;
	private float prix;
	private String lien_image;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getLien_image() {
		return lien_image;
	}
	public void setLien_image(String lien_image) {
		this.lien_image = lien_image;
	}
	
	public Produit(int id, String libelle, String description, int stock,float prix,
			String lien_image) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.stock=stock;
		this.quantite=1;
		this.prix = prix;
		this.lien_image = lien_image;
	}
	public Produit(int id, String libelle, String description, int stock,int quantite,
			float prix, String lien_image) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.stock=stock;
		this.quantite = quantite;
		this.prix = prix;
		this.lien_image = lien_image;
	}
	
	
	
	
}
