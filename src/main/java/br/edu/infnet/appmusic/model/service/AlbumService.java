package br.edu.infnet.appmusic.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmusic.model.domain.Album;
import br.edu.infnet.appmusic.model.domain.Usuario;
import br.edu.infnet.appmusic.model.repository.AlbumRepository;

@Service
public class AlbumService {

	@Autowired
	private AlbumRepository albumRepository;

	public Album incluir(Album album) {
		return albumRepository.save(album);
	}
	
	public void excluir(Integer key) {
		albumRepository.deleteById(key);
	}
	
	public Collection<Album> obterLista() {
		return (Collection<Album>) albumRepository.findAll();
	}
	
	public Collection<Album> obterLista(Usuario usuario) {
		return (Collection<Album>) albumRepository.obterLista(usuario.getId());
	}
	
	public Album obterPorId(Integer id) {
		return albumRepository.findById(id).orElse(null);
	}
}
