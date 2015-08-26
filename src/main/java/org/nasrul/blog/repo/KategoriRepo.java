package org.nasrul.blog.repo;

import java.util.List;

import org.hibernate.dialect.pagination.LimitHelper;
import org.nasrul.blog.entity.Kategori;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategoriRepo extends JpaRepository<Kategori, Integer> {
	
	Kategori findByNamaSeo(String namaSeo);
	Page<Kategori> findAll(Pageable pageable);
	
}
