package br.edu.infnet.appmusic.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmusic.model.domain.ShowGravado;
import br.edu.infnet.appmusic.model.domain.Usuario;
import br.edu.infnet.appmusic.model.repository.ShowGravadoRepository;

@Service
public class ShowGravadoService {
	
	@Autowired
	private ShowGravadoRepository showGravadoRepository;

	public ShowGravado incluir(ShowGravado showGravado) {
		return showGravadoRepository.save(showGravado);
	}
	
	public void excluir(Integer key) {
		showGravadoRepository.deleteById(key);
	}
	
	public Collection<ShowGravado> obterLista() {
		return (Collection<ShowGravado>) showGravadoRepository.findAll();
	}
	
	public Collection<ShowGravado> obterLista(Usuario usuario) {
		return (Collection<ShowGravado>) showGravadoRepository.obterLista(usuario.getId());
	}
	
	public ShowGravado obterPorId(Integer id) {
		return showGravadoRepository.findById(id).orElse(null);
	}
}
