/*Repita a questão anterior, contudo, usando a Pesquisa Binária. A entrada e a saída padrão serão iguais as da questão anterior. O nome do arquivo de log será matrícula_binaria.txt.
A entrada desta questão não está ordenada.*/

#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>
#include <time.h>

// Definição da estrutura para armazenar uma lista de nomes alternativos
typedef struct
{
    char Lista[500];
} Lista;

// Definição da estrutura para armazenar informações de um personagem
typedef struct
{
    char id[200];
    char name[200];
    Lista alternate_names; // Utiliza a estrutura Lista para armazenar nomes alternativos
    char house[200];
    char ancestry[200];
    char species[200];
    char patronus[200];
    bool hogwartsStaff;
    bool hogwartsStudent;
    char actorName[200];
    bool alive;
    char dateOfBirth[200];
    int yearOfBirth;
    char eyeColour[200];
    char gender[200];
    char hairColor[200];
    bool wizard;
} Personagem;

// Protótipo das funções
Personagem construtor(char *, char *, char *, char *, char *, char *, char *, bool, bool, char *, bool, char *, int, char *, char *, char *, bool);
Personagem construtor_vazio();
char *getId(Personagem *);
void setId(char *, Personagem *);
char *getName(Personagem *);
void setName(char *, Personagem *);
// Protótipos das outras funções de getter e setter...

char **ler(char *);
void imprimir(Personagem *);
void PreencherVetor(Personagem *, char[][200]);
void QuickSort(Personagem *, int, int, int *);
void swap(Personagem *, int, int);
void Log(int, int, double);
bool PesquisaBinaria(Personagem *, char *);

int main()
{
    // Início do cronômetro
    clock_t inicio = clock();
    char id[200];
    char ids[30][200];
    int i = 0;
    int comp_mov[2] = {0, 0};
    char name[200];
    char lixo[200];

    // Leitura dos IDs até encontrar "FIM"
    scanf("%s", id);
    while (strcmp(id, "FIM") != 0)
    {
        strcpy(ids[i], id);
        i++;
        scanf("%s", id);
    }

    // Declaração de um vetor de personagens
    Personagem personagens[27];

    // Preenchimento do vetor de personagens a partir do arquivo CSV
    PreencherVetor(personagens, ids);

    // Ordenação rápida (QuickSort) do vetor de personagens
    QuickSort(personagens, 0, 26, comp_mov);

    // Fim do cronômetro e cálculo do tempo de execução
    clock_t fim = clock();
    double tempoExecucao = (double)(fim - inicio);

    // Gravação dos dados de desempenho no arquivo de log
    Log(comp_mov[0], comp_mov[1], tempoExecucao);

    bool find;

    // Limpeza do buffer de entrada
    scanf("%99[^\n]%*c", lixo);

    // Leitura dos nomes para busca até encontrar "FIM"
    scanf("%99[^\n]%*c", name);
    name[strcspn(name, "\r")] = '\0';
    while (strcmp(name, "FIM") != 0)
    {
        // Busca binária do nome no vetor de personagens
        find = PesquisaBinaria(personagens, name);

        // Impressão do resultado da busca
        if (find == true)
        {
            printf("SIM\n");
        }
        else
        {
            printf("NAO\n");
        }

        // Leitura do próximo nome para busca
        scanf("%99[^\n]%*c", name);
        name[strcspn(name, "\r")] = '\0';
    }
}

