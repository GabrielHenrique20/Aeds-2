// Não deu certo!!

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BatukeSpiral {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lendo entrada
        int N = scanner.nextInt();
        int startRow = scanner.nextInt() - 1;
        int startCol = scanner.nextInt() - 1;

        // Direções: direita, baixo, esquerda, cima
        int[] dRow = { 0, 1, 0, -1 };
        int[] dCol = { 1, 0, -1, 0 };

        boolean[][] visited = new boolean[N][N];
        List<Integer> path = new ArrayList<>();
        int totalCells = 0;
        int row = startRow;
        int col = startCol;
        int direction = 0;
        int step = 1;

        // Convertendo coordenadas para a célula inicial no formato 1..NxN
        int initialCell = row * N + col + 1;
        path.add(initialCell);
        visited[row][col] = true;
        totalCells++;

        while (totalCells < N * N) {
            for (int i = 0; i < step; i++) {
                row += dRow[direction];
                col += dCol[direction];

                // Se sair da matriz, ignora o movimento e ajusta a posição
                if (row < 0 || row >= N || col < 0 || col >= N) {
                    row -= dRow[direction];
                    col -= dCol[direction];
                    break;
                }

                // Se já visitado, ignora o movimento e ajusta a posição
                if (visited[row][col]) {
                    row -= dRow[direction];
                    col -= dCol[direction];
                    break;
                }

                // Adiciona a célula ao percurso
                int cell = row * N + col + 1;
                path.add(cell);
                visited[row][col] = true;
                totalCells++;
            }

            // Alterna direções: 0: direita, 1: baixo, 2: esquerda, 3: cima
            direction = (direction + 1) % 4;

            // A cada duas direções, incrementa o número de passos
            if (direction == 0 || direction == 2) {
                step++;
            }
        }

        // Imprime o percurso
        for (int i = 0; i < path.size(); i++) {
            if (i > 0)
                System.out.print(" ");
            System.out.print(path.get(i));
        }
        System.out.println();

        // Imprime o total de células percorridas
        System.out.println(totalCells);

        scanner.close();
    }
}

/*class Selecao {

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


/* class Insercao {

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


 /*class BubbleSort {
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
        int n = 6;
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
// do loop é diferente. */