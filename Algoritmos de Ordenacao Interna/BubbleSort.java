public class BubbleSort {
    public static void bolha(int[] array, int n) {
        boolean houveTroca = true; // variavel de controle que para o programa por completo se o vetor ja estiver
                                   // ordenado, diminuindo o numero de iterações

        for (int rep = 0; rep < (n - 1) && houveTroca; rep++) {
            for (int b = 0; b < n - (rep + 1); b++) { // n - (rep + 1) diminuindo o numero de comparações a serem feitas
                                                      // (se eu em uma rodada ja sei que o numero é o ultimo e maior,
                                                      // nao preciso verficar com ele novamente)
                if (array[b] > array[b + 1]) {
                    swap(array, b, b + 1);
                    houveTroca = true;
                }
            }
        }
    }

    // Método para trocar dois elementos em um array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int n = 5;
        int array[] = { 101, 115, 30, 63, 47, 20 };
        int i = 0;

        // printar vetor desordenado
        System.out.print("Vetor desordenado: ");
        for (i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }

        bolha(array, n);
        System.out.println();

        // printar vetor ordenado
        System.out.print("Vetor ordenado: ");
        for (i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

// Melhor caso = vetor ordenado em ordem crescente
// Pior caso = vetor ordenado em ordem decrescente

/*
 * Bolha do Max
 * /**
 * Algoritmo de ordenacao Bolha.
 *
 * public void sort() {
 * for (int i = (n - 1); i > 0; i--) {
 * for (int j = 0; j < i; j++) {
 * if (array[j] > array[j + 1]) {
 * swap(j, j+1);
 * }
 * }
 * }
 * }
 */

// No código fornecido agora, o loop externo começa de n - 1 e decrementa i em
// cada iteração até i ser maior que 0. Isso é o oposto do que está no código
// anterior, onde o loop externo começa de 0 e incrementa rep até n - 1. Ambos
// os métodos são válidos para a implementação do Bubble Sort, apenas a direção
// do loop é diferente.