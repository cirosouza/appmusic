package br.edu.infnet.appmusic.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appmusic.model.domain.Produtora;

@Repository
public interface ProdutoraRepository extends CrudRepository<Produtora, Integer>{

	@Query("from Produtora p where p.usuario.id = :userId")
	List<Produtora> obterLista(Integer userId);
}
