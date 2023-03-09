package br.edu.infnet.appmusic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArtistaController {

	@GetMapping(value = "/artista")
	public String telaCadastro() {

		return "artista/cadastro";
	}
}
