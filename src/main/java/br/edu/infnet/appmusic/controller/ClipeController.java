package br.edu.infnet.appmusic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appmusic.model.domain.Clipe;
import br.edu.infnet.appmusic.model.domain.Usuario;
import br.edu.infnet.appmusic.model.service.ClipeService;

@Controller
public class ClipeController {
	
	@Autowired
	private ClipeService clipeService;
	
	private String msg;

	@GetMapping(value = "/clipe/cadastro")
	public String telaCadastro() {

		return "clipe/cadastro";
	}

	@GetMapping(value = "/clipe/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {

		model.addAttribute("clipes", clipeService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "clipe/lista";
	}

	@PostMapping(value = "/clipe/incluir")
	public String incluir(Clipe clipe, @SessionAttribute("usuario") Usuario usuario) {
		
		clipe.setUsuario(usuario);
		
		clipeService.incluir(clipe);

		msg = "A inclusão do usuário " + clipe.getNome() + " foi realizada com sucesso!";
		
		return "redirect:/clipe/lista";
	}

	@GetMapping(value="/clipe/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Clipe clipe = clipeService.obterPorId(id);
		
		try {
			clipeService.excluir(id);
			msg = "A exclusão do clipe" + clipe.getNome() + " foi realizada com sucesso!";
		} catch (Exception e) {
			msg = "A exclusão do clipe" + clipe.getNome() + " não pôde ser realizada";
		}

		return "redirect:/clipe/lista";
	}
}
