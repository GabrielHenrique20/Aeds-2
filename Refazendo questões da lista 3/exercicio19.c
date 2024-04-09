#include <stdio.h>

int main(void) {
  int fatorial = 1;
  int numero = 0;
  int i = 0;

  printf("\nDigite um numero:  \n");
  scanf("%d", &numero);

  for (i = 1; i <= numero; i++) {
    fatorial = fatorial * i;
    printf("\n\n%d\n", i);
  }

  printf("\nFatorial do numero %d é:  %d\n", numero, fatorial);
  return 0;
}