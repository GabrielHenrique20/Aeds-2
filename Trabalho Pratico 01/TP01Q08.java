/*Faça um programa que leia um número inteiro n indicando o número de valores reais que devem ser lidos e 
salvos sequencialmente em um arquivo texto. Após a leitura dos valores, devemos fechar o arquivo. 
Em seguida, reabri-lo e fazer a leitura de trás para frente usando os métodos getFilePointer e 
seek da classe RandomAccessFile e mostre todos os valores lidos na tela. 
Nessa questão, você não pode usar, arrays, strings ou qualquer estrutura de dados. 
A entrada padrão é composta por um número inteiro n e mais n números reais. 
A saída padrão corresponde a n números reais mostrados um por linha de saída. */

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class TP01Q08 {
    static Scanner sc = new Scanner(System.in);

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        // Leia um número inteiro n indicando o número de valores reais
        int N;
        N = sc.nextInt();
        int i = 0;
        long aux = 0;

        // Try Catch obrigatorio para arquivos
        try {
            // Criar o arquivo usando RandomAceesFile para leitura e escrita
            RandomAccessFile arquivo = new RandomAccessFile("arquivo.txt", "rw");

            // Escreve números de ponto flutuante no arquivo
            for (i = 0; i < N; i++) {
                double numeros = sc.nextDouble();
                arquivo.writeDouble(numeros);
            }

            // Fecha o arquivo
            arquivo.close();

            // Reabre o arquivo e APENAS para lermos ele de tras pra frente
            arquivo = new RandomAccessFile("arquivo.txt", "r");

            // Obtém o tamanho total do arquivo e seu conteudo
            long tamanho = arquivo.length(); // em c poderiamos colocar lonk long

            // Mostrar os valores do arquivo de tras pra frente
            for (aux = tamanho - 8; aux >= 0; aux -= 8) { /*
                                                           * (tamanho - 8) Isso é feito para que aux comece na posição
                                                           * do último
                                                           * número real armazenado no arquivo. Cada número real é
                                                           * representado por 8 bytes em Java.
                                                           */
                arquivo.seek(aux); // posiciona o ponteiro de leitura do arquivo na posição determinada por aux.
                                   // Isso faz com que o próximo valor a ser lido seja o valor armazenado nessa
                                   // posição.

                double reverse = arquivo.readDouble();

                if (reverse == (int) reverse) {
                    // NUMEROS INTEIROS
                    System.out.println((int) reverse);
                }

                else {
                    // NUMEROS REAIS
                    System.out.println(reverse);
                }
            }

            // FECHAR O ARQUIVO
            arquivo.close();

        }

        catch (IOException e) {
            System.err.println("Erro de E/S: " + e.getMessage());
        }

    }
}
