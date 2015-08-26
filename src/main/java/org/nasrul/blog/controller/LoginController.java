package org.nasrul.blog.controller;

import java.security.Principal;

import org.nasrul.blog.entity.User;
import org.nasrul.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute(value = "user")
	public User construct(){
		return new User();
	}
	
	@RequestMapping("/login")
	public String getLogin(){
		return "login";
	}
	
	@RequestMapping("/account")
	public String getAccount(Model model, Principal principal){
		
		model.addAttribute("user", userService.findByUsername(principal.getName()));
		return "pageAkun";
		
	}
	
}
