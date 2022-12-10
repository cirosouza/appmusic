package br.edu.infnet.appmusic.model.domain;

import br.edu.infnet.appmusic.model.exceptions.ClipeInvalidoException;
import br.edu.infnet.appmusic.model.exceptions.MidiaAnoVazioException;
import br.edu.infnet.appmusic.model.exceptions.MidiaDuracaoInvalidaException;
import br.edu.infnet.appmusic.model.exceptions.MidiaNomeVazioException;

public class Clipe extends Midia {

	private String diretor;
	private String linkVideo;

	public Clipe(String nome, float duracao, int anoDeGravacao, String diretor, String linkVideo)
			throws MidiaNomeVazioException, MidiaDuracaoInvalidaException, MidiaAnoVazioException, ClipeInvalidoException {
		super(nome, duracao, anoDeGravacao);

		if (diretor == null) {
			throw new ClipeInvalidoException("Não há diretor associado ao clipe musical!");
		}
		
		if (linkVideo == null) {
			throw new ClipeInvalidoException("Não há link associado ao clipe musical!");
		}

		this.diretor = diretor;
		this.linkVideo = linkVideo;
	}

	@Override
	public float calcularCustoDeProducao() {
		return this.getDuracao() * 20000;
	}

	public String getLinkVideo() {
		return linkVideo;
	}

	public String getDiretor() {
		return diretor;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.getDiretor());
		sb.append(";");
		sb.append(this.getLinkVideo());
		
		return sb.toString();
	}

	public String construirLinha() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.toString());
		sb.append("\r\n");
		
		return sb.toString();
	}

}
