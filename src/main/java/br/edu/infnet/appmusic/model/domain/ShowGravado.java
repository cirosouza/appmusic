package br.edu.infnet.appmusic.model.domain;

import br.edu.infnet.appmusic.model.exceptions.MidiaAnoVazioException;
import br.edu.infnet.appmusic.model.exceptions.MidiaDuracaoInvalidaException;
import br.edu.infnet.appmusic.model.exceptions.MidiaNomeVazioException;
import br.edu.infnet.appmusic.model.exceptions.ShowGravadoInvalidoException;

public class ShowGravado extends Midia {

	public ShowGravado(String nome, float duracao, int anoDeGravacao, String localDeGravacao,
			int numeroDeMusicasPerformadas)
			throws MidiaNomeVazioException, MidiaDuracaoInvalidaException, MidiaAnoVazioException, ShowGravadoInvalidoException  {
		super(nome, duracao, anoDeGravacao);
		
		if (localDeGravacao == null) {
			throw new ShowGravadoInvalidoException("Não há local de gravacao associado ao show gravado!");
		}
		
		if(numeroDeMusicasPerformadas == 0) {
			throw new ShowGravadoInvalidoException("O numero de musicas performadas no show é inválido!");
		}

		this.localDeGravacao = localDeGravacao;
		this.numeroDeMusicasPerformadas = numeroDeMusicasPerformadas;
	}

	private String localDeGravacao;
	private int numeroDeMusicasPerformadas;

	@Override
	public float calcularCustoDeProducao() {
		return this.getNumeroDeMusicasPerformadas() * 5000 + this.getDuracao() * 1000;
	}

	public String getLocalDeGravacao() {
		return localDeGravacao;
	}

	public int getNumeroDeMusicasPerformadas() {
		return numeroDeMusicasPerformadas;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.getLocalDeGravacao());
		sb.append(";");
		sb.append(this.getNumeroDeMusicasPerformadas());
		
		return sb.toString();
	}

	public String construirLinha() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.toString());
		sb.append("\r\n");
		
		return sb.toString();
	}
}
