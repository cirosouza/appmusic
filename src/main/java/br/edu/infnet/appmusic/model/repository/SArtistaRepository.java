package br.edu.infnet.appmusic.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.appmusic.model.domain.Artista;

@Repository
public class SArtistaRepository {
	private static Integer id = 1;

	private static Map<Integer, Artista> mapaArtista = new HashMap<Integer, Artista>();

	public boolean incluir(Artista artista) {

		artista.setId(id++);

		try {
			mapaArtista.put(artista.getId(), artista);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Artista excluir(Integer key) {

		return mapaArtista.remove(key);
	}

	public Collection<Artista> obterLista() {
		return mapaArtista.values();
	}
}
