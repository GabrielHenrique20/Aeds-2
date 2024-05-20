#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Definindo a estrutura para armazenar os dados dos alunos
typedef struct
{
    char nome[101];
    char regiao;
    int distancia;
} Aluno;

// Função de comparação para o qsort
int comparaAlunos(Aluno *aluno1, Aluno *aluno2)
{

    // Primeiro critério: distancia (da menor para a maior)
    if (aluno1->distancia != aluno2->distancia)
    {
        return aluno1->distancia - aluno2->distancia; // aluno 1 MENOS aluno 2
    }

    // Segundo critério: região (em ordem alfabética)
    if (aluno1->regiao != aluno2->regiao)
    {
        return aluno1->regiao - aluno2->regiao; // aluno 1 MENOS aluno 2
        // Os caracteres são comparados de acordo com seus valores ASCII, ordenando as regiões em ordem alfabética
    }

    // Terceiro critério: nome (em ordem alfabética)
    return strcmp(aluno1->nome, aluno2->nome); // compara os dois pelo nome
}

int main()
{
    int Q;

    // Lê a quantidade de alunos
    while (scanf("%d", &Q) != EOF)
    {
        // Aloca memória para armazenar os alunos
        Aluno alunos[Q];

        // Lê os dados de cada aluno
        for (int i = 0; i < Q; i++)
        {
            scanf("%s %c %d", alunos[i].nome, &alunos[i].regiao, &alunos[i].distancia);
        }

        // Ordena os alunos de acordo com os critérios especificados crescente
        qsort(alunos, Q, sizeof(Aluno), comparaAlunos);
        // alunos: o array a ser ordenado.
        // Q: o número de elementos no array.
        // sizeof(Aluno): o tamanho de cada elemento do array.
        // comparaAlunos: a função de comparação que define a ordem dos elementos.

        // Imprime os alunos na ordem correta
        for (int i = 0; i < Q; i++)
        {
            printf("%s\n", alunos[i].nome);
        }
    }

    return 0;
}
