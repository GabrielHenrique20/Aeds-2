/*Repita a questão anterior, contudo, usando a Seleção Recursiva. A entrada e a saída padrão serão iguais as da questão anterior. O nome do arquivo de log será matrícula_selecaoRecursiva.txt.*/

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

// Definição da estrutura para representar um personagem
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

// Protótipos de funções
Personagem construtor(char *, char *, char *, char *, char *, char *, char *, bool, bool, char *, bool, char *, int, char *, char *, char *, bool);
Personagem construtor_vazio();
char **ler(char *);
void imprimir(Personagem *);
void PreencherVetor(Personagem *, char[][200]);
void Selecao(Personagem *, int, int, int *);
void Log(int, int, double);
char *getId(Personagem *);
void setId(char *, Personagem *);
char *getName(Personagem *);
void setName(char *, Personagem *);
char *getAlternate_names(Personagem *);
void setAlternate_names(char *, Personagem *);
char *getHouse(Personagem *);
void setHouse(char *, Personagem *);
char *getAncestry(Personagem *);
void setAncestry(char *, Personagem *);
char *getSpecies(Personagem *);
void setSpecies(char *, Personagem *);
char *getPatronus(Personagem *);
void setPatronus(char *, Personagem *);
char *getHogwartsStaff(Personagem *);
void setHogwartsStaff(char *, Personagem *);
char *getHogwartsStudent(Personagem *);
void setHogwartsStudent(char *, Personagem *);
char *getActorName(Personagem *);
void setActorName(char *, Personagem *);
char *getAlive(Personagem *);
void setAlive(char *, Personagem *);
char *getDateOfBirth(Personagem *);
void setDateOfBirth(char *, Personagem *);
int getYearOfBith(Personagem *);
void setYearOfBith(int, Personagem *);
char *getEyeColour(Personagem *);
void setEyeColour(char *, Personagem *);
char *getGender(Personagem *);
void setGender(char *, Personagem *);
char *getHairColor(Personagem *);
void setHairColor(char *, Personagem *);
char *getWizard(Personagem *);
void setWizard(char *, Personagem *);

// Função principal
int main(){
    clock_t inicio = clock();
    char id[200];
    char ids[27][200];
    int i = 0;
    scanf("%s", id);
    int comp_mov[2] = {0,0};
    
    while(strcmp(id, "FIM") != 0){
        strcpy(ids[i], id);
        i++;
        scanf("%s", id);
    }

    Personagem personagens[27];
    PreencherVetor(personagens, ids);

    
    ShellSort(personagens, comp_mov);
    
    clock_t fim = clock();

    double tempoExecucao = (double)(fim - inicio);

    Log(comp_mov[0], comp_mov[1], tempoExecucao);

    for(int i = 0; i < 27; i++){
        imprimir(&personagens[i]);
    }
}

