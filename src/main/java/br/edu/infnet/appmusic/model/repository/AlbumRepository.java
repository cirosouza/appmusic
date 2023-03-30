package br.edu.infnet.appmusic.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appmusic.model.domain.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer> {

	@Query("from Album a where a.usuario.id = :userId")
	public List<Album> obterLista(Integer userId, Sort sort);
}
