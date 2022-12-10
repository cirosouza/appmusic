package br.edu.infnet.appmusic.model.domain;

import br.edu.infnet.appmusic.model.exceptions.MidiaAnoVazioException;
import br.edu.infnet.appmusic.model.exceptions.MidiaDuracaoInvalidaException;
import br.edu.infnet.appmusic.model.exceptions.MidiaNomeVazioException;

public abstract class Midia {

	private String nome;
	private float duracao;
	private int anoDeGravacao;

	public Midia(String nome, float duracao, int anoDeGravacao)
			throws MidiaNomeVazioException, MidiaDuracaoInvalidaException, MidiaAnoVazioException {

		if (nome == null) {
			throw new MidiaNomeVazioException("Não há nome associado à mídia!");
		}

		if (duracao == 0 || duracao < 0) {
			throw new MidiaDuracaoInvalidaException("O valor oferecido para a duracao é inválido!");
		}

		if (anoDeGravacao == 0) {
			throw new MidiaAnoVazioException("Não há ano de gravação associado à mídia!");
		}

		this.nome = nome;
		this.duracao = duracao;
		this.anoDeGravacao = anoDeGravacao;
	}

	public String getNome() {
		return nome;
	}

	public float getDuracao() {
		return duracao;
	}

	public int getAnoDeGravacao() {
		return anoDeGravacao;
	}
	
	public abstract float calcularCustoDeProducao();
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(";");
		sb.append(duracao);
		sb.append(";");
		sb.append(anoDeGravacao);

		return sb.toString();
	}
}
