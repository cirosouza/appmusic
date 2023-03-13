package br.edu.infnet.appmusic.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmusic.model.domain.Clipe;
import br.edu.infnet.appmusic.model.repository.ClipeRepository;

@Service
public class ClipeService {

	@Autowired
	private ClipeRepository clipeRepository;

	public boolean incluir(Clipe clipe) {
		return clipeRepository.incluir(clipe);
	}
	
	public Clipe excluir(Integer key) {
		return clipeRepository.excluir(key);
	}
	
	public Collection<Clipe> obterLista() {
		return clipeRepository.obterLista();
	}
}
