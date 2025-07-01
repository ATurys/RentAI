# Projeto de Programação Orientada a Objetos em Java

Este projeto consiste no desenvolvimento de um sistema em Java que aplica os princípios da Programação Orientada a Objetos (POO) para gerenciar informações de um domínio específico. O sistema evolui de uma aplicação em memória para uma solução completa com persistência de dados em um banco de dados relacional.

---

## Etapa 1: Fundamentos de POO e Modelagem em Memória

### Objetivos de Aprendizagem

Nesta etapa inicial, os principais objetivos foram:

* **Modelagem Orientada a Objetos:** Aprender a modelar um domínio de problema utilizando os princípios da POO.
* **Encapsulamento:** Implementar classes em Java aplicando corretamente o conceito de encapsulamento.
* **Relacionamentos entre Classes:** Implementar diferentes tipos de relacionamentos (associação, agregação e composição) para refletir a estrutura do domínio.
* **Mapeamento Conceitual:** Realizar o mapeamento conceitual de um modelo de dados (proveniente da disciplina de Banco de Dados) para um modelo orientado a objetos.
* **Interface de Usuário Simplificada:** Desenvolver uma aplicação simples com interface de usuário baseada em menu de texto no terminal (console).

### Descrição Geral

O projeto inicial foca na implementação das funcionalidades básicas de cadastro (inserção) e consulta de informações sobre um domínio específico. Este domínio é o mesmo trabalhado na disciplina de Banco de Dados. O sistema foi modelado e implementado seguindo os princípios fundamentais da POO, **operando exclusivamente em memória**.

---

### O Domínio do Sistema

O domínio do sistema reutiliza o tema, entidades e relacionamentos definidos e modelados no projeto da disciplina de Banco de Dados. Exemplos comuns incluem Sistemas de Gerenciamento de Biblioteca, Controle Simplificado de Vendas, Gestão Acadêmica Básica, ou Sistemas de Locadora.

**Importante:** Nesta etapa, o foco principal está na **representação em memória** das estruturas de dados e seus relacionamentos utilizando objetos e os princípios da POO. Não há implementação de mecanismos complexos de Mapeamento Objeto-Relacional (ORM) ou persistência de dados em um banco de dados real. O esquema do banco de dados é usado como inspiração e base estrutural, adaptado para um bom design orientado a objetos.

---

### Requisitos Funcionais

* **Interface de Usuário:** Interação exclusiva via menu principal em modo texto no terminal (console), com opções numeradas para navegação.
* **Operações CRUD (Parcial):**
    * **Inserir (Create):** Cadastro de novas instâncias das classes principais.
    * **Consultar (Read):** Opções para listar todas as instâncias cadastradas e/ou consultar detalhes de uma instância específica.
    * **Atualizar (Update) e Excluir (Delete):** Opcionais nesta fase, não são requisitos estritos.
* **Persistência de Dados:** **Não há persistência de dados.** Todos os dados existem apenas na memória RAM durante a execução do programa e são perdidos ao encerrar a aplicação. O foco é a lógica de negócio encapsulada nos objetos.
* **Tratamento de Erros:** Validações básicas para entrada de dados do usuário e mensagens claras e informativas em caso de erro, evitando encerramento abrupto.

---

### Requisitos Não Funcionais

* **Linguagem:** Desenvolvido integralmente em **Java**.
* **Classes e Objetos:** Estrutura baseada em classes que modelam entidades e conceitos do domínio, com operações realizadas por meio da criação e manipulação de objetos.
* **Encapsulamento (Obrigatório):** Atributos das classes declarados como `private`, com acesso controlado por métodos `public` (getters, setters ou métodos de negócio).
* **Relacionamentos entre Classes (Obrigatório):** Implementação de, no mínimo, um exemplo claro de **associação** e, adicionalmente, um exemplo claro de **agregação OU composição**.

---

### Entregáveis da Etapa 1

* Todos os arquivos de código-fonte necessários para compilar e executar o projeto, organizados logicamente (e.g., em pacotes ou pastas), preferencialmente no formato de um projeto IntelliJ.

---

## Etapa 2: Evolução, Persistência e POO Avançada

### Objetivos de Aprendizagem

Esta etapa aprofunda os conhecimentos em POO e introduz a persistência de dados. Os objetivos incluem:

