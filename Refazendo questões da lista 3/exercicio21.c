#include <stdio.h>

int main(void) {
  int voto;
  int candidato1 = 0;
  int candidato2 = 0;
  int candidato3 = 0;
  int candidato4 = 0;
  int nulo = 0;
  int branco = 0;
  int totalVotos = 0;
  float porcentagem = 0.0;

  while (voto != 0) {
    for (int i = 1; i <= 4; i++) {
      printf("\nDigite para quem vai seu voto:  \n");
      scanf("%d", &voto);

      switch (voto) {
      case 1:
        candidato1++;
        totalVotos++;
        break;

      case 2:
        candidato2++;
        totalVotos++;
        break;

      case 3:
        candidato3++;
        totalVotos++;
        break;

      case 4:
        candidato4++;
        totalVotos++;
        break;

      case 5:
        nulo++;
        totalVotos++;
        break;

      case 6:
        branco++;
        totalVotos++;
        break;

      case 0:
        goto fim;
        break;

      default:
        printf("\nVoto inválido!!\n");
      }
    }
  }
fim:

  porcentagem = ((float)branco / totalVotos) * 100.0;

  printf("\nO candidato 1 teve %d votos!!\n", candidato1);
  printf("\nO candidato 2 teve %d votos!!\n", candidato2);
  printf("\nO candidato 3 teve %d votos!!\n", candidato3);
  printf("\nO candidato 4 teve %d votos!!\n", candidato4);
  printf("\nTotal de votos nulos:  %d\n", nulo);
  printf(
      "\nTotal de votos em branco:  %d, sendo que %.2f%%\n votaram em branco\n",
      branco, porcentagem);
  printf("\n\nTOTAL DE VOTOS:  %d\n", totalVotos);

  return 0;
}