package org.nasrul.blog.controller;

import org.nasrul.blog.entity.Artikel;
import org.nasrul.blog.repo.ArtikelRepo;
import org.nasrul.blog.service.ArtikelService;
import org.nasrul.blog.service.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArtikelController {
	
	@Autowired
	private ArtikelService artikelService;
	
	@Autowired
	private KategoriService kategoriService;
	
	@ModelAttribute(value = "artikel")
	public Artikel construct(){
		return new Artikel();
	}
	
	@RequestMapping("/artikel/index")
	public String getIndex(Model model){
		model.addAttribute("artikel", artikelService.findAll());
		return "artikelIndex";
	}
	
	@RequestMapping("/{judul}-{id}")
	public String getArtikelDetail(Model model, @PathVariable String judul, @PathVariable int id){
		model.addAttribute("artikel", artikelService.findOneD(judul, id));
		return "artikelDetail";
	}
	
	@RequestMapping("/kategori/{kategori}")
	public String getArtikelKategori(Model model, @PathVariable String kategori){
		model.addAttribute("artikel", artikelService.findByKategori(kategori));
		return "artikelIndex";
	}
	
	@RequestMapping("/admin/list-artikel")
	public String getListArtikel(Model model){
		Page<Artikel> pageArtikel = artikelService.findAllWPaging(0);
		model.addAttribute("hasPrev", pageArtikel.hasPreviousPage());
		model.addAttribute("hasNext", pageArtikel.hasNextPage());
		model.addAttribute("curPages", pageArtikel.getNumber() + 1);
		model.addAttribute("totalPages", pageArtikel.getTotalPages());
		model.addAttribute("listartikel", pageArtikel.getContent());
		return "listArtikel";
	}
	
	@RequestMapping("/admin/list-artikel/{num}")
	public String getListArtikel(Model model, @PathVariable int num){
		Page<Artikel> pageArtikel = artikelService.findAllWPaging(num - 1);
		model.addAttribute("hasPrev", pageArtikel.hasPreviousPage());
		model.addAttribute("hasNext", pageArtikel.hasNextPage());
		model.addAttribute("curPages", pageArtikel.getNumber() + 1);
		model.addAttribute("totalPages", pageArtikel.getTotalPages());
		model.addAttribute("listartikel", pageArtikel.getContent());
		return "listArtikel";
	}
	
	@RequestMapping("/admin/artikel-add")
	public String addArtikel(Model model){
		model.addAttribute("listkategori", kategoriService.findAll());
		return "artikelAdd";
	}
	
}
