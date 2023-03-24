package br.edu.infnet.appmusic.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.edu.infnet.appmusic.model.exceptions.MidiaAnoVazioException;
import br.edu.infnet.appmusic.model.exceptions.MidiaDuracaoInvalidaException;
import br.edu.infnet.appmusic.model.exceptions.MidiaNomeVazioException;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Midia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private float duracao;
	private int anoDeGravacao;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@ManyToMany(mappedBy = "midias")
	private List<Produtora> produtoras;

	public Midia() {

	}

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDuracao(float duracao) {
		this.duracao = duracao;
	}

	public void setAnoDeGravacao(int anoDeGravacao) {
		this.anoDeGravacao = anoDeGravacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Produtora> getProdutoras() {
		return produtoras;
	}

	public void setProdutoras(List<Produtora> produtoras) {
		this.produtoras = produtoras;
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
