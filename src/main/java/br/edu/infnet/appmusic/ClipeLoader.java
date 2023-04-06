package br.edu.infnet.appmusic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appmusic.model.domain.Clipe;
import br.edu.infnet.appmusic.model.domain.Usuario;
import br.edu.infnet.appmusic.model.service.ClipeService;

@Order(4)
@Component
public class ClipeLoader implements ApplicationRunner {

	@Autowired
	private ClipeService clipeService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {
			String arq = "clipes.txt";

			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);

				String linha = leitura.readLine();
				String[] campos = null;

				while (linha != null) {

					campos = linha.split(";");
					
					Clipe clipe = new Clipe(
							campos[0], 
							Float.parseFloat(campos[1]), 
							Integer.parseInt(campos[2]),
							campos[3],
							campos[4],
							Integer.parseInt(campos[5])
							);
					
					Usuario usuario = new Usuario();
					usuario.setId(1);
							
					clipe.setUsuario(usuario);
					
					clipeService.incluir(clipe);
					
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
		
		//criando clipes para o usuario 2		
		Clipe clipe1 = new Clipe();
		clipe1.setNome("Shoulders");
		clipe1.setDuracao(3);
		clipe1.setAnoDeGravacao(2021);
		clipe1.setDiretor("Claudio Sanchez");
		clipe1.setLinkVideo("https://www.youtube.com/watch?v=-Tb_v8MFbF8");
		clipe1.setNumeroDeAtoresFigurantes(15);
		clipe1.setUsuario(usuario2);
		
		clipeService.incluir(clipe1);
		
		Clipe clipe2 = new Clipe();
		clipe2.setNome("Welcome Home");
		clipe2.setDuracao(4);
		clipe2.setAnoDeGravacao(2009);
		clipe2.setDiretor("Claudio Sanchez");
		clipe2.setLinkVideo("https://www.youtube.com/watch?v=n0H3RlaQVrM");
		clipe2.setNumeroDeAtoresFigurantes(0);
		clipe2.setUsuario(usuario2);
		
		clipeService.incluir(clipe2);
	}
}
