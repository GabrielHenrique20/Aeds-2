
import java.io.*;
import java.nio.charset.*;

class MyIO {

    private static BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));
    private static String charset = "ISO-8859-1";

    public static void setCharset(String charset_) {
        charset = charset_;
        in = new BufferedReader(new InputStreamReader(System.in, Charset.forName(charset)));
    }

    public static void print() {
    }

    public static void print(int x) {
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(x);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Erro: charset invalido");
        }
    }

    public static void print(float x) {
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(x);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Erro: charset invalido");
        }
    }

    public static void print(double x) {
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(x);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Erro: charset invalido");
        }
    }

    public static void print(String x) {
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(x);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Erro: charset invalido");
        }
    }

    public static void print(boolean x) {
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(x);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Erro: charset invalido");
        }
    }

    public static void print(char x) {
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(x);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Erro: charset invalido");
        }
    }

    public static void println() {
    }

    public static void println(int x) {
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.println(x);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Erro: charset invalido");
        }
    }

    public static void println(float x) {
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.println(x);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Erro: charset invalido");
        }
    }

    public static void println(double x) {
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.println(x);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Erro: charset invalido");
        }
    }

    public static void println(String x) {
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.println(x);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Erro: charset invalido");
        }
    }

    public static void println(boolean x) {
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.println(x);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Erro: charset invalido");
        }
    }

    public static void println(char x) {
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.println(x);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Erro: charset invalido");
        }
    }

    public static void printf(String formato, double x) {
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.printf(formato, x);// "%.2f"
        } catch (UnsupportedEncodingException e) {
            System.out.println("Erro: charset invalido");
        }
    }

    public static double readDouble() {
        double d = -1;
        try {
            d = Double.parseDouble(readString().trim().replace(",", "."));
        } catch (Exception e) {
        }
        return d;
    }

    public static double readDouble(String str) {
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(str);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Erro: charset invalido");
        }
        return readDouble();
    }

    public static float readFloat() {
        return (float) readDouble();
    }

    public static float readFloat(String str) {
        return (float) readDouble(str);
    }

    public static int readInt() {
        int i = -1;
        try {
            i = Integer.parseInt(readString().trim());
        } catch (Exception e) {
        }
        return i;
    }

    public static int readInt(String str) {
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(str);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Erro: charset invalido");
        }
        return readInt();
    }

    public static String readString() {
        String s = "";
        char tmp;
        try {
            do {
                tmp = (char) in.read();
                if (tmp != '\n' && tmp != ' ' && tmp != 13) {
                    s += tmp;
                }
            } while (tmp != '\n' && tmp != ' ');
        } catch (IOException ioe) {
            System.out.println("lerPalavra: " + ioe.getMessage());
        }
        return s;
    }

    public static String readString(String str) {
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(str);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Erro: charset invalido");
        }
        return readString();
    }

    public static String readLine() {
        String s = "";
        char tmp;
        try {
            do {
                tmp = (char) in.read();
                if (tmp != '\n' && tmp != 13) {
                    s += tmp;
                }
            } while (tmp != '\n');
        } catch (IOException ioe) {
            System.out.println("lerPalavra: " + ioe.getMessage());
        }
        return s;
    }

    public static String readLine(String str) {
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(str);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Erro: charset invalido");
        }
        return readLine();
    }

    public static char readChar() {
        char resp = ' ';
        try {
            resp = (char) in.read();
        } catch (Exception e) {
        }
        return resp;
    }

    public static char readChar(String str) {
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(str);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Erro: charset invalido");
        }
        return readChar();
    }

    public static boolean readBoolean() {
        boolean resp = false;
        String str = "";

        try {
            str = readString();
        } catch (Exception e) {
        }

        if (str.equals("true") || str.equals("TRUE") || str.equals("t") || str.equals("1") ||
                str.equals("verdadeiro") || str.equals("VERDADEIRO") || str.equals("V")) {
            resp = true;
        }

        return resp;
    }

    public static boolean readBoolean(String str) {
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(str);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Erro: charset invalido");
        }
        return readBoolean();
    }

    public static void pause() {
        try {
            in.read();
        } catch (Exception e) {
        }
    }

    public static void pause(String str) {
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(str);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Erro: charset invalido");
        }
        pause();
    }
}

public class TP01Q05 {
    public static void main(String[] args) {
        boolean notFim;
        int quantNumeros;
        String entradaString = new String();
        int tam;
        char[] entradaChar = new char[1000];

        do {
            quantNumeros = MyIO.readInt();
            notFim = notFim(quantNumeros);
            if (notFim) {
                String[] listaValores = lerValores(quantNumeros);
                entradaString = MyIO.readLine();
                str2char(entradaString, entradaChar);
                tam = entradaString.length();
                tam = removerEspacos(entradaChar, tam);
                trocar(entradaChar, listaValores, tam);
                char resp = algebraBooleana(entradaChar, tam);
                MyIO.println(resp);
            }
        } while (notFim);
    }

    /*
     * Converte de String para array de caracteres
     */
    public static void str2char(String entradaString, char[] entradaChar) {
        for (int i = 0; i < entradaString.length(); i++) {
            entradaChar[i] = entradaString.charAt(i);
        }
    }

