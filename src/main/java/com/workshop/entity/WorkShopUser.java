package com.workshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="work_shop_user")
public class WorkShopUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String prenom;
	private String nom;
	private String adress;
	private int codePostal;
	private String commune;
	private String email;
	private String password;
	private String role;
	
	
	public WorkShopUser() {

	}


	public WorkShopUser(int id, String prenom, String nom, String adress, int codePostal, String commune,
			String email, String password, String role) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.adress = adress;
		this.codePostal = codePostal;
		this.commune = commune;
		this.email = email;
		this.password = password;
		this.role = role;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public int getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}


	public String getCommune() {
		return commune;
	}


	public void setCommune(String commune) {
		this.commune = commune;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "WorkShopUser [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", adress=" + adress + ", codePostal="
				+ codePostal + ", commune=" + commune + ", email=" + email + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	


	
	
	
}
