package br.edu.infnet.appmusic.model.tests;

import br.edu.infnet.appmusic.model.domain.Artista;
import br.edu.infnet.appmusic.model.exceptions.ArtistaInvalidoException;

public class ArtistaTest {

	public static void main(String[] args) {
		
		try {
			Artista artista1 = new Artista("Iron Maiden", 1975, "banda", true);
			System.out.println(artista1.toString());
		} catch (ArtistaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Artista artista2 = new Artista("Iron Maiden", -1, "banda", true);
			System.out.println(artista2.toString());
		} catch (ArtistaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Artista artista3 = new Artista("Iron Maiden", 1975, null, true);
			System.out.println(artista3.toString());
		} catch (ArtistaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}
