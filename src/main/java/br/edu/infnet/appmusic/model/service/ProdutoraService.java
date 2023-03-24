package br.edu.infnet.appmusic.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmusic.model.domain.Produtora;
import br.edu.infnet.appmusic.model.domain.Usuario;
import br.edu.infnet.appmusic.model.repository.ProdutoraRepository;

@Service
public class ProdutoraService {

	@Autowired
	private ProdutoraRepository produtoraRepository;

	public Produtora incluir(Produtora produtora) {
		return produtoraRepository.save(produtora);
	}
	
	public void excluir(Integer key) {
		produtoraRepository.deleteById(key);
	}
	
	public Collection<Produtora> obterLista() {
		return (Collection<Produtora>) produtoraRepository.findAll();
	}
	
	public Collection<Produtora> obterLista(Usuario usuario) {
		return (Collection<Produtora>) produtoraRepository.obterLista(usuario.getId());
	}
	
	public Produtora obterPorId(Integer id) {
		return produtoraRepository.findById(id).orElse(null);
	}
}
