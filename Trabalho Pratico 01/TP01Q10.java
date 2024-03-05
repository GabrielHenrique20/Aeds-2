// Refaça a questão Palíndromo de forma RECURSIVA.

import java.util.Scanner;

public class TP01Q10 {
    public static Scanner sc = new Scanner(System.in);

    public static boolean saoIguais(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindromoRecursive(String palavra, int inicio, int fim) {
        if (inicio >= fim) {
            return true;
        }

        if (palavra.charAt(inicio) != palavra.charAt(fim)) {
            return false;
        }

        return isPalindromoRecursive(palavra, inicio + 1, fim - 1);
    }

    public static void main(String[] args) {
        String palavra;

        do {
            palavra = sc.nextLine().toLowerCase();

            if (!saoIguais(palavra.toLowerCase(), "fim")) {
                if (isPalindromoRecursive(palavra, 0, palavra.length() - 1)) {
                    System.out.println("SIM");
                } else {
                    System.out.println("NAO");
                }
            }

        } while (!saoIguais(palavra.toLowerCase(), "fim"));

        sc.close();
    }
}
