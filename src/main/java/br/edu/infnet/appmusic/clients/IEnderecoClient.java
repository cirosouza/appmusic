package br.edu.infnet.appmusic.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appmusic.model.domain.Endereco;

@FeignClient(url="http://viacep.com.br/ws", name="enderecoClient")
public interface IEnderecoClient {

	@GetMapping(value = "/{cep}/json")
	public Endereco buscaPorCep(@PathVariable String cep);
	
 }
