package br.edu.infnet.appmusic.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.appmusic.model.domain.Clipe;

public class ClipeRepository {
	private static Integer id = 1;

	private static Map<Integer, Clipe> mapaClipe = new HashMap<Integer, Clipe>();

	public static boolean incluir(Clipe clipe) {

		clipe.setId(id++);

		try {
			mapaClipe.put(clipe.getId(), clipe);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static Clipe excluir(Integer key) {

		return mapaClipe.remove(key);
	}

	public static Collection<Clipe> obterLista() {
		return mapaClipe.values();
	}
}
