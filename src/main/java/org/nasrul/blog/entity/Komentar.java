package org.nasrul.blog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Komentar {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "published_date")
	private Date publishedDate;
	
	private String user;
	
	private String email;
	
	private Boolean status;
	
	@Column(name = "isi_komentar")
	private String isiKomentar;
	
	@ManyToOne
	@JoinColumn(name = "id_artikel")
	private Artikel artikel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getIsiKomentar() {
		return isiKomentar;
	}

	public void setIsiKomentar(String isiKomentar) {
		this.isiKomentar = isiKomentar;
	}

	public Artikel getArtikel() {
		return artikel;
	}

	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}
	
}
