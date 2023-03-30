package br.edu.infnet.appmusic.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appmusic.model.domain.Midia;

@Repository
public interface MidiaRepository extends CrudRepository<Midia, Integer> {

	@Query("from Midia m where m.usuario.id = :userId")
	public List<Midia> obterLista(Integer userId, Sort sort);
}
