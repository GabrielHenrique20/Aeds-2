// Algoritmo de insercao
class Insercao extends Geracao {
   private long comparacoes;
   private long movimentacoes;

   /**
    * Construtor.
    */
   public Insercao() {
      super();
   }

   /**
    * Construtor.
    * 
    * @param int tamanho do array de numeros inteiros.
    */
   public Insercao(int tamanho) {
      super(tamanho);
   }

   /**
    * Algoritmo de ordenacao por insercao.
    */
   @Override
   public void sort() {
      comparacoes = 0;
      movimentacoes = 0;
      for (int i = 1; i < n; i++) {
         int tmp = array[i];
         int j = i - 1;

         while ((j >= 0) && (array[j] > tmp)) {
            array[j + 1] = array[j];
            j--;

            comparacoes++;
            movimentacoes++;
         }
         array[j + 1] = tmp;
         movimentacoes++;
      }
   }

   @Override
   public void printarContadores() {
      System.out.println("Numero de comparacoes: " + comparacoes);
      System.out.println("Numero de movimentacoes: " + movimentacoes);
   }
}

// Algoritmo de Mergesort
class Mergesort extends Geracao {
   private long comparacoes;
   private long movimentacoes;

   /**
    * Construtor.
    */
   public Mergesort() {
      super();
   }

   /**
    * Construtor.
    * 
    * @param int tamanho do array de numeros inteiros.
    */
   public Mergesort(int tamanho) {
      super(tamanho);
   }

   /**
    * Algoritmo de ordenacao Mergesort.
    */
   @Override
   public void sort() {
      comparacoes = 0;
      movimentacoes = 0;
      mergesort(0, n - 1);
   }

   /**
    * Algoritmo de ordenacao Mergesort.
    * 
    * @param int esq inicio do array a ser ordenado
    * @param int dir fim do array a ser ordenado
    */
   private void mergesort(int esq, int dir) {
      if (esq < dir) {
         int meio = (esq + dir) / 2;
         mergesort(esq, meio);
         mergesort(meio + 1, dir);
         intercalar(esq, meio, dir);
      }
   }

   /**
    * Algoritmo que intercala os elementos entre as posicoes esq e dir
    * 
    * @param int esq inicio do array a ser ordenado
    * @param int meio posicao do meio do array a ser ordenado
    * @param int dir fim do array a ser ordenado
    */
   public void intercalar(int esq, int meio, int dir) {
      int n1, n2, i, j, k;

      n1 = meio - esq + 1;
      n2 = dir - meio;

      int[] a1 = new int[n1];
      int[] a2 = new int[n2];

      for (i = 0; i < n1; i++) {
         a1[i] = array[esq + i];
         movimentacoes++;
      }

      for (j = 0; j < n2; j++) {
         a2[j] = array[meio + j + 1];
         movimentacoes++;
      }

      i = j = 0;
      k = esq;

      while (i < n1 && j < n2) {
         comparacoes++;
         if (a1[i] <= a2[j]) {
            array[k] = a1[i];
            i++;
         } else {
            array[k] = a2[j];
            j++;
         }
         k++;
         movimentacoes++;
      }

      while (i < n1) {
         array[k] = a1[i];
         i++;
         k++;
         movimentacoes++;
      }

      while (j < n2) {
         array[k] = a2[j];
         j++;
         k++;
         movimentacoes++;
      }
   }

   @Override
   public void printarContadores() {
      System.out.println("Numero de comparacoes: " + comparacoes);
      System.out.println("Numero de movimentacoes: " + movimentacoes);
   }
}

// Algoritmo de Quicksort
class Quicksort extends Geracao {
   private long comparacoes;
   private long movimentacoes;

   /**
    * Construtor.
    */
   public Quicksort() {
      super();
   }

   /**
    * Construtor.
    * 
    * @param int tamanho do array de numeros inteiros.
    */
   public Quicksort(int tamanho) {
      super(tamanho);
   }

   /**
    * Algoritmo de ordenacao Quicksort.
    */
   @Override
   public void sort() {
      comparacoes = 0;
      movimentacoes = 0;
      quicksort(0, n - 1);
   }

   /**
    * Algoritmo de ordenacao Quicksort.
    * 
    * @param int esq inicio do array a ser ordenado
    * @param int dir fim do array a ser ordenado
    */
   private void quicksort(int esq, int dir) {
      int i = esq, j = dir;
      int pivo = array[(dir + esq) / 2];
      while (i <= j) {
         while (array[i] < pivo) {
            i++;
            comparacoes++;
         }
         while (array[j] > pivo) {
            j--;
            comparacoes++;
         }
         if (i <= j) {
            swap(i, j);
            i++;
            j--;
            movimentacoes += 3;
         }
      }
      if (esq < j) {
         quicksort(esq, j);
      }
      if (i < dir) {
         quicksort(i, dir);
      }
   }

