package Fila;

class Celula {
    public int elemento; // Elemento inserido na celula.
    public Celula prox; // Aponta a celula prox.

    /**
     * Construtor da classe.
     */
    public Celula() {
        this(0);
    }

    /**
     * Construtor da classe.
     * @param elemento int inserido na celula.
     */
    public Celula(int elemento) {
        this.elemento = elemento;
        this.prox = null;
    }
}

class FilaFlexivel {
    private Celula primeiro;
    private Celula ultimo;

    /**
     * Construtor da classe que cria uma fila sem elementos (somente no cabeca).
     */
    public FilaFlexivel() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    /**
     * Insere elemento na fila (politica FIFO).
     * @param x int elemento a inserir.
     */
    public void inserir(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    /**
     * Remove elemento da fila (politica FIFO).
     * @return Elemento removido.
     * @throws Exception Se a fila nao tiver elementos.
     */
    public int remover() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover! Fila vazia.");
        }

        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        int resp = primeiro.elemento;
        tmp.prox = null;
        return resp;
    }

    /**
     * Mostra os elementos separados por espacos.
     */
    public void mostrar() {
        System.out.print("[ ");

        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }

        System.out.println("]");
    }
}

class PrincipalFila {
    public static void main(String[] args) throws Exception {
        System.out.println("==== FILA FLEXIVEL ====");
        FilaFlexivel filaflex = new FilaFlexivel();
        int x1, x2, x3;

        filaflex.inserir(5);
        filaflex.inserir(7);
        filaflex.inserir(8);
        filaflex.inserir(9);

        System.out.println("Apos insercoes(5, 7, 8, 9): ");
        filaflex.mostrar();

        x1 = filaflex.remover();
        x2 = filaflex.remover();

        System.out.println("Apos remocoes (" + x1 + ", " + x2 + "):");
        filaflex.mostrar();

        filaflex.inserir(3);
        filaflex.inserir(4);

        System.out.println("Apos insercoes(3, 4): ");
        filaflex.mostrar();

        x1 = filaflex.remover();
        x2 = filaflex.remover();
        x3 = filaflex.remover();

        System.out.println("Apos remocoes (" + x1 + ", " + x2 + ", " + x3 + "):");
        filaflex.mostrar();

        filaflex.inserir(4);
        filaflex.inserir(5);

        System.out.println("Apos insercoes(4, 5): ");
        filaflex.mostrar();

        x1 = filaflex.remover();
        x2 = filaflex.remover();

        System.out.println("Apos remocoes (" + x1 + ", " + x2 + "):");
        filaflex.mostrar();

        filaflex.inserir(6);
        filaflex.inserir(7);

        System.out.println("Apos insercoes(6, 7): ");
        filaflex.mostrar();

        x1 = filaflex.remover();

        System.out.println("Apos remocao (" + x1 + "): ");
        filaflex.mostrar();
    }
}
