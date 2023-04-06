package br.edu.infnet.appmusic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appmusic.model.domain.Artista;
import br.edu.infnet.appmusic.model.domain.Usuario;
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
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {

		model.addAttribute("artistas", artistaService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "artista/lista";
	}

	@PostMapping(value = "/artista/incluir")
	public String incluir(Artista artista, @SessionAttribute("usuario") Usuario usuario) {

		artista.setUsuario(usuario);
		artistaService.incluir(artista);

		msg = "A inclusão do artista " + artista.getNome() + " foi realizada com sucesso!";

		return "redirect:/artista/lista";
	}

	@GetMapping(value="/artista/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Artista artista = artistaService.obterPorId(id);
		
		try {
			artistaService.excluir(id);
			msg = "A exclusão do clipe" + artista.getNome() + " foi realizada com sucesso!";
		} catch (Exception e) {
			msg = "A exclusão do clipe" + artista.getNome() + " não pôde ser realizada";
		}

		return "redirect:/artista/lista";
	}
}
