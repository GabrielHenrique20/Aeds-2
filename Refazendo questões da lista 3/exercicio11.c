#include <stdio.h>

int main(void) {
  int numero = 0;
  int contadorNum = 0;
  int contador5 = 0;

  while (numero != -1) {
    printf("\nDigite um numero:  \n");
    scanf("%d", &numero);

    contadorNum++;

    if (numero == 5) {
      contador5++;
    }
  }

  printf("\nTotal de números digitados:  %d\n", contadorNum - 1);
  printf("\nTotal de numero 5 digitados:  %d\n", contador5);
  return 0;
}