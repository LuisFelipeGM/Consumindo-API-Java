package br.com.magna.apicep.model;

public class Endereco {

	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String ddd;

	public Endereco() {
	}

	public Endereco(EnderecoViaCep endViaCep) {
		this.cep = endViaCep.cep();
		this.logradouro = endViaCep.logradouro();
		this.complemento = endViaCep.complemento();
		this.bairro = endViaCep.bairro();
		this.cidade = endViaCep.localidade();
		this.estado = endViaCep.uf();
		this.ddd = endViaCep.ddd();
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	
	@Override
	public String toString() {
		return "CEP: " + cep + "\nLogradouro: " + logradouro +
				"\nComplemento: " + complemento + "\nBairro: " +
				bairro + "\nCidade: " + cidade + "\nEstado: " +
				estado + "\nDDD: " + ddd;
	}

}
