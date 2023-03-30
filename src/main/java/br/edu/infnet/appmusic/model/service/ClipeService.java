package br.edu.infnet.appmusic.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmusic.model.domain.Clipe;
import br.edu.infnet.appmusic.model.domain.Usuario;
import br.edu.infnet.appmusic.model.repository.ClipeRepository;

@Service
public class ClipeService {

	@Autowired
	private ClipeRepository clipeRepository;

	public Clipe incluir(Clipe clipe) {
		return clipeRepository.save(clipe);
	}
	
	public void excluir(Integer key) {
		clipeRepository.deleteById(key);
	}
	
	public Collection<Clipe> obterLista() {
		return (Collection<Clipe>) clipeRepository.findAll();
	}
	
	public Collection<Clipe> obterLista(Usuario usuario) {
		return (Collection<Clipe>) clipeRepository.obterLista(usuario.getId(), Sort.by(Direction.ASC, "anoDeGravacao"));
	}
	
	public Clipe obterPorId(Integer id) {
		return clipeRepository.findById(id).orElse(null);
	}
}
