package application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String menu = "Digite o cep para busca ou sair para finalizar a aplicação:";
        Scanner sc = new Scanner(System.in);
        String address = "";

        System.out.println("Bem vindo(a)");
        while (!address.equalsIgnoreCase("sair")) {
            System.out.println(menu);
            address = sc.next();

            if (address.equalsIgnoreCase("sair")) {
                break;
            }
        }
    }
}
