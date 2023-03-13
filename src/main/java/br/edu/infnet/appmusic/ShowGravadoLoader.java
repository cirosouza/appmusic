package br.edu.infnet.appmusic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appmusic.model.domain.ShowGravado;
import br.edu.infnet.appmusic.model.service.ShowGravadoService;

@Order(5)
@Component
public class ShowGravadoLoader implements ApplicationRunner {

	@Autowired
	private ShowGravadoService showGravadoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {
			String arq = "shows_gravados.txt";

			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);

				String linha = leitura.readLine();
				String[] campos = null;

				while (linha != null) {

					campos = linha.split(";");
					
					ShowGravado showGravado = new ShowGravado(
							campos[0], 
							Float.parseFloat(campos[1]), 
							Integer.parseInt(campos[2]),
							campos[3],
							Integer.parseInt(campos[4]),
							campos[5]
							);
					
					showGravadoService.incluir(showGravado);
					
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
