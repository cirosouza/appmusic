package br.edu.infnet.appmusic.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.edu.infnet.appmusic.model.exceptions.ProdutoraSemArtistaException;
import br.edu.infnet.appmusic.model.exceptions.ProdutoraSemMidiaException;

@Entity
public class Produtora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String pais;
	private int anoDeCriacao;
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idArtista")
	private Artista artista;
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Midia> midias;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	public Produtora() {
	}

	public Produtora(Artista artista, List<Midia> midias)
			throws ProdutoraSemArtistaException, ProdutoraSemMidiaException {

		if (artista == null) {
			throw new ProdutoraSemArtistaException("Não existe nenhum artista associado à Produtora!");
		}

		if (midias == null) {
			throw new ProdutoraSemMidiaException("Não existe nenhuma mídia associado à Produtora!");
		}

		this.artista = artista;
		this.midias = midias;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getAnoDeCriacao() {
		return anoDeCriacao;
	}

	public void setAnoDeCriacao(int anoDeCriacao) {
		this.anoDeCriacao = anoDeCriacao;
	}

	public Artista getArtista() {
		return artista;
	}

	public List<Midia> getMidias() {
		return midias;
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

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public void setMidias(List<Midia> midias) {
		this.midias = midias;
	}

	@Override
	public String toString() {

		return String.format("%s;%s;%s;%s;%s", this.getNome(), this.getPais(), this.getAnoDeCriacao(),
				this.getArtista().getNome(), this.getMidias().size());

	}

	public String construirLinha() {

		StringBuilder sb = new StringBuilder();

		sb.append(this.getNome());
		sb.append(";");
		sb.append(this.getArtista().getNome());
		sb.append(";");
		sb.append(this.getMidias().size());
		sb.append("\r\n");

		return sb.toString();
	}

	public void imprimir() {
		System.out.println("Nome: " + this.getNome());
		System.out.println("Pais: " + this.getPais());
		System.out.println("Ano de criacao: " + this.getAnoDeCriacao());
		System.out.println("Artista: " + this.getArtista().getNome());
		System.out.println("Midias: ");
		for (Midia m : midias) {
			System.out.println("- " + m.getNome());
		}
	}

}
