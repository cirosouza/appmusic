package br.edu.infnet.appmusic.model.domain;

import br.edu.infnet.appmusic.model.auxiliar.Constants;
import br.edu.infnet.appmusic.model.exceptions.MidiaAnoVazioException;
import br.edu.infnet.appmusic.model.exceptions.MidiaDuracaoInvalidaException;
import br.edu.infnet.appmusic.model.exceptions.MidiaNomeVazioException;
import br.edu.infnet.appmusic.model.exceptions.ShowGravadoInvalidoException;

public class ShowGravado extends Midia {

	private String localDeGravacao;
	private int numeroDeMusicasPerformadas;
	private String producao;

	public ShowGravado(String nome, float duracao, int anoDeGravacao, String localDeGravacao,
			int numeroDeMusicasPerformadas, String producao) throws MidiaNomeVazioException,
			MidiaDuracaoInvalidaException, MidiaAnoVazioException, ShowGravadoInvalidoException {
		super(nome, duracao, anoDeGravacao);

		if (localDeGravacao == null) {
			throw new ShowGravadoInvalidoException("Não há local de gravacao associado ao show gravado!");
		}

		if (numeroDeMusicasPerformadas == 0) {
			throw new ShowGravadoInvalidoException("O numero de musicas performadas no show é inválido!");
		}

		if (producao == null) {
			throw new ShowGravadoInvalidoException("Não há produtor associado ao show gravado!");
		}

		this.setLocalDeGravacao(localDeGravacao);
		this.setNumeroDeMusicasPerformadas(numeroDeMusicasPerformadas);
		this.setProducao(producao);
	}

	public void setLocalDeGravacao(String localDeGravacao) {
		this.localDeGravacao = localDeGravacao;
	}

	public void setNumeroDeMusicasPerformadas(int numeroDeMusicasPerformadas) {
		this.numeroDeMusicasPerformadas = numeroDeMusicasPerformadas;
	}

	public String getLocalDeGravacao() {
		return localDeGravacao;
	}

	public int getNumeroDeMusicasPerformadas() {
		return numeroDeMusicasPerformadas;
	}

	public String getProducao() {
		return producao;
	}

	public void setProducao(String producao) {
		this.producao = producao;
	}

	@Override
	public float calcularCustoDeProducao() {
		return this.getNumeroDeMusicasPerformadas() * Constants.PRECO_FILMAGEM_MUSICA + this.getDuracao() * 1000;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.getLocalDeGravacao());
		sb.append(";");
		sb.append(this.getNumeroDeMusicasPerformadas());
		sb.append(";");
		sb.append(this.getProducao());

		return sb.toString();
	}

	public String construirLinha() {
		StringBuilder sb = new StringBuilder();

		sb.append(this.toString());
		sb.append("\r\n");

		return sb.toString();
	}

}
