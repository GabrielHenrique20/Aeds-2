/* import java.io.*;
import java.net.*;

class ExemploURL {
   public static String getHtml(String endereco){
      URL url;
      InputStream is = null;
      BufferedReader br;
      String resp = "", line;

      try {
         url = new URL(endereco);
         is = url.openStream();  // throws an IOException
         br = new BufferedReader(new InputStreamReader(is));

         while ((line = br.readLine()) != null) {
            resp += line + "\n";
         }
      } catch (MalformedURLException mue) {
         mue.printStackTrace();
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } 

      try {
         is.close();
      } catch (IOException ioe) {
         // nothing to see here

      }

      return resp;
   }
   public static void main(String[] args) {
      String endereco, html;
      endereco = "http://maratona.crc.pucminas.br/series/Friends.html";
      html = getHtml(endereco);
      System.out.print(html);
   }
}*/

/*Leia duas strings sendo que a primeira é o nome de uma página web e a segunda, seu endereço. 
Por exemplo, Pontifícia Universidade Católica de Minas Gerais e www.pucminas.br. 
Em seguida, mostre na tela o número de vogais (sem e com acento), consoantes e dos padrões <br> e <table> que aparecem no código dessa página. 
A entrada padrão é composta por várias linhas. Cada uma contém várias strings sendo que a primeira é um endereço web e as demais o nome dessa página web. 
A última linha da entrada padrão contém a palavra FIM. A saída padrão contém várias linhas sendo que cada uma apresenta o número de ocorrência 
(valor x_{i} entre parênteses) de cada caractere ou string solicitado. 
Cada linha de saída será da seguinte forma: a(x_{1}) e(x_{2}) i(x_{3}) o(x_{4}) u(x_{5}) á(x_{6}) é(x_{7}) í(x_{8}) ó(x_{9}) ú(x_{10}) à(x_{11}) 
è(x_{12}) ì(x_{13}) ò(x_{14}) ù(x_{15}) ã(x_{16}) õ(x_{17}) â(x_{19}) ê(x_{19}) î(x_{20}) ô(x_{21}) û(x_{22}) consoante(x_{23}) *<br>*(x_{24}) 
*<table>*(x_{25}) nomepágina(x_{26}). */

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

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

public class TP01Q07 {

    public static boolean isFim(String s) {
        return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static String getHtml(String endereco) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;

        try {
            url = new URL(endereco);
            is = url.openStream(); // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                resp += line + "\n";
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            is.close();
        } catch (IOException ioe) {
            // nothing to see here

        }

        return resp;
    }

    public static int hasTag(String html, String tag) {
        int qtd = 0;
        if (tag == "<table>") {
            for (int i = 0; i < html.length(); i++) {
                if (html.charAt(i) == '<') {
                    if (html.charAt(i + 1) == 't' && html.charAt(i + 2) == 'a' && html.charAt(i + 3) == 'b'
                            && html.charAt(i + 4) == 'l' && html.charAt(i + 5) == 'e' && html.charAt(i + 6) == '>') {
                        qtd++;
                    }
                }
            }
        } else {
            for (int i = 0; i < html.length(); i++) {
                if (html.charAt(i) == '<') {
                    if (html.charAt(i + 1) == 'b' && html.charAt(i + 2) == 'r' && html.charAt(i + 3) == '>') {
                        qtd++;
                    }
                }
            }
        }
        return qtd;
    }

