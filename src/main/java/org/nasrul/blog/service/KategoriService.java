package org.nasrul.blog.service;

import java.util.List;

import org.nasrul.blog.entity.Kategori;
import org.nasrul.blog.repo.KategoriRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class KategoriService {
	
	@Autowired
	private KategoriRepo kategoriRepo;
	
	public List<Kategori> findAll(){
		return kategoriRepo.findAll();
	}
	
	public Page<Kategori> findWPaging(int num){
		return kategoriRepo.findAll(new PageRequest(num, 5, Direction.ASC, "id"));
	}
	
	public void save(Kategori kategori){
		String namaKategori = kategori.getNamaKategori();
		kategori.setNamaSeo(namaKategori.toLowerCase().replace(" ", "-"));
		kategoriRepo.save(kategori);
	}
	
	public Kategori findOne(int id){
		return kategoriRepo.findOne(id);
	}
	
	public void update(Kategori kategori){
		kategoriRepo.save(kategori);
	}
	
	public void delete(int id){
		kategoriRepo.delete(id);
	}
	
}
