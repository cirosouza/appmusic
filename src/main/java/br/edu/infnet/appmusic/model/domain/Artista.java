package br.edu.infnet.appmusic.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.infnet.appmusic.model.exceptions.ArtistaInvalidoException;

@Entity
public class Artista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private int anoDeOrigem;
	private String tipo;
	private boolean ativo;
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Artista() {

	}

	public Artista(String nome, int anoDeOrigem, String tipo, Boolean ativo) throws ArtistaInvalidoException {

		if (nome == null) {
			throw new ArtistaInvalidoException("O nome do artista deve ser preenchido!");
		}

		if (anoDeOrigem == 0 | anoDeOrigem < 0) {
			throw new ArtistaInvalidoException("O ano de origem do artista deve ter um valor valido!");
		}

		if (tipo == null) {
			throw new ArtistaInvalidoException("O tipo do artista deve ser preenchido!");
		}
		this.nome = nome;
		this.anoDeOrigem = anoDeOrigem;
		this.tipo = tipo;
		this.ativo = ativo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setAnoDeOrigem(int anoDeOrigem) {
		this.anoDeOrigem = anoDeOrigem;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getNome() {
		return nome;
	}

	public int getAnoDeOrigem() {
		return anoDeOrigem;
	}

	public String getTipo() {
		return tipo;
	}

	public String isAtivo() {
		if (this.ativo) {
			return "Sim";
		}
		return "Não";

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nome);
		sb.append(":");
		sb.append(this.anoDeOrigem);
		sb.append(";");
		sb.append(tipo);
		sb.append(ativo ? "Ativo" : "Inativo");

		return sb.toString();

	}

	public String construirLinha() {

		StringBuilder sb = new StringBuilder();

		sb.append(this.toString());
		sb.append("\r\n");

		return sb.toString();
	}

}
