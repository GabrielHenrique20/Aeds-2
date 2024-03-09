#include <ctype.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

bool palindromo_recursivo(char palavra[], int i, int j)
{
    // Se i for maior ou igual a j, significa que a verificação foi concluída
    if (i >= j)
    {
        return true;
    }

    // Enquanto palavra[i] não é uma letra, avance i
    while (!isalpha(palavra[i]) && i < j)
    {
        i++;
    }

    // Enquanto palavra[j] não é uma letra, retroceda j
    while (!isalpha(palavra[j]) && i < j)
    {
        j--;
    }

    // Se as letras nas posições i e j são diferentes, não é um palíndromo
    if (i < j && palavra[i] != palavra[j])
    {
        return false;
    }

    // Chame a função recursivamente para a próxima iteração
    return palindromo_recursivo(palavra, i + 1, j - 1);
}

bool palindromo(char palavra[])
{
    // Inicie a chamada recursiva com i = 0 e j = comprimento da palavra - 1
    return palindromo_recursivo(palavra, 0, strlen(palavra) - 1);
}

int main(void)
{
    char palavra[1000];

    while (1)
    {
        scanf(" %[^\n]", palavra);

        if (strcasecmp(palavra, "FIM") == 0)
        {
            break;
        }

        palavra[strcspn(palavra, "\n")] = '\0';

        if (palindromo(palavra))
        {
            printf("SIM\n");
        }
        else
        {
            printf("NAO\n");
        }
    }

    return 0;
}
