package br.edu.infnet.appmusic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appmusic.model.domain.Endereco;
import br.edu.infnet.appmusic.model.domain.Produtora;
import br.edu.infnet.appmusic.model.domain.Usuario;
import br.edu.infnet.appmusic.model.service.ArtistaService;
import br.edu.infnet.appmusic.model.service.MidiaService;
import br.edu.infnet.appmusic.model.service.ProdutoraService;

@Controller
public class ProdutoraController {

	@Autowired
	private ProdutoraService produtoraService;

	@Autowired
	private ArtistaService artistaService;
	
	@Autowired
	private MidiaService midiaService;

	private String msg;

	@GetMapping(value = "/produtora")
	public String telaCadastro(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("artistas", artistaService.obterLista(usuario));
		
		model.addAttribute("midias", midiaService.obterLista(usuario));

		return "produtora/cadastro";
	}

	@GetMapping(value = "/produtora/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {

		model.addAttribute("produtoras", produtoraService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "produtora/lista";
	}

	@PostMapping(value = "/produtora/incluir")
	public String incluir(Produtora produtora, Endereco endereco,@SessionAttribute("usuario") Usuario usuario) {

		usuario.setEndereco(endereco);
		
		produtora.setUsuario(usuario);

		produtoraService.incluir(produtora);

		msg = "A inclusão da produtora " + produtora.getNome() + " foi realizada com sucesso!";

		return "redirect:/produtora/lista";
	}

	@GetMapping(value = "/produtora/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Produtora produtora = produtoraService.obterPorId(id);

		produtoraService.excluir(id);

		msg = "A exclusão da produtora " + produtora.getNome()+ " foi realizada com sucesso!";

		return "redirect:/produtora/lista";
	}
}
