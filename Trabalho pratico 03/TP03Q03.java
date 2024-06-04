/*
 * Crie uma Pilha de registros baseada na pilha de inteiros vista na sala de
 * aula. Neste exercício, faremos inserções, remoções e mostraremos os elementos
 * de nossa pilha. A entrada e a saída padrão serão como as da questão anterior,
 * contudo, teremos apenas os comandos I para inserir na pilha (empilhar) e R
 * para remover (desempilhar).
 */

 import java.io.*;
 import java.time.LocalDate;
 import java.time.format.DateTimeFormatter;
 import java.time.format.DateTimeParseException;
 import java.util.*;
 
 public class TP03Q03 {
   public static void main(String[] args) throws Exception {
     Scanner sc = new Scanner(System.in);
     Stack<Personagem> pilha = new Stack<>();
 
     // Leitura dos dados
     while (true) {
       String search = sc.nextLine();
       if (search.equals("FIM"))
         break;
 
       Personagem personagem = new Personagem();
       personagem.setId(search);
 
       try {
         personagem.ler();
         pilha.push(personagem);
       } catch (Exception e) {
         System.err.println(e.getMessage());
       }
     }
 
     // Realização das operações
     int qtde = Integer.parseInt(sc.nextLine());
     for (int i = 0; i < qtde; i++) {
       String operacao = sc.nextLine();
       String[] partes = operacao.split(" ");
 
       switch (partes[0]) {
         case "I":
           String idInserir = partes[1];
           Personagem personagem = new Personagem();
           personagem.setId(idInserir);
           try {
             personagem.ler();
             pilha.push(personagem);
           } catch (Exception e) {
             System.err.println(e.getMessage());
           }
           break;
         case "R":
           if (!pilha.isEmpty()) {
             Personagem removido = pilha.pop();
             System.out.println("(R) " + removido.getName());
           }
           break;
       }
     }
     int j = 0;
     System.out.println("[ Top ]");
     // Imprimindo os personagens com índice em ordem inversa
     for (int i = pilha.size() - 1; i >= 0; i--) {
       System.out.print("[" + j + " ## ");
       pilha.get(i).imprimir();
       j++;
     }
     System.out.println("[ Bottom ]");
 
     sc.close();
   }
 }
 
 class Personagem {
   private String id;
   private String name;
   private String alternateNames;
   private String house;
   private String ancestry;
   private String species;
   private String patronus;
   private String hogwartsStaff;
   private String hogwartsStudent;
   private String actorName;
   private String alive;
   private String alternateActor;
   private LocalDate dateOfBirth;
   private int yearOfBirth;
   private String eyeColour;
   private String gender;
   private String hairColour;
   private String wizard;
 
   public Personagem() {
     this.id = this.name = this.house = this.ancestry = this.species = this.patronus = this.hogwartsStudent = this.actorName = this.alternateActor = this.eyeColour = this.gender = this.hairColour = this.hogwartsStaff = this.alive = this.wizard = this.alternateNames = null;
     this.yearOfBirth = 0;
     this.dateOfBirth = null;
   }
 
   public Personagem(String id, String name, String alternateNames, String house, String ancestry,
       String species, String patronus,
       String hogwartsStaff, String hogwartsStudent, String actorName, String alive, String alternateActor,
       LocalDate dateOfBirth,
       int yearOfBirth,
       String eyeColour, String gender, String hairColour, String wizard) {
     this.id = id;
     this.name = name;
     this.alternateNames = alternateNames;
     this.house = house;
     this.ancestry = ancestry;
     this.species = species;
     this.patronus = patronus;
     this.hogwartsStaff = hogwartsStaff;
     this.hogwartsStudent = hogwartsStudent;
     this.actorName = actorName;
     this.alive = alive;
     this.alternateActor = alternateActor;
     this.dateOfBirth = dateOfBirth;
     this.yearOfBirth = yearOfBirth;
     this.eyeColour = eyeColour;
     this.gender = gender;
     this.hairColour = hairColour;
     this.wizard = wizard;
   }
 
   // Getters
 
   public String getId() {
     return id;
   }
 
   public String getName() {
     return name;
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
 
   public String isHogwartsStaff() {
     return hogwartsStaff;
   }
 
   public String getHogwartsStudent() {
     return hogwartsStudent;
   }
 
   public String getActorName() {
     return actorName;
   }
 
   public String isAlive() {
     return alive;
   }
 
   public String getAlternateActor() {
     return alternateActor;
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
 
   public String isWizard() {
     return wizard;
   }
 
   public LocalDate getDateOfBirth() {
     return dateOfBirth;
   }
 
   public String getAlternateNames() {
     return alternateNames;
   }
 
   // Setters
 
   public void setId(String id) {
     this.id = id;
   }
 
   public void setName(String name) {
     this.name = name;
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
 
   public void setHogwartsStaff(String hogwartsStaff) {
     this.hogwartsStaff = hogwartsStaff;
   }
 
   public void setHogwartsStudent(String hogwartsStudent) {
     this.hogwartsStudent = hogwartsStudent;
   }
 
   public void setActorName(String actorName) {
     this.actorName = actorName;
   }
 
   public void setAlive(String alive) {
     this.alive = alive;
   }
 
   public void setAlternateActor(String alternateActor) {
     this.alternateActor = alternateActor;
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
 
   public void setWizard(String wizard) {
     this.wizard = wizard;
   }
 
   public void setDateOfBirth(LocalDate dateOfBirth) {
     this.dateOfBirth = dateOfBirth;
   }
 
   public void setAlternateNames(String alternateNames) {
     this.alternateNames = alternateNames;
   }
 
   public Personagem clone() {
     Personagem clonado = new Personagem();
     // Clonando todas as variáveis
     clonado.setId(this.id);
     clonado.setName(this.name);
     // ---------------------
     // Clonando o arrayList
     clonado.setAlternateNames(this.alternateNames);
     // ---------------------
     clonado.setHouse(this.house);
     clonado.setAncestry(this.ancestry);
     clonado.setSpecies(this.species);
     clonado.setPatronus(this.patronus);
     clonado.setHogwartsStaff(this.hogwartsStaff);
     clonado.setHogwartsStudent(this.hogwartsStudent);
     clonado.setActorName(this.actorName);
     clonado.setAlive(this.alive);
     clonado.setAlternateActor(this.alternateActor);
     clonado.setDateOfBirth(this.dateOfBirth);
     clonado.setYearOfBirth(this.yearOfBirth);
     clonado.setEyeColour(this.eyeColour);
     clonado.setGender(this.gender);
     clonado.setHairColour(this.hairColour);
     clonado.setWizard(this.wizard);
     return clonado;
   }
 
   public void imprimir() {
 
     // Imprimindo os atributos formatados
     System.out.println(
         this.id + " ## " + this.name + " ## {" + this.alternateNames + "} ## " + this.house
             + " ## "
             + this.ancestry + " ## "
             + this.species + " ## " + this.patronus + " ## "
             + (this.hogwartsStaff.equals("VERDADEIRO") ? "true" : "false") + " ## "
             + (this.hogwartsStudent.equals("VERDADEIRO") ? "true" : "false") + " ## "
             + this.actorName + " ## " + (this.alive.equals("VERDADEIRO") ? "true" : "false") + " ## "
             + this.dateOfBirth.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " ## " + this.yearOfBirth
             + " ## " + this.eyeColour
             + " ## " + this.gender + " ## " + this.hairColour + " ## "
             + (this.wizard.equals("VERDADEIRO") ? "true" : "false") + "]");
   }
 
   public void ler() throws IOException {
     try {
       // String nomeArquivo = "characters.csv";
       String nomeArquivo = "/tmp/characters.csv";
       FileReader fileReader = new FileReader(nomeArquivo);
       BufferedReader bufferedReader = new BufferedReader(fileReader);
 
       String linha;
       boolean primeiraLinha = true; // Flag para controlar a primeira linha
 
       while ((linha = bufferedReader.readLine()) != null) {
         if (primeiraLinha) {
           primeiraLinha = false;
           continue; // Ignora a primeira linha com cabeçalhos
         }
 
         // separa a linha por campos, tendo como condição de separação o sinal ;
         String[] campos = linha.split(";");
         String id;
         try {
           id = campos[0]; // id do personagem
 
           if (id.equals(this.id)) {// O personagem com o ID desejado foi encontrado
 
             this.name = campos[1]; // Nome do personagem
 
             if (campos.length > 2 && campos[2] != null && !campos[2].isEmpty()) {
               String apelidosArray = campos[2].trim(); // Remove os espaços em branco extras
 
               if (apelidosArray.startsWith("[") && apelidosArray.endsWith("]")) {
                 apelidosArray = apelidosArray.substring(1, apelidosArray.length() - 1); // Remove os
                                                                                         // colchetes
               }
 
               // Verifica se o campo está vazio após remover colchetes
               if (!apelidosArray.isEmpty()) {
                 StringBuilder nomeAlternativoBuilder = new StringBuilder();
                 String[] apelidosFinal = apelidosArray.split("',\\s*'"); // Isso divide os apelidos com
                                                                          // base na ',' para tirar as
                                                                          // aspas simples de cada
                                                                          // apelido
                 for (String apelido : apelidosFinal) {// faz a string apelido percorrer tudo até
                                                       // terminar o array apelidosFinal
                   StringBuilder apelidoSemAspas = new StringBuilder();
                   for (int i = 0; i < apelido.length(); i++) {
                     if (apelido.charAt(i) != '\'') { // Adiciona apenas os caracteres que não são
                                                      // aspas simples
                       apelidoSemAspas.append(apelido.charAt(i));
                     }
                   }
                   nomeAlternativoBuilder.append(apelidoSemAspas.toString()).append(", "); // Adiciona
                                                                                           // o apelido
                                                                                           // sem as
                                                                                           // aspas à
                                                                                           // lista
                 }
                 // Remove a vírgula e o espaço extras no final
                 String nomeAlternativo = nomeAlternativoBuilder.toString().trim();
                 nomeAlternativo = nomeAlternativo.substring(0, nomeAlternativo.length() - 1);
 
                 this.alternateNames = nomeAlternativo; // Apelidos como uma String separada por vírgulas
               } else {
                 this.alternateNames = ""; // String vazia se o campo estiver vazio
               }
             } else {
               this.alternateNames = ""; // String vazia se não houver apelidos
             }
 
             this.house = campos[3]; // casa do personagem
 
             this.ancestry = campos[4]; // "passado" do personagem
 
             this.species = campos[5]; // espécie do personagem
 
             this.patronus = campos[6]; // patrono do personagem
 
             this.hogwartsStaff = campos[7]; // verifica se é funcionário de Hogwarts
 
             this.hogwartsStudent = campos[8]; // String que verifica se é estudante de Hogwarts
 
             this.actorName = campos[9]; // nome do Ator
 
             this.alive = campos[10]; // verifica se tá vivo ou morto
 
             this.alternateActor = campos[11];
 
             DateTimeFormatter[] formatters = {
                 DateTimeFormatter.ofPattern("dd-MM-yyyy"), // Verifica o formato dd-MM-yyyy
                 DateTimeFormatter.ofPattern("dd-M-yyyy") // Verifica o formato dd-M-yyyy (por causa de
                                                          // erro em uma linha do csv)
             };
 
             for (DateTimeFormatter formatter : formatters) {
               try {
                 this.dateOfBirth = LocalDate.parse(campos[12], formatter);
                 break;// sai do loop se a data tiver no padrão
               } catch (DateTimeParseException e) {
                 // vai pra outra tentativa se não for no padrão dd-MM-yyyy
               }
             }
 
             // Se não é nenhuma das duas, vai ser a data padrão nula
             if (this.dateOfBirth == null) {
               this.dateOfBirth = null;
             }
 
             this.yearOfBirth = Integer.parseInt(campos[13]); // ano de nascimento do personagemgem
 
             this.eyeColour = campos[14]; // cor de olho do personagem
 
             this.gender = campos[15]; // gênero do personagem
 
             this.hairColour = campos[16]; // cor de cabelo do personagem
 
             this.wizard = campos[17]; // verifica se é bruxo
 
             break; // Para de ler o arquivo assim que ler todas as informações do personagem
           }
 
         } catch (NumberFormatException e) {
           System.err.println("Erro ao converter um número: " + e.getMessage()); // erro de conversão de número
         }
       }
 
       bufferedReader.close(); // fecha o buffer
     } catch (IOException e) {
       System.err.println("Erro ao ler o arquivo: " + e.getMessage());
     }
   }
 }
