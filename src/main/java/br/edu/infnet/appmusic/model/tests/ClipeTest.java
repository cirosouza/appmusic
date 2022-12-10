package br.edu.infnet.appmusic.model.tests;

import br.edu.infnet.appmusic.model.domain.Clipe;
import br.edu.infnet.appmusic.model.exceptions.ClipeInvalidoException;
import br.edu.infnet.appmusic.model.exceptions.MidiaAnoVazioException;
import br.edu.infnet.appmusic.model.exceptions.MidiaDuracaoInvalidaException;
import br.edu.infnet.appmusic.model.exceptions.MidiaNomeVazioException;

public class ClipeTest {
	
	public static void main(String[] args) {
		
		try {
			Clipe clipe1 = new Clipe("The Writing On The Wall", 8, 2021,"Nicos Livesey", "https://www.youtube.com/watch?v=FhBnW7bZHEE");
			System.out.println(clipe1);
			System.out.println("Custo de produção = R$" + clipe1.calcularCustoDeProducao());
		} catch (MidiaNomeVazioException | MidiaDuracaoInvalidaException | MidiaAnoVazioException | ClipeInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Clipe clipe2 = new Clipe(null, 8, 2021,"Nicos Livesey", "https://www.youtube.com/watch?v=FhBnW7bZHEE");
			System.out.println(clipe2);
			System.out.println("Custo de produção = R$" + clipe2.calcularCustoDeProducao());
		} catch (MidiaNomeVazioException | MidiaDuracaoInvalidaException | MidiaAnoVazioException | ClipeInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Clipe clipe3 = new Clipe("The Writing On The Wall", -1, 2021,"Nicos Livesey", "https://www.youtube.com/watch?v=FhBnW7bZHEE");
			System.out.println(clipe3);
			System.out.println("Custo de produção = R$" + clipe3.calcularCustoDeProducao());
		} catch (MidiaNomeVazioException | MidiaDuracaoInvalidaException | MidiaAnoVazioException | ClipeInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}
