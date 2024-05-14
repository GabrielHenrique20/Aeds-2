class CoutingSort {

    /**
     * Algoritmo de ordenacao Countingsort.
     */
    public static void coutingsort(int[] array, int n) {
        // Array para contar o numero de ocorrencias de cada elemento
        int[] count = new int[getMaior(array, n) + 1];
        int[] ordenado = new int[n];

        // Inicializar cada posicao do array de contagem
        for (int i = 0; i < count.length; count[i] = 0, i++)
            ;

        // Agora, o count[i] contem o numero de elemento iguais a i
        for (int i = 0; i < n; count[array[i]]++, i++)
            ;

        // Agora, o count[i] contem o numero de elemento menores ou iguais a i
        for (int i = 1; i < count.length; count[i] += count[i - 1], i++)
            ;

        // Ordenando
        for (int i = n - 1; i >= 0; ordenado[count[array[i]] - 1] = array[i], count[array[i]]--, i--)
            ;

        // Copiando para o array original
        for (int i = 0; i < n; array[i] = ordenado[i], i++)
            ;
    }

    /**
     * Retorna o maior elemento do array.
     * 
     * @return maior elemento
     */
    public static int getMaior(int[] array, int n) {
        int maior = array[0];

        for (int i = 0; i < n; i++) {
            if (maior < array[i]) {
                maior = array[i];
            }
        }
        return maior;
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

        coutingsort(array, n);
        System.out.println();

        // printar vetor ordenado
        System.out.print("Vetor ordenado: ");
        for (i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}