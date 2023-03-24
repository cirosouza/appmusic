package br.edu.infnet.appmusic.model.domain;

import javax.persistence.Entity;

import br.edu.infnet.appmusic.model.auxiliar.Constants;
import br.edu.infnet.appmusic.model.exceptions.AlbumInvalidoException;
import br.edu.infnet.appmusic.model.exceptions.MidiaAnoVazioException;
import br.edu.infnet.appmusic.model.exceptions.MidiaDuracaoInvalidaException;
import br.edu.infnet.appmusic.model.exceptions.MidiaNomeVazioException;

@Entity
public class Album extends Midia {

	private int numeroDeMusicas;
	private String tipo;
	private int tempoConteudoBonus;


	public Album() {
		super();
	}

	public Album(String nome, float duracao, int anoDeGravacao, int numeroDeMusicas, String tipo,
			int tempoConteudoBonus) throws MidiaNomeVazioException, MidiaDuracaoInvalidaException,
			MidiaAnoVazioException, AlbumInvalidoException {
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
		this.setTempoConteudoBonus(tempoConteudoBonus);
	}

	public int getNumeroDeMusicas() {
		return numeroDeMusicas;
	}

	public void setNumeroDeMusicas(int numeroDeMusicas) {
		this.numeroDeMusicas = numeroDeMusicas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getTempoConteudoBonus() {
		return tempoConteudoBonus;
	}

	public void setTempoConteudoBonus(int tempoConteudoBonus) {
		this.tempoConteudoBonus = tempoConteudoBonus;
	}

	@Override
	public float calcularCustoDeProducao() {
		return this.getNumeroDeMusicas() * Constants.PRECO_GRAVACAO_MUSICA + this.getDuracao() > 50 ? 10000 : 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.getTipo());
		sb.append(";");
		sb.append(this.getNumeroDeMusicas());
		sb.append(";");
		sb.append(this.getTempoConteudoBonus());

		return sb.toString();
	}

	public String construirLinha() {

		StringBuilder sb = new StringBuilder();

		sb.append(this.toString());
		sb.append("\r\n");

		return sb.toString();
	}

}
