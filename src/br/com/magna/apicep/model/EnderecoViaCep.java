package br.com.magna.apicep.model;

public record EnderecoViaCep(String cep,
		String logradouro, 
		String complemento, 
		String bairro, 
		String localidade, 
		String uf, 
		String ddd) {

}