    public static void Has(String html, String titulo) {
        int[] qtd = new int[25];
        qtd[23] = hasTag(html, "<br>");
        qtd[24] = hasTag(html, "<table>");
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) >= 97 && html.charAt(i) <= 122 && (html.charAt(i) != 97 && html.charAt(i) != 101
                    && html.charAt(i) != 105 && html.charAt(i) != 111 && html.charAt(i) != 117)) {
                qtd[22]++;
            } else {
                if (html.charAt(i) == 'a')
                    qtd[0]++;
                else {
                    if (html.charAt(i) == 'e')
                        qtd[1]++;
                    else {
                        if (html.charAt(i) == 'i')
                            qtd[2]++;
                        else {
                            if (html.charAt(i) == 'o')
                                qtd[3]++;
                            else {
                                if (html.charAt(i) == 'u')
                                    qtd[4]++;
                                else {
                                    if (html.charAt(i) == '\u00E1') // á
                                        qtd[5]++;
                                    else {
                                        if (html.charAt(i) == '\u00E9')
                                            qtd[6]++;
                                        else {
                                            if (html.charAt(i) == '\u00ED')
                                                qtd[7]++;
                                            else {
                                                if (html.charAt(i) == '\u00F3')
                                                    qtd[8]++;
                                                else {
                                                    if (html.charAt(i) == '\u00FA')
                                                        qtd[9]++;
                                                    else {
                                                        if (html.charAt(i) == '\u00E0')
                                                            qtd[10]++;
                                                        else {
                                                            if (html.charAt(i) == '\u00E8')
                                                                qtd[11]++;
                                                            else {
                                                                if (html.charAt(i) == '\u00EC')
                                                                    qtd[12]++;
                                                                else {
                                                                    if (html.charAt(i) == '\u00F2')
                                                                        qtd[13]++;
                                                                    else {
                                                                        if (html.charAt(i) == '\u00F9')
                                                                            qtd[14]++;
                                                                        else {
                                                                            if (html.charAt(i) == '\u00E3')
                                                                                qtd[15]++;
                                                                            else {
                                                                                if (html.charAt(i) == '\u00F5')
                                                                                    qtd[16]++;
                                                                                else {
                                                                                    if (html.charAt(i) == '\u00E2')
                                                                                        qtd[17]++;
                                                                                    else {
                                                                                        if (html.charAt(i) == '\u00EA')
                                                                                            qtd[18]++;
                                                                                        else {
                                                                                            if (html.charAt(
                                                                                                    i) == '\u00EE')
                                                                                                qtd[19]++;
                                                                                            else {
                                                                                                if (html.charAt(
                                                                                                        i) == '\u00F4')
                                                                                                    qtd[20]++;
                                                                                                else {
                                                                                                    if (html.charAt(
                                                                                                            i) == '\u00FB')
                                                                                                        qtd[21]++;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (qtd[24] > 0) { // table
            qtd[0] = qtd[0] - qtd[24];
            qtd[1] = qtd[1] - qtd[24];
            qtd[22] = qtd[22] - 3 * qtd[24];
        }
        if (qtd[23] > 0) {// br
            qtd[22] = qtd[22] - 2 * qtd[23];
        }

        System.out.println("a(" + (qtd[0]) + ") e(" + (qtd[1]) + ") i(" + qtd[2] + ") o(" + qtd[3] + ") u(" + qtd[4]
                + ") " + (char) '\u00E1' + "(" + qtd[5] + ") " + (char) '\u00E9' + "(" + qtd[6] + ") " + (char) '\u00ED'
                + "(" +
                qtd[7] + ") " + (char) '\u00F3' + "(" + qtd[8] + ") " + (char) '\u00FA' + "(" + qtd[9] + ") "
                + (char) '\u00E0' + "(" + qtd[10]
                + ") " + (char) '\u00E8' + "(" + qtd[11] + ") " + (char) '\u00EC' + "(" + qtd[12] + ") "
                + (char) '\u00F2' + "(" +
                qtd[13] + ") " + (char) '\u00F9' + "(" + qtd[14] + ") " + (char) '\u00E3' + "(" + qtd[15] + ") "
                + (char) '\u00F5' + "("
                + qtd[16] + ") " + (char) '\u00E2' + "(" + qtd[17] + ") " + (char) '\u00EA' + "(" + qtd[18] + ") "
                + (char) '\u00EE' + "(" + qtd[19] + ") " + (char) '\u00F4' + "(" + qtd[20] + ") " + (char) '\u00FB'
                + "(" + qtd[21]
                + ") consoante(" + qtd[22] + ") <br>(" + qtd[23] + ") <table>(" + qtd[24] + ") " + titulo);
    }

    public static void main(String[] args) {
        String[] linhas = new String[100];
        String[] endereco = new String[50];
        String[] titulo = new String[50];
        int numEntrada = 0;

        do {
            linhas[numEntrada] = MyIO.readLine();
        } while (isFim(linhas[numEntrada++]) == false);
        numEntrada--;

        String html;

        for (int i = 0, j = 0; i < numEntrada; i += 2, j++) {
            titulo[j] = linhas[i];
            endereco[j] = linhas[i + 1];
            html = getHtml(endereco[j]);
            Has(html, titulo[j]);
        }
    }
}
