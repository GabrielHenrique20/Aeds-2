#include <stdio.h>

int main(void) {
  int i = 0;
  int proximo = 0;
  int primeiro = 1;
  int segundo = 0;
  int numero = 0;
  int fibo = 0;

  printf("\nDigite um numero:  \n");
  scanf("%d", &numero);

  for (i = 1; i <= numero; i++) {
    proximo = primeiro + segundo;
    segundo = primeiro;
    primeiro = proximo;
    printf("\n%d\n", primeiro);
  }
  return 0;
}