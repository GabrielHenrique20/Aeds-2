#include <stdio.h>

int main() {
  int primo = 0;
  int i = 0;
  int j = 0;
  int contador = 0;

  for (i = 2; i <= 1000; i++) {
    primo = 1;
    for (j = 2; j < i; j++) {
      if (i % j == 0) {
        primo = 0;
      }
    }

    if (primo == 1) {
      contador++;
    }
  }

  printf("\nExistem %d números primos entre 1 e 1000!!\n", contador);

  return 0;
}