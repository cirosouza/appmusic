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

	}

}
