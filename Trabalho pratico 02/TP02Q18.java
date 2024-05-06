/*Refaça a Questão Quicksort considerando a ordenação parcial com k igual a 10. */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Diferenca entre DateTime e Date:
 
 A diferença não é só a notação, é o conteúdo, é o valor que ele armazena. 
 Date não tem hora, só a data, DateTime tem ambos, e isso é importante porque é possível extrair só a data ou só a hora do segundo, 
 mas o primeiro só tem data.


 */

// Classe lista para inicializar e mexer na variavel alternate_names
class Lista {
    private List<String> Lista;

    Lista() {
        this.Lista = new ArrayList<>();
    }

    public List<String> getLista() {
        return Lista;
    }

    public void setLista(List<String> lista) {
        Lista = lista;
    }

    public List<String> parseStringToList(String texto) {
        // Expressão regular para encontrar strings entre aspas simples
        Pattern pattern = Pattern.compile("'(.*?)'");
        Matcher matcher = pattern.matcher(texto);

        // Iterar sobre as correspondências encontradas e adicionar à lista
        while (matcher.find()) {
            Lista.add(matcher.group(1)); // Adiciona o texto capturado entre as aspas simples
        }

        return Lista;

    }
}

class Personagem {
    private String id;
    private String name;
    private List<String> alternate_names;
    private String house;
    private String ancestry;
    private String species;
    private String patronus;
    private boolean hogwartsStaff;
    private boolean hogwatsStudent;
    private String actorName;
    private boolean alive;
    private Date dateOfBirth;
    private int yearOfBith;
    private String eyeColour;
    private String gender;
    private String hairColor;
    private boolean wizard;

    // OBS --> Sua classe tambem tera pelo menos dois construtores, os metodos
    // gets, sets, clone, imprimir e ler.

    // Primeiro construtor para inicializar tudo
    public Personagem(String id, String name, List<String> alternate_names, String house, String ancestry,
            String species,
            String patronus, boolean hogwartsStaff, boolean hogwatsStudent, String actorName, boolean alive,
            Date dateOfBirth, int yearOfBith, String eyeColour, String gender, String hairColor, boolean wizard) {
        this.id = id;
        this.name = name;
        this.alternate_names = alternate_names;
        this.house = house;
        this.ancestry = ancestry;
        this.species = species;
        this.patronus = patronus;
        this.hogwartsStaff = hogwartsStaff;
        this.hogwatsStudent = hogwatsStudent;
        this.actorName = actorName;
        this.alive = alive;
        this.dateOfBirth = dateOfBirth;
        this.yearOfBith = yearOfBith;
        this.eyeColour = eyeColour;
        this.gender = gender;
        this.hairColor = hairColor;
        this.wizard = wizard;
    }

    // Segundo construtor
    public Personagem() {
        this.id = "zzzzzzzzzzzz";
        this.name = "zzzzzzzzzzzzz";
        this.alternate_names = new ArrayList<>();
        this.house = "zzzzzzzzzzzzz";
        this.ancestry = "zzzzzzzzzzzzzz";
        this.species = "zzzzzzzzzzzzzzzzzz";
        this.patronus = "zzzzzzzzzzzzzz";
        this.hogwartsStaff = false;
        this.hogwatsStudent = false;
        this.actorName = "zzzzzzzzzzzzzzzzzzzzzz";
        this.alive = false;
        this.dateOfBirth = Date.from(Instant.now());
        this.yearOfBith = 0;
        this.eyeColour = "zzzzzzzzzzzzzzzz";
        this.gender = "zzzzzzzzzzzzzzzzzzzz";
        this.hairColor = "zzzzzzzzzzzzzzzzzz";
        this.wizard = false;
    }

