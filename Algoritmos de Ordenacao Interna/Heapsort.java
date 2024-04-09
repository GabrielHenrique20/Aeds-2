import java.util.*;

class Heapsort extends Geracao {

    public static void heapsort(int[] array, int n) {
        int tam;

        // Alterar o vetor ignorando a posicao zero
        int[] tmp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            tmp[i + 1] = array[i];
        }
        array = tmp;

        // Primeiro passo: Construção do Heap
        for (tam = 2; tam <= n; tam++) {
            construir(array, tam);
        }

        // Ordenacao propriamente dita
        tam = n;

        while (tam > 1) {
            swap(array, 1, tam--);
            // Retira a raiz, realiza o swap entre a ultima folha e a raiz vazia e elimina
            // uma casa do array, ou seja, agora o array possui um "tamanho menor".
            // O elemento que sai da raiz vai para o final e lá fica ordenado, tendo em
            // vista que ele era o maior do Heap, e assim vamos fazendo com todos ordenando
            // tudo de tras para frente
            reconstruir(array, tam);
        }

        // Alterar o vetor para voltar a posicao zero
        tmp = array;
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = tmp[i + 1];
        }
    }

    public static void construir(int[] array, int tam) {

        for (int i = tam; i > 1 && array[i] > array[i / 2]; i /= 2) { // Metodo que verifica se o filho é maior que o
                                                                      // pai, se for, trocam de posição do Heap
            swap(array, i, i / 2);
        }
    }

    public static void reconstruir(int[] array, int tam) {
        int i = 1;
        while (hasFilho(i, tam) == true) {
            int filho = getMaiorFilho(array, i, tam);

            if (array[i] < array[filho]) {
                swap(array, i, filho);
                i = filho;
            }

            else {
                i = tam;
            }
        }
    }

    // Função swap para trocar dois elementos de posição em um array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Função para saber se o pai ainda possui algum filho
    public static boolean hasFilho(int i, int tam) {
        return (i <= (tam / 2));
    }

    // Função que compara dois filhos e fala qual o maior deles
    public static int getMaiorFilho(int[] array, int i, int tam) {
        int filho;
        if (2 * i == tam || array[2 * i] > array[2 * i + 1]) {
            filho = 2 * i;
        } else {
            filho = 2 * i + 1;
        }
        return filho;
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

        // Realizo o Heap
        heapsort(array, n);
        System.out.println();

        // printar vetor ordenado
        System.out.print("Vetor ordenado: ");
        for (i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }

    }

}