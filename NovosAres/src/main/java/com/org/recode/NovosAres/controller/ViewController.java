package com.org.recode.NovosAres.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.org.recode.NovosAres.model.Cliente;

@Controller
public class ViewController {
	
	@GetMapping("/")
	public String index() {
		

		return "/view/index";

	}
	@GetMapping("/Pagina_contato")
	public String Pagina_contato() {
		
		
		return "/view/Pagina_contato";
		
	}
	@GetMapping("/view/Paginadestino")
	public String Paginadestino() {
		
		
		return "/view/Paginadestino";
		
	}
	@GetMapping("/view/Pagina_casal")
	public String Pagina_casal() {
		
		
		return "/view/Pagina_casal";
		
	}
	@GetMapping("/view/Pagina_familia")
	public String Pagina_familia() {
		
		
		return "/view/Pagina_familia";
		
	}
	@GetMapping("/view/Pagina_solteiro")
	public String Pagina_solteiro() {
		
		
		return "/view/Pagina_solteiro";
		
	}

	@GetMapping("/view/login")
	public String login() {
		
		return "/view/login";

	}
	

}
