class Heapsort {

    /**
     * Algoritmo de ordenacao Heapsort.
     */

    public static void HEAPsort(int[] array, int n) {
        // Contrucao do heap
        for (int tamHeap = 2; tamHeap <= n; tamHeap++) {
            construir(tamHeap, array);
        }

        // Ordenacao propriamente dita
        int tamHeap = n;
        while (tamHeap > 1) {
            swap(array, 0, tamHeap - 1);
            tamHeap--;
            reconstruir(tamHeap, array, 0);
        }
    }

    public static void construir(int tamHeap, int[] array) {
        for (int i = tamHeap - 1; i > 0 && array[i] > array[(i - 1) / 2]; i = (i - 1) / 2) {
            swap(array, i, (i - 1) / 2);
        }
    }

    public static void reconstruir(int tamHeap, int[] array, int i) {
        while (2 * i + 1 < tamHeap) {
            int filho = getMaiorFilho(i, tamHeap, array);
            if (array[i] < array[filho]) {
                swap(array, i, filho);
                i = filho;
            } else {
                break;
            }
        }
    }

    public static int getMaiorFilho(int i, int tamHeap, int[] array) {
        int filho;
        if (2 * i + 1 == tamHeap - 1 || array[2 * i + 1] > array[2 * i + 2]) {
            filho = 2 * i + 1;
        } else {
            filho = 2 * i + 2;
        }
        return filho;
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

        HEAPsort(array, n);
        System.out.println();

        // printar vetor ordenado
        System.out.print("Vetor ordenado: ");
        for (i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

/*
 * O Heapsort contém duas etapas, ambas com custo O (n x lg(n)).
 * 
 * A primeira etapa é a criação do Heap. A segunda etapa é a destruição do Heap
 * ou ordenação propriamente dita.
 * 
 * O Heap é uma TAD que nos fornece ou o menor ou o maior elemento do conjunto
 * com custo O (1). O custo de construção do Heap é O (n x lg(n)). Ao remover a
 * cabeça do Heap, conseguimos reorganizá -lo com custo O (lg(n)).
 * 
 * O Heap tradicional armazena menor elemento em sua cabeça. O Heap Invertido, o
 * maior (organiza de trás pra frente).
 * 
 * O princípio de inserção no Heap consiste em inserir uma nova folha no último
 * nível, o mais à esquerda possível. Em seguida, comparamos a nova folha com o
 * pai. Se a nova folha for maior que o pai, invertemos seus valores.
 * Continuaremos "subindo" o novo elemento enquanto ele for maior que seu pai.
 * 
 * Na verdade, o pior caso e o caso médio da primeira etapa do Heapsort, têm
 * custo O (n x lg(n)). O melhor caso da primeira etapa do Heapsort tem custo O
 * (n) e acontece quando cada elemento inserido no Heap for menor ou
 * igual ao seu pai.
 * 
 * O único momento do Heapsort que comparamos elementos irmãos acontece na
 * remoção da cabeça do Heap. Nesse caso, comparamos os irmãos para saber quem
 * ficará no lugar do pai.
 * 
 *
 
 * 
 
 */
