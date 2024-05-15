package Matriz;

class Celula {
    public int elemento;
    public Celula inf, sup, esq, dir;
 
    public Celula(){
       this(0);
    }
 
    public Celula(int elemento){
       this(elemento, null, null, null, null);
    }
 
    public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir){
       this.elemento = elemento;
       this.inf = inf;
       this.sup = sup;
       this.esq = esq;
       this.dir = dir;
    }
 }

 class MatrizFlexivel{
   private Celula inicio;
   private int linha,coluna;
   public MatrizFlexivel(){
       this(3,3);
   }
   public MatrizFlexivel(int linhas, int colunas){
      inicio = new Celula(0);
      this.linha = linhas;
      this.coluna = colunas;
      Celula i = inicio;
      for(int j = 1; j< this.coluna; j++){
       Celula nova = new Celula(0);
       i.dir = nova;
       nova.esq = i;
       i = nova;
      }

      Celula linhaAnterior = inicio;
      for(int k = 1; k<this.linha; k++){
       Celula novaLinha = new Celula(0);
       linhaAnterior.inf = novaLinha;
       novaLinha.sup = linhaAnterior;

       Celula celulaAtualLinha = novaLinha;
       Celula celulaAcima = linhaAnterior;
       for(int j = 1; j<this.coluna; j++){
           Celula novaCelula = new Celula(0);
           celulaAtualLinha.dir = novaCelula;
           novaCelula.esq = celulaAtualLinha;

           celulaAcima = celulaAcima.dir;
           celulaAcima.inf = novaCelula;
           novaCelula.sup = celulaAcima;

           celulaAtualLinha=novaCelula;
       }
       linhaAnterior = novaLinha;
      }
       
   }
}