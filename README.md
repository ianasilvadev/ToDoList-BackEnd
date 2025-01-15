# To do List (Front-end)

## Começando

Projeto é uma aplicação Full Stack, que inclui tanto o Front-end quanto o Back-end, utilizando React JS no Front-end e Spring Boot no Back-end. A API de lista de tarefas (ToDo List) permite que os usuários criem, leiam e excluam tarefas, além de armazenar informações como título, descrição e status. A aplicação é conteinerizada com Docker, facilitando sua implementação e escalabilidade. Nesta documentação, analisaremos os pré-requisitos, o processo de instalação, construção e as versões do projeto referentes à parte Back-end com Spring Boot.

### 📋 Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas ambiente de desenvolvimento:

```
* Java
* Spring Boot 
* Docker

```

### 🔧 Instalação

1. Clone o repositório:

```
git clone <repositorio>
cd <pasta com o repositorio>
Instale as dependências:
```

2. Instalar as dependências necessárias para o Back-end:

```
mvn install

```

3. Construa a imagem Docker:

```
docker-compose build

```

4. Inicie os contêineres:

```
docker-compose up

```

5. O back-end estará disponível em: http://localhost:8080


### 🛠️ Construído com

* [Spring Boot] - Utilizado no Back-end para desenvolver a API RESTl que gerencia as operações de lista de tarefas
* [Java] - Linguagem de programação utilizada no desenvolvimento do Back-end.
* [Docker] - Usado para criar contêineres que facilitam a execução da aplicação em diferentes ambientes de desenvolvimento e produção.
* [MySQL] - Banco de dados relacional para armazenar as informações das tarefas.
* [Spring Data JPA] - Usado para simplificar a integração com o banco de dados e operações CRUD.
* [Spring Web] - Framework do Spring que permite criar endpoints RESTful de maneira simples.
* [Spring Boot DevTools] - Ferramenta para facilitar o desenvolvimento, com recursos como recarga automática.
* [Spring Transaction Management] - Gerenciar transações e garantir a consistência dos dados durante operações críticas.


### ⚙️ Funcionalidades (Endpoints)

**1. Criação de tarefa:**


* Endpoint: **POST /v1/tarefas**

* Descrição: Permite que seja realizada a criação de novas tarefas. O usuário envia um objeto JSON contendo os seguintes dados da tarefa: Título descrição e status. Os dados são recebidos e convertidos para uma entidade Tarefa no Service, que então as salva no banco de dados. 

* Exemplo de requisição: 

{
  "titulo": "Nova Tarefa",
  "descricao": "Descrição da nova tarefa",
  "status": "Pendente"
}


**2. Obter todas as tarefas:**


* Endpoint: **GET /v1/tarefas**

* Descrição: Retorna uma lista de todas as tarefas criadas e armazenadas no banco de dados. A funcionalidade é útil para exibir todas as tarefas no front-end, permitindo aos usuários visualizar o progresso e suas tarefas pendentes.


**3. Obter tarefa específica (por título):**

* Endpoint: **GET /v1/tarefas/buscar**

* Descrição: Permite ao usuário buscar uma tarefa específica pelo título. Se a tarefa for encontrada, ela é retornada como um objeto JSON e no Front-end, retorna como um Card de tarefa encontrado. Caso contrário, será lançada uma exceção informando que a tarefa não foi encontrada.


**4. Deletar Tarefa (Endpoint adicional):**

* Endpoint: **DELETE /v1/tarefas/{tarefaId}**

* Descrição: Permite ao usuário deletar uma tarefa específica usando o ID da tarefa. O sistema verifica se a tarefa existe no banco de dados e, se encontrada, é excluída.

### 📋 Banco de dados:

Foi utilizado o banco Mysql para armazenar as informações.

Acessar o MySQL no Contêiner

Para acessar o MySQL, a senha “secret”

**Principais comandos:**

```
SHOW DATABASES;
```
```
USE <todolist>;
```
```
SHOW TABLES;
```
```
DROP TABLE tb_tarefas;
```
```
SELECT * FROM tb_tarefas;
```

### ▶️ Fluxo de Execução:

**Criação da Tarefa:** O usuário realiza uma requisição POST a partir de um formulário no Front-end, que envia um objeto contendo as informações necessárias para a criação de uma tarefa (título, descrição e status).

As tarefas são exibidas na lista de tarefas do Front-end com os status Pendente, Em Progresso e Concluída. Quando uma atividade concluída é adicionada, o sistema a reconhece e a sublinha, tornando-a não editável. Quando uma atividade pendente ou em progresso é adicionada, o usuário pode marcar a tarefa como concluída, utilizando uma verificação (Check). O sistema então altera seu status para “Concluído” e também a torna não editável.


**Obter Todas as Tarefas:** O usuário visualiza as tarefas ao fazer uma requisição GET no Front-end, que exibe todas as tarefas já criadas.
A partir da requisição GET, o front-end exibe todas as tarefas já criadas e existentes           do usuário, mostrando seu título, descrição e status. Para uma melhor visualização, o usuário pode visualizar suas informações com mais detalhes ao clicar em uma das tarefas, o que abrirá um modal exibindo as informações completas.


**Buscar Tarefa por Título:** O usuário pode buscar uma tarefa pelo seu título através de um campo de pesquisa (input Search), onde o valor é capturado e pesquisado no banco de dados para retornar a tarefa correspondente.


**Deletar Tarefa:** O usuário pode excluir uma tarefa clicando no ícone ao lado do status, presente no card de tarefa. Esse ícone faz uma requisição DELETE com o ID da tarefa específica, removendo-a do banco de dados.


