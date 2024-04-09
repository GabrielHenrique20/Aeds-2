#include <stdio.h>

int main(void) {
  float media = 0;
  float soma = 0;
  float nota = 0;

  for (int i = 1; i <= 3; i++) {

    soma = 0;
    media = 0;

    for (int j = 1; j <= 3; j++) {
      printf("\nDigite a nota do aluno:  \n");
      scanf("%f", &nota);

      soma += nota;
      media = soma / 3;
    }

    printf("\nSoma das notas do aluno:  %.2f\n", soma);
    printf("Media das notas do aluno:  %.2f\n", media);
  }
  return 0;
}