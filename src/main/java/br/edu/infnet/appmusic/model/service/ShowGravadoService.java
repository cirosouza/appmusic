package br.edu.infnet.appmusic.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmusic.model.domain.ShowGravado;
import br.edu.infnet.appmusic.model.repository.ShowGravadoRepository;

@Service
public class ShowGravadoService {
	
	@Autowired
	private ShowGravadoRepository showGravadoRepository;

	public boolean incluir(ShowGravado showGravado) {
		return showGravadoRepository.incluir(showGravado);
	}
	
	public ShowGravado excluir(Integer key) {
		return showGravadoRepository.excluir(key);
	}
	
	public Collection<ShowGravado> obterLista() {
		return showGravadoRepository.obterLista();
	}
}
