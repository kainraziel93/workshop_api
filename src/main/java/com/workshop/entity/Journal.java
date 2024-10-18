package com.workshop.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Journal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String status;
	private String reseau;
	private String description;
	private String userUrl;
	private List<String> screenshots;
	@ManyToOne
	private WorkShopUser user;
	
	public Journal() {

	}
	

	public Journal(int id, String title, String status, String reseau, String description, String userUrl,
			List<String> screenshots, WorkShopUser user) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
		this.reseau = reseau;
		this.description = description;
		this.userUrl = userUrl;
		this.screenshots = screenshots;
		this.user = user;
	}


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUserUrl() {
		return userUrl;
	}
	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}
	public List<String> getScreenshots() {
		return screenshots;
	}
	public void setScreenshots(List<String> screenshots) {
		this.screenshots = screenshots;
	}
	public int getId() {
		return id;
	}
	
	
	public WorkShopUser getUser() {
		return user;
	}
	public void setUser(WorkShopUser user) {
		this.user = user;
	}

	

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getReseau() {
		return reseau;
	}


	public void setReseau(String reseau) {
		this.reseau = reseau;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Journal [id=" + id + ", title=" + title + ", status=" + status + ", reseau=" + reseau + ", description="
				+ description + ", userUrl=" + userUrl + ", screenshots=" + screenshots + ", user=" + user + "]";
	}
	

	
	

}
