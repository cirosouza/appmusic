package br.edu.infnet.appmusic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appmusic.model.domain.Usuario;
import br.edu.infnet.appmusic.model.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	private String msg;

	@GetMapping(value = "/usuario")
	public String telaCadastro() {

		return "usuario/cadastro";
	}

	@GetMapping(value = "/usuario/lista")
	public String telaLista(Model model) {

		model.addAttribute("usuarios", UsuarioRepository.obterLista());
		
		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "usuario/lista";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluir(Usuario usuario) {
		System.out.println("Inclusao realizada com sucesso!!!" + usuario);

		UsuarioRepository.incluir(usuario);
		
		msg = "A inclusão do usuário " + usuario.getNome() + " foi realizada com sucesso!";

		return "redirect:/";
	}
	
	@GetMapping(value="/usuario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Usuario usuario = UsuarioRepository.excluir(id);
		
		msg = "A exclusão do usuário " + usuario.getNome() + " foi realizada com sucesso!";
		
		return "redirect:/usuario/lista";
	}

}
