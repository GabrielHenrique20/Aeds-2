#include <ctype.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

bool palindromo(char palavra[1000]) {
  int i = 0;
  int j = strlen(palavra) - 1;

  // o i vai começar no inicio e o j no final da palavra, entoao i tem que ser
  // menor que ela

  while (i < j) {

    // tirar o que nao e letra
    while (i < j && !isalpha(palavra[i])) {
      i++;
    }

    while (i < j && !isalpha(palavra[j])) {
      j--;
    }

    // comparar cada letra da palavra (se uma for diferente da outra ja cancela
    // tudo ja)
    while (i < j && (palavra[i]) != (palavra[j])) {
      return false;
    }

    i++;
    j--;

    // incrementa e decrementa pois nao estamos em um for e precisamos andar
    // pelo array/string
  }

  return true;
}

int main(void) {
  char palavra[1000];

  while (1) {
    // scanf("%s", palavra);
    scanf(" %[^\n]", palavra);

    // a funcao strcasecmp ignora se o usario digitar eu maiusculo e minusculo
    if (strcasecmp(palavra, "FIM") == 0) {
      break;
    }

    // Remove o caractere de nova linha (\n) da entrada
    palavra[strcspn(palavra, "\n")] = '\0';

    if (palindromo(palavra)) {
      printf("SIM\n");
    }

    else {
      printf("NAO\n");
    }
  }

  return 0;
}