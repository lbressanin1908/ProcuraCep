package org.aplicacao.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.aplicacao.DTO.EnderecoDto;

public class APIService {

    EnderecoDto enderecoDto = new EnderecoDto();

    public EnderecoDto getEndereco(String cep) throws IOException, InterruptedException {
        EnderecoDto enderecoDto = null;

        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://viacep.com.br/ws/" + cep + "/json/"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            enderecoDto = mapper.readValue(response.body(), EnderecoDto.class);
        } catch (Exception e) {
            System.out.println("Erro ao processar a requisição: " + e.getMessage());
        }

        return enderecoDto;
    }
}
