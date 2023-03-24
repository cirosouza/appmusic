package br.edu.infnet.appmusic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appmusic.model.domain.Usuario;
import br.edu.infnet.appmusic.model.service.MidiaService;

@Controller
public class MidiaController {
	
	@Autowired
	private MidiaService midiaService;
	
	private String msg;


	@GetMapping(value = "/midia/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {

		model.addAttribute("midias", midiaService.obterLista(usuario));

		model.addAttribute("mensagem", msg);

		msg = null;

		return "midia/lista";
	}

	@GetMapping(value="/midia/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		midiaService.excluir(id);

		msg = "A exclusão do album (" + id + ") foi realizada com sucesso!";

		return "redirect:/midia/lista";
	}
}
