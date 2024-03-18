import java.util.*;

class VogaisAliens {
    static Scanner sc = new Scanner(System.in);

    public static int ContadorVogaisAliens(String alfabetoAlien, String fraseAlien) {
        int contador = 0;
        int i, j = 0;
        boolean resposta = false;

        for (i = 0; i < fraseAlien.length(); i++) {
            char letraFrase = fraseAlien.charAt(i);
            resposta = false; // Resetar resposta para falso em cada iteração do loop externo

            for (j = 0; j < alfabetoAlien.length(); j++) {
                char letraAlfabeto = alfabetoAlien.charAt(j);

                if (letraAlfabeto == letraFrase) {
                    resposta = true;
                    break;
                }
            }
            if (resposta) {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        String fraseAlien = "";
        String alfabetoAlien = "";
        int contador = 0;

        while (sc.hasNext()) {
            alfabetoAlien = sc.nextLine();
            fraseAlien = sc.nextLine();

            contador = ContadorVogaisAliens(alfabetoAlien, fraseAlien);

            System.out.println(contador);
        }

        sc.close();
    }
}