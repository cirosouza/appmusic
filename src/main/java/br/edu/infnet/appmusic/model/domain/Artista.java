package br.edu.infnet.appmusic.model.domain;

import br.edu.infnet.appmusic.model.exceptions.ArtistaInvalidoException;

public class Artista {

	private String nome;
	private int anoDeOrigem;
	private String tipo;
			
	public Artista(String nome, int anoDeOrigem, String tipo) throws ArtistaInvalidoException {
		
		if(nome == null) {
			throw new ArtistaInvalidoException("O nome do artista deve ser preenchido!");
		}
		
		if(anoDeOrigem == 0 | anoDeOrigem < 0) {
			throw new ArtistaInvalidoException("O ano de origem do artista deve ter um valor valido!");
		}
		
		if(tipo == null) {
			throw new ArtistaInvalidoException("O tipo do artista deve ser preenchido!");
		}
		this.nome = nome;
		this.anoDeOrigem = anoDeOrigem;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoDeOrigem() {
		return anoDeOrigem;
	}

	public void setAnoDeOrigem(int anoDeOrigem) {
		this.anoDeOrigem = anoDeOrigem;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nome);
		sb.append(":");
		sb.append(this.anoDeOrigem);
		sb.append(";");
		sb.append(tipo);
		
		return sb.toString();
		
	}
	
	public String construirLinha() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.toString());
		sb.append("\r\n");
		
		return sb.toString();
	}
}
