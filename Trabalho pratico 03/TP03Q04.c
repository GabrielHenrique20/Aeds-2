/*Crie uma classe Fila Circular de Personagem. Essa fila deve ter tamanho cinco. Em seguida, faça um programa que leia vários registros e insira seus atributos na fila.
Quando o programa tiver que inserir um registro e a fila estiver cheia, antes, ele deve fazer uma remoção. A entrada padrão será igual à da questão anterior.
A saída padrão será um número inteiro para cada registro inserido na fila.
Esse número corresponde à média arredondada do yearOfBirth dos registros contidos na fila após cada inserção. Além disso, para cada registro removido da fila, a saída padrão também apresenta a palavra (R) e alguns atributos desse registro.
Por último, a saída padrão mostra os registros existentes na fila seguindo o padrão da questão anterior.*/

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <wchar.h>
#include <locale.h>
#include <math.h>

#define MAX 5

typedef struct s_Personagem
{
    char *id;
    char *name;
    char *alternateNames;
    char *house;
    char *ancestry;
    char *species;
    char *patronus;
    bool hogwartsStaff;
    bool hogwartsStudent;
    char *actorName;
    bool alive;
    char *alternateActors;
    char *dateOfBirth;
    int yearOfBirth;
    char *eyeColour;
    char *gender;
    char *hairColour;
    bool wizard;
} Personagem;

// construtor
void newPersonagem(Personagem *personagem, char *id, char *name, char *alternateNames, char *house, char *ancestry, char *species, char *patronus, bool hogwartsStaff, bool hogwartsStudent, char *actorName, bool alive, char *alternateActors, char *dateOfBirth, int yearOfBirth, char *eyeColour, char *gender, char *hairColour, bool wizard)
{
    if (personagem != NULL)
    {
        personagem->id = id;
        personagem->name = name;
        personagem->alternateNames = alternateNames;
        personagem->house = house;
        personagem->ancestry = ancestry;
        personagem->species = species;
        if (strcmp(patronus, "null") == 0)
        {
            personagem->patronus = "";
        }
        else
        {
            personagem->patronus = patronus;
        }
        personagem->hogwartsStaff = hogwartsStaff;
        personagem->hogwartsStudent = hogwartsStudent;
        if (strcmp(actorName, "null") == 0)
        {
            personagem->actorName = "";
        }
        else
        {
            personagem->actorName = actorName;
        }
        personagem->alive = alive;
        personagem->alternateActors = alternateActors;
        personagem->dateOfBirth = dateOfBirth;
        personagem->yearOfBirth = yearOfBirth;
        personagem->eyeColour = eyeColour;
        personagem->gender = gender;
        personagem->hairColour = hairColour;
        personagem->wizard = wizard;
    }
}

// setters

void setPersonagemId(Personagem *p, char *id)
{
    if (p->id != NULL)
        free(p->id);
    p->id = strdup(id);
}

void setPersonagemName(Personagem *p, char *name)
{
    if (p->name != NULL)
        free(p->name);
    p->name = strdup(name);
}

void setPersonagemAlternateNames(Personagem *p, char *alternateNames)
{
    if (p->alternateNames != NULL)
        free(p->alternateNames);
    p->alternateNames = strdup(alternateNames);
}

void setPersonagemHouse(Personagem *p, char *house)
{
    if (p->house != NULL)
        free(p->house);
    p->house = strdup(house);
}

void setPersonagemAncestry(Personagem *p, char *ancestry)
{
    if (p->ancestry != NULL)
        free(p->ancestry);
    p->ancestry = strdup(ancestry);
}

void setPersonagemSpecies(Personagem *p, char *species)
{
    if (p->species != NULL)
        free(p->species);
    p->species = strdup(species);
}

void setPersonagemPatronus(Personagem *p, char *patronus)
{
    if (p->patronus != NULL)
        free(p->patronus);
    p->patronus = strdup(patronus);
}

void setPersonagemHogwartsStaff(Personagem *p, bool hogwartsStaff)
{
    p->hogwartsStaff = hogwartsStaff;
}

void setPersonagemHogwartsStudent(Personagem *p, bool hogwartsStudent)
{
    p->hogwartsStudent = hogwartsStudent;
}

void setPersonagemActorName(Personagem *p, char *actorName)
{
    if (p->actorName != NULL)
        free(p->actorName);
    p->actorName = strdup(actorName);
}

void setPersonagemAlive(Personagem *p, bool alive)
{
    p->alive = alive;
}

