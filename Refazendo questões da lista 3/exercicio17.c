#include <stdio.h>

int main(void) {
  float serie = 0;
  float soma = 0;
  int N = 0;
  int i = 0;
  int j = 1;

  printf("\nDigite um numero:  \n");
  scanf("%d", &N);

  for (i = 1; i <= N; i++) {
    serie = ((float)j) / (float)i;
    j = j + 2;

    soma += serie;

    printf("\n\n%.2f\n", serie);
  }

  printf("\n\nSOMA =  %.2f\n", soma);
  return 0;
}