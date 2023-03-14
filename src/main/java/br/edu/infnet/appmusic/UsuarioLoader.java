package br.edu.infnet.appmusic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appmusic.model.domain.Usuario;
import br.edu.infnet.appmusic.model.service.UsuarioService;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner{

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario usuario = new Usuario("Administrador", "admin@admin.com", "senha123");	
		
		
		
		usuarioService.incluir(usuario);
	}
	
}
