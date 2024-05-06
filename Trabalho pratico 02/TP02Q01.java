/*1) Classe em Java: Crie uma classe Personagem seguindo todas as regras apresentadas no
slide unidade00l conceitosBasicos introducaoOO.pdf. Sua classe ter´a os atributos privados id
(String), name (String), alternate names (Lista)1, house (String), ancestry (String), species
(String), patronus (String), hogwartsStaff (Boolean), hogwartsStudent (String), actorName
(String), alive (Boolean), dateOfBirth (Date), yearOfBirth (int), eyeColour (String),
gender (String), hairColour (String), wizard (Boolean). Sua classe tamb´em ter´a pelo menos
dois construtores, e os m´etodos gets, sets, clone, imprimir e ler.
O m´etodo imprimir mostra os atributos do registro (ver cada linha da sa´ıda padr˜ao) e o ler lˆe
os atributos de um registro. Aten¸c˜ao para o arquivo de entrada, pois em alguns registros faltam
valores e esse foi substitu´ıdo pelo valor 0 (zero) ou vazio.
A entrada padr˜ao ´e composta por v´arias linhas e cada uma cont´em uma string indicando o id
do Personagem a ser lido. A ´ultima linha da entrada cont´em a palavra FIM. A sa´ıda padr˜ao
tamb´em cont´em v´arias linhas, uma para cada registro contido em uma linha da entrada padr˜ao */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*Diferenca entre DateTime e Date:
 
 A diferença não é só a notação, é o conteúdo, é o valor que ele armazena. 
 Date não tem hora, só a data, DateTime tem ambos, e isso é importante porque é possível extrair só a data ou só a hora do segundo, 
 mas o primeiro só tem data.


 */

public class TP02Q01 extends Personagem {

    public static void main(String[] args) throws Exception {

        String IdsPersonagens = "";
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        IdsPersonagens = entrada.readLine();
        while (IdsPersonagens.equals("FIM") != true) {
            personagens[tampersonagens] = new Personagem();
            TratarString(ler(IdsPersonagens));
            imprimir();
            tampersonagens += 1;
            IdsPersonagens = entrada.readLine();
        }
    }
}

class Personagem {

    public static Personagem[] personagens = new Personagem[1000];
    public static int tampersonagens = 0;

    private String id;
    private String name;
    private String[] alternate_names;
    private String house;
    private String ancestry;
    private String species;
    private String patronus;
    private Boolean hogwartsStaff;
    private String hogwartsStudent;
    private String actorName;
    private Boolean alive;
    private Date dateOfBirth;
    private int yearOfBirth;
    private String eyeColour;
    private String gender;
    private String hairColour;
    private Boolean wizard;

    // OBS --> Sua classe tambem tera pelo menos dois construtores, os metodos
    // gets, sets, clone, imprimir e ler.

    // // Primeiro construtor para inicializar tudo

    public Personagem() {
        id = "";
        name = "";
        alternate_names = new String[1];
        house = "";
        ancestry = "";
        species = "";
        patronus = "";
        hogwartsStaff = false;
        hogwartsStudent = "";
        actorName = "";
        alive = false;
        dateOfBirth = new Date(0);
        yearOfBirth = 0;
        eyeColour = "";
        gender = "";
        hairColour = "";
        wizard = false;
    }

    // Segundo construtor

    public Personagem(String id, String name, String[] alternate_names, String house, String ancestry, String species,
            String patronus,
            Boolean hogwartsStaff, String hogwartsStudent, String actorName, Boolean alive, Date dateOfBirth,
            int yearOfBirth, String eyeColour,
            String gender, String hairColour, Boolean wizard) {

        this.id = id;
        this.name = name;
        this.alternate_names = alternate_names;
        this.house = house;
        this.ancestry = ancestry;
        this.species = species;
        this.patronus = patronus;
        this.hogwartsStaff = hogwartsStaff;
        this.hogwartsStudent = hogwartsStudent;
        this.actorName = actorName;
        this.alive = alive;
        this.dateOfBirth = dateOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.eyeColour = eyeColour;
        this.gender = gender;
        this.hairColour = hairColour;
        this.wizard = wizard;

    }

