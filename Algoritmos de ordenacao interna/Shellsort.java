class Shellsort {

    /**
     * Algoritmo de ordenacao Shellsort.
     */

    public static void shellsort(int[] array, int n) {
        int h = 1;

        do {
            h = (h * 3) + 1;
        } while (h < n);

        do {
            h /= 3;
            for (int cor = 0; cor < h; cor++) {
                insercaoPorCor(cor, h, n, array);
            }
        } while (h != 1);
    }

    /**
     * Metodo que efetua a insercao nos pseudo-arrays do Shellsort.
     * 
     * @param int cor cor do pseudo array.
     * @param int h passo do shelsort
     */
    public static void insercaoPorCor(int cor, int h, int n, int[] array) {
        for (int i = (h + cor); i < n; i += h) {
            int tmp = array[i];
            int j = i - h;
            while ((j >= 0) && (array[j] > tmp)) {
                array[j + h] = array[j];
                j -= h;
            }
            array[j + h] = tmp;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int array[] = { 101, 115, 30, 63, 47, 20 };
        int i = 0;

        // printar vetor desordenado
        System.out.print("Vetor desordenado: ");
        for (i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }

        shellsort(array, n);
        System.out.println();

        // printar vetor ordenado
        System.out.print("Vetor ordenado: ");
        for (i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
