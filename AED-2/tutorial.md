# Algoritmo e Estrutura de Dados II
## Como usar o Nvim e o Nano
O Nvim e o Nano são IDE do tipo editores de texto que podem ser executados em um terminal Linux, o repositório tratará, especificamente, do Shell Script Bash para distribuições Linux baseadas em Debian. Torna-se versátil para computadores linux (com ou sem dualboot), terminal wls ou git bash, cloud, servidores e dockers.

O comando **touch** cria um arquivo vazio, enquanto o **chmod 777** oferece permissões de escrita (write/w), leitura (read/r) e execução (execute/x) no superusuário/admin, no grupo local, no grupo de usuários utilizadores, respectivamente.
```bash
$ touch arquivo.java
$ chmod777 arquivo.java
```
Pode ser escolhido tanto o **vim** quanto o **nano**
```bash
$ vim arquivo.java
$ nano arquivo.java
```
Depois disso, é só compilar na linguagem!

**OBS.:** Se o compilador ou editor de texto não estiver instalado, faça: um **sudo apt install**

## Como compilar em Java e em C/C++
* Arquivo em **Java** (arquivo.java)
```bash
$ javac arquivo.java
```
Isso irá criar um executável, por **arquivo.class**. Assim,
```bash
$ java arquivo.java
```

* Arquivo em **C** (arquivo.c)
```bash
$ gcc arquivo.c -o arquivo
```
Logo em seguida, o compilador criará um arquivo executor com o nome passado após o parâmetro -o
```bash
$ ./arquivo
```

* Arquivo em **C++** (arquivo.cpp)
```bash
$ g++ arquivo.cpp -o arquivo
```
Logo em seguida, o compilador criará um arquivo executor com o nome passado após o parâmetro -o
```bash
$ ./arquivo
```

## Acompanhe o Calendário:

| **Aula** | **Conteúdo** |
|------------|--------------|
| 1 | Apresentação da disciplina e dos professores |
| 2 | U1 - Introdução (Noções de Complexidade) |
| 3 | U1 - Introdução (Noções de Complexidade) |
| 4 | U1 - Introdução (Ordenação interna - Seleção) |
| 5 | U1 - Somatórios |
| 6 | U1 - Somatórios |
| 7 | U1 - Fundamentos de análise de algoritmos |
| 8 | U1 - Fundamentos de análise de algoritmos |
| 9 | U2 - Estruturas de dados lineares |
| 10 | Prova I (17/mar) |
| 11 | U3 - Ordenação (Inserção e Merge) |
| 12 | U3 - Ordenação (Quicksort) |
| 13 | U3 - Ordenação (Heap) |
| 14 | U3 - Ordenação (Heap) |
| 15 | U3 - Ordenação Parcial |
| 16 | U3 - Ordenação Paralela |
| 17 | U4 - Estruturas de dados flexível (referência, alocação, célula cabeça) |
| 18 | U4 - Estruturas de dados flexível (Pilha) |
| 19 | U4 - Estruturas de dados flexível (Fila e Lista) |
| 20 | U4 - Estruturas de dados flexível (Lista Dupla e Matriz) |
| 21 | U4 - Estruturas de dados flexível (Coleta de Lixo) |
| 22 | U5 - Árvores binárias (Conceitos básicos e o tipo Nó) |
| 23 | U5 - Árvores binárias (Inserção e Caminhamento) |
| 24 | U5 - Árvores binárias (Exercícios e Remoção) |
| 25 | Prova 2 (7/maio) |
| 26 | U5 - Árvores binárias (Inserção em C e C++) |
| 27 | U5 - Árvores binárias (Estruturas híbridas) |
| 28 | U6 - Balanceamento (Tipos de rotações e AVL) |
| 29 | U6 - Balanceamento (2-3-4) |
| 30 | U6 - Balanceamento (Bicolor) |
| 31 | U7 - Tabelas e dicionários (hash) |
| 32 | U7 - Tabelas e dicionários (dicionários) |
| 33 | U8 - Árvores TRIE |
| 34 | U8 - Árvores TRIE |
| 35 | U8 - Árvores TRIE |
| 36 | Exercícios |
| 37 | Prova 3 (26/jun) |
| 38 | Devolutiva |
| 39 | Reavaliação (3/jul) |
| 40 | Devolutiva |
