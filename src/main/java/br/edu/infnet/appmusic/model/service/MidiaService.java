package br.edu.infnet.appmusic.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmusic.model.domain.Midia;
import br.edu.infnet.appmusic.model.domain.Usuario;
import br.edu.infnet.appmusic.model.repository.MidiaRepository;

@Service
public class MidiaService {

	@Autowired
	private MidiaRepository midiaRepository;

	public void excluir(Integer key) {
		midiaRepository.deleteById(key);
	}
	
	public Collection<Midia> obterLista() {
		return (Collection<Midia>) midiaRepository.findAll();
	}
	
	public Collection<Midia> obterLista(Usuario usuario) {
		return (Collection<Midia>) midiaRepository.obterLista(usuario.getId(), Sort.by(Direction.ASC, "anoDeGravacao"));
	}
	
	public Midia obterPorId(Integer id) {
		return midiaRepository.findById(id).orElse(null);
	}
}
