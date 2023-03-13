package br.edu.infnet.appmusic.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmusic.model.domain.Artista;
import br.edu.infnet.appmusic.model.repository.ArtistaRepository;

@Service
public class ArtistaService {
	
	@Autowired
	private ArtistaRepository artistaRepository;

	public boolean incluir(Artista artista) {
		return artistaRepository.incluir(artista);
	}
	
	public Artista excluir(Integer key) {
		return artistaRepository.excluir(key);
	}
	
	public Collection<Artista> obterLista() {
		return artistaRepository.obterLista();
	}
}
