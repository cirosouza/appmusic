package br.edu.infnet.appmusic.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.appmusic.model.domain.ShowGravado;

@Repository
public class ShowGravadoRepository {
	private static Integer id = 1;

	private static Map<Integer, ShowGravado> mapaShow = new HashMap<Integer, ShowGravado>();

	public boolean incluir(ShowGravado show) {

		show.setId(id++);

		try {
			mapaShow.put(show.getId(), show);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public ShowGravado excluir(Integer key) {

		return mapaShow.remove(key);
	}

	public Collection<ShowGravado> obterLista() {
		return mapaShow.values();
	}
}
