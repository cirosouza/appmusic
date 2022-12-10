package br.edu.infnet.appmusic.model.tests;

import br.edu.infnet.appmusic.model.domain.Album;
import br.edu.infnet.appmusic.model.domain.Clipe;
import br.edu.infnet.appmusic.model.domain.Midia;
import br.edu.infnet.appmusic.model.domain.ShowGravado;
import br.edu.infnet.appmusic.model.exceptions.AlbumInvalidoException;
import br.edu.infnet.appmusic.model.exceptions.ClipeInvalidoException;
import br.edu.infnet.appmusic.model.exceptions.MidiaAnoVazioException;
import br.edu.infnet.appmusic.model.exceptions.MidiaDuracaoInvalidaException;
import br.edu.infnet.appmusic.model.exceptions.MidiaNomeVazioException;
import br.edu.infnet.appmusic.model.exceptions.ShowGravadoInvalidoException;

public class MidiaTest {

	public static void main(String[] args) {
		
		try {
			Midia midia1 = new Clipe("The Writing On The Wall", 8, 2021,"Nicos Livesey", "https://www.youtube.com/watch?v=FhBnW7bZHEE");
			System.out.println(midia1);
			System.out.println("Custo de produção = R$" + midia1.calcularCustoDeProducao());
		} catch (MidiaNomeVazioException | MidiaDuracaoInvalidaException | MidiaAnoVazioException | ClipeInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage()); 
		}
		
		try {
			Midia midia2 = new ShowGravado("Iron Maiden Rock in Rio", 120, 2002, "Rio de Janeiro", 19);
			System.out.println(midia2);
			System.out.println("Custo de produção = R$" + midia2.calcularCustoDeProducao());
		} catch (MidiaNomeVazioException | MidiaDuracaoInvalidaException | MidiaAnoVazioException | ShowGravadoInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage()); 
		}
		
		try {
			Midia midia3 = new Album ("Powerslave", 51, 1984, 8, "LP");
			System.out.println(midia3);
			System.out.println("Custo de produção = R$" + midia3.calcularCustoDeProducao());
		} catch (MidiaNomeVazioException | MidiaDuracaoInvalidaException | MidiaAnoVazioException | AlbumInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage()); 
		}
	}
}
