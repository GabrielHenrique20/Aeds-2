import java.util.*;

public class EtiquetasNoel {
    static Scanner sc = new Scanner(System.in);

    // Método para buscar a tradução correspondente ao idioma da criança
    public static String buscarTraducao(String[] idiomas, String[] traducoes, String lingua) {
        for (int i = 0; i < idiomas.length; i++) {
            if (idiomas[i].equals(lingua)) {
                return traducoes[i];
            }
        }
        return ""; // Retorno vazio se não encontrar a tradução
    }

    public static void main(String[] args) {
        int quantidadeTraducoes = 0;

        // Leitura da quantidade de traduções de "Feliz Natal"
        quantidadeTraducoes = sc.nextInt();
        sc.nextLine();

        // Arrays para armazenar os idiomas e as traduções
        String[] idiomas = new String[quantidadeTraducoes];
        String[] traducoes = new String[quantidadeTraducoes];

        int i = 0;

        // Leitura das traduções e armazenamento nos arrays
        for (i = 0; i < quantidadeTraducoes; i++) {
            idiomas[i] = sc.nextLine();
            traducoes[i] = sc.nextLine();
        }

        // Leitura da quantidade de crianças que recebrao as cartas e suas informações
        // pessoais
        int numCriancas = sc.nextInt();
        sc.nextLine();

        // aqui é o for onde a crianca recebera sua mensagem de feliz natal traduzida
        // para sua lingua nativa
        for (i = 0; i < numCriancas; i++) {
            String nome = sc.nextLine(); // digite seu nome
            String linguaNativa = sc.nextLine(); // digite sua lingua nativa

            String traducao = buscarTraducao(idiomas, traducoes, linguaNativa); // busca por todas as traducoes e
                                                                                // idiomas de feliz natal e traduz para
                                                                                // a que foi pedida

            // Imprimindo etiqueta
            System.out.println(nome);
            System.out.println(traducao);
            System.out.println();
        }

        sc.close();
    }
}
