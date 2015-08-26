package org.nasrul.blog.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kategori {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "nama_kategori")
	private String namaKategori;
	
	@Column(name = "nama_seo")
	private String namaSeo;
	
	@OneToMany(mappedBy = "kategori")
	private List<Artikel> artikel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNamaKategori() {
		return namaKategori;
	}

	public void setNamaKategori(String namaKategori) {
		this.namaKategori = namaKategori;
	}

	public String getNamaSeo() {
		return namaSeo;
	}

	public void setNamaSeo(String namaSeo) {
		this.namaSeo = namaSeo;
	}

	public List<Artikel> getArtikel() {
		return artikel;
	}

	public void setArtikel(List<Artikel> artikel) {
		this.artikel = artikel;
	}
	
}
