package br.edu.infnet.appmusic.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.appmusic.model.domain.ShowGravado;

public class ShowGravadoRepository {
	private static Integer id = 1;

	private static Map<Integer, ShowGravado> mapaShow = new HashMap<Integer, ShowGravado>();

	public static boolean incluir(ShowGravado show) {

		show.setId(id++);

		try {
			mapaShow.put(show.getId(), show);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static ShowGravado excluir(Integer key) {

		return mapaShow.remove(key);
	}

	public static Collection<ShowGravado> obterLista() {
		return mapaShow.values();
	}
}
