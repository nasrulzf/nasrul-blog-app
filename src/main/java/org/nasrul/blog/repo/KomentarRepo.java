package org.nasrul.blog.repo;

import java.util.List;

import org.nasrul.blog.entity.Artikel;
import org.nasrul.blog.entity.Komentar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KomentarRepo extends JpaRepository<Komentar, Integer> {
	
	List<Komentar> findByArtikel(Artikel artikel);
	
}
