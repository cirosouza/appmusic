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
import br.edu.infnet.appmusic.model.domain.Usuario;
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
					
					Usuario usuario = new Usuario();
					usuario.setId(1);
							
					showGravado.setUsuario(usuario);
					
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
		
		Usuario usuario2 = new Usuario();
		usuario2.setId(2);
		
		//criando clipes para o usuario 2		
		ShowGravado show1 = new ShowGravado();
		show1.setNome("Coheed and Cambria - Guitar Center Sessions");
		show1.setDuracao(30);
		show1.setAnoDeGravacao(2022);
		show1.setLocalDeGravacao("Hollywood");
		show1.setNumeroDeMusicasPerformadas(7);
		show1.setProducao("DIRECTV");
		show1.setUsuario(usuario2);
		
		showGravadoService.incluir(show1);
		
		ShowGravado show2 = new ShowGravado();
		show2.setNome("Coheed and Cambria Live at Stone Pony Summer Stage");
		show2.setDuracao(4);
		show2.setAnoDeGravacao(2019);
		show2.setLocalDeGravacao("New Jersey");
		show2.setNumeroDeMusicasPerformadas(16);
		show2.setProducao("REVOLVER");
		show2.setUsuario(usuario2);
		
		showGravadoService.incluir(show2);
	}
}
