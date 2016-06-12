package com.steg.steg_app;

public class Facture {
	private String reference;
	private String ref_facture;
	private String type;
	private String etat;
	private String date;
	private String nb_mois;
	private String n_index_elec;
	private String n_index_chauf;
	private String n_index_gaz;
	private String total_elec;
	private String total_chauf;
	private String total_gaz;
	private String total;
	private String tva;
	private String rtt;
	private String taxes;
	private String montant;
	private String date_limit;
	private String ctr_elec;
	private String ctr_chauf;
	private String ctr_gaz;
	private String index_elec;
	private String index_chauf;
	private String index_gaz;
	private String arrieres;
	private String payement;
	private String solde;
	private String date_relever;
	private String date_proch_relever;
	public Facture() {
		super();
		this.reference = "";
		this.ref_facture = "";
		this.type = "";
		this.etat = "";
		this.date = "";
		this.nb_mois = "";
		this.n_index_elec = "";
		this.n_index_chauf = "";
		this.n_index_gaz = "";
		this.total_elec = "";
		this.total_chauf = "";
		this.total_gaz = "";
		this.total = "";
		this.tva = "";
		this.rtt = "";
		this.taxes = "";
		this.montant = "";
		this.date_limit = "";
		this.ctr_elec = "";
		this.ctr_chauf = "";
		this.ctr_gaz = "";
		this.index_elec = "";
		this.index_chauf = "";
		this.index_gaz = "";
		this.arrieres = "";
		this.payement = "";
		this.solde = "";
		this.date_relever = "";
		this.date_proch_relever = "";
	}
	public Facture(String reference, String ref_facture, String type,
			String etat, String date, String nb_mois, String n_index_elec,
			String n_index_chauf, String n_index_gaz, String total_elec,
			String total_chauf, String total_gaz, String total, String tva,
			String rtt, String taxes, String montant, String date_limit,
			String ctr_elec, String ctr_chauf, String ctr_gaz,
			String index_elec, String index_chauf, String index_gaz,
			String arrieres, String payement, String solde,
			String date_relever, String date_proch_relever) {
		super();
		this.reference = reference;
		this.ref_facture = ref_facture;
		this.type = type;
		this.etat = etat;
		this.date = date;
		this.nb_mois = nb_mois;
		this.n_index_elec = n_index_elec;
		this.n_index_chauf = n_index_chauf;
		this.n_index_gaz = n_index_gaz;
		this.total_elec = total_elec;
		this.total_chauf = total_chauf;
		this.total_gaz = total_gaz;
		this.total = total;
		this.tva = tva;
		this.rtt = rtt;
		this.taxes = taxes;
		this.montant = montant;
		this.date_limit = date_limit;
		this.ctr_elec = ctr_elec;
		this.ctr_chauf = ctr_chauf;
		this.ctr_gaz = ctr_gaz;
		this.index_elec = index_elec;
		this.index_chauf = index_chauf;
		this.index_gaz = index_gaz;
		this.arrieres = arrieres;
		this.payement = payement;
		this.solde = solde;
		this.date_relever = date_relever;
		this.date_proch_relever = date_proch_relever;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getRef_facture() {
		return ref_facture;
	}
	public void setRef_facture(String ref_facture) {
		this.ref_facture = ref_facture;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNb_mois() {
		return nb_mois;
	}
	public void setNb_mois(String nb_mois) {
		this.nb_mois = nb_mois;
	}
	public String getN_index_elec() {
		return n_index_elec;
	}
	public void setN_index_elec(String n_index_elec) {
		this.n_index_elec = n_index_elec;
	}
	public String getN_index_chauf() {
		return n_index_chauf;
	}
	public void setN_index_chauf(String n_index_chauf) {
		this.n_index_chauf = n_index_chauf;
	}
	public String getN_index_gaz() {
		return n_index_gaz;
	}
	public void setN_index_gaz(String n_index_gaz) {
		this.n_index_gaz = n_index_gaz;
	}
	public String getTotal_elec() {
		return total_elec;
	}
	public void setTotal_elec(String total_elec) {
		this.total_elec = total_elec;
	}
	public String getTotal_chauf() {
		return total_chauf;
	}
	public void setTotal_chauf(String total_chauf) {
		this.total_chauf = total_chauf;
	}
	public String getTotal_gaz() {
		return total_gaz;
	}
	public void setTotal_gaz(String total_gaz) {
		this.total_gaz = total_gaz;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getTva() {
		return tva;
	}
	public void setTva(String tva) {
		this.tva = tva;
	}
	public String getRtt() {
		return rtt;
	}
	public void setRtt(String rtt) {
		this.rtt = rtt;
	}
	public String getTaxes() {
		return taxes;
	}
	public void setTaxes(String taxes) {
		this.taxes = taxes;
	}
	public String getMontant() {
		return montant;
	}
	public void setMontant(String montant) {
		this.montant = montant;
	}
	public String getDate_limit() {
		return date_limit;
	}
	public void setDate_limit(String date_limit) {
		this.date_limit = date_limit;
	}
	public String getCtr_elec() {
		return ctr_elec;
	}
	public void setCtr_elec(String ctr_elec) {
		this.ctr_elec = ctr_elec;
	}
	public String getCtr_chauf() {
		return ctr_chauf;
	}
	public void setCtr_chauf(String ctr_chauf) {
		this.ctr_chauf = ctr_chauf;
	}
	public String getCtr_gaz() {
		return ctr_gaz;
	}
	public void setCtr_gaz(String ctr_gaz) {
		this.ctr_gaz = ctr_gaz;
	}
	public String getIndex_elec() {
		return index_elec;
	}
	public void setIndex_elec(String index_elec) {
		this.index_elec = index_elec;
	}
	public String getIndex_chauf() {
		return index_chauf;
	}
	public void setIndex_chauf(String index_chauf) {
		this.index_chauf = index_chauf;
	}
	public String getIndex_gaz() {
		return index_gaz;
	}
	public void setIndex_gaz(String index_gaz) {
		this.index_gaz = index_gaz;
	}
	public String getArrieres() {
		return arrieres;
	}
	public void setArrieres(String arrieres) {
		this.arrieres = arrieres;
	}
	public String getPayement() {
		return payement;
	}
	public void setPayement(String payement) {
		this.payement = payement;
	}
	public String getSolde() {
		return solde;
	}
	public void setSolde(String solde) {
		this.solde = solde;
	}
	public String getDate_relever() {
		return date_relever;
	}
	public void setDate_relever(String date_relever) {
		this.date_relever = date_relever;
	}
	public String getDate_proch_relever() {
		return date_proch_relever;
	}
	public void setDate_proch_relever(String date_proch_relever) {
		this.date_proch_relever = date_proch_relever;
	}
}
	
	
		