package br.edu.infnet.appmusic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appmusic.model.domain.Album;
import br.edu.infnet.appmusic.model.domain.Usuario;
import br.edu.infnet.appmusic.model.service.AlbumService;

@Order(3)
@Component
public class AlbumLoader implements ApplicationRunner{

	@Autowired
	private AlbumService albumService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
			String arq = "albuns.txt";

			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);

				String linha = leitura.readLine();
				String[] campos = null;

				while (linha != null) {

					campos = linha.split(";");

					Album album = new Album(campos[0], Float.parseFloat(campos[1]), Integer.parseInt(campos[2]),
							Integer.parseInt(campos[3]), campos[4], Integer.parseInt(campos[5]));
					
					Usuario usuario = new Usuario();
					usuario.setId(1);
							
					album.setUsuario(usuario);

					albumService.incluir(album);

					linha = leitura.readLine();

				}

				leitura.close();
				fileR.close();

			} catch (IOException e) {
				System.out.println("[ERRO] " + e.getMessage());
			}
		} finally {
			System.out.println("Processamento realizado com sucesso!!!");
		}
		
		Usuario usuario2 = new Usuario();
		usuario2.setId(2);
		
		//criando albuns para o usuario 2		
		Album album1 = new Album();
		album1.setNome("In Keeping Secrets of Silent Earth: 3");
		album1.setDuracao(69);
		album1.setAnoDeGravacao(2003);
		album1.setNumeroDeMusicas(12);
		album1.setTipo("LP");
		album1.setTempoConteudoBonus(0);
		album1.setUsuario(usuario2);
		
		albumService.incluir(album1);
		
		Album album2 = new Album();
		album2.setNome("Year of the Black Rainbow");
		album2.setDuracao(53);
		album2.setAnoDeGravacao(2010);
		album2.setNumeroDeMusicas(15);
		album2.setTipo("LP");
		album2.setTempoConteudoBonus(13);
		album2.setUsuario(usuario2);
		
		albumService.incluir(album2);

	}

}