// Função para construir um objeto Personagem com parâmetros fornecidos
Personagem construtor(char id[], char name[], char alternate_names[], char house[], char ancestry[], char species[], char patronus[], bool hogwartsStaff, bool hogwartsStudent, char actorName[], bool alive, char dateOfBirth[],
                      int yearOfBirth, char eyeColour[], char gender[], char hairColor[], bool wizard)
{
    Personagem P;

    // Preenchimento dos campos da estrutura Personagem
    strcpy(P.id, id);
    strcpy(P.name, name);
    strcpy(P.alternate_names.Lista, alternate_names);
    strcpy(P.house, house);
    strcpy(P.ancestry, ancestry);
    strcpy(P.patronus, patronus);
    strcpy(P.species, species);
    P.hogwartsStaff = hogwartsStaff;
    P.hogwartsStudent = hogwartsStudent;
    strcpy(P.actorName, actorName);
    P.alive = alive;
    strcpy(P.dateOfBirth, dateOfBirth);
    P.yearOfBirth = yearOfBirth;
    strcpy(P.eyeColour, eyeColour);
    strcpy(P.gender, gender);
    strcpy(P.hairColor, hairColor);
    P.wizard = wizard;

    return P;
}

// Função para criar um objeto Personagem vazio
Personagem construtor_vazio()
{
    Personagem P;

    // Preenchimento dos campos da estrutura Personagem com valores vazios ou padrão
    strcpy(P.id, "");
    strcpy(P.name, "");
    strcpy(P.alternate_names.Lista, "");
    strcpy(P.house, "");
    strcpy(P.ancestry, "");
    strcpy(P.patronus, "");
    strcpy(P.species, "");
    P.hogwartsStaff = 0;
    P.hogwartsStudent = 0;
    strcpy(P.actorName, "");
    P.alive = 0;
    strcpy(P.dateOfBirth, "");
    P.yearOfBirth = 0;
    strcpy(P.eyeColour, "");
    strcpy(P.gender, "");
    strcpy(P.hairColor, "");
    P.wizard = 0;

    return P;
}

// Função para ler uma linha do arquivo CSV e separar os campos
char **ler(char line[])
{
    // Declaração de variáveis locais
    int tam_line = strlen(line);
    int start = 0;
    int count_campos = 0;
    char **campos = malloc(18 * sizeof(char *));

    // Alocação de memória para cada string
    for (int i = 0; i < 18; i++)
    {
        campos[i] = malloc(500);
    }

    // Laço para percorrer a linha e separar os campos
    for (int i = 0; i < tam_line; i++)
    {
        if (line[i] == ';' && line[i - 1] == ';')
        {
            strcpy(campos[count_campos], "");
            start = i + 1;
            count_campos++;
        }
        else if (line[i] == ';')
        {
            strncpy(campos[count_campos], line + start, i - start);
            campos[count_campos][i - start] = '\0';
            start = i + 1;
            count_campos++;
        }
    }

    // Copia o último campo
    strncpy(campos[17], line + start, tam_line - start - 1);

    return campos;
}

// Função para imprimir os campos de um personagem
void imprimir(Personagem *P)
{
    printf("[%s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %d ## %s ## %s ## %s ## %s]\n",
           P->id, P->name, P->alternate_names.Lista, P->house, P->ancestry, P->species, P->patronus,
           P->hogwartsStaff == 1 ? "true" : "false", P->hogwartsStudent == 1 ? "true" : "false", P->actorName, P->alive == 1 ? "true" : "false", P->dateOfBirth, P->yearOfBirth, P->eyeColour, P->gender, P->hairColor, P->wizard == 1 ? "true" : "false");
}

