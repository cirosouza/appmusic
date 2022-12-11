package br.edu.infnet.appmusic.model.tests;

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

public class ProdutoraTest {

	public static void main(String[] args) {
		List<Midia> midias1 = new ArrayList<Midia>();
		Artista artista1 = null;
		Midia clipe1 = null;
		Midia album1 = null;
		Midia show1 = null;
		
		try {
			artista1 = new Artista("Iron Maiden", 1975, "banda", true);
			
		} catch (ArtistaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			clipe1 = new Clipe("The Writing On The Wall", 8, 2021,"Nicos Livesey", "https://www.youtube.com/watch?v=FhBnW7bZHEE",0);
			midias1.add(clipe1);
		} catch (MidiaNomeVazioException | MidiaDuracaoInvalidaException | MidiaAnoVazioException
				| ClipeInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			album1 = new Album ("Powerslave", 51, 1984, 8, "LP",7);
			midias1.add(album1);
		} catch (MidiaNomeVazioException | MidiaDuracaoInvalidaException | MidiaAnoVazioException | AlbumInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			show1 = new ShowGravado("Iron Maiden Rock in Rio", 120, 2002, "Rio de Janeiro", 19, "Kevin Shirley");
			midias1.add(show1);
		} catch (MidiaNomeVazioException | MidiaDuracaoInvalidaException | MidiaAnoVazioException | ShowGravadoInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Produtora produtora = new Produtora(artista1, midias1);
			produtora.setNome("EMI");
			produtora.setPais("Inglaterra");
			produtora.setAnoDeCriacao(1931);
			produtora.imprimir();
			System.out.println(produtora.toString());
		} catch (ProdutoraSemArtistaException | ProdutoraSemMidiaException | NumberFormatException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Produtora produtora = new Produtora(null, midias1);
			produtora.setNome("EMI");
			produtora.setPais("Inglaterra");
			produtora.setAnoDeCriacao(1931);
			produtora.imprimir();
			System.out.println(produtora.toString());
		} catch (ProdutoraSemArtistaException | ProdutoraSemMidiaException | NumberFormatException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

	}

}
