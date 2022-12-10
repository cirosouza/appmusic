package br.edu.infnet.appmusic.model.tests;

import br.edu.infnet.appmusic.model.domain.ShowGravado;
import br.edu.infnet.appmusic.model.exceptions.MidiaAnoVazioException;
import br.edu.infnet.appmusic.model.exceptions.MidiaDuracaoInvalidaException;
import br.edu.infnet.appmusic.model.exceptions.MidiaNomeVazioException;
import br.edu.infnet.appmusic.model.exceptions.ShowGravadoInvalidoException;

public class ShowGravadoTest {

	public static void main(String[] args) {
		try {
			ShowGravado show1 = new ShowGravado("Iron Maiden Rock in Rio", 120, 2002, "Rio de Janeiro", 19);
			System.out.println(show1);
			System.out.println("Custo de produção = R$" + show1.calcularCustoDeProducao());
		} catch (MidiaNomeVazioException | MidiaDuracaoInvalidaException | MidiaAnoVazioException | ShowGravadoInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			ShowGravado show2 = new ShowGravado(null, 120, 2002, "Rio de Janeiro", 19);
			System.out.println(show2);
			System.out.println("Custo de produção = R$" + show2.calcularCustoDeProducao());
		} catch (MidiaNomeVazioException | MidiaDuracaoInvalidaException | MidiaAnoVazioException | ShowGravadoInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			ShowGravado show3 = new ShowGravado("Iron Maiden Rock in Rio", 120, 2002, null, 19);
			System.out.println(show3);
			System.out.println("Custo de produção = R$" + show3.calcularCustoDeProducao());
		} catch (MidiaNomeVazioException | MidiaDuracaoInvalidaException | MidiaAnoVazioException | ShowGravadoInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}

}
