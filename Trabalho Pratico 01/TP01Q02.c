#include <stdbool.h>
#include <stdio.h>
#include <string.h>

#define MAX_LENGTH 100

bool saoIguais(char str1[], char str2[])
{
  if (strlen(str1) != strlen(str2))
  {
    return false;
  }

  for (int i = 0; i < strlen(str1); i++)
  {
    if (str1[i] != str2[i])
    {
      return false;
    }
  }

  return true;
}

bool Palim(char palavra[])
{
  int tamanho = strlen(palavra);

  for (int i = 0; i < tamanho / 2; i++)
  {
    if (palavra[i] != palavra[tamanho - i - 1])
    {
      return false;
    }
  }

  return true;
}

int main()
{
  char palavra[MAX_LENGTH];

  do
  {
    fgets(palavra, MAX_LENGTH, stdin);
    palavra[strcspn(palavra, "\n")] =
        '\0'; // Remover o caractere de nova linha do final

    if (!saoIguais(palavra, "fim"))
    {
      if (Palim(palavra))
      {
        printf("SIM\n");
      }
      else
      {
        printf("NAO\n");
      }
    }

  } while (!saoIguais(palavra, "fim"));

  return 0;
}
