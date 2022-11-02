package com.org.recode.NovosAres.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.org.recode.NovosAres.model.Cliente;
import com.org.recode.NovosAres.repository.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepositorio;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("clientes/exibir.html");

		List<Cliente> cliente = clienteRepositorio.findAll();
		modelAndView.addObject("cliente", cliente);
		return modelAndView;

	}

//	    @GetMapping("/{id}")
//	    public ModelAndView detalhes(@PathVariable Long id) {
//	        ModelAndView modelAndView = new ModelAndView("cliente/detalhes");
//
//	        modelAndView.addObject("cliente", clienteRepositorio.getOne(id));
//
//	        return modelAndView;
//	    }
//	    
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("clientes/cadastro");

		modelAndView.addObject("cliente", new Cliente());
//	        modelAndView.addObject("ufs", UF.values());

		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Cliente cliente) throws IOException {

		cliente.setData_cli(new Date());
		ModelAndView modelAndView = new ModelAndView("redirect:/clientes");

		clienteRepositorio.save(cliente);

		return modelAndView;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView("clientes/cadastro");

		modelAndView.addObject("cliente", clienteRepositorio.getOne(id));
//	        modelAndView.addObject("ufs", UF.values());

		return modelAndView;
	}

	@PostMapping("/{id}/editar")
	public String salvar(Cliente cliente) {
		clienteRepositorio.save(cliente);

	   return "redirect:/clientes";
	   }

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable int id) {
		clienteRepositorio.deleteById(id);

		return "redirect:/clientes";
	}

}
