package br.edu.infnet.appmusic.model.domain;

public class Usuario {
	String nome;
	String email;
	String senha;
	
	public Usuario() {
		
	}
	
	public Usuario(String nome, String email) {
		this();
		this.nome = nome;
		this.email = email;
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
	
	@Override
	public String toString() {
		
	return String.format(
		"O usuario tem o nome %s e as credenciais %s e %s.",
		nome, email, senha
		);
	}
	
}
