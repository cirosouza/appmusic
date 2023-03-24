package br.edu.infnet.appmusic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appmusic.model.domain.ShowGravado;
import br.edu.infnet.appmusic.model.domain.Usuario;
import br.edu.infnet.appmusic.model.service.ShowGravadoService;

@Controller
public class ShowGravadoController {
	
	@Autowired
	private ShowGravadoService showGravadoService;
	
	private String msg;

	@GetMapping(value = "/show/cadastro")
	public String telaCadastro() {

		return "show/cadastro";
	}

	@GetMapping(value = "/show/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {

		model.addAttribute("shows", showGravadoService.obterLista(usuario));

		model.addAttribute("mensagem", msg);

		msg = null;

		return "show/lista";
	}

	@PostMapping(value = "/show/incluir")
	public String incluir(ShowGravado show, @SessionAttribute("usuario") Usuario usuario) {
		
		show.setUsuario(usuario);

		showGravadoService.incluir(show);

		msg = "A inclusão do usuário " + show.getNome() + " foi realizada com sucesso!";
		
		return "redirect:/show/lista";
	}

	@GetMapping(value="/show/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		showGravadoService.excluir(id);

		msg = "A exclusão do usuário (" + id + ") foi realizada com sucesso!";

		return "redirect:/show/lista";
	}
}
