package br.edu.infnet.appmusic.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appmusic.model.domain.Clipe;

@Repository
public interface ClipeRepository extends CrudRepository<Clipe, Integer> {

	@Query("from Clipe c where c.usuario.id = :userId")
	public List<Clipe> obterLista(Integer userId, Sort sort);
}
