package Pilha;

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
     * 
     * @param elemento int inserido na celula.
     */
    public Celula(int elemento) {
        this.elemento = elemento;
        this.prox = null;
    }
}

public class PilhaFlexivel {
    private Celula topo;

    /**
     * Construtor da classe que cria uma fila sem elementos.
     */
    public PilhaFlexivel() {
        topo = null;
    }

    /**
     * Insere elemento na pilha (politica FILO).
     * 
     * @param x int elemento a inserir.
     */
    public void inserir(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
        tmp = null;
    }

    /**
     * Remove elemento da pilha (politica FILO).
     * 
     * @return Elemento removido.
     * @trhows Exception Se a sequencia nao contiver elementos.
     */
    public int remover() throws Exception {
        if (topo == null) {
            throw new Exception("Erro ao remover!");
        }
        int resp = topo.elemento;
        Celula tmp = topo;
        topo = topo.prox;
        tmp.prox = null;
        tmp = null;
        return resp;
    }

    /**
     * Mostra os elementos separados por espacos, comecando do topo.
     */
    public void mostrar() {
        System.out.print("[ ");
        for (Celula i = topo; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println("] ");
    }

    public int getSoma() {
        return getSoma(topo);
    }

    private int getSoma(Celula i) {
        int resp = 0;
        if (i != null) {
            resp += i.elemento + getSoma(i.prox);
        }
        return resp;
    }

    public int getMax() {
        int max = topo.elemento;
        for (Celula i = topo.prox; i != null; i = i.prox) {
            if (i.elemento > max)
                max = i.elemento;
        }
        return max;
    }

    public void mostraPilha() {
        mostraPilha(topo);
    }

    private void mostraPilha(Celula i) {
        if (i != null) {
            mostraPilha(i.prox);
            System.out.println("" + i.elemento);
        }
    }

}

class PrincipalPilha {
    public static void main(String[] args) {
        try {
            System.out.println(" ==== PILHA FLEXIVEL ====");
            PilhaFlexivel pilhaflex = new PilhaFlexivel();
            int x1, x2, x3;

            pilhaflex.inserir(0);
            pilhaflex.inserir(1);
            pilhaflex.inserir(2);
            pilhaflex.inserir(3);
            pilhaflex.inserir(4);
            pilhaflex.inserir(5);

            System.out.print("Apos insercoes: ");
            pilhaflex.mostrar();

            x1 = pilhaflex.remover();
            x2 = pilhaflex.remover();
            x3 = pilhaflex.remover();

            System.out.print("Apos as remocoes (" + x1 + "," + x2 + "," + x3 + "): ");
            pilhaflex.mostrar();

        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }
    }
}
