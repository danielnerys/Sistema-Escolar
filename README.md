# 📚 Sistema de Gerenciamento Escolar (CRUD)

Este projeto é uma aplicação de console em Java para o gerenciamento de alunos e turmas, utilizando JDBC para persistência em banco de dados e seguindo o padrão de arquitetura DAO (Data Access Object).

## 🚀 Funcionalidades

O sistema oferece um menu interativo com as seguintes operações:

* **Cadastrar Aluno**: Registro completo com Nome, CPF, Email, Data de Nascimento e Telefone.
* **Atualizar Aluno**: Permite editar Nome, Email ou Telefone de um aluno existente através do ID.
* **Excluir Aluno**: Remoção de registros do banco de dados.
* **Listar Alunos**: Exibição de todos os alunos cadastrados.
* **Buscar por ID**: Localiza e exibe os detalhes de um aluno específico.
* **Gestão de Turmas**: Listagem de todas as turmas e consulta de alunos matriculados por turma.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 11+
* **Persistência:** JDBC (Java Database Connectivity)
* **Arquitetura:** Padrão DAO (Data Access Object)
* **Entrada de Dados:** Scanner (Java Util)

## 📂 Estrutura do Código

* `org.example.App`: Classe principal com o menu e loop do sistema.
* `model`: Classes de entidade (`Aluno` e `Turma`).
* `DAOImplements`: Classes que contém o SQL (Insert, Update, Delete, Select).
* `database`: Configurações da classe `sqlConn` para conexão com o banco.

## ⚙️ Como Executar

1.  **Configurar Banco**: Certifique-se de que as tabelas `aluno` e `turma` existam no seu banco de dados.
2.  **Conexão**: Ajuste a URL, usuário e senha na classe `sqlConn.java`.
3.  **Execução**:
    * Importe como projeto Maven na sua IDE (IntelliJ, Eclipse ou VS Code).
    * Execute a classe `App.java`.

## 📝 Exemplo de Uso (Terminal)

```text
======= Menu =========
1. Cadastrar Aluno
2. Atualizar Aluno
3. Excluir Aluno
4. Listar Alunos
5. Buscar aluno por ID
6. Listar todas turmas
