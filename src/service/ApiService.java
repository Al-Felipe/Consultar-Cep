package service;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class ApiService {
    private ArrayList<String> cepList = new ArrayList<>();

    public void getRequest(String address) {
        String apiUrl = "https://viacep.com.br/ws/" + address + "/json/";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                cepList.add(response.body());
                System.out.println(response.body());
            } else {
                System.out.println("CEP inválido");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeResponse() throws IOException {
        FileWriter fileWriter = new FileWriter("cep.json");
        fileWriter.write(String.valueOf(cepList));
        fileWriter.close();
    }
}
