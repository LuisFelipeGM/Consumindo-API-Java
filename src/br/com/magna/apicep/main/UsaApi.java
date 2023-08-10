package br.com.magna.apicep.main;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.magna.apicep.model.ConsultaEndereco;
import br.com.magna.apicep.model.Endereco;
import br.com.magna.apicep.model.EnderecoViaCep;

public class UsaApi {

	public static void main(String[] args) throws IOException {

		Scanner leitura = new Scanner(System.in);
		String busca = "";
		List<Endereco> enderecos = new ArrayList<>();
		ConsultaEndereco consultaCep = new ConsultaEndereco();
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting()
				.create();

		while (true) {

			busca = JOptionPane.showInputDialog("*Digite o CEP:\nSe deseja finalizar e criar o JSON digite (SAIR) ou clique no cancelar*");

		    if (busca == null || busca.equalsIgnoreCase("sair")) {
		        break;
		    }

			try {
				EnderecoViaCep endViaCep = consultaCep.buscaEndereco(busca);
				Endereco end = new Endereco(endViaCep);
				JOptionPane.showMessageDialog(null, end);
				enderecos.add(end);
			} catch (IllegalArgumentException e) {
				System.out.println("Algum erro de argumento na busca, verifique o endereço");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		System.out.println(enderecos);
		FileWriter escrita = new FileWriter("enderecos.json");
		escrita.write(gson.toJson(enderecos));
		escrita.close();
		JOptionPane.showMessageDialog(null, "Arquivo JSON gerado!\nPrograma finalizado com sucesso");

	}

}
