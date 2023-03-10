package br.edu.infnet.appmusic.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.appmusic.model.domain.Artista;

public class ArtistaRepository {
	private static Integer id = 1;

	private static Map<Integer, Artista> mapaArtista = new HashMap<Integer, Artista>();

	public static boolean incluir(Artista artista) {

		artista.setId(id++);

		try {
			mapaArtista.put(artista.getId(), artista);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static Artista excluir(Integer key) {

		return mapaArtista.remove(key);
	}

	public static Collection<Artista> obterLista() {
		return mapaArtista.values();
	}
}
