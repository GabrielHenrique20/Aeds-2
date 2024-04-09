#include <stdio.h>

// pi = sequencia * 4

int main(void) {
  float pi = 0;
  int N = 0;
  float sequencia = 0;
  int sinal = 1;
  float soma = 0;
  int i = 0;

  printf("\n\nDigite N termos para uma sequencia:  \n");
  scanf("%d", &N);

  for (i = 1; i <= N; i = i + 2) {
    sequencia = (1.0 / i);
    soma = (soma + sequencia) * sinal;
    sinal = -sinal;

    printf("\n%.2f\n", sequencia);
  }

  pi = 4 * soma;

  printf("\nSOMA =  %.2f\n", soma);
  printf("O valor de PI é:  %.2f\n", pi);
  return 0;
}