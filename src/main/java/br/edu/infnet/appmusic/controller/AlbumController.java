package br.edu.infnet.appmusic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appmusic.model.domain.Album;
import br.edu.infnet.appmusic.model.domain.Usuario;
import br.edu.infnet.appmusic.model.service.AlbumService;

@Controller
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;
	
	private String msg;

	@GetMapping(value = "/album/cadastro")
	public String telaCadastro() {

		return "album/cadastro";
	}

	@GetMapping(value = "/album/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {

		model.addAttribute("albuns", albumService.obterLista(usuario));

		model.addAttribute("mensagem", msg);

		msg = null;

		return "album/lista";
	}

	@PostMapping(value = "/album/incluir")
	public String incluir(Album album, @SessionAttribute("usuario") Usuario usuario) {

		album.setUsuario(usuario);
		
		albumService.incluir(album);

		msg = "A inclusão do usuário " + album.getNome() + " foi realizada com sucesso!";

		return "redirect:/album/lista";
	}

	@GetMapping(value="/album/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Album album = albumService.obterPorId(id);
		
		try {
			albumService.excluir(id);
			msg = "A exclusão do album" + album.getNome() + " foi realizada com sucesso!";
		} catch (Exception e) {
			msg = "A exclusão do album" + album.getNome() + " não pôde ser realizada";
		}

		return "redirect:/album/lista";
	}
}