   @Override
   public void printarContadores() {
      System.out.println("Numero de comparacoes: " + comparacoes);
      System.out.println("Numero de movimentacoes: " + movimentacoes);
   }
}

// Algoritmo de Radixsort
class Radixsort extends Geracao {
   private long comparacoes;
   private long movimentacoes;

   /**
    * Construtor.
    */
   public Radixsort() {
      super();
   }

   /**
    * Construtor.
    * 
    * @param int tamanho do array de numeros inteiros.
    */
   public Radixsort(int tamanho) {
      super(tamanho);
   }

   /**
    * Algoritmo de ordenacao Countingsort.
    */
   @Override
   public void sort() {
      comparacoes = 0;
      movimentacoes = 0;
      int max = getMaior();
      for (int exp = 1; max / exp > 0; exp *= 10) {
         sort(exp);
      }
   }

   public void sort(int exp) {
      int[] count = new int[10];
      int[] output = new int[n];

      for (int i = 0; i < 10; i++) {
         count[i] = 0;
         movimentacoes++;
      }

      for (int i = 0; i < n; i++) {
         count[(array[i] / exp) % 10]++;
         movimentacoes++;
      }

      for (int i = 1; i < 10; i++) {
         count[i] += count[i - 1];
         movimentacoes++;
      }

      for (int i = n - 1; i >= 0; i--) {
         output[count[(array[i] / exp) % 10] - 1] = array[i];
         count[(array[i] / exp) % 10]--;
         movimentacoes += 3;
      }

      for (int i = 0; i < n; i++) {
         array[i] = output[i];
         movimentacoes++;
      }
   }

   /**
    * Retorna o maior elemento do array.
    * 
    * @return maior elemento
    */
   public int getMaior() {
      int maior = array[0];

      for (int i = 1; i < n; i++) {
         if (maior < array[i]) {
            maior = array[i];
         }
      }
      return maior;
   }

   @Override
   public void printarContadores() {
      System.out.println("Numero de comparacoes: " + comparacoes);
      System.out.println("Numero de movimentacoes: " + movimentacoes);
   }
}

// Algoritmo de selecao
class Selecao extends Geracao {
   private long comparacoes;
   private long movimentacoes;

   /**
    * Construtor.
    */
   public Selecao() {
      super();
   }

   /**
    * Construtor.
    * 
    * @param int tamanho do array de numeros inteiros.
    */
   public Selecao(int tamanho) {
      super(tamanho);
   }

   /**
    * Algoritmo de ordenacao por selecao.
    */
   @Override
   public void sort() {
      comparacoes = 0;
      movimentacoes = 0;

      for (int i = 0; i < (n - 1); i++) {
         int menor = i;
         for (int j = (i + 1); j < n; j++) {
            comparacoes++;
            if (array[menor] > array[j]) {
               menor = j;
            }
         }
         swap(menor, i);
         movimentacoes += 3; // conta as movimentações do swap
      }
   }

   @Override
   public void printarContadores() {
      System.out.println("Numero de comparacoes: " + comparacoes);
      System.out.println("Numero de movimentacoes: " + movimentacoes);
   }
}

class Principal {
   public static void main(String[] args) {

      // Delcaracao de variaveis
      Geracao algoritmo;
      int n = (args.length < 1) ? 10 : Integer.parseInt(args[0]);
      double inicio, fim;

      // Inicializacao do algoritmo de ordenacao
      //algoritmo = new Insercao(n);
      // algoritmo = new Mergesort(n);
      // algoritmo = new Quicksort(n);
      algoritmo = new Radixsort(n);
      // algoritmo = new Selecao(n);

      // Geracao do conjunto a ser ordenado
      // algoritmo.aleatorio();
      //algoritmo.crescente();
      algoritmo.decrescente();

      // Mostrar o conjunto a ser ordenado
      algoritmo.mostrar();

      // Execucao do algoritmo de ordenacao
      inicio = algoritmo.now();
      algoritmo.sort();
      fim = algoritmo.now();

      // Mostrar o conjunto ordenado, tempo de execucao e status da ordenacao
      algoritmo.mostrar();
      System.out.println("Tempo para ordenar: " + (fim - inicio) / 1000.0 + " s.");
      System.out.println("isOrdenado: " + algoritmo.isOrdenado());

      algoritmo.printarContadores();
   }
}