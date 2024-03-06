public class PesquisaBinariaRecursiva {

    public static boolean pesqBinRec(int[] vet, int numero) {
        return pesqBinRec(vet, numero, 0, (vet.length - 1));
    }

    public static boolean pesqBinRec(int[] vet, int numero, int esq, int dir) {
        boolean resp;
        int meio = (esq + dir) / 2;

        if (esq > dir) {
            resp = false;
        } else if (numero == vet[meio]) {
            resp = true;
        } else if (numero > vet[meio]) {
            resp = pesqBinRec(vet, numero, meio + 1, dir);
        } else {
            resp = pesqBinRec(vet, numero, esq, meio - 1);
        }
        return resp;
    }

    public static void main (String[] args){
        int[] vet = {2, 3, 5, 7, 9, 11, 15, 17, 20, 21, 30, 43, 49, 70, 71, 82};
        int numero = 30;
  
        System.out.println("Pesquisa Binária Recursiva: " + pesqBinRec(vet, numero));
     }
}
