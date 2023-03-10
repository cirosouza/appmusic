package br.edu.infnet.appmusic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appmusic.model.domain.Clipe;
import br.edu.infnet.appmusic.model.repository.ClipeRepository;

@Controller
public class ClipeController {
	private String msg;

	@GetMapping(value = "/clipe/cadastro")
	public String telaCadastro() {

		return "clipe/cadastro";
	}

	@GetMapping(value = "/clipe/lista")
	public String telaLista(Model model) {

		model.addAttribute("clipes", ClipeRepository.obterLista());

		model.addAttribute("mensagem", msg);

		msg = null;

		return "clipe/lista";
	}

	@PostMapping(value = "/clipe/incluir")
	public String incluir(Clipe clipe) {
		
		ClipeRepository.incluir(clipe);

		msg = "A inclusão do usuário " + clipe.getNome() + " foi realizada com sucesso!";
		
		return "redirect:/clipe/lista";
	}

	@GetMapping(value="/clipe/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Clipe clipe = ClipeRepository.excluir(id);

		msg = "A exclusão do usuário " + clipe.getNome() + " foi realizada com sucesso!";

		return "redirect:/clipe/lista";
	}
}
