class Selecao {

    public static void selecao(int[] array, int n) {
        for (int i = 0; i < (n - 1); i++) { // o primeiro for sempre ficara apontando para a posicao que espera o
                                            // primeiro elemento
            int menor = i; // defini no array o local onde o menor vai ficar dependendo de onde o i estiver

            for (int j = (i + 1); j < n; j++) { // o segundo for vai ser responsavel por realizar a busca do menor
                                                // elemento na parte nao ordenada
                if (array[menor] > array[j]) { // comparacao
                    menor = j; // se ele achar outro que seja menor que o inicial, ele muda o valor do menor
                }
            }

            swap(array, menor, i); // movimentacao
        }
    }

    // Função swap para trocar dois elementos de posição em um array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int n = 6;
        int array[] = { 101, 115, 30, 63, 47, 20 };
        int i = 0;

        // printar vetor desordenado
        System.out.print("Vetor desordenado: ");
        for (i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }

        selecao(array, n);
        System.out.println();

        // printar vetor ordenado
        System.out.print("Vetor ordenado: ");
        for (i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

/*--> COMPARAÇÕES:
        *Pior e Melhor casos: n^2/2 - n/2 ou também O(n^2) 
 */

/*--> MOVIMENTAÇÕES
       *Pior e Melhor casos: 3(n - 1) = 3n - 3 ou também O(n)
 */