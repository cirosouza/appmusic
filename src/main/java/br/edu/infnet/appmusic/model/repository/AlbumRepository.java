package br.edu.infnet.appmusic.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.appmusic.model.domain.Album;

public class AlbumRepository {
	private static Integer id = 1;

	private static Map<Integer, Album> mapaAlbum = new HashMap<Integer, Album>();

	public static boolean incluir(Album album) {

		album.setId(id++);

		try {
			mapaAlbum.put(album.getId(), album);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static Album excluir(Integer key) {

		return mapaAlbum.remove(key);
	}

	public static Collection<Album> obterLista() {
		return mapaAlbum.values();
	}
}
