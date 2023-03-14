package br.edu.infnet.appmusic.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	@OneToMany
	@JoinColumn(name="idUsuario")
	private List<Artista> artistas;

	public Usuario() {

	}

	public Usuario(String email, String senha) {
		this();
		this.email = email;
		this.senha = senha;
	}

	public Usuario(String nome, String email, String senha) {
		this(email, senha);
		this.setNome(nome);

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public List<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	@Override
	public String toString() {

		return String.format("O usuario tem o nome %s e as credenciais %s e %s.", nome, email, senha);
	}

}
