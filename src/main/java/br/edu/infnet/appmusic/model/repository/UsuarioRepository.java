package br.edu.infnet.appmusic.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appmusic.model.domain.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	@Query("from Usuario u where u.email = :email and senha = :senha")
	Usuario autenticacao(String email, String senha);
}
