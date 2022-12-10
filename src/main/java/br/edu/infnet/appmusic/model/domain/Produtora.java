package br.edu.infnet.appmusic.model.domain;

import java.util.List;

import br.edu.infnet.appmusic.model.exceptions.ProdutoraSemArtistaException;
import br.edu.infnet.appmusic.model.exceptions.ProdutoraSemMidiaException;

public class Produtora {

	private String nome;
	private String pais;
	private int anoDeCriacao;
	private Artista artista;
	private List<Midia> midias;

	public Produtora(Artista artista, List<Midia> midias)
			throws ProdutoraSemArtistaException, ProdutoraSemMidiaException {

		if (artista == null) {
			throw new ProdutoraSemArtistaException("Não existe nenhum artista associado à Produtora!");
		}

		if (midias == null) {
			throw new ProdutoraSemMidiaException("Não existe nenhuma mídia associado à Produtora!");
		}

		this.artista = artista;
		this.midias = midias;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getAnoDeCriacao() {
		return anoDeCriacao;
	}

	public void setAnoDeCriacao(int anoDeCriacao) {
		this.anoDeCriacao = anoDeCriacao;
	}

	public Artista getArtista() {
		return artista;
	}

	public List<Midia> getMidias() {
		return midias;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.getNome());
		sb.append(";");
		sb.append(this.getPais());
		sb.append(";");
		sb.append(this.getAnoDeCriacao());
		sb.append(";");
		sb.append(this.getArtista());
		sb.append(";");
		sb.append(this.getMidias().size());
		
		return sb.toString();
	}
	
	public String construirLinha() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.toString());
		sb.append("\r\n");
		
		return sb.toString();
	}
	
	public void imprimir() {
		System.out.println("Nome: " + this.getNome());
		System.out.println("Pais: " + this.getPais());
		System.out.println("Ano de criacao: " + this.getAnoDeCriacao());
		System.out.println("Artista: " + this.getArtista().getNome());
		System.out.println("Midias: ");
		for (Midia m : midias) {
			System.out.println("- " + m.getNome());
		}
	}

}
