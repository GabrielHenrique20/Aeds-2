import java.util.Random;

public class ExercicioInsercao {

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

    // Algoritmo de insercao
    public static void Insercao(int[] array, int n) {
        int contadorComparacoes = 0;
        int i = 0;

        for (i = 0; i < n; i++) {
            int temp = array[i];
            int j = i - 1;

            while ((j >= 0) && (array[j] > temp)) {
                contadorComparacoes++;
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = temp;
        }

        System.out.println("A quantidade de comparações foi: " + contadorComparacoes);
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
        Insercao(array, N - 1);
        System.out.println();
        System.out.println();

        // printar vetor ordenado
        System.out.print("Vetor ornenado: ");
        for (i = 0; i < N; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
