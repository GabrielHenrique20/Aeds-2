#include <stdio.h>
#include <stdlib.h>

int main()
{
    int N, i;
    long aux = 0;
    FILE *arquivo;

    // Ler um número inteiro N indicando o número de valores reais
    scanf("%d", &N);

    // Abrir o arquivo para escrita
    arquivo = fopen("arquivo.txt", "wb");

    // Escrever números de ponto flutuante no arquivo
    double numeros;
    for (i = 0; i < N; i++)
    {
        scanf("%lf", &numeros);
        fwrite(&numeros, sizeof(double), 1, arquivo);
    }

    // Fechar o arquivo
    fclose(arquivo);

    // Reabrir o arquivo para leitura
    arquivo = fopen("arquivo.txt", "rb");

    // Obter o tamanho total do arquivo
    fseek(arquivo, 0, SEEK_END);
    long tamanho = ftell(arquivo);

    // Mostrar os valores do arquivo de trás para frente
    for (aux = tamanho - sizeof(double); aux >= 0; aux -= sizeof(double))
    {
        fseek(arquivo, aux, SEEK_SET);

        double reverse;
        fread(&reverse, sizeof(double), 1, arquivo);

        // Verificar se o valor lido é um número inteiro ou real
        if ((int)reverse == reverse)
        {
            // NÚMEROS INTEIROS
            printf("%.0lf\n", reverse); // Imprimir sem casas decimais
        }
        else
        {
            // NÚMEROS REAIS
            printf("%.3lf\n", reverse); // Imprimir com três casas decimais
        }
    }

    // Fechar o arquivo
    fclose(arquivo);

    return 0;
}
