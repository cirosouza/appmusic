package br.edu.infnet.appmusic.model.domain;

import javax.persistence.Entity;

import br.edu.infnet.appmusic.model.auxiliar.Constants;
import br.edu.infnet.appmusic.model.exceptions.ClipeInvalidoException;
import br.edu.infnet.appmusic.model.exceptions.MidiaAnoVazioException;
import br.edu.infnet.appmusic.model.exceptions.MidiaDuracaoInvalidaException;
import br.edu.infnet.appmusic.model.exceptions.MidiaNomeVazioException;

@Entity
public class Clipe extends Midia {

	private String diretor;
	private String linkVideo;
	private int numeroDeAtoresFigurantes;

	public Clipe() {
		super();
	}

	
	public Clipe(String nome, float duracao, int anoDeGravacao, String diretor, String linkVideo,
			int numeroDeAtoresFigurantes) throws MidiaNomeVazioException, MidiaDuracaoInvalidaException,
			MidiaAnoVazioException, ClipeInvalidoException {
		super(nome, duracao, anoDeGravacao);

		if (diretor == null) {
			throw new ClipeInvalidoException("Não há diretor associado ao clipe musical!");
		}

		if (linkVideo == null) {
			throw new ClipeInvalidoException("Não há link associado ao clipe musical!");
		}

		if (numeroDeAtoresFigurantes < 0) {
			throw new ClipeInvalidoException("O numero de atores figurantes e invalido!");
		}

		this.setDiretor(diretor);
		this.setLinkVideo(linkVideo);
		this.setNumeroDeAtoresFigurantes(numeroDeAtoresFigurantes);
	}

	@Override
	public float calcularCustoDeProducao() {
		return this.getDuracao() * 20000 + numeroDeAtoresFigurantes * Constants.PRECO_FIGURANTE;
	}

	public String getLinkVideo() {
		return linkVideo;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public void setLinkVideo(String linkVideo) {
		this.linkVideo = linkVideo;
	}

	public int getNumeroDeAtoresFigurantes() {
		return numeroDeAtoresFigurantes;
	}

	public void setNumeroDeAtoresFigurantes(int numeroDeAtoresFigurantes) {
		this.numeroDeAtoresFigurantes = numeroDeAtoresFigurantes;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.getDiretor());
		sb.append(";");
		sb.append(this.getLinkVideo());
		sb.append(";");
		sb.append(this.getNumeroDeAtoresFigurantes());

		return sb.toString();
	}

	public String construirLinha() {
		StringBuilder sb = new StringBuilder();

		sb.append(this.toString());
		sb.append("\r\n");

		return sb.toString();
	}



}
