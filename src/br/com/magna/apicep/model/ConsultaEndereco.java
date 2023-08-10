package br.com.magna.apicep.model;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class ConsultaEndereco {
	
	public EnderecoViaCep buscaEndereco(String cep) {
		
		String url = "https://viacep.com.br/ws/" + cep + "/json/";
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest
				.newBuilder()
				.uri(URI.create(url))
				.build();
		
		HttpResponse<String> response;
		try {
			response = HttpClient
					.newHttpClient()
					.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException("Não consegui obter o endereço a partir do CEP.");
		}
		
		return new Gson().fromJson(response.body(), EnderecoViaCep.class);
	}

}
