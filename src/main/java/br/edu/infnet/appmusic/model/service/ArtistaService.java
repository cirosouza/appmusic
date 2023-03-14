package br.edu.infnet.appmusic.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmusic.model.domain.Artista;
import br.edu.infnet.appmusic.model.domain.Usuario;
import br.edu.infnet.appmusic.model.repository.ArtistaRepository;

@Service
public class ArtistaService {

	@Autowired
	private ArtistaRepository artistaRepository;

	public Artista incluir(Artista artista) {
		return artistaRepository.save(artista);
	}

	public void excluir(Integer key) {
		artistaRepository.deleteById(key);
	}

	public Collection<Artista> obterLista() {
		return (Collection<Artista>) artistaRepository.findAll();
	}
	
	public Collection<Artista> obterLista(Usuario usuario) {
		return (Collection<Artista>) artistaRepository.ObterLista(usuario.getId());
	}
}