    // METODOS GETS
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String[] getAlternate_names() {
        return alternate_names;
    }

    public String getHouse() {
        return house;
    }

    public String getAncestry() {
        return ancestry;
    }

    public String getSpecies() {
        return species;
    }

    public String getPatronus() {
        return patronus;
    }

    public Boolean getHogwartsStaff() {
        return hogwartsStaff;
    }

    public String getHogwartsStudent() {
        return hogwartsStudent;
    }

    public String getActorName() {
        return actorName;
    }

    public Boolean getAlive() {
        return alive;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public String getGender() {
        return gender;
    }

    public String getHairColour() {
        return hairColour;
    }

    public Boolean getWizard() {
        return wizard;
    }

    // ---------------------------------------------------------------------------//

    // METODOS SETS
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlternate_names(String[] alternate_names) {
        this.alternate_names = alternate_names;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setAncestry(String ancestry) {
        this.ancestry = ancestry;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }

    public void setHogwartsStaff(Boolean hogwartsStaff) {
        this.hogwartsStaff = hogwartsStaff;
    }

    public void setHogwartsStudent(String hogwartsStudent) {
        this.hogwartsStudent = hogwartsStudent;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public void setWizard(Boolean wizard) {
        this.wizard = wizard;
    }

    // ---------------------------------------------------------------------------//

    // METODO CLONE

    public Personagem Clone() {
        Personagem clone = new Personagem();

        clone.id = id;
        clone.name = name;
        clone.alternate_names = alternate_names;
        clone.house = house;
        clone.ancestry = ancestry;
        clone.species = species;
        clone.patronus = patronus;
        clone.hogwartsStaff = hogwartsStaff;
        clone.hogwartsStudent = hogwartsStudent;
        clone.actorName = actorName;
        clone.alive = alive;
        clone.dateOfBirth = dateOfBirth;
        clone.yearOfBirth = yearOfBirth;
        clone.eyeColour = eyeColour;
        clone.gender = gender;
        clone.hairColour = hairColour;
        clone.wizard = wizard;

        return clone;
    }

    // ---------------------------------------------------------------------------//

    // LEITURA DO ARQUIVO

    public static String ler(String entradaid) throws Exception {
        String entrada = "";
        try (BufferedReader arq = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/characters.csv")))) {
            entrada = arq.readLine();
            while (entrada != null) {
                String[] Ids = entrada.split(";");
                if (Ids[0].equals(entradaid) == true) {
                    return entrada;
                }
                entrada = arq.readLine();
            }
        }

        String saida = "";

        return saida;
    }

    public static void TratarString(String entrada) throws Exception {
        int tam = entrada.length();
        if (entrada.charAt(tam - 1) == ';') {
            entrada = entrada + "nao informado";
        }
        entrada = entrada.replaceAll(";;", ";nao informado;");
        String[] HPpersonagens = entrada.split(";");

        // ID do Personagem
        personagens[tampersonagens].setId(HPpersonagens[0]);
        // Nome do Personagem
        personagens[tampersonagens].setName(HPpersonagens[1]);
        // Alternate_names do Personagem
        int inicio = HPpersonagens[2].indexOf('[');
        int fim = HPpersonagens[2].indexOf(']');
        if (inicio != -1 && fim != -1 && fim > inicio) {
            String alternateNames = HPpersonagens[2].substring(inicio + 1, fim);
            alternateNames = alternateNames.replaceAll("'", "");
            personagens[tampersonagens].setAlternate_names(alternateNames.split(","));
        }
        // House do Personagem
        if (!HPpersonagens[3].equals("[]")) {
            personagens[tampersonagens].setHouse(HPpersonagens[3]);
        } else {
            personagens[tampersonagens].setHouse("nao informado");
        }
        // Ancestry do Personagem
        if (!HPpersonagens[4].equals("[]")) {
            personagens[tampersonagens].setAncestry(HPpersonagens[4]);
        } else {
            personagens[tampersonagens].setAncestry("nao informado");
        }
        // Species do Personagem
        if (!HPpersonagens[5].equals("[]")) {
            personagens[tampersonagens].setSpecies(HPpersonagens[5]);
        } else {
            personagens[tampersonagens].setSpecies("nao informado");
        }
        // Patronous do Personagem
        if (!HPpersonagens[6].equals("[]")) {
            personagens[tampersonagens].setPatronus(HPpersonagens[6]);
        } else {
            personagens[tampersonagens].setPatronus("nao informado");
        }
        // HogwartsStaff do Personagem
        boolean hogwartsStaff = Boolean.parseBoolean(HPpersonagens[7]);
        personagens[tampersonagens].setHogwartsStaff(hogwartsStaff);
        // Hogwartstudent do Personagem
        boolean hogwartsStudent = Boolean.parseBoolean(HPpersonagens[8]);
        personagens[tampersonagens].setHogwartsStudent(String.valueOf(hogwartsStudent));
        // Ator do Personagem
        personagens[tampersonagens].setActorName(HPpersonagens[9]);
        // Personagem Alive
        boolean alive = Boolean.parseBoolean(HPpersonagens[10]);
        personagens[tampersonagens].setAlive(alive);
        // Date of birth do Personagem
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        if (!HPpersonagens[12].equals("[]")) {
            try {
                Date dataNascimento = sdf.parse(HPpersonagens[12]);
                personagens[tampersonagens].setDateOfBirth(dataNascimento);
            } catch (ParseException e) {
                personagens[tampersonagens].setDateOfBirth(new Date());
            }
        } else {
            personagens[tampersonagens].setDateOfBirth(new Date());
        }
        // Year of birth do Personagem
        int anonascimento = Integer.parseInt(HPpersonagens[13]);
        personagens[tampersonagens].setYearOfBirth(anonascimento);
        // Eye Colour do Personagem
        if (!HPpersonagens[14].equals("[]")) {
            personagens[tampersonagens].setEyeColour(HPpersonagens[14]);
        } else {
            personagens[tampersonagens].setEyeColour("nao informado");
        }
        // Gender do Personagem
        if (!HPpersonagens[15].equals("[]")) {
            personagens[tampersonagens].setGender(HPpersonagens[15]);
        } else {
            personagens[tampersonagens].setGender("nao informado");
        }
        // Hair Colour do Personagem
        if (!HPpersonagens[16].equals("[]")) {
            personagens[tampersonagens].setHairColour(HPpersonagens[16]);
        } else {
            personagens[tampersonagens].setHairColour("nao informado");
        }
        // Wizard do Personagem
        boolean wizard = HPpersonagens[17].equalsIgnoreCase("verdadeiro");
        personagens[tampersonagens].setWizard(wizard);
    }

    // ---------------------------------------------------------------------------//

    // IMPRIMIR
    public static void imprimir() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dataNascimentoFormatada = (personagens[tampersonagens].getDateOfBirth() != null)
                ? sdf.format(personagens[tampersonagens].getDateOfBirth())
                : "N/A";

        System.out.print("[" +
                personagens[tampersonagens].getId() + " ## " +
                personagens[tampersonagens].getName() + " ## ");
        String[] alternateNames = personagens[tampersonagens].getAlternate_names();
        System.out.print("{");
        for (int i = 0; i < alternateNames.length; i++) {
            System.out.print(alternateNames[i]);
            if (i < alternateNames.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("} ## ");
        System.out.print(personagens[tampersonagens].getHouse() + " ## " +
                personagens[tampersonagens].getAncestry() + " ## " +
                personagens[tampersonagens].getSpecies() + " ## " +
                personagens[tampersonagens].getPatronus() + " ## " +
                personagens[tampersonagens].getHogwartsStaff() + " ## " +
                personagens[tampersonagens].getHogwartsStudent() + " ## " +
                personagens[tampersonagens].getActorName() + " ## " +
                personagens[tampersonagens].getAlive() + " ## " +
                dataNascimentoFormatada + " ## " +
                personagens[tampersonagens].getYearOfBirth() + " ## " +
                personagens[tampersonagens].getEyeColour() + " ## " +
                personagens[tampersonagens].getGender() + " ## " +
                personagens[tampersonagens].getHairColour() + " ## " +
                personagens[tampersonagens].getWizard() + "]\n");
    }
}