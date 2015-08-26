package org.nasrul.blog.service;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.nasrul.blog.entity.Artikel;
import org.nasrul.blog.entity.Kategori;
import org.nasrul.blog.entity.Komentar;
import org.nasrul.blog.entity.User;
import org.nasrul.blog.repo.ArtikelRepo;
import org.nasrul.blog.repo.KategoriRepo;
import org.nasrul.blog.repo.KomentarRepo;
import org.nasrul.blog.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class InitDbService {
	
	@Autowired
	private ArtikelRepo artikelRepo;
	
	@Autowired
	private KategoriRepo kategoriRepo;
	
	@Autowired
	private KomentarRepo komentarRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@PostConstruct
	private void init(){
		
		Kategori kategoriA = new Kategori();
		kategoriA.setNamaKategori("Umum");
		kategoriA.setNamaSeo("umum");
		kategoriRepo.save(kategoriA);
		
		Kategori kategoriB = new Kategori();
		kategoriB.setNamaKategori("Tutorial");
		kategoriB.setNamaSeo("tutorial");
		kategoriRepo.save(kategoriB);
		
		User user = new User();
		user.setNamaLengkap("Nasrul Aziz");
		user.setUsername("nasrul");
		user.setRegisterDate(new Date());
		user.setRole("ROLE_ADMIN");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode("admin"));
		userRepo.save(user);
		
		Artikel artikelA = new Artikel();
		artikelA.setJudul("Blog Baru Yeahh");
		artikelA.setJudulSeo("blog-baru-yeahh");
		artikelA.setIsiArtikel("Ini isi artikel Blog baru yeahh");
		artikelA.setKategori(kategoriA);
		artikelA.setPenulis(user);
		artikelA.setPublishedDate(new Date());
		artikelRepo.save(artikelA);
		
		Artikel artikelB = new Artikel();
		artikelB.setJudul("Belajar Java");
		artikelB.setJudulSeo("belajar-java");
		artikelB.setIsiArtikel("Ini isi artikel belajar Java");
		artikelB.setKategori(kategoriB);
		artikelB.setPenulis(user);
		artikelB.setPublishedDate(new Date());
		artikelRepo.save(artikelB);
		
		Komentar komentarA = new Komentar();
		komentarA.setArtikel(artikelA);
		komentarA.setUser("Asep");
		komentarA.setEmail("asep@nail.com");
		komentarA.setPublishedDate(new Date());
		komentarA.setIsiKomentar("Nice Artikel Bro");
		komentarRepo.save(komentarA);
		
		Komentar komentarB = new Komentar();
		komentarB.setArtikel(artikelB);
		komentarB.setUser("Asep");
		komentarB.setEmail("asep@nail.com");
		komentarB.setPublishedDate(new Date());
		komentarB.setIsiKomentar("Nice Artikel Bro");
		komentarRepo.save(komentarB);
		
	}
	
}
