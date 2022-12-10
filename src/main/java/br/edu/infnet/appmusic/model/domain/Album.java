package br.edu.infnet.appmusic.model.domain;

import br.edu.infnet.appmusic.model.exceptions.AlbumInvalidoException;
import br.edu.infnet.appmusic.model.exceptions.MidiaAnoVazioException;
import br.edu.infnet.appmusic.model.exceptions.MidiaDuracaoInvalidaException;
import br.edu.infnet.appmusic.model.exceptions.MidiaNomeVazioException;

public class Album extends Midia {

	private int numeroDeMusicas;
	private String tipo;

	public Album(String nome, float duracao, int anoDeGravacao, int numeroDeMusicas, String tipo)
			throws MidiaNomeVazioException, MidiaDuracaoInvalidaException, MidiaAnoVazioException,
			AlbumInvalidoException {
		super(nome, duracao, anoDeGravacao);

		if (numeroDeMusicas == 0) {
			throw new AlbumInvalidoException("Não há musicas associadas ao album!");
		}

		if (numeroDeMusicas < 0) {
			throw new AlbumInvalidoException("O numero de musicas esta negativo!");
		}

		if (tipo == null) {
			throw new AlbumInvalidoException("Não há tipo associado ao album");
		}

		this.setNumeroDeMusicas(numeroDeMusicas);
		this.setTipo(tipo);
	}

	public int getNumeroDeMusicas() {
		return numeroDeMusicas;
	}

	private void setNumeroDeMusicas(int numeroDeMusicas) {
		this.numeroDeMusicas = numeroDeMusicas;
	}

	public String getTipo() {
		return tipo;
	}

	private void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public float calcularCustoDeProducao() {
		return this.getNumeroDeMusicas() * 10000;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.getTipo());
		sb.append(";");
		sb.append(this.getNumeroDeMusicas());

		return sb.toString();
	}

	public String construirLinha() {

		StringBuilder sb = new StringBuilder();

		sb.append(this.toString());
		sb.append("\r\n");

		return sb.toString();
	}
}
