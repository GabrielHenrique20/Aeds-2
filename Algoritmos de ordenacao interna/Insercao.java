class Insercao {

    // Algoritmo de ordenacao por insercao
    public static void insercao(int array[], int n) {

        for (int i = 1; i < n; i++) {
            int temp = array[i]; // coloca a variavel que vai ser ordenada no temp
            int j = i - 1; // coloca j uma posição antes de i para depois ir decrementando

            while ((j >= 0) && (array[j] > temp)) { // comparação
                array[j + 1] = array[j]; // SHIFT, elementos vão para a direita
                j--; // decrementa j
            }
            array[j + 1] = temp; // no final, coloca o valor da variavel temp eu seu devido lugar
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int array[] = { 101, 115, 30, 63, 47, 20 };
        int i = 0;

        // printar vetor desordenado
        System.out.print("Vetor desornenado: ");
        for (i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }

        insercao(array, n);
        System.out.println();

        // printar vetor ordenado
        System.out.print("Vetor ornenado: ");
        for (i = 0; i < n; i++) {
            System.out.print(array[i]+ " ");
        }

    }
}

/*COMPARAÇÕES:

 * Pior caso: n^2/2 - n/2, também chaamdo de O(n^2) (sendo assim, ela tem a mesma complexidade do que a seleçao no pior caso de comparações)
 * Esse caso acontece quando o array esta em ordem decrescente, pois teriamos que comparar todas os elementos e ordena-los novamente
 
 *Melhor caso: O(n), ou seja, quando o array já esta ordenado por completo em ordem crescente
 */