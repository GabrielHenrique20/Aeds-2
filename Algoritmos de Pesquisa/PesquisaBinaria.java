public class PesquisaBinaria {

    public static boolean PesquisaBinaria(int[] vet, int numero) {
        boolean resp = false;
        int dir = (vet.length - 1), esq = 0, meio;

        while (esq <= dir) {
            meio = (esq + dir) / 2;
            if (numero == vet[meio]) {
                resp = true;
                esq = dir + 1;
            } else if (numero > vet[meio]) {
                esq = meio + 1;
            } else {
                dir = meio - 1;
            }
        }
        return resp;
    }

    public static void main(String[] args) {

        int[] vet = { 2, 3, 5, 7, 9, 11, 15, 17, 20, 21, 30, 43, 49, 70, 71, 82 };
        int numero = 17;

        System.out.println("Pesquisa Binária: " + PesquisaBinaria(vet, numero));

    }

}

// É mais eficiente que a sequencial, tendo em vista que seu processo começa
// pelo meio do array e vai varrendo ele de 2 em 2 (metade)

// Nessa pesquisa, o array TEM QUE ESTAR ORDENADO SEMPRE, diferente da
// sequencial

// PIOR CASO ---> Quando o numero não se encontra no ultimo meio do aray ou nem
// esta nele, F(n) = lg(n) ou também Θ(lg(n))

// MELHRO CASO ---> Quando o número se encontra no primeiro meio do array, F(n)
// = 1 ou também Θ(1)
