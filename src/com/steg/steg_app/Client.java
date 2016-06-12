package com.steg.steg_app;

public class Client {
	private String reference;
	private String num_contact;
	private String num_service;
	private String electricite;
	private String chauffeau;
 	private String gaz;
	private String nom;
	private String prenom;
	private String adresse;
	public Client() {
		super();
	}
	
	public Client(String reference, String num_contact, String num_service,
			String electricite, String chauffeau, String gaz, String nom,
			String prenom, String adresse) {
		super();
		this.reference = reference;
		this.num_contact = num_contact;
		this.num_service = num_service;
		this.electricite = electricite;
		this.chauffeau = chauffeau;
		this.gaz = gaz;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getNum_contact() {
		return num_contact;
	}
	public void setNum_contact(String num_contact) {
		this.num_contact = num_contact;
	}
	public String getNum_service() {
		return num_service;
	}
	public void setNum_service(String num_service) {
		this.num_service = num_service;
	}
	public String getElectricite() {
		return electricite;
	}
	public void setElectricite(String electricite) {
		this.electricite = electricite;
	}
	public String getChauffeau() {
		return chauffeau;
	}
	public void setChauffeau(String chauffeau) {
		this.chauffeau = chauffeau;
	}
	public String getGaz() {
		return gaz;
	}
	public void setGaz(String gaz) {
		this.gaz = gaz;
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
	
	
	
}