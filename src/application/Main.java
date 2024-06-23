package application;

import service.ApiService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String menu = "Digite o cep para busca ou sair para finalizar a aplicação:";
        Scanner sc = new Scanner(System.in);
        String address = "";
        ApiService apiService = new ApiService();

        System.out.println("Bem vindo(a)");
        while (!address.equalsIgnoreCase("sair")) {
            System.out.println(menu);
            address = sc.next();

            if (address.equalsIgnoreCase("sair")) {
                break;
            }

            apiService.getRequest(address);
        }

        try {
            apiService.writeResponse();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
