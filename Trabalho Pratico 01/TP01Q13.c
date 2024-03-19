#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

char *AlteracaoAleatoriaRec(char *palavra, char letra1, char letra2, int aux, int tamanho)
{
    if (aux >= tamanho)
    {
        return palavra;
    }

    if (palavra[aux] == letra1)
    {
        palavra[aux] = letra2;
    }

    return AlteracaoAleatoriaRec(palavra, letra1, letra2, aux + 1, tamanho);
}

int main(void)
{
    // Definir a semente para geração aleatória
    srand(4);

    char palavra[10000];
    char letra1, letra2;

    while (1)
    {
        // Gerar letras aleatórias para cada linha
        letra1 = 'a' + (rand() % 26);
        letra2 = 'a' + (rand() % 26);

        if (scanf(" %9999[^\n]", palavra) != 1)
        {
            break; // Se não for possível ler uma palavra, encerrar o loop
        }

        if (strcmp(palavra, "FIM") == 0)
        {
            break;
        }

        int tamanho = strlen(palavra);
        printf("%s\n", AlteracaoAleatoriaRec(palavra, letra1, letra2, 0, tamanho));
    }

    return 0;
}
