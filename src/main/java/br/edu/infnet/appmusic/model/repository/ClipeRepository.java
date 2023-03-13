package br.edu.infnet.appmusic.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.appmusic.model.domain.Clipe;

@Repository
public class ClipeRepository {
	private static Integer id = 1;

	private static Map<Integer, Clipe> mapaClipe = new HashMap<Integer, Clipe>();

	public boolean incluir(Clipe clipe) {

		clipe.setId(id++);

		try {
			mapaClipe.put(clipe.getId(), clipe);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Clipe excluir(Integer key) {

		return mapaClipe.remove(key);
	}

	public Collection<Clipe> obterLista() {
		return mapaClipe.values();
	}
}
