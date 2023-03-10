package br.edu.infnet.appmusic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appmusic.model.domain.ShowGravado;
import br.edu.infnet.appmusic.model.repository.ShowGravadoRepository;

@Controller
public class ShowGravadoController {
	private String msg;

	@GetMapping(value = "/show/cadastro")
	public String telaCadastro() {

		return "show/cadastro";
	}

	@GetMapping(value = "/show/lista")
	public String telaLista(Model model) {

		model.addAttribute("shows", ShowGravadoRepository.obterLista());

		model.addAttribute("mensagem", msg);

		msg = null;

		return "show/lista";
	}

	@PostMapping(value = "/show/incluir")
	public String incluir(ShowGravado show) {

		ShowGravadoRepository.incluir(show);

		msg = "A inclusão do usuário " + show.getNome() + " foi realizada com sucesso!";
		
		return "redirect:/show/lista";
	}

	@GetMapping(value="/show/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		ShowGravado show = ShowGravadoRepository.excluir(id);

		msg = "A exclusão do usuário " + show.getNome() + " foi realizada com sucesso!";

		return "redirect:/show/lista";
	}
}