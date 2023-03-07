package br.edu.infnet.appmusic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.appmusic.model.domain.Usuario;
import br.edu.infnet.appmusic.model.repository.AcessoRepository;

@Controller
public class AcessoController {

	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";
	}

	@PostMapping(value = "/login")
	public String login(@RequestParam String email, @RequestParam String senha) {
		
		Usuario user = new Usuario(email, senha);
		
		if(AcessoRepository.autenticar(user) != null){
			return "redirect:/home";
		}
		
		return "redirect:/home";
	}

}