// Função para construir um personagem com todos os atributos fornecidos
Personagem construtor(char id[], char name[], char alternate_names[], char house[], char ancestry[], char species[], char patronus[], bool hogwartsStaff, bool hogwartsStudent, char actorName[], bool alive, char dateOfBirth[],
                      int yearOfBirth, char eyeColour[], char gender[], char hairColor[], bool wizard)
{
    Personagem P;

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

// Função para construir um personagem com valores padrão
Personagem construtor_vazio()
{
    Personagem P;

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

// Função para ler os atributos de uma linha CSV e retorná-los como um array de strings
char **ler(char line[])
{
    int tam_line = strlen(line);
    int start = 0;
    int count_campos = 0;
    char **campos = malloc(18 * sizeof(char *));

    for (int i = 0; i < 18; i++)
    {
        campos[i] = malloc(500); // Aloca memória para cada string
    }

    // Iteração sobre a linha para extrair os campos separados por ';'
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

    // Copiando o último campo
    strncpy(campos[17], line + start, tam_line - start - 1);

    return campos;
}

// Função para imprimir os atributos de um personagem
void imprimir(Personagem *P)
{
    printf("[%s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %d ## %s ## %s ## %s ## %s]\n",
           P->id, P->name, P->alternate_names.Lista, P->house, P->ancestry, P->species, P->patronus,
           P->hogwartsStaff == 1 ? "true" : "false", P->hogwartsStudent == 1 ? "true" : "false", P->actorName, P->alive == 1 ? "true" : "false", P->dateOfBirth, P->yearOfBirth, P->eyeColour, P->gender, P->hairColor, P->wizard == 1 ? "true" : "false");
}

// Função para preencher um vetor de personagens a partir de um arquivo CSV
void PreencherVetor(Personagem personagens[], char ids[][200])
{
    FILE *arquivo_csv;
    char line[1200];
    if ((arquivo_csv = fopen("characters.csv", "r")) != NULL)
    {

        int i = 0;
        int tam_lista;
        fgets(line, 1200, arquivo_csv);
        while (fgets(line, 1200, arquivo_csv) != NULL)
        {
            char **atributos = ler(line);

            // Ajuste para o formato da lista de nomes alternativos
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

            // Preenchendo o vetor de personagens com base nos IDs fornecidos
            for (int k = 0; k < 27; k++)
            {
                if (strcmp(ids[k], atributos[0]) == 0)
                {
                    personagens[i] = construtor(atributos[0], atributos[1], atributos[2], atributos[3], atributos[4],
                                                atributos[5], atributos[6], strcmp(atributos[7], "VERDADEIRO") == 0 ? true : false, strcmp(atributos[8], "VERDADEIRO") == 0 ? true : false, atributos[9], atributos[10],
                                                atributos[12], atoi(atributos[13]), atributos[14], atributos[15], atributos[16], strcmp(atributos[17], "VERDADEIRO") == 0 ? true : false);

                    i++;
                }
            }

            free(atributos);
        }
        fclose(arquivo_csv);
    }
    else
    {
        printf("Não foi possivel ler o arquivo");
    }
}

void ShellSort(Personagem personagens[], int comp_mov[]){
    int h = 1;

    do{
        h = (h*3) + 1;
    }while(h < 27);

    do{ 
        h /= 3;
        for(int cor = 0; cor < h; cor++){
            IncercaoPorCor(personagens, cor, h, comp_mov);
        }
    }while(h > 1);
        
}

void IncercaoPorCor(Personagem personagens[], int cor, int h, int comp_mov[]){
    for(int i = (cor + h); i < 27; i += h){
        Personagem tmp = personagens[i];
        int j = i - h;
        while((j >= 0) && (strcmp(personagens[j].eyeColour,tmp.eyeColour) >= 0)){
            if(strcmp(personagens[j].eyeColour,tmp.eyeColour) == 0){
                if(strcmp(personagens[j].name,tmp.name) > 0){
                    personagens[j+h] = personagens[j];
                    comp_mov[0] += 3;
                    comp_mov[1]++;
                    j -= h;
                }else{
                    comp_mov[0] += 3;
                    break;
                }
            }else{
                personagens[j+h] = personagens[j];
                comp_mov[0] += 2;
                comp_mov[1]++;
                j -= h;
            }
        }

        personagens[j+h] = tmp;
        comp_mov[1]++;
    }
}

// Função para registrar os resultados no arquivo de log
void Log(int comparacoes, int movimentacoes, double tempoExecucao)
{
    FILE *log;

    if ((log = fopen("775799_selecaoRecursiva.txt", "w")) != NULL)
    {
        fprintf(log, "775799\t%d\t%d\t%f", comparacoes, movimentacoes, tempoExecucao);
    }
    else
    {
        printf("Erro ao abrir arquivo de Log!");
    }
}

// As funções abaixo são getters e setters para os atributos da estrutura Personagem

char *getId(Personagem *P)
{
    return P->id;
}

void setId(char *id, Personagem *P)
{
    strcpy(P->id, id);
}

char *getName(Personagem *P)
{
    return P->name;
}

void setName(char *name, Personagem *P)
{
    strcpy(P->name, name);
}

char *getAlternate_names(Personagem *P)
{
    return P->alternate_names.Lista;
}

void setAlternate_names(char *alternate_names, Personagem *P)
{
    strcpy(P->alternate_names.Lista, alternate_names);
}

char *getHouse(Personagem *P)
{
    return P->house;
}

void setHouse(char *house, Personagem *P)
{
    strcpy(P->house, house);
}

char *getAncestry(Personagem *P)
{
    return P->ancestry;
}

void setAncestry(char *species, Personagem *P)
{
    strcpy(P->species, species);
}

char *getSpecies(Personagem *P)
{
    return P->species;
}

void setSpecies(char *species, Personagem *P)
{
    strcpy(P->species, species);
}

char *getPatronus(Personagem *P)
{
    return P->patronus;
}

void setPatronus(char *patronus, Personagem *P)
{
    strcpy(P->patronus, patronus);
}

char *getHogwartsStaff(Personagem *P)
{
    int value = P->hogwartsStaff;
    return value == 1 ? "true" : "false";
}

void setHogwartsStaff(char *hogwartsStaff, Personagem *P)
{
    if (strcmp(hogwartsStaff, "true") == 0)
    {
        P->hogwartsStaff = 1;
    }
    else
    {
        P->hogwartsStaff = 0;
    }
}

char *getHogwartsStudent(Personagem *P)
{
    int value = P->hogwartsStudent;
    return value == 1 ? "true" : "false";
}

void setHogwartsStudent(char *hogwartsStudent, Personagem *P)
{
    if (strcmp(hogwartsStudent, "true") == 0)
    {
        P->hogwartsStaff = 1;
    }
    else
    {
        P->hogwartsStaff = 0;
    }
}

char *getActorName(Personagem *P)
{
    return P->actorName;
}

void setActorName(char *actorName, Personagem *P)
{
    strcpy(P->actorName, actorName);
}

char *getAlive(Personagem *P)
{
    int value = P->alive;
    return value == 1 ? "true" : "false";
}

void setAlive(char *alive, Personagem *P)
{
    if (strcmp(alive, "true") == 0)
    {
        P->alive = 1;
    }
    else
    {
        P->alive = 0;
    }
}

char *getDateOfBirth(Personagem *P)
{
    return P->dateOfBirth;
}

void setDateOfBirth(char *dateOfBirth, Personagem *P)
{
    strcpy(P->dateOfBirth, dateOfBirth);
}

int getYearOfBith(Personagem *P)
{
    return P->yearOfBirth;
}

void setYearOfBith(int yearOfBirth, Personagem *P)
{
    P->yearOfBirth = yearOfBirth;
}

char *getEyeColour(Personagem *P)
{
    return P->eyeColour;
}

void setEyeColour(char *eyeColour, Personagem *P)
{
    strcpy(P->eyeColour, eyeColour);
}

char *getGender(Personagem *P)
{
    return P->gender;
}

void setGender(char *gender, Personagem *P)
{
    strcpy(P->gender, gender);
}

char *getHairColor(Personagem *P)
{
    return P->hairColor;
}

void setHairColor(char *hairColor, Personagem *P)
{
    strcpy(P->hairColor, hairColor);
}

char *getWizard(Personagem *P)
{
    int value = P->wizard;
    return value == 1 ? "true" : "false";
}

void setWizard(char *wizard, Personagem *P)
{
    if (strcmp(wizard, "true") == 0)
    {
        P->wizard = 1;
    }
    else
    {
        P->wizard = 0;
    }
}
