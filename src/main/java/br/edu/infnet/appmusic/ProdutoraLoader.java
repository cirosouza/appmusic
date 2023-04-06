package br.edu.infnet.appmusic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appmusic.model.domain.Album;
import br.edu.infnet.appmusic.model.domain.Artista;
import br.edu.infnet.appmusic.model.domain.Clipe;
import br.edu.infnet.appmusic.model.domain.Midia;
import br.edu.infnet.appmusic.model.domain.Produtora;
import br.edu.infnet.appmusic.model.domain.ShowGravado;
import br.edu.infnet.appmusic.model.domain.Usuario;
import br.edu.infnet.appmusic.model.service.ProdutoraService;

@Order(6)
@Component
public class ProdutoraLoader  implements ApplicationRunner {

	@Autowired
	private ProdutoraService produtoraService;

	@Override
	public void run(ApplicationArguments args) throws Exception {


		Usuario usuario2 = new Usuario();
		usuario2.setId(2);
		
		Produtora produtora = new Produtora();
		
		produtora.setNome("Roadrunner Records");
		produtora.setPais("Netherlands");
		produtora.setAnoDeCriacao(1980);
		
		Album album1 = new Album();
		album1.setId(4);
		
		Album album2 = new Album();
		album2.setId(5);
		
		Clipe clipe1 = new Clipe();
		clipe1.setId(9);
		
		Clipe clipe2 = new Clipe();
		clipe2.setId(10);
		
		ShowGravado show1 = new ShowGravado();
		show1.setId(14);
		
		ShowGravado show2 = new ShowGravado();
		show2.setId(15);
		
		List<Midia> midias	= new ArrayList<Midia>();
		midias.add(album1);
		midias.add(album2);
		midias.add(clipe1);
		midias.add(clipe2);
		midias.add(show1);
		midias.add(show2);
		
		produtora.setMidias(midias);
		
		Artista artista = new Artista();
		artista.setId(4);
		
		produtora.setArtista(artista);
		
		produtora.setUsuario(usuario2);
		
		produtoraService.incluir(produtora);
	}
	

	
	
}
