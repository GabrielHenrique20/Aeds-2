/*Repita a questão de Ordenação por Seleção, contudo, usando o algoritmo Heapsort, fazendo com que a chave de pesquisa seja o atributo hairColour. 
O nome do arquivo de log será matrícula_heapsort.txt. */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*Diferenca entre DateTime e Date:
 
 A diferença não é só a notação, é o conteúdo, é o valor que ele armazena. 
 Date não tem hora, só a data, DateTime tem ambos, e isso é importante porque é possível extrair só a data ou só a hora do segundo, 
 mas o primeiro só tem data.
*/

public class TP02Q09 extends Personagem {

    public static void main(String[] args) throws Exception {
        String idPersonagens = "";
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        idPersonagens = entrada.readLine();
        while (!idPersonagens.equals("FIM")) {
            personagens[tampersonagens] = new Personagem();
            TratarString(ler(idPersonagens));
            tampersonagens++;
            idPersonagens = entrada.readLine();
        }

        ordenarPorCorDoCabelo(personagens, tampersonagens);

        for (int i = 0; i < tampersonagens; i++) {
            imprimir(personagens[i]);
        }

        // Criar arquivo de log
        criarArquivoLog();
    }

    // Método para ordenar por cor do cabelo usando Heapsort
    public static void ordenarPorCorDoCabelo(Personagem[] array, int tamanho) {
        // Construir o heap inicial
        for (int i = tamanho / 2 - 1; i >= 0; i--) {
            heapify(array, tamanho, i);
        }

        // Extrair elementos um por um do heap
        for (int i = tamanho - 1; i > 0; i--) {
            // Mover a raiz atual para o final
            Personagem temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Chamar max heapify no heap reduzido
            heapify(array, i, 0);
        }
    }

    // Método para construir um heap máximo
    public static void heapify(Personagem[] array, int tamanho, int indiceRaiz) {
        int maior = indiceRaiz; // Inicializar a raiz como o maior
        int filhoEsquerda = 2 * indiceRaiz + 1; // Filho esquerdo
        int filhoDireita = 2 * indiceRaiz + 2; // Filho direito

        // Se o filho esquerdo for maior que a raiz
        if (filhoEsquerda < tamanho
                && array[filhoEsquerda].getHairColour().compareTo(array[maior].getHairColour()) > 0) {
            maior = filhoEsquerda;
        }

        // Se o filho direito for maior que a raiz
        if (filhoDireita < tamanho && array[filhoDireita].getHairColour().compareTo(array[maior].getHairColour()) > 0) {
            maior = filhoDireita;
        }

        // Se o maior não for a raiz
        if (maior != indiceRaiz) {
            // Trocar o elemento raiz com o maior
            Personagem temp = array[indiceRaiz];
            array[indiceRaiz] = array[maior];
            array[maior] = temp;

            // Chamar heapify recursivamente no subárvore afetado
            heapify(array, tamanho, maior);
        }
    }

    // Método para imprimir personagem
    public static void imprimir(Personagem p) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dataNascimentoFormatada = (p.getDateOfBirth() != null) ? sdf.format(p.getDateOfBirth()) : "";

        // Converte booleanos em "true" ou "false"
        String hogwartsStaffStr = (p.getHogwartsStaff()) ? "true" : "false";
        String hogwartsStudentStr = (p.getHogwartsStudent().equalsIgnoreCase("true")) ? "true" : "false";
        String aliveStr = (p.getAlive()) ? "true" : "false";
        String wizardStr = (p.getWizard()) ? "true" : "false";

        // Verifica se a lista de alternate_names está vazia e constrói a representação
        // em string apropriada
        String alternateNamesStr = (p.getAlternate_names().length == 0) ? "{}"
                : "{" + String.join(", ", p.getAlternate_names()) + "}";

        System.out.println("[" +
                p.getId() + " ## " +
                p.getName() + " ## " +
                alternateNamesStr + " ## " + // Imprime a representação da lista alternate_names
                p.getHouse() + " ## " +
                p.getAncestry() + " ## " +
                p.getSpecies() + " ## " +
                p.getPatronus() + " ## " +
                hogwartsStaffStr + " ## " +
                hogwartsStudentStr + " ## " +
                p.getActorName() + " ## " +
                aliveStr + " ## " +
                dataNascimentoFormatada + " ## " +
                p.getYearOfBirth() + " ## " +
                p.getEyeColour() + " ## " +
                p.getGender() + " ## " +
                p.getHairColour() + " ## " +
                wizardStr + "]");
    }

    // Método para criar arquivo de log
    public static void criarArquivoLog() {
        String matricula = "775799"; // Substitua pela sua matrícula
        int numComparacoes = (tampersonagens * (tampersonagens - 1)) / 2; // Número de comparações no pior caso
        long tempoInicio = System.currentTimeMillis();

        // Ordenar novamente para medir o número de movimentações
        Personagem[] copiaPersonagens = new Personagem[tampersonagens];
        System.arraycopy(personagens, 0, copiaPersonagens, 0, tampersonagens);
        ordenarPorCorDoCabelo(personagens, tampersonagens);
        int numMovimentacoes = contarMovimentacoes(personagens, copiaPersonagens);

        long tempoFim = System.currentTimeMillis();
        long tempoExecucao = tempoFim - tempoInicio;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("matricula_selecao.txt"));
            writer.write(matricula + "\t" + numComparacoes + "\t" + numMovimentacoes + "\t" + tempoExecucao);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para contar o número de movimentações
    public static int contarMovimentacoes(Personagem[] original, Personagem[] ordenado) {
        int movimentacoes = 0;
        int tamanho = Math.min(original.length, ordenado.length); // Determina o tamanho mínimo dos arrays
        for (int i = 0; i < tamanho; i++) {
            if (!original[i].equals(ordenado[i])) {
                movimentacoes++;
            }
        }
        return movimentacoes;
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

    public int compareNome(Personagem other) {
        return this.name.compareTo(other.name);
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
        try (BufferedReader arq = new BufferedReader(
                new InputStreamReader(new FileInputStream("/tmp/characters.csv")))) {
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