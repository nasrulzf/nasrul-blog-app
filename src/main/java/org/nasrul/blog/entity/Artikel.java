package org.nasrul.blog.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Artikel {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String judul;
	
	@Column(name = "judul_seo")
	private String judulSeo;
	
	@Column(name = "published_date")
	private Date publishedDate;
	
	@Column(name = "isi_artikel")
	private String isiArtikel;
	
	@Column(name = "update_date")
	private Date updateDate;
	
	@ManyToOne
	@JoinColumn(name = "id_penulis")
	private User penulis;
	
	@ManyToOne
	@JoinColumn(name = "id_kategori")
	private Kategori kategori;
	
	@OneToMany(mappedBy = "artikel")
	private List<Komentar> komentar;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJudul() {
		return judul;
	}

	public void setJudul(String judul) {
		this.judul = judul;
	}

	public String getJudulSeo() {
		return judulSeo;
	}

	public void setJudulSeo(String judulSeo) {
		this.judulSeo = judulSeo;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getIsiArtikel() {
		return isiArtikel;
	}

	public void setIsiArtikel(String isiArtikel) {
		this.isiArtikel = isiArtikel;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public User getPenulis() {
		return penulis;
	}

	public void setPenulis(User penulis) {
		this.penulis = penulis;
	}

	public Kategori getKategori() {
		return kategori;
	}

	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}

	public List<Komentar> getKomentar() {
		return komentar;
	}

	public void setKomentar(List<Komentar> komentar) {
		this.komentar = komentar;
	}
	
	
}
