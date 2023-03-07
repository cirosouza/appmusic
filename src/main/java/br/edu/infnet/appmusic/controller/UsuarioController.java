package br.edu.infnet.appmusic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appmusic.model.domain.Usuario;
import br.edu.infnet.appmusic.model.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@GetMapping(value = "/usuario")
	public String telaCadastro() {

		return "usuario/cadastro";
	}
	
	@GetMapping(value = "/usuario/lista")
	public String telaLista() {

		return "usuario/lista";
	}
	
	@PostMapping(value = "/usuario/incluir")
	public String incluir(Usuario usuario) {
		System.out.println("Inclusao realizada com sucesso!!!" + usuario);
		
		UsuarioRepository.incluir(usuario);

		return "redirect:/usuario/lista";
	}

}
