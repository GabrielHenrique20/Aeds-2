import java.util.Random;

class ExercicioSelecao {
    // Define o tamanho do vetor
    public static int N = 100;

    // Preencher vetor com valores aleatorios
    public static void PreencherVetor(int[] array) {
        int i = 0;
        Random rnd = new Random();

        for (i = 0; i < N; i++) {
            array[i] = rnd.nextInt(300);
        }
    }

    public static void selecao(int[] array, int n) {
        int contador = 0;
        for (int i = 0; i < (n - 1); i++) { // o primeiro for sempre ficara apontando para a posicao que espera o
                                            // primeiro elemento
            int menor = i; // defini no array o local onde o menor vai ficar dependendo de onde o i estiver

            for (int j = (i + 1); j < n; j++) { // o segundo for vai ser responsavel por realizar a busca do menor
                                                // elemento na parte nao ordenada
                contador++;
                if (array[menor] > array[j]) { // comparacao
                    menor = j; // se ele achar outro que seja menor que o inicial, ele muda o valor do menor
                }
            }

            swap(array, menor, i); // movimentacao
        }
        System.out.println("A quantidade de comparações foi " + contador + " comparações\n");
    }

    // Função swap para trocar dois elementos de posição em um array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Main
    public static void main(String[] args) {
        int[] array = new int[N];
        int i = 0;

        // vamos preencher o vetor com valores aleatorios
        PreencherVetor(array);

        // printar vetor desordenado
        System.out.print("Vetor desornenado: ");
        for (i = 0; i < N; i++) {
            System.out.print(array[i] + " ");
        }

        // Insercao
        selecao(array, N - 1);
        System.out.println();
        System.out.println();

        // printar vetor ordenado
        System.out.print("Vetor ornenado: ");
        for (i = 0; i < N; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
