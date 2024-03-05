/*Crie um método iterativo que recebe uma string como parâmetro e retorna true se essa é um Palíndromo.
Na saída padrão, para cada linha de entrada, escreva uma linha de saída com SIM/NÃO indicando se a linha é um palíndromo. Destaca-se que uma linha de entrada pode ter caracteres não letras. */

import java.util.*;

class TP01Q01 {
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

  public static boolean Palim(String palavra) {
    int tamanho = palavra.length(); // strlen() em c

    for (int i = 0; i < tamanho / 2; i++) { // divindo por 2, não vai precisar de um j. A palavra ja vai ser
                                            // dividida em duas partes e as duas serao analisadas(v[i] != v[tamanho
                                            // - i -1])
      if (palavra.charAt(i) != palavra.charAt(tamanho - i - 1)) { // palavra[i] e palavra[tam - i - 1]
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {

    String palavra;

    do {

      palavra = sc.nextLine().toLowerCase(); // ler colocando tudo de forma minuscula

      if (!saoIguais(palavra.toLowerCase(), "fim")) {

        if (Palim(palavra)) {
          System.out.println("SIM");
        }

        else {
          System.out.println("NAO");
        }
      }

    } while (!saoIguais(palavra.toLowerCase(), "fim"));

    sc.close();
    return;
  }
}