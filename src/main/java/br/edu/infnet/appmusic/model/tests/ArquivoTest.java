package br.edu.infnet.appmusic.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.appmusic.model.domain.Album;
import br.edu.infnet.appmusic.model.domain.Artista;
import br.edu.infnet.appmusic.model.domain.Clipe;
import br.edu.infnet.appmusic.model.domain.Midia;
import br.edu.infnet.appmusic.model.domain.Produtora;
import br.edu.infnet.appmusic.model.domain.ShowGravado;
import br.edu.infnet.appmusic.model.exceptions.AlbumInvalidoException;
import br.edu.infnet.appmusic.model.exceptions.ArtistaInvalidoException;
import br.edu.infnet.appmusic.model.exceptions.ClipeInvalidoException;
import br.edu.infnet.appmusic.model.exceptions.MidiaAnoVazioException;
import br.edu.infnet.appmusic.model.exceptions.MidiaDuracaoInvalidaException;
import br.edu.infnet.appmusic.model.exceptions.MidiaNomeVazioException;
import br.edu.infnet.appmusic.model.exceptions.ProdutoraSemArtistaException;
import br.edu.infnet.appmusic.model.exceptions.ProdutoraSemMidiaException;
import br.edu.infnet.appmusic.model.exceptions.ShowGravadoInvalidoException;

public class ArquivoTest {

	public static void main(String[] args) {

		File file = new File("");
		String currentPath = file.getAbsolutePath();

		try {
			FileReader fileR = new FileReader(
					currentPath + "\\src\\main\\java\\br\\edu\\infnet\\appmusic\\model\\tests\\midias.txt");
			BufferedReader reader = new BufferedReader(fileR);

			FileWriter fileW = new FileWriter(
					currentPath + "\\src\\main\\java\\br\\edu\\infnet\\appmusic\\model\\tests\\out_midias.txt");
			BufferedWriter writer = new BufferedWriter(fileW);

			String line = reader.readLine();
			String[] fields = null;

			List<Midia> midias = new ArrayList<Midia>();
			Produtora produtora = null;

			while (line != null) {

				System.out.println(line);

				fields = line.split(";");

				switch (fields[0].toUpperCase()) {

				case "P":
					try {
						produtora = new Produtora(new Artista(fields[4], Integer.parseInt(fields[5]), fields[6]),
								midias);
						produtora.setNome(fields[1]);
						produtora.setPais(fields[2]);
						produtora.setAnoDeCriacao(Integer.parseInt(fields[3]));
						writer.write(produtora.construirLinha());
					} catch (ProdutoraSemArtistaException | ProdutoraSemMidiaException | NumberFormatException
							| ArtistaInvalidoException | IOException e) {
						System.out.println("[ERRO] " + e.getMessage());
					}
					break;
					
				case "A":
					try {
						Artista artista = new Artista(fields[1], Integer.parseInt(fields[2]), fields[3]);
						writer.write(artista.construirLinha());
					} catch (ArtistaInvalidoException | IOException e) {
						System.out.println("[ERRO] " + e.getMessage());
					}
					break;
				
				case "C":
					try {
						Clipe clipe = new Clipe(fields[1],Integer.parseInt(fields[2]),Integer.parseInt(fields[3]),fields[4],fields[5]);
						writer.write(clipe.construirLinha());
					} catch(MidiaNomeVazioException | MidiaDuracaoInvalidaException | MidiaAnoVazioException | ClipeInvalidoException | IOException e) {
						System.out.println("[ERRO] " + e.getMessage());
					}
					break;
				case "S":
					try {
						ShowGravado show = new ShowGravado(fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]),fields[4],Integer.parseInt(fields[3]));
						writer.write(show.construirLinha());
					} catch (MidiaNomeVazioException | MidiaDuracaoInvalidaException | MidiaAnoVazioException | ShowGravadoInvalidoException | IOException e) {
						System.out.println("[ERRO] " + e.getMessage());
					}
					break;
				case "L":
					try {
						Album album = new Album(fields[1], Float.parseFloat(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), fields[5]);
						writer.write(album.construirLinha());
					} catch (MidiaNomeVazioException | MidiaDuracaoInvalidaException | MidiaAnoVazioException |
							AlbumInvalidoException | IOException e) {
						System.out.println("[ERRO] " + e.getMessage());
					}
				}
				
				line = reader.readLine();
			}

			//writer.write(produtora.construirLinha());

			writer.close();
			reader.close();
			fileR.close();

		} catch (IOException e) {
			System.out.println("[ERRO] " + e.getMessage());
		} finally {
			System.out.println("Processo de leitura e escrita do arquivo finalizadado.");
		}
	}
}
