#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Definindo a estrutura para armazenar os dados dos alunos
typedef struct
{
    char nome[101];
    char regiao;
    int custo;
} Aluno;

// Função de comparação para o qsort
int comparaAlunos(const void *a, const void *b)
{
    Aluno *aluno1 = (Aluno *)a;
    Aluno *aluno2 = (Aluno *)b;

    // Primeiro critério: custo (da menor para a maior)
    if (aluno1->custo != aluno2->custo)
    {
        return aluno1->custo - aluno2->custo;
    }

    // Segundo critério: região (em ordem alfabética)
    if (aluno1->regiao != aluno2->regiao)
    {
        return aluno1->regiao - aluno2->regiao;
    }

    // Terceiro critério: nome (em ordem alfabética)
    return strcmp(aluno1->nome, aluno2->nome);
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
            scanf("%s %c %d", alunos[i].nome, &alunos[i].regiao, &alunos[i].custo);
        }

        // Ordena os alunos de acordo com os critérios especificados
        qsort(alunos, Q, sizeof(Aluno), comparaAlunos);

        // Imprime os alunos na ordem correta
        for (int i = 0; i < Q; i++)
        {
            printf("%s\n", alunos[i].nome);
        }
    }

    return 0;
}
