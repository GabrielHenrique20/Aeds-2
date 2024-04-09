#include <stdio.h>

int main(void) {
  int maior = 0;
  int menor = 0;
  int numero = 0;

  for (int i = 1; i <= 10; i++) {
    printf("\nDigite um numero:  \n");
    scanf("%d", &numero);

    if (i == 1) {
      maior = numero;
      menor = numero;
    }

    else {

      if (numero > maior) {
        maior = numero;
      }

      else if (numero < menor) {
        menor = numero;
      }
    }
  }

  printf("\nO maior numero digitado foi:  %d\n", maior);
  printf("\nO menor numero digitado foi:  %d\n", menor);
  return 0;
}