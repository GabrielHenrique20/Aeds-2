class PesquisaSequencial {

    public static boolean PesquisaSequencial(int[] vet, int numero) {
        boolean resp = false;
        int n = vet.length;

        for (int i = 0; i < n; i++) { // se eu colocar um igual aqui, vai dar erro de tamanho no array (i <= n)
            if (vet[i] == numero) {
                resp = true;
                i = n;
            }
        }
        return resp; // false se nao achar o elemento e true se achar o elemento desejado
    }

    public static void main(String[] args) {
        int[] vet = { 2, 3, 5, 7, 9, 11, 15, 17, 20, 21, 30, 43, 49, 70, 71, 82 };
        int numero = 83;

        System.out.println("Pesquisa Sequencial: " + PesquisaSequencial(vet, numero));
    }
}

// PIOR CASO ---> Quando o elemento está na ultima posição do vetor ou nem esta
// nele, F(n) = n ou também Θ(n)

// MELHOR CASO ---> Quando o elemento está na primeira posição do array, F(n) =
// 1 ou também Θ(n)