    public static int removerEspacos(char[] entradaChar, int tam) {
        for (int i = 0; i < tam; i++) {
            if (entradaChar[i] == ' ' || entradaChar[i] == ',') {
                for (int j = i; j < tam - 1; j++) {
                    entradaChar[j] = entradaChar[j + 1];
                }
                i--;
                entradaChar[tam] = '\0';
                tam--;
            }
        }
        return tam;
    }

    /*
     * Troca as letras pelos valores binarios
     */

    public static void trocar(char[] entradaChar, String[] listaValores, int tam) {
        int index = 0;
        for (int i = 0; i < listaValores.length; i++) {
            for (int j = 0; j < tam; j++) {
                if ((int) entradaChar[j] == index + 65) {
                    entradaChar[j] = (char) listaValores[index].charAt(0);
                }
            }
            index++;
        }
        return;
    }

    /*
     * Le os valores binarios que sao apresentados na entrada
     */
    public static String[] lerValores(int quantValores) {
        String[] listaValores = new String[quantValores];
        for (int i = 0; i < quantValores; i++) {
            listaValores[i] = MyIO.readString();
        }
        return listaValores;
    }

    /*
     * Metodo booleano not
     */
    public static char not(char[] valores, int quantValores) {
        char retorno = '1';
        for (int i = 0; i < quantValores; i++) {

            if (valores[i] == '1') {
                retorno = '0';
                i = quantValores;
                valores = new char[10];
            }
        }
        return retorno;

    }

    /*
     * Metodo booleano and
     */
    public static char and(char[] valores, int quantValores) {
        char retorno = '1';
        for (int i = 0; i < quantValores; i++) {

            if (valores[i] == '0') {
                retorno = '0';
                i = quantValores;
                valores = new char[10];
            }
        }
        return retorno;

    }
    /*
     * Metodo booleano or
     */

    public static char or(char[] valores, int quantValores) {
        char retorno = '0';
        for (int i = 0; i < quantValores; i++) {

            if (valores[i] == '1') {
                retorno = '1';
                i = quantValores;
                valores = new char[10];
            }
        }
        return retorno;
    }

    /*
     * Realiza a solucao da expressao booleana. Para isso, procura um ')', salva sua
     * posicao em i e depois
     * procura um '('. Depois olha qual caractere est� antes de '('. Se for 'd',
     * sabe-se que eh um and, se for 'r'
     * eh um or e se for um 't', eh um not. Com isso, ele le os valores entre '(' e
     * ')' e armazena em char[] valores, depois manda
     * o array para a funcao correspondente.
     */

    public static char algebraBooleana(char[] entradaChar, int tam) {

        char substituir;
        char[] valores = new char[10];
        int quantValores = 0;

        for (int i = 0; i < tam; i++) {
            if (entradaChar[i] == ')') {

                for (int j = i; j > 0; j--) {
                    if (entradaChar[j] == '(') {
                        // Achei um not
                        if (entradaChar[j - 1] == 't') {
                            valores[quantValores] = entradaChar[j + 1];
                            quantValores++;

                            substituir = not(valores, quantValores);
                            entradaChar[j - 3] = substituir;
                            for (int k = 0; k < quantValores + 4; k++) {
                                for (int w = j - 2; w < tam - 1; w++) {
                                    entradaChar[w] = entradaChar[w + 1];
                                }
                                entradaChar[tam - k] = '\0';
                            }
                            tam -= quantValores + 4;
                            quantValores = 0;
                            i = 0;
                            j = 0;
                        }

                        // Achei um and
                        else if (entradaChar[j - 1] == 'd') {
                            for (int k = j + 1; k < i; k++) {
                                valores[quantValores] = entradaChar[k];
                                quantValores++;
                            }
                            substituir = and(valores, quantValores);
                            entradaChar[j - 3] = substituir;

                            for (int k = 0; k < quantValores + 4; k++) {
                                for (int w = j - 2; w < tam - 1; w++) {
                                    entradaChar[w] = entradaChar[w + 1];
                                }
                                entradaChar[tam - k] = '\0';
                            }

                            tam -= quantValores + 4;
                            quantValores = 0;
                            i = 0;
                            j = 0;
                        }

                        // Achei um or
                        else if (entradaChar[j - 1] == 'r') {
                            for (int k = j + 1; k < i; k++) {
                                valores[quantValores] = entradaChar[k];
                                quantValores++;
                            }
                            substituir = or(valores, quantValores);
                            entradaChar[j - 2] = substituir;

                            for (int k = 0; k < quantValores + 3; k++) {
                                for (int w = j - 1; w < tam - 1; w++) {
                                    entradaChar[w] = entradaChar[w + 1];
                                }
                                entradaChar[tam - k] = '\0';
                            }
                            tam -= quantValores + 3;
                            quantValores = 0;
                            i = 0;
                            j = 0;
                        }
                    }
                }
            }
        }
        return entradaChar[0];
    }

    /*
     * Verifica se a palavra inserida pelo usuario eh igual a FIM. Se for diferente,
     * retorna True
     */
    public static boolean notFim(int quantNumeros) {
        boolean notFim = true;
        if (quantNumeros == 0) {
            notFim = false;
        }
        return notFim;
    }

}