package br.edu.infnet.appmusic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appmusic.model.domain.Artista;
import br.edu.infnet.appmusic.model.service.ArtistaService;

@Controller
public class ArtistaController {
	
	@Autowired
	private ArtistaService artistaService;

	private String msg;

	@GetMapping(value = "/artista/cadastro")
	public String telaCadastro() {

		return "artista/cadastro";
	}

	@GetMapping(value = "/artista/lista")
	public String telaLista(Model model) {

		model.addAttribute("artistas", artistaService.obterLista());

		model.addAttribute("mensagem", msg);

		msg = null;

		return "artista/lista";
	}

	@PostMapping(value = "/artista/incluir")
	public String incluir(Artista artista) {

		artistaService.incluir(artista);

		msg = "A inclusão do usuário " + artista.getNome() + " foi realizada com sucesso!";

		return "redirect:/artista/lista";
	}

	@GetMapping(value="/artista/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Artista artista = artistaService.excluir(id);

		msg = "A exclusão do usuário " + artista.getNome() + " foi realizada com sucesso!";

		return "redirect:/artista/lista";
	}
}
