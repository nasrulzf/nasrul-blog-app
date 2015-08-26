package org.nasrul.blog.controller;

import org.nasrul.blog.entity.Kategori;
import org.nasrul.blog.repo.KategoriRepo;
import org.nasrul.blog.service.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class KategoriController {
	
	@Autowired
	private KategoriService kategoriService;
	
	@ModelAttribute("kategori")
	public Kategori construct(){
		return new Kategori();
	}
	
	@RequestMapping("/admin/list-kategori")
	public String showKategori(Model model){
		Page<Kategori> pageKategori = kategoriService.findWPaging(0);
		model.addAttribute("listkategori", pageKategori.getContent());
		model.addAttribute("totalPages", pageKategori.getTotalPages());
		model.addAttribute("curPages", pageKategori.getNumber() + 1);
		model.addAttribute("hasPrev", pageKategori.hasPreviousPage());
		model.addAttribute("hasNext", pageKategori.hasNextPage());
		return "listKategori";
	}
	
	@RequestMapping("/admin/list-kategori/{num}")
	public String showKategori(Model model, @PathVariable int num){
		Page<Kategori> pageKategori = kategoriService.findWPaging(num - 1);
		model.addAttribute("listkategori", pageKategori.getContent());
		model.addAttribute("totalPages", pageKategori.getTotalPages());
		model.addAttribute("curPages", pageKategori.getNumber() + 1);
		model.addAttribute("hasPrev", pageKategori.hasPreviousPage());
		model.addAttribute("hasNext", pageKategori.hasNextPage());
		return "listKategori";
	}
	
	@RequestMapping("/admin/kategori-add")
	public String showKategoriAdd(Model model){
		return "kategoriAdd";
	}
	
	@RequestMapping(value = "/admin/kategori-add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("kategori") Kategori kategori){
		kategoriService.save(kategori);
		return "redirect:/admin/list-kategori.do";
	}
	
	@RequestMapping("/admin/kategori-update/{id}")
	public String updateKategori(Model model, @PathVariable int id){
		Kategori kategori = kategoriService.findOne(id);
		model.addAttribute("kategori", kategori);
		return "kategoriAdd";
	}
	
	@RequestMapping(value = "/admin/kategori-update/{id}", method = RequestMethod.POST)
	public String doUpdateKategori(Model model, @ModelAttribute("kategori") Kategori kategori){
		kategoriService.update(kategori);
		return "redirect:/admin/list-kategori.do";
	}
	
	@RequestMapping("/admin/kategori-delete/{id}")
	public String deleteKategori(@PathVariable int id){
		kategoriService.delete(id);
		return "redirect:/admin/list-kategori.do";
	}
	
}
