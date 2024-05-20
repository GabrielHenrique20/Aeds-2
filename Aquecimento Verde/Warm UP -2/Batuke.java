import java.util.Scanner;
import java.util.ArrayList;

class Celula {
    int pos;
    Celula esq, dir, inf, sup;

    public Celula() {
        this.pos = 0;
        this.esq = this.dir = this.inf = this.sup = null;
    }

    public Celula(int x) {
        this.pos = x;
        this.esq = this.dir = this.inf = this.sup = null;
    }
}

class Matriz {
    private Celula inicio;
    private int linha, coluna;

    public Matriz(int linhas, int colunas) {
        int count = 1;
        inicio = new Celula(count++);
        this.linha = linhas;
        this.coluna = colunas;
        Celula i = inicio;
        for (int j = 1; j < this.coluna; j++) {
            Celula nova = new Celula(count++);
            i.dir = nova;
            nova.esq = i;
            i = nova;
        }
        Celula linhaAnterior = inicio;
        for (int k = 1; k < this.linha; k++) {
            Celula novaLinha = new Celula(count++);
            linhaAnterior.inf = novaLinha;
            novaLinha.sup = linhaAnterior;
            Celula celulaAtualLinha = novaLinha;
            Celula celulaAcima = linhaAnterior;
            for (int j = 1; j < this.coluna; j++) {
                Celula novaCelula = new Celula(count++);
                celulaAtualLinha.dir = novaCelula;
                novaCelula.esq = celulaAtualLinha;
                celulaAcima = celulaAcima.dir;
                celulaAcima.inf = novaCelula;
                novaCelula.sup = celulaAcima;
                celulaAtualLinha = novaCelula;
            }
            linhaAnterior = novaLinha;
        }
    }

    public void caminhar(int lin, int col) {
        @SuppressWarnings("unused")
        int s = 0;
        ArrayList<Integer> percorridos = new ArrayList<Integer>();
        int count = 0;
        Celula aux = inicio;
        // Setar posicao inicial
        for (int i = 0; i < lin; i++) {
            aux = aux.inf;
        }
        for (int j = 0; j < col; j++) {
            aux = aux.dir;
        }
        int passos = 1;
        int qtd = 0;
        percorridos.add(aux.pos);
        qtd++;
        System.out.print(aux.pos + " ");
        while (qtd < this.linha * this.coluna) {
            for (int i = 0; i < passos; i++) {
                aux = aux.dir;
                System.out.print(aux.pos + " ");
                if (!percorridos.contains(aux.pos)) {
                    percorridos.add(aux.pos);
                }
                qtd++;
            }
            for (int i = 0; i < passos; i++) {
                aux = aux.inf;
                System.out.print(aux.pos + " ");
                if (!percorridos.contains(aux.pos)) {
                    percorridos.add(aux.pos);
                }
                qtd++;
            }
            passos++;
            for (int i = 0; i < passos; i++) {
                aux = aux.esq;
                System.out.print(aux.pos + " ");
                if (!percorridos.contains(aux.pos)) {
                    percorridos.add(aux.pos);
                }
                qtd++;
                if (qtd == (this.linha * this.coluna)) {
                    break;
                }
            }
            if (qtd == (this.linha * this.coluna)) {
                break;
            }
            for (int i = 0; i < passos; i++) {
                aux = aux.sup;
                System.out.print(aux.pos + " ");
                if (!percorridos.contains(aux.pos)) {
                    percorridos.add(aux.pos);
                }
                qtd++;
            }
            passos++;
        }
        System.out.println("\n" + qtd);
    }
}

public class Batuke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lin = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        Matriz vizinhanca = new Matriz(lin, lin);
        vizinhanca.caminhar(x, y);
        sc.close();
    }
}