// Função para preencher o vetor de personagens a partir do arquivo CSV
void PreencherVetor(Personagem personagens[], char ids[][200])
{
    // Declaração de variáveis locais
    FILE *arquivo_csv;
    char line[1200];
    int tam_lista;

    // Abertura do arquivo CSV para leitura
    if ((arquivo_csv = fopen("/tmp/characters.csv", "r")) != NULL)
    {
        // Índice de personagem
        int i = 0;

        // Ignora a primeira linha (cabeçalho)
        fgets(line, 1200, arquivo_csv);

        // Leitura das linhas do arquivo CSV
        while (fgets(line, 1200, arquivo_csv) != NULL)
        {
            // Separa os campos da linha
            char **atributos = ler(line);

            // Correção dos nomes alternativos
            for (int i = 0; atributos[2][i] != '\0'; i++)
            {
                if (atributos[2][i] == '[')
                {
                    atributos[2][i] = '{';
                }
                else if (atributos[2][i] == '\'')
                {
                    for (int j = i; atributos[2][j] != '\0'; j++)
                    {
                        atributos[2][j] = atributos[2][j + 1];
                    }
                }
            }

            tam_lista = strlen(atributos[2]);
            atributos[2][tam_lista - 1] = '}';

            // Verifica se o ID do personagem está na lista de IDs fornecida
            for (int k = 0; k < 27; k++)
            {
                if (strcmp(ids[k], atributos[0]) == 0)
                {
                    // Constrói e armazena o personagem no vetor
                    personagens[i] = construtor(atributos[0], atributos[1], atributos[2], atributos[3], atributos[4],
                                                atributos[5], atributos[6], strcmp(atributos[7], "VERDADEIRO") == 0 ? true : false, strcmp(atributos[8], "VERDADEIRO") == 0 ? true : false, atributos[9], atributos[10],
                                                atributos[12], atoi(atributos[13]), atributos[14], atributos[15], atributos[16], strcmp(atributos[17], "VERDADEIRO") == 0 ? true : false);

                    i++;
                }
            }

            // Libera a memória alocada para os campos
            free(atributos);
        }

        // Fecha o arquivo CSV
        fclose(arquivo_csv);
    }
    else
    {
        printf("Não foi possivel ler o arquivo");
    }
}

// Função para trocar dois elementos de posição no vetor
void swap(Personagem personagens[], int i, int j)
{
    Personagem tmp;

    tmp = personagens[i];
    personagens[i] = personagens[j];
    personagens[j] = tmp;
}

// Função de ordenação rápida (QuickSort)
void QuickSort(Personagem personagens[], int esq, int dir, int comp_mov[])
{
    // Declaração de variáveis locais
    int i = esq;
    int j = dir;
    Personagem pivo = personagens[(esq + dir) / 2];

    // Laço para dividir o vetor em partições
    while (i <= j)
    {
        // Movimenta o índice i até encontrar um elemento maior que o pivô
        while (strcmp(personagens[i].name, pivo.name) < 0)
        {
            comp_mov[0] += 2;
            i++;
        }

        // Movimenta o índice j até encontrar um elemento menor que o pivô
        while (strcmp(personagens[j].name, pivo.name) > 0)
        {
            comp_mov[0]++;
            j--;
        }

        // Troca os elementos e ajusta os índices
        if (i <= j)
        {
            swap(personagens, i, j);
            comp_mov[1] += 3;
            i++;
            j--;
        }
    }

    // Chamadas recursivas para as partições restantes
    if (i < dir)
    {
        QuickSort(personagens, i, dir, comp_mov);
    }

    if (j > esq)
    {
        QuickSort(personagens, esq, j, comp_mov);
    }
}

// Função de busca binária em um vetor de personagens
bool PesquisaBinaria(Personagem personagens[], char nome[])
{
    // Declaração de variáveis locais
    int dir = 26;
    int esq = 0;
    int meio;
    bool resp = false;

    // Laço para buscar o nome no vetor
    while (esq <= dir)
    {
        meio = (esq + dir) / 2;

        if (strcmp(personagens[meio].name, nome) == 0)
        {
            resp = true;
            esq = dir + 1;
        }
        else if (strcmp(personagens[meio].name, nome) > 0)
        {
            dir = meio - 1;
        }
        else
        {
            esq = meio + 1;
        }
    }

    return resp;
}

