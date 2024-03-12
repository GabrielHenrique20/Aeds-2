import java.util.*;

public class Pokemons {
    static Scanner leitor = new Scanner(System.in);

    // ordenar em ordem alfabética
    public static void selecao(String[] nomes) {
        int n = nomes.length;
        for (int i = 0; i < (n - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < n; j++) {
                if (nomes[j].compareTo(nomes[menor]) < 0) {
                    menor = j;
                }
            }
            swap(nomes, menor, i);
        }
    }

    // Método para trocar elementos no array
    private static void swap(String[] nomes, int i, int j) {
        String temp = nomes[i];
        nomes[i] = nomes[j];
        nomes[j] = temp;
    }

    public static void main(String[] args) {
        int totalCapturados = 0; // numero de pomekons que Dabriel capturou

        totalCapturados = leitor.nextInt();
        leitor.nextLine(); // Consumir a quebra de linha após o próximo int

        // Array para armazenar os nomes dos Pomekons
        String[] nomesPokemons = new String[totalCapturados];

        for (int i = 0; i < totalCapturados; i++) {
            nomesPokemons[i] = leitor.nextLine();
        }

        // Chamando o método de ordenação
        selecao(nomesPokemons);

        // Contando a quantidade de Pomekons únicos
        int contador = 1; // Começa com 1 porque o primeiro nome sempre é único
        for (int i = 1; i < nomesPokemons.length; i++) {
            if (!nomesPokemons[i].equals(nomesPokemons[i - 1])) {
                contador++;
            }
        }

        System.out.println("Falta(m) " + (151 - contador) + " pomekon(s).");
    }
}
