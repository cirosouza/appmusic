package br.edu.infnet.appmusic.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appmusic.model.domain.Artista;

@Repository
public interface ArtistaRepository extends CrudRepository<Artista, Integer>{

	@Query("from Artista a where a.usuario.id = :userId")
	List<Artista> ObterLista(Integer userId, Sort sort);
}