// Função para gravar dados de desempenho no arquivo de log
void Log(int comparacoes, int movimentacoes, double tempoExecucao)
{
    // Declaração de variável local
    FILE *log;

    // Abertura do arquivo de log para escrita
    if ((log = fopen("824007_quicksort.txt", "w")) != NULL)
    {
        // Gravação dos dados no arquivo
        fprintf(log, "824007\t%d\t%d\t%f", comparacoes, movimentacoes, tempoExecucao);
    }
    else
    {
        printf("Erro ao abrir arquivo de Log!");
    }
}

// Implementações das funções de getter e setter...

char* getId(Personagem *P){
    return P->id;
}

void setId(char *id, Personagem *P){
    strcpy(P->id, id);
}

char* getName(Personagem *P){
    return P->name;
}

void setName(char *name, Personagem *P){
    strcpy(P->name, name);
}

char* getAlternate_names(Personagem *P){
    return P->alternate_names.Lista;
}

void setAlternate_names(char *alternate_names, Personagem *P){
    strcpy(P->alternate_names.Lista, alternate_names);
}

char* getHouse(Personagem *P){
    return P->house;
}

void setHouse(char *house, Personagem *P){
    strcpy(P->house, house);
}

char* getAncestry(Personagem *P){
    return P->ancestry;
}

void setAncestry(char *species, Personagem *P){
    strcpy(P->species, species);
}

char* getSpecies(Personagem *P){
    return P->species;
}

void setSpecies(char *species, Personagem *P){
    strcpy(P->species, species);
}

char* getPatronus(Personagem *P){
    return P->patronus;
}

void setPatronus(char *patronus, Personagem *P){
    strcpy(P->patronus, patronus);
}

char* getHogwartsStaff(Personagem *P){
    int value = P->hogwartsStaff;
    return value == 1? "true": "false";
}

void setHogwartsStaff(char *hogwartsStaff, Personagem *P){
    if(strcmp(hogwartsStaff, "true") == 0){
        P->hogwartsStaff = 1;    
    }else {
        P->hogwartsStaff = 0;
    }
}

char* getHogwartsStudent(Personagem *P){
    int value = P->hogwartsStudent;
    return value == 1? "true": "false";
}

void setHogwartsStudent(char * hogwartsStudent, Personagem *P){
      if(strcmp(hogwartsStudent, "true") == 0){
        P->hogwartsStaff = 1;    
    }else {
        P->hogwartsStaff = 0;
    }
}

char* getActorName(Personagem *P){
    return P->actorName;
}

void setActorName(char *actorName, Personagem *P){
    strcpy(P->actorName, actorName);
}

char* getAlive(Personagem *P){
    int value = P->alive;
    return value == 1? "true": "false";
}

void setAlive(char *alive, Personagem *P){
    if(strcmp(alive, "true") == 0){
        P->alive = 1;    
    }else {
        P->alive = 0;
    }
}

char* getDateOfBirth(Personagem *P){
    return P->dateOfBirth;
}

void setDateOfBirth(char *dateOfBirth, Personagem *P){
    strcpy(P->dateOfBirth, dateOfBirth);
}

int getYearOfBith(Personagem *P){
    return P->yearOfBirth;
}

void setYearOfBith(int yearOfBirth, Personagem *P){
    P->yearOfBirth = yearOfBirth;
}

char* getEyeColour(Personagem *P){
    return P->eyeColour;
}

void setEyeColour(char *eyeColour, Personagem *P){
    strcpy(P->eyeColour, eyeColour);
}

char* getGender(Personagem *P){
    return P->gender;
}

void setGender(char *gender, Personagem *P){
    strcpy(P->gender, gender);
}

char* getHairColor(Personagem *P){
    return P->hairColor;
}

void setHairColor(char *hairColor, Personagem *P){
    strcpy(P->hairColor, hairColor);
}

char* getWizard(Personagem *P){
    int value = P->wizard;
    return value == 1? "true": "false";
}

void setWizard(char *wizard, Personagem *P){
    if(strcmp(wizard, "true") == 0){
        P->wizard = 1;    
    }else {
        P->wizard = 0;
    }
}