* **Polimorfismo:** Aplicar polimorfismo utilizando classes abstratas, interfaces e heranças para código flexível e extensível.
* **Sobrescrita e Sobrecarga:** Demonstrar o uso de sobrescrita (`@Override`) e sobrecarga (`Overload`) de métodos.
* **Organização de Código:** Organizar o código-fonte em **pacotes** para melhor estruturação e separação de responsabilidades.
* **Persistência de Dados:** Implementar a persistência de dados, conectando a aplicação Java a um banco de dados relacional para operações CRUD.
* **Apresentação:** Produzir uma apresentação em vídeo demonstrando o código e a execução do sistema.

### Descrição Geral

Esta fase é uma continuação direta do projeto anterior, com o objetivo de refatorar e evoluir o código para incorporar conceitos avançados de POO e, fundamentalmente, **integrar a aplicação com um banco de dados real**.

---

### Requisitos Funcionais

* **Evolução do Domínio:** Continuação do trabalho sobre o mesmo domínio da Etapa 1.
* **Persistência de Dados com Banco de Dados:**
    * Dados **não mais armazenados apenas em memória**. Todas as operações de Inserir (Create) e Consultar (Read) agora operam sobre um banco de dados relacional.
    * Conexão com o banco de dados implementada utilizando **JDBC (Java Database Connectivity)**.
    * Operações de **Atualizar (Update) e Excluir (Delete)**, que eram opcionais na primeira etapa, são agora **obrigatórias** para, no mínimo, uma das entidades principais do sistema.
* **Interface com o Usuário:** A interface pode permanecer em modo texto no terminal, mas deve ser adaptada para suportar as novas funcionalidades (Update e Delete).

---

### Requisitos Não Funcionais

* **Organização em Pacotes (Obrigatório):** Código-fonte organizado em pacotes para separar responsabilidades. Recomenda-se uma estrutura como:
    * `br.edu.ifsc.modelo`: para as classes de domínio (entidades).
    * `br.edu.ifsc.persistencia`: para as classes responsáveis pelo acesso aos dados (DAO - Data Access Object).
    * `br.edu.ifsc.visao`: para a classe que contém a interface com o usuário (menu de texto).
    * `br.edu.ifsc.controle`: para classes que orquestram a lógica do sistema.
* **Herança (Obrigatório):** O projeto deve conter, no mínimo, **uma hierarquia de herança** bem justificada (ex: `Pessoa` com `Aluno` e `Funcionario`).
* **Classes e Métodos Abstratos (Obrigatório):** Uso de, no mínimo, **uma classe abstrata** com ao menos **um método abstrato**, justificando sua existência dentro de uma hierarquia de herança.
* **Interfaces (Obrigatório):** Uso de, no mínimo, **três interfaces** que definam contratos (conjuntos de métodos) implementados por uma ou mais classes (ex: `Autenticavel` com método `login()`).
* **Polimorfismo (Obrigatório):** Polimorfismo claramente demonstrado (ex: listar diferentes tipos de objetos, como `Aluno` e `Funcionario`, tratados genericamente por sua superclasse `Pessoa`).
* **Sobrescrita e Sobrecarga de Métodos (Obrigatório):** Exemplos claros e justificados de:
    * **Sobrescrita (`@Override`):** Métodos da superclasse especializados nas subclasses.
    * **Sobrecarga (`Overloading`):** Múltiplos construtores ou métodos com o mesmo nome, mas assinaturas diferentes, dentro da mesma classe.

---

### Entregáveis da Etapa 2

* **Código-Fonte:** Um único arquivo compactado (.zip) contendo todo o projeto Java, incluindo os arquivos-fonte organizados em pacotes e quaisquer scripts SQL necessários para a criação das tabelas no banco de dados.
* **Vídeo de Apresentação:**
    * Vídeo de, no máximo, **30 minutos**, publicado no YouTube como **"Não Listado" (Unlisted)**.
    * O vídeo deve:
        * **Apresentar o Código:** Explicar decisões de design e como os requisitos (herança, interfaces, pacotes, conexão com BD, etc.) foram implementados.
        * **Executar o Sistema:** Demonstrar todas as funcionalidades do sistema (CRUD completo) em execução.
    * O link do vídeo do YouTube deve ser submetido em um arquivo de texto (.txt) junto com o arquivo `.zip` do projeto.

---