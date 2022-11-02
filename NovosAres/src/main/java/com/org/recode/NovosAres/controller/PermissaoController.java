package com.org.recode.NovosAres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.org.recode.NovosAres.repository.PermissaoRepository;

@Controller
@RequestMapping("/permissao")
public class PermissaoController {
	
	@Autowired
    private PermissaoRepository permissaoRepositorio;
	
	@GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("permissao/cadastro");

        modelAndView.addObject("permissao", permissaoRepositorio.findAll());

        return modelAndView;
    }
	

}
