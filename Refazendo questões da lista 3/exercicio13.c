#include <stdio.h>

// primo = 1 ---> TRUE, número é primo
// primo = 0 ---> FALSE, número não é primo

int main(void) {
  int i = 0;
  int numero = 0;
  int primo = 1;

  printf("\nDigite um numero:  \n");
  scanf("%d", &numero);

  for (i = 2; i < numero; i++) {
    if (numero % i == 0) {
      primo = 0;
      break;
    }
  }

  if (primo == 1) { // se o primo for verdadeiro
    printf("\nO numero %d é primo!!\n", numero);
  }

  else { // se o primo for = 0, o useja, falso
    printf("\nO numero %d não é primo!!\n", numero);
  }
  return 0;
}