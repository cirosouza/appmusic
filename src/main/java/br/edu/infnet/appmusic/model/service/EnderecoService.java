package br.edu.infnet.appmusic.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmusic.clients.IEnderecoClient;
import br.edu.infnet.appmusic.model.domain.Endereco;

@Service
public class EnderecoService {

	@Autowired
	private IEnderecoClient enderecoClient;

	public Endereco buscaPorCep(String cep) {

		return enderecoClient.buscaPorCep(cep);
	}
}