/*
 * import java.io.*;
 * import java.nio.charset.*;
 * 
 * class MyIO {
 * 
 * private static BufferedReader in = new BufferedReader(new
 * InputStreamReader(System.in, Charset.forName("ISO-8859-1")));
 * private static String charset = "ISO-8859-1";
 * 
 * public static void setCharset(String charset_){
 * charset = charset_;
 * in = new BufferedReader(new InputStreamReader(System.in,
 * Charset.forName(charset)));
 * }
 * 
 * public static void print(){
 * }
 * 
 * public static void print(int x){
 * try {
 * PrintStream out = new PrintStream(System.out, true, charset);
 * out.print(x);
 * }catch(UnsupportedEncodingException e){
 * System.out.println("Erro: charset invalido"); }
 * }
 * 
 * public static void print(float x){
 * try {
 * PrintStream out = new PrintStream(System.out, true, charset);
 * out.print(x);
 * }catch(UnsupportedEncodingException e){
 * System.out.println("Erro: charset invalido"); }
 * }
 * 
 * public static void print(double x){
 * try {
 * PrintStream out = new PrintStream(System.out, true, charset);
 * out.print(x);
 * }catch(UnsupportedEncodingException e){
 * System.out.println("Erro: charset invalido"); }
 * }
 * 
 * public static void print(String x){
 * try {
 * PrintStream out = new PrintStream(System.out, true, charset);
 * out.print(x);
 * }catch(UnsupportedEncodingException e){
 * System.out.println("Erro: charset invalido"); }
 * }
 * 
 * public static void print(boolean x){
 * try {
 * PrintStream out = new PrintStream(System.out, true, charset);
 * out.print(x);
 * }catch(UnsupportedEncodingException e){
 * System.out.println("Erro: charset invalido"); }
 * }
 * 
 * public static void print(char x){
 * try {
 * PrintStream out = new PrintStream(System.out, true, charset);
 * out.print(x);
 * }catch(UnsupportedEncodingException e){
 * System.out.println("Erro: charset invalido"); }
 * }
 * 
 * public static void println(){
 * }
 * 
 * public static void println(int x){
 * try {
 * PrintStream out = new PrintStream(System.out, true, charset);
 * out.println(x);
 * }catch(UnsupportedEncodingException e){
 * System.out.println("Erro: charset invalido"); }
 * }
 * 
 * public static void println(float x){
 * try {
 * PrintStream out = new PrintStream(System.out, true, charset);
 * out.println(x);
 * }catch(UnsupportedEncodingException e){
 * System.out.println("Erro: charset invalido"); }
 * }
 * 
 * public static void println(double x){
 * try {
 * PrintStream out = new PrintStream(System.out, true, charset);
 * out.println(x);
 * }catch(UnsupportedEncodingException e){
 * System.out.println("Erro: charset invalido"); }
 * }
 * 
 * public static void println(String x){
 * try {
 * PrintStream out = new PrintStream(System.out, true, charset);
 * out.println(x);
 * }catch(UnsupportedEncodingException e){
 * System.out.println("Erro: charset invalido"); }
 * }
 * 
 * public static void println(boolean x){
 * try {
 * PrintStream out = new PrintStream(System.out, true, charset);
 * out.println(x);
 * }catch(UnsupportedEncodingException e){
 * System.out.println("Erro: charset invalido"); }
 * }
 * 
 * public static void println(char x){
 * try {
 * PrintStream out = new PrintStream(System.out, true, charset);
 * out.println(x);
 * }catch(UnsupportedEncodingException e){
 * System.out.println("Erro: charset invalido"); }
 * }
 * 
 * public static void printf(String formato, double x){
 * try {
 * PrintStream out = new PrintStream(System.out, true, charset);
 * out.printf(formato, x);// "%.2f"
 * }catch(UnsupportedEncodingException e){
 * System.out.println("Erro: charset invalido"); }
 * }
 * 
 * public static double readDouble(){
 * double d = -1;
 * try{
 * d = Double.parseDouble(readString().trim().replace(",","."));
 * }catch(Exception e){}
 * return d;
 * }
 * 
 * public static double readDouble(String str){
 * try {
 * PrintStream out = new PrintStream(System.out, true, charset);
 * out.print(str);
 * }catch(UnsupportedEncodingException e){
 * System.out.println("Erro: charset invalido"); }
 * return readDouble();
 * }
 * 
 * public static float readFloat(){
 * return (float) readDouble();
 * }
 * 
 * public static float readFloat(String str){
 * return (float) readDouble(str);
 * }
 * 
 * public static int readInt(){
 * int i = -1;
 * try{
 * i = Integer.parseInt(readString().trim());
 * }catch(Exception e){}
 * return i;
 * }
 * 
 * public static int readInt(String str){
 * try {
 * PrintStream out = new PrintStream(System.out, true, charset);
 * out.print(str);
 * }catch(UnsupportedEncodingException e){
 * System.out.println("Erro: charset invalido"); }
 * return readInt();
 * }
 * 
 * public static String readString(){
 * String s = "";
 * char tmp;
 * try{
 * do{
 * tmp = (char)in.read();
 * if(tmp != '\n' && tmp != ' ' && tmp != 13){
 * s += tmp;
 * }
 * }while(tmp != '\n' && tmp != ' ');
 * }catch(IOException ioe){
 * System.out.println("lerPalavra: " + ioe.getMessage());
 * }
 * return s;
 * }
 * 
 * public static String readString(String str){
 * try {
 * PrintStream out = new PrintStream(System.out, true, charset);
 * out.print(str);
 * }catch(UnsupportedEncodingException e){
 * System.out.println("Erro: charset invalido"); }
 * return readString();
 * }
 * 
 * public static String readLine(){
 * String s = "";
 * char tmp;
 * try{
 * do{
 * tmp = (char)in.read();
 * if(tmp != '\n' && tmp != 13){
 * s += tmp;
 * }
 * }while(tmp != '\n');
 * }catch(IOException ioe){
 * System.out.println("lerPalavra: " + ioe.getMessage());
 * }
 * return s;
 * }
 * 
 * public static String readLine(String str){
 * try {
 * PrintStream out = new PrintStream(System.out, true, charset);
 * out.print(str);
 * }catch(UnsupportedEncodingException e){
 * System.out.println("Erro: charset invalido"); }
 * return readLine();
 * }
 * 
 * public static char readChar(){
 * char resp = ' ';
 * try{
 * resp = (char)in.read();
 * }catch(Exception e){}
 * return resp;
 * }
 * 
 * public static char readChar(String str){
 * try {
 * PrintStream out = new PrintStream(System.out, true, charset);
 * out.print(str);
 * }catch(UnsupportedEncodingException e){
 * System.out.println("Erro: charset invalido"); }
 * return readChar();
 * }
 * 
 * public static boolean readBoolean(){
 * boolean resp = false;
 * String str = "";
 * 
 * try{
 * str = readString();
 * }catch(Exception e){}
 * 
 * if(str.equals("true") || str.equals("TRUE") || str.equals("t") ||
 * str.equals("1") ||
 * str.equals("verdadeiro") || str.equals("VERDADEIRO") || str.equals("V")){
 * resp = true;
 * }
 * 
 * return resp;
 * }
 * 
 * public static boolean readBoolean(String str){
 * try {
 * PrintStream out = new PrintStream(System.out, true, charset);
 * out.print(str);
 * }catch(UnsupportedEncodingException e){
 * System.out.println("Erro: charset invalido"); }
 * return readBoolean();
 * }
 * 
 * public static void pause(){
 * try{
 * in.read();
 * }catch(Exception e){}
 * }
 * 
 * public static void pause(String str){
 * try {
 * PrintStream out = new PrintStream(System.out, true, charset);
 * out.print(str);
 * }catch(UnsupportedEncodingException e){
 * System.out.println("Erro: charset invalido"); }
 * pause();
 * }
 * }
 */