package br.edu.infnet.appmusic.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appmusic.model.domain.ShowGravado;

@Repository
public interface ShowGravadoRepository extends CrudRepository<ShowGravado, Integer> {

	@Query("from ShowGravado s where s.usuario.id = :userId")
	public List<ShowGravado> obterLista(Integer userId, Sort sort);
}
