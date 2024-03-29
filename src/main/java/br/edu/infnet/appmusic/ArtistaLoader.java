package br.edu.infnet.appmusic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appmusic.model.domain.Artista;
import br.edu.infnet.appmusic.model.domain.Usuario;
import br.edu.infnet.appmusic.model.service.ArtistaService;

@Order(2)
@Component
public class ArtistaLoader implements ApplicationRunner {

	@Autowired
	private ArtistaService artistaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {
			String arq = "artistas.txt";

			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);

				String linha = leitura.readLine();
				String[] campos = null;

				while (linha != null) {

					campos = linha.split(";");
					
					Usuario usuario = new Usuario();
					usuario.setId(1);
					
					Artista artista = new Artista(
							campos[0], 
							Integer.parseInt(campos[1]), 
							campos[2],
							Boolean.parseBoolean(campos[3])
							);
					
					artista.setUsuario(usuario);
					
					artistaService.incluir(artista);
					
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
		Artista artista1 = new Artista();
		artista1.setNome("Coheed and Cambria");
		artista1.setAnoDeOrigem(1995);
		artista1.setTipo("Banda");
		artista1.setAtivo(true);
		artista1.setUsuario(usuario2);
		
		artistaService.incluir(artista1);
	}
}
