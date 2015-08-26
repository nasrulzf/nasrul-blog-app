package org.nasrul.blog.service;

import java.util.List;

import javax.transaction.Transactional;

import org.nasrul.blog.entity.Artikel;
import org.nasrul.blog.entity.Kategori;
import org.nasrul.blog.repo.ArtikelRepo;
import org.nasrul.blog.repo.KategoriRepo;
import org.nasrul.blog.repo.KomentarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class ArtikelService {
	
	@Autowired
	private ArtikelRepo artikelRepo;
	
	@Autowired
	private KomentarRepo komentarRepo;
	
	@Autowired
	private KategoriRepo kategoriRepo;
	
	public List<Artikel> findAll(){
		return artikelRepo.findAll();
	}
	
	public List<Artikel> findByKategori(String seoKategori){
		
		Kategori kategori = kategoriRepo.findByNamaSeo(seoKategori);
		return artikelRepo.findByKategori(kategori);
	}
	
	public Artikel findOne(String judul, int id){
		return artikelRepo.findByIdAndJudulSeo(id, judul);
	}
	
	@Transactional
	public Artikel findOneD(String judul, int id){
		
		Artikel artikel = findOne(judul, id);
		
		artikel.setKomentar(komentarRepo.findByArtikel(artikel));
		
		return artikel;
	}
	
	
	public Page<Artikel> findAllWPaging(int num){
		return artikelRepo.findAll(new PageRequest(num, 5, Direction.ASC, "id"));
	}
}
