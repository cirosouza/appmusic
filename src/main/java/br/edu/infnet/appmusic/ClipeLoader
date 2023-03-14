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
	}
}