    // METODOS GETS e SETS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAlternate_names() {
        return alternate_names;
    }

    public void setAlternate_names(List<String> alternate_names) {
        this.alternate_names = alternate_names;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getAncestry() {
        return ancestry;
    }

    public void setAncestry(String ancestry) {
        this.ancestry = ancestry;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getPatronus() {
        return patronus;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }

    public boolean isHogwartsStaff() {
        return hogwartsStaff;
    }

    public void setHogwartsStaff(boolean hogwartsStaff) {
        this.hogwartsStaff = hogwartsStaff;
    }

    public boolean getHogwatsStudent() {
        return hogwatsStudent;
    }

    public void setHogwatsStudent(boolean hogwatsStudent) {
        this.hogwatsStudent = hogwatsStudent;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getYearOfBith() {
        return yearOfBith;
    }

    public void setYearOfBith(int yearOfBith) {
        this.yearOfBith = yearOfBith;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public boolean isWizard() {
        return wizard;
    }

    public void setWizard(boolean wizard) {
        this.wizard = wizard;
    }

    // ---------------------------------------------------------------------------//

    // Metodo para imprimir igual no verde
    public void imprimir() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("[" + id + " ## " + name + " ## "
                + alternate_names.toString().replace('[', '{').replace(']', '}') + " ## " + house + " ## " + ancestry
                + " ## " + species + " ## " + patronus + " ## " + hogwartsStaff +
                " ## " + hogwatsStudent + " ## " + actorName + " ## " + alive + " ## " + formatter.format(dateOfBirth)
                + " ## " + yearOfBith + " ## " + eyeColour + " ## " + gender + " ## " + hairColor + " ## " + wizard
                + "]");
    }

    // Clonar o personagem
    public Personagem clonar() {
        return this;
    }

    public static String[] ler(String dados) {
        String[] atributos = dados.split(";");

        return atributos;
    }

}

public class TP02Q18 {

    // Criar e preencher o vetor
    public static void preencherVetor(Personagem[] personagens, ArrayList<String> ids) {
        String line;
        String[] atributos;
        Lista alternate_names;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date dateOfBirth;
        try {
            Scanner sc = new Scanner(new File("/tmp/characters.csv"));
            int i = 0;
            sc.nextLine();
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                atributos = Personagem.ler(line);
                alternate_names = new Lista();

                for (int j = 0; j < ids.size(); j++) {
                    if (ids.get(j).equals(atributos[0]) == true) {
                        try {
                            dateOfBirth = formatter.parse(atributos[12]);
                            personagens[i] = new Personagem(atributos[0], atributos[1],
                                    alternate_names.parseStringToList(atributos[2]), atributos[3], atributos[4],
                                    atributos[5], atributos[6], atributos[7].equals("VERDADEIRO") ? true : false,
                                    atributos[8].equals("VERDADEIRO") ? true : false, atributos[9],
                                    atributos[10].equals("VERDADEIRO") ? true : false, dateOfBirth,
                                    Integer.parseInt(atributos[13]), atributos[14], atributos[15], atributos[16],
                                    atributos[17].equals("VERDADEIRO") ? true : false);

                            i++;
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        j = ids.size() + 1;
                    }
                }

            }

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void QuickSortParcial(Personagem[] personagens, int esq, int dir, int[] comp_mov) {
        int i = esq;
        int j = dir;

        Personagem pivo = personagens[(esq + dir) / 2];

        while (i <= j) {
            while (personagens[i].getHouse().compareTo(pivo.getHouse()) <= 0) {
                if (personagens[i].getHouse().compareTo(pivo.getHouse()) == 0) {
                    if (personagens[i].getName().compareTo(pivo.getName()) < 0) {
                        i++;
                        comp_mov[0] += 3;
                    } else {
                        comp_mov[0] += 3;
                        break;
                    }
                } else {
                    i++;
                    comp_mov[0] += 2;
                }
            }

            while (personagens[j].getHouse().compareTo(pivo.getHouse()) >= 0) {
                if (personagens[j].getHouse().compareTo(pivo.getHouse()) == 0) {
                    if (personagens[j].getName().compareTo(pivo.getName()) > 0) {
                        j--;
                        comp_mov[0] += 3;
                    } else {
                        comp_mov[0] += 3;
                        break;
                    }
                } else {
                    j--;
                    comp_mov[0] += 2;
                }
            }

            if (i <= j) {
                Personagem tmp = personagens[i];
                personagens[i] = personagens[j];
                personagens[j] = tmp;
                i++;
                j--;
                comp_mov[1] += 3;
            }
        }

        if (i < dir && i < 10) {
            QuickSortParcial(personagens, i, dir, comp_mov);
        }

        if (j > esq) {
            QuickSortParcial(personagens, esq, j, comp_mov);
        }
    }

    public static void log(long tempoExecucao, int comparacoes, int movimentacoes) {
        File log = new File("775799_mergesort.txt");
        double segundos = tempoExecucao / 1_000_000_000.0;

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(log, true));
            writer.println("775799\t" + comparacoes + "\t" + movimentacoes + "\t" + segundos);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ids = new ArrayList<>();
        String id;
        int[] comp_mov = { 0, 0 };

        id = sc.nextLine();
        while (id.equals("FIM") != true) {
            ids.add(id);

            id = sc.nextLine();
        }

        Personagem[] personagens = new Personagem[ids.size()];

        preencherVetor(personagens, ids);

        long inicio = System.nanoTime();

        QuickSortParcial(personagens, 0, personagens.length - 1, comp_mov);

        long fim = System.nanoTime();

        long tempoExecucao = fim - inicio;

        log(tempoExecucao, comp_mov[0], comp_mov[1]);

        for (int i = 0; i < 10; i++) {
            personagens[i].imprimir();
        }

        sc.close();
    }

}