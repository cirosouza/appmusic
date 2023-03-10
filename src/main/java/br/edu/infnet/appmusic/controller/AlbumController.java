package br.edu.infnet.appmusic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appmusic.model.domain.Album;
import br.edu.infnet.appmusic.model.repository.AlbumRepository;

@Controller
public class AlbumController {
	private String msg;

	@GetMapping(value = "/album/cadastro")
	public String telaCadastro() {

		return "album/cadastro";
	}

	@GetMapping(value = "/album/lista")
	public String telaLista(Model model) {

		model.addAttribute("albuns", AlbumRepository.obterLista());

		model.addAttribute("mensagem", msg);

		msg = null;

		return "album/lista";
	}

	@PostMapping(value = "/album/incluir")
	public String incluir(Album album) {

		AlbumRepository.incluir(album);

		msg = "A inclusão do usuário " + album.getNome() + " foi realizada com sucesso!";

		return "redirect:/album/lista";
	}

	@GetMapping(value="/album/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Album album = AlbumRepository.excluir(id);

		msg = "A exclusão do usuário " + album.getNome() + " foi realizada com sucesso!";

		return "redirect:/album/lista";
	}
}
