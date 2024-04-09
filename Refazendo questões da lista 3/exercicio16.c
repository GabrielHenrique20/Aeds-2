#include <stdio.h>

int main(void) {
  float sequencia = 0;
  float soma = 0;
  int N = 0;
  int i = 0;

  printf("\nDigite um numero:  \n");
  scanf("%d", &N);

  for (i = 1; i <= N; i++) {
    sequencia = (1.0 / i);
    soma = soma + sequencia;

    printf("\n\n%.2f\n", sequencia);
  }

  printf("\n\nSOMA DA SEQUENCIA =  %.2f\n", soma);
  return 0;
}