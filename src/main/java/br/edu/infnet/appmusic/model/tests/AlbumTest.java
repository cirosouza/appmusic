package br.edu.infnet.appmusic.model.tests;

import br.edu.infnet.appmusic.model.domain.Album;
import br.edu.infnet.appmusic.model.exceptions.AlbumInvalidoException;
import br.edu.infnet.appmusic.model.exceptions.MidiaAnoVazioException;
import br.edu.infnet.appmusic.model.exceptions.MidiaDuracaoInvalidaException;
import br.edu.infnet.appmusic.model.exceptions.MidiaNomeVazioException;

public class AlbumTest {
	public static void main(String[] args) {

		try {
			Album album1 = new Album ("Powerslave", 51, 1984, 8, "LP", 7);
			System.out.println(album1);
			System.out.println("Custo de produção = R$" + album1.calcularCustoDeProducao());
		} catch (MidiaNomeVazioException | MidiaDuracaoInvalidaException | MidiaAnoVazioException | AlbumInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Album album1 = new Album (null, 51, 1984, 8, "LP",7);
			System.out.println(album1);
			System.out.println("Custo de produção = R$" + album1.calcularCustoDeProducao());
		} catch (MidiaNomeVazioException | MidiaDuracaoInvalidaException | MidiaAnoVazioException | AlbumInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Album album1 = new Album ("Piece of Mind", 51, 1984, -5, "LP",7);
			System.out.println(album1);
			System.out.println("Custo de produção = R$" + album1.calcularCustoDeProducao());
		} catch (MidiaNomeVazioException | MidiaDuracaoInvalidaException | MidiaAnoVazioException | AlbumInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

	}
}
