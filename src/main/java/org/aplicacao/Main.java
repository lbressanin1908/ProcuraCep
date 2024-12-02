package org.aplicacao;

import java.io.IOException;
import org.aplicacao.services.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{
        APIService apiService = new APIService();

        try {
            System.out.println(apiService.getEndereco("03197040"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}