void setPersonagemAlternateActors(Personagem *p, char *alternateActors)
{
    if (p->alternateActors != NULL)
        free(p->alternateActors);
    p->alternateActors = strdup(alternateActors);
}

void setPersonagemDateOfBirth(Personagem *p, char *dateOfBirth)
{
    if (p->dateOfBirth != NULL)
        free(p->dateOfBirth);
    p->dateOfBirth = strdup(dateOfBirth);
}

void setPersonagemYearOfBirth(Personagem *p, int yearOfBirth)
{
    p->yearOfBirth = yearOfBirth;
}

void setPersonagemEyeColour(Personagem *p, char *eyeColour)
{
    if (p->eyeColour != NULL)
        free(p->eyeColour);
    p->eyeColour = strdup(eyeColour);
}

void setPersonagemGender(Personagem *p, char *gender)
{
    if (p->gender != NULL)
        free(p->gender);
    p->gender = strdup(gender);
}

void setPersonagemHairColour(Personagem *p, char *hairColour)
{
    if (p->hairColour != NULL)
        free(p->hairColour);
    p->hairColour = strdup(hairColour);
}

void setPersonagemWizard(Personagem *p, bool wizard)
{
    p->wizard = wizard;
}

// getters
char *getPersonagemId(Personagem *p)
{
    return p->id;
}

char *getPersonagemName(Personagem *p)
{
    return p->name;
}

char *getPersonagemAlternateNames(Personagem *p)
{
    return p->alternateNames;
}

char *getPersonagemHouse(Personagem *p)
{
    return p->house;
}

char *getPersonagemAncestry(Personagem *p)
{
    return p->ancestry;
}

char *getPersonagemSpecies(Personagem *p)
{
    return p->species;
}

char *getPersonagemPatronus(Personagem *p)
{
    return p->patronus;
}

bool getPersonagemHogwartsStaff(Personagem *p)
{
    return p->hogwartsStaff;
}

bool getPersonagemHogwartsStudent(Personagem *p)
{
    return p->hogwartsStudent;
}

char *getPersonagemActorName(Personagem *p)
{
    return p->actorName;
}

bool getPersonagemAlive(Personagem *p)
{
    return p->alive;
}

char *getPersonagemAlternateActors(Personagem *p)
{
    return p->alternateActors;
}

char *getPersonagemDateOfBirth(Personagem *p)
{
    return p->dateOfBirth;
}

int getPersonagemYearOfBirth(Personagem *p)
{
    return p->yearOfBirth;
}
char *getPersonagemEyeColour(Personagem *p)
{
    return p->eyeColour;
}

char *getPersonagemGender(Personagem *p)
{
    return p->gender;
}

char *getPersonagemHairColour(Personagem *p)
{
    return p->hairColour;
}

bool getPersonagemWizard(Personagem *p)
{
    return p->wizard;
}

// imprimir personagem

void imprimir(Personagem *personagem)
{
    // adequando ao layout do canvas
    // printf("ESTUDANTE: %s\n",personagem->hogwartsStudent);
    if (personagem->dateOfBirth && strlen(personagem->dateOfBirth) < 10)
    {
        char *aux = calloc(11, sizeof(char)); // espaço para "dd-mm-yyyy\0"
        int dia, mes, ano;

        // parse da data presumindo formatos "d-m-yyyy" ou "dd-m-yyyy" etc.
        if (sscanf(personagem->dateOfBirth, "%d-%d-%d", &dia, &mes, &ano) == 3)
        {
            sprintf(aux, "%02d-%02d-%d", dia, mes, ano); // formata com zeros à esquerda para dia e mês
            free(personagem->dateOfBirth);               // libera a memória antiga
            personagem->dateOfBirth = aux;               // atribui a nova string formatada
        }
        else
        {
            free(aux); // libera aux se não for usada
        }
    }
    printf(" ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %d ## %s ## %s ## %s ## %s]\n", personagem->id, personagem->name, personagem->alternateNames, personagem->house, personagem->ancestry, personagem->species, personagem->patronus, personagem->hogwartsStaff ? "true" : "false", personagem->hogwartsStudent ? "true" : "false", personagem->actorName, personagem->alive ? "true" : "false", personagem->dateOfBirth, personagem->yearOfBirth, personagem->eyeColour, personagem->gender, personagem->hairColour, personagem->wizard ? "true" : "false");
}
bool checardata(char data[])
{
    bool edata = "false";
    char molde[] = {"00-0-0000"};
    int count = 0;
    for (int i = 0; i < strlen(molde); i++)
    {
        if (data[i] == molde[i])
        {
            count++;
        }
    }
    if (count == 2)
    {
        edata = "true";
    }
    return edata;
}

void padronizarData(char data[])
{
    int dia, mes, ano;
    for (int i = 0; i < strlen(data); i++)
    {
        printf("%c", data[i]);
    }
    printf("\n");
}

// ler arquivo e colocar as caracteristicas daquele ID no personagem

Personagem clone(Personagem *p1)
{

    Personagem *aux = (Personagem *)malloc(1 * sizeof(Personagem));
    newPersonagem(aux, getPersonagemId(p1), getPersonagemName(p1), getPersonagemAlternateNames(p1), getPersonagemHouse(p1), getPersonagemAncestry(p1), getPersonagemSpecies(p1), getPersonagemPatronus(p1), getPersonagemHogwartsStaff(p1), getPersonagemHogwartsStudent(p1), getPersonagemActorName(p1), getPersonagemAlive(p1), getPersonagemAlternateActors(p1), getPersonagemDateOfBirth(p1), getPersonagemYearOfBirth(p1), getPersonagemEyeColour(p1), getPersonagemGender(p1), getPersonagemHairColour(p1), getPersonagemWizard(p1));
}

Personagem *ler(Personagem *personagem, char *filename, char *id_procurado)
{
    // leitura do arquivo
    FILE *file = fopen(filename, "r");
    if (file == NULL)
    {
        printf("\nERROR: File Not Found.\n");
    }
    else
    {
        char line[500];
        // variavel para controlar o while
        bool idFound = false;

        // pular cabeçalho
        fgets(line, sizeof(line), file);
        // ler o resto das linhas
        int na = 0;
        // a cada fgets é uma quebra de linha
        while (fgets(line, sizeof(line), file) != NULL && !idFound)
        {
            char *atributos[18];
            char auxline[500] = {0};
            int col = 0;
            int t = 0;
            int k = 0;
            int index = 0;
            // faz a mesma coisa que o split, armazena nessa variavel as palavras separadas com ;
            char *token = strtok(line, ";");
            int execvar = 0;
            na++;
            int debug = 0;
            while (token != NULL)
            {
                // nesse caso a lógica é que esse ponteiro de strings "token" vai ser repartido e seu valor vai para aquele indice em atributos
                debug++;
                execvar++;
                atributos[index++] = strdup(token);
                token = strtok(NULL, ";");
            }
            // variavel auxiliar para trocar o [] por {}
            char aux[500] = {0};
            int j = 0;
            for (int i = 0; i < strlen(atributos[2]); i++)
            {
                if (atributos[2][i] == '[')
                {
                    aux[j] = '{';
                }
                else if (atributos[2][i] == ']')
                {
                    aux[j] = '}';
                }
                else if (atributos[2][i] == '\'')
                {
                    continue;
                }
                else
                {
                    aux[j] = atributos[2][i];
                }
                j++;
            }
            aux[j] = '\0';

            free(atributos[2]);
            atributos[2] = strdup(aux);
            // comparação entre a primeira coluna e o id colocado pelo usuario
            if (strcmp(atributos[0], id_procurado) == 0)
            {
                // atribuição dos valores das colunas para um personagem
                bool aux = "false";

                if (execvar < 18)
                {
                    if (execvar > 16)
                    {
                        if (strlen(atributos[16]) >= 11)
                        {
                            aux = "true";
                        }
                        else
                        {
                            aux = 0;
                        }
                        newPersonagem(personagem, atributos[0], atributos[1], atributos[2], atributos[3], atributos[4], atributos[5], "null", strcmp(atributos[6], "VERDADEIRO") == 0, strcmp(atributos[7], "VERDADEIRO") == 0, atributos[8], strcmp(atributos[9], "VERDADEIRO") == 0, atributos[10], atributos[11], atoi(atributos[12]), atributos[13], atributos[14], atributos[15], aux);
                    }
                    else
                    {
                        if (strlen(atributos[15]) >= 11)
                        {
                            aux = "true";
                        }
                        else
                        {
                            aux = 0;
                        }
                        newPersonagem(personagem, atributos[0], atributos[1], atributos[2], atributos[3], atributos[4], atributos[5], "null", strcmp(atributos[6], "VERDADEIRO") == 0, strcmp(atributos[7], "VERDADEIRO") == 0, "null", strcmp(atributos[8], "VERDADEIRO") == 0, atributos[9], atributos[10], atoi(atributos[11]), atributos[12], atributos[13], atributos[14], aux);
                    }
                }
                else
                {
                    if (strlen(atributos[17]) >= 11)
                    {
                        aux = "true";
                    }
                    else
                    {
                        aux = 0;
                    }
                    newPersonagem(personagem, atributos[0], atributos[1], atributos[2], atributos[3], atributos[4], atributos[5], atributos[6], strcmp(atributos[7], "VERDADEIRO") == 0, strcmp(atributos[8], "VERDADEIRO") == 0, atributos[9], strcmp(atributos[10], "VERDADEIRO") == 0, atributos[11], atributos[12], atoi(atributos[13]), atributos[14], atributos[15], atributos[16], aux);
                }
                idFound = true;
                // retorna o personagem com essas caracteristicas
                return personagem;
            }

            // liberar memoria
            for (int x = 0; x < index; x++)
            {
                free(atributos[x]);
            }
        }
        // fechar arquivo
        fclose(file);
    }
}

bool pesquisaBinaria(Personagem *personagens, int n, char *nomeprocurado)
{
    bool encontrou = false;
    int esq = 0, dir = n - 1, meio;
    while (esq <= dir && !encontrou)
    {
        meio = (esq + dir) / 2;
        int res = strcmp(personagens[meio].name, nomeprocurado);
        if (strcmp(personagens[meio].name, nomeprocurado) == 0)
        {
            encontrou = true;
        }
        if (strcmp(personagens[meio].name, nomeprocurado) < 0)
        {
            esq = meio + 1;
        }
        if (strcmp(personagens[meio].name, nomeprocurado) > 0)
        {
            dir = meio - 1;
        }
    }
    return encontrou; // não encontrou o personagem
}

// função para ordenar o array usando o algoritmo Shell Sort
void shellSort(Personagem personagens[], int n)
{
    // define o intervalo inicial
    int intervalo = 1;
    while (intervalo < n / 3)
    {
        intervalo = intervalo * 3 + 1;
    }

    // aplica o algoritmo Shell Sort
    while (intervalo >= 1)
    {
        for (int i = intervalo; i < n; i++)
        {
            Personagem chave = personagens[i];
            int j = i - intervalo;
            while (j >= 0 && strcmp(personagens[j].eyeColour, chave.eyeColour) > 0)
            {
                personagens[j + intervalo] = personagens[j];
                j -= intervalo;
            }
            personagens[j + intervalo] = chave;
        }
        intervalo /= 3;
    }
}

void swap(Personagem *i, Personagem *j)
{
    Personagem temp = *i;
    *i = *j;
    *j = temp;
}

void bolha(Personagem personagens[], int n)
{
    int i, j;
    for (i = 0; i < n - 1; i++)
    {
        for (j = 0; j < n - 1; j++)
        {
            if (strcmp(personagens[j].hairColour, personagens[j + 1].hairColour) > 0 || (strcmp(personagens[j].hairColour, personagens[j + 1].hairColour) == 0 && strcmp(personagens[j].name, personagens[j + 1].name) > 0))
            {
                swap(&personagens[j], &personagens[j + 1]);
            }
        }
    }
}
void construir(Personagem *array, int tamHeap)
{
    for (int i = tamHeap; i > 1; i /= 2)
    {
        int cmp = strcmp(array[i].hairColour, array[i / 2].hairColour);
        if (cmp < 0 || (cmp == 0 && strcmp(array[i].name, array[i / 2].name) < 0))
        {
            swap(&array[i], &array[i / 2]);
        }
        else
        {
            break; // Se não é menor e nem igual, não faz swap, quebra o loop
        }
    }
}

int getMaiorFilho(Personagem *array, int i, int tamHeap)
{
    int filho = 2 * i;
    if (filho < tamHeap)
    {
        int cmp = strcmp(array[filho].hairColour, array[filho + 1].hairColour);
        if (cmp > 0 || (cmp == 0 && strcmp(array[filho].name, array[filho + 1].name) > 0))
        {
            filho++;
        }
    }
    return filho;
}

void reconstruir(Personagem *array, int tamHeap)
{
    int i = 1;
    while (i <= (tamHeap / 2))
    {
        int filho = getMaiorFilho(array, i, tamHeap);
        int cmp = strcmp(array[i].hairColour, array[filho].hairColour);
        if (cmp > 0 || (cmp == 0 && strcmp(array[i].name, array[filho].name) > 0))
        {
            swap(&array[i], &array[filho]);
            i = filho;
        }
        else
        {
            break;
        }
    }
}

void partialHeapsort(Personagem *array, int n, int k)
{
    // Alterar o vetor ignorando a posição zero
    Personagem arrayTmp[n + 1];
    for (int i = 0; i < n; i++)
    {
        arrayTmp[i + 1] = array[i];
    }

    // Construção do heap
    for (int tamHeap = 2; tamHeap <= n; tamHeap++)
    {
        construir(arrayTmp, tamHeap);
    }

    // Ordenação parcial (extrai apenas os k menores elementos)
    int tamHeap = n;
    for (int i = 0; i < k; i++)
    {
        swap(&arrayTmp[1], &arrayTmp[tamHeap]);
        tamHeap--;
        reconstruir(arrayTmp, tamHeap);
    }

    // Copiar os k menores elementos de volta para o array original
    for (int i = 0; i < k; i++)
    {
        array[i] = arrayTmp[n - i];
    }
}

typedef struct
{
    Personagem *personagens[MAX];
    int inicio;
    int fim;
    int tamanho;
} FilaCircular;

void inicializarFila(FilaCircular *fila)
{
    fila->inicio = 0;
    fila->fim = 0;
    fila->tamanho = 0;
}

bool filaVazia(FilaCircular *fila)
{
    return (fila->tamanho == 0);
}

bool filaCheia(FilaCircular *fila)
{
    return (fila->tamanho == MAX);
}

void inserirFila(FilaCircular *fila, Personagem *p)
{
    if (filaCheia(fila))
    {
        Personagem *removido = fila->personagens[fila->inicio];
        fila->inicio = (fila->inicio + 1) % MAX;
        fila->tamanho--;
        free(removido->id);
        free(removido->name);
        free(removido);
    }
    fila->personagens[fila->fim] = p;
    fila->fim = (fila->fim + 1) % MAX;
    fila->tamanho++;
    int soma = 0;
    for (int i = 0; i < fila->tamanho; i++)
    {
        int index = (fila->inicio + i) % MAX;
        soma += fila->personagens[index]->yearOfBirth;
    }
    printf(">> Year Birthday Average: %d\n", (int)round((double)soma / fila->tamanho));
}

void imprimirFila(FilaCircular *fila)
{
    for (int i = 0; i < fila->tamanho; i++)
    {
        int index = (fila->inicio + i) % MAX;
        printf("%s\n", fila->personagens[index]->name);
    }
}
Personagem *removerFila(FilaCircular *fila)
{
    if (filaVazia(fila))
    {
        return NULL;
    }
    Personagem *removido = fila->personagens[fila->inicio];
    fila->inicio = (fila->inicio + 1) % MAX;
    fila->tamanho--;
    return removido;
}
Personagem *inicializarPersonagem(char *id)
{
    Personagem *p = (Personagem *)malloc(sizeof(Personagem));
    char *path = "/tmp/characters.csv";
    ler(p, path, id);
    return p;
}
int main()
{
    Personagem *personagens = NULL;
    Personagem *personagem = NULL;
    int numPersonagens = 0;
    char *path = "/tmp/characters.csv";
    char id[81];
    FilaCircular fila;
    inicializarFila(&fila);

    // ler id novo
    scanf("%s", id);
    getchar();
    while (strcmp(id, "FIM") != 0)
    {

        personagem = (Personagem *)malloc(sizeof(Personagem));
        // alocar espaço para um novo personagem no array
        personagens = (Personagem *)realloc(personagens, (numPersonagens + 1) * sizeof(Personagem));

        if (personagens == NULL)
        {
            fprintf(stderr, "Erro ao alocar memória\n");
            return 1;
        }

        // ler o personagem do arquivo
        ler(&personagens[numPersonagens], path, id);
        ler(personagem, path, id);
        inserirFila(&fila, personagem);
        numPersonagens++;

        // ler id novo
        scanf("%s", id);
        getchar();
    }

    int numComandos;
    scanf("%d", &numComandos);

    for (int i = 0; i < numComandos; i++)
    {
        char comando[10];
        scanf("%s", comando);
        if (strcmp(comando, "I") == 0)
        {
            scanf("%s", id);
            Personagem *p = inicializarPersonagem(id);
            inserirFila(&fila, p);
        }
        else if (strcmp(comando, "R") == 0)
        {
            Personagem *p = removerFila(&fila);
            if (p != NULL)
            {
                printf("(R) %s %d\n", p->name, p->yearOfBirth);
                free(p->id);
                free(p->name);
                free(p);
            }
        }
    }

    printf("[ Head ]\n");
    imprimirFila(&fila);
    printf("[ Tail ]\n");

    // Liberar memória alocada para o array de personagens
    for (int i = 0; i < numPersonagens; i++)
    {
        free(personagens[i].id);
        free(personagens[i].name);
    }
    free(personagens);

    return 0;
}