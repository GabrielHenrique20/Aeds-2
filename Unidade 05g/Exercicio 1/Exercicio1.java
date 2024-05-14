import java.io.*;

class Contato {
    String nome, telefone, email;
    int cpf;

    public Contato() {
        this("", "", "", -1);
    }

    public Contato(String nome, String telefone, String email, int cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }
}

class Celula {
    Contato contato;
    Celula prox;

    Celula() {
        this.contato = new Contato(); // novo ponteiro Contato
        this.prox = null; // ponteiro para null
    }

    Celula(Contato contato) {
        this.contato = contato;
        this.prox = prox;
    }
}

class No {
    char letra;
    No esq, dir;
    Celula primeiro, ultimo;

    No(char c) {
        this.letra = c;
        this.dir = null;
        this.esq = null;
        this.primeiro = new Celula();
        this.ultimo = primeiro;
    }

    void mostrar() {
        Celula i;

        for (i = primeiro.prox; i != null; i = i.prox) {
            System.out.println(i.contato.nome + " ");
        }
    }
}

class Agenda {
    No raiz;

    int compararCaractere(char c1, char c2) {
        if ((int) c1 > (int) c2) {
            return 1;
        } else if ((int) c1 < (int) c2) {
            return -1;
        } else {
            return 0;
        }
    }

    void inserirNo(char c) throws Exception {
        raiz = inserirNo(c, raiz);
    }

    No inserirNo(char c, No i) throws Exception {
        if (i == null) {
            i = new No(c);
        }

        else if (compararCaractere(c, i.letra) < 0) {
            i.esq = inserirNo(c, i.esq);
        }

        else if (compararCaractere(c, i.letra) > 0) {
            i.dir = inserirNo(c, i.dir);
        }

        else {
            throw new Exception("Erro!");
        }
        return i;
    }

    // METODOS PARA CONSTRUIR A ARVORE (quase igual quando faz o heapsort)

    void construirArvoreBinaria(char inicio, char fim) {
        if (inicio > fim) {
            return;
        }

        char meio = (char) ((inicio + fim) / 2.0);
        try {
            inserirNo(meio);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        construirArvoreBinaria(inicio, (char) (meio - 1));
        construirArvoreBinaria((char) (meio + 1), fim);
    }

    // Inserir todas as 26 letras do alfabeto...
    Agenda() throws Exception {
        construirArvoreBinaria('A', 'Z');
    }

    void parteCentralDaArvore(No i) {
        if (i != null) {
            parteCentralDaArvore(i.esq);
            System.out.println(i.letra + " ");
            i.mostrar();
            parteCentralDaArvore(i.dir);
        }
    }

    // Metodo para inserir
    void inserir(Contato contato) {
        raiz = inserir(contato, raiz);
    }

    No inserir(Contato contato, No i) {
        if (contato.nome.charAt(0) == i.letra) {
            if (i.primeiro == null) {
                i.primeiro.prox = new Celula(contato);
                i.ultimo = i.primeiro.prox;
            } else {
                Celula tmp = i.primeiro.prox;
                i.primeiro.prox = new Celula(contato);
                i.primeiro.prox.prox = tmp;
            }
        } else if (compararCaractere(contato.nome.charAt(0), i.letra) > 0) {
            inserir(contato, i.dir);
        } else {
            inserir(contato, i.esq);
        }
        return i;
    }

    // Metodo de remover

    // Metodo de pesquisar pelo nome
    public boolean pesquisarNome(String nome) {
		return pesquisarNome(raiz, nome);
	}

	private boolean pesquisarNome(No no, String nome) {
      boolean resp;
		if (no == null) { 
         resp = false;
      } else if (Char.toUpper(nome.charAt(0)) == no.letra) { 
         resp = false;
         for(Celula i = no.primeiro.prox; (!resp && i != null); i = i.prox){
            if(i.contato.nome.equals(nome) == true){
               resp = true;
            }
         }
      } else if (Char.toUpper(nome.charAt(0)) < no.letra) { 
         resp = pesquisarNome(no.esq, nome); 

      } else { 
         resp = pesquisarNome(no.dir, nome); 
      }
      return resp;
	}

    // Metodo de pesquisar pelo cpf
    public boolean pesquisar(int cpf) {
		return pesquisar(raiz, cpf);
	}

	private boolean pesquisar(No no, int cpf) {
		boolean resp = false;
		if (no != null) {
			resp = pesquisar(no.primeiro.prox, cpf);
			if(resp == false){
				resp = pesquisar(no.esq, cpf);
				if(resp == false){
					resp = pesquisar(no.dir, cpf);
				}
			}
		}
		return resp;
	}

	private boolean pesquisar(Celula i, int cpf){
        return false;
		//efeuar a pesquisa na lista a partir do i
	}
}