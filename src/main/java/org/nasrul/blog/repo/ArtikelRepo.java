package org.nasrul.blog.repo;

import java.util.List;

import org.nasrul.blog.entity.Artikel;
import org.nasrul.blog.entity.Kategori;
import org.nasrul.blog.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtikelRepo extends JpaRepository<Artikel, Integer> {

	public List<Artikel> findByKategori(Kategori kategori);
	
	public List<Artikel> findByKategori(User user);
	
	public Artikel findByIdAndJudulSeo(int id, String judulSeo);
	
	public Page<Artikel> findAll(Pageable pageable);
	
}
