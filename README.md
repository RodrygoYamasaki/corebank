# 🏦 CoreBank

Este projeto é uma API REST desenvolvida com Spring Boot para simular as funcionalidades de um banco digital. Ela permite o gerenciamento de contas bancárias, incluindo cadastro, consulta e encerramento.

## ⚙️ Funcionalidades

- **Gestão de Contas:** Permite cadastrar novas contas, buscar todas as contas ou filtrar por ID.
- **Transação Financeiras:** Suporta depósitos, saques e transferências por via Pix.
- **Validação de Dados:** Garante a integridade das informações com validações de dados rigorosas, e todos os dados são persistidos em um bando de dados H2.

---

## 🌐 Tecnologias e Dependências

- **Java:** Linguagem principal do projeto.
- **Maven:** Ferramenta de automação de build e gerenciamento de dependências.
- **Insomnia:** Ferramenta de testes de API REST.
- **Spring Web:** Módulo do Spring responsável pela criação de aplicações web, incluindo suporte a RESTful APIs.
- **Spring Boot DevTools:** Ferramenta que facilita o desenvolvimento, oferecendo recursos como reinicialização automática e live reload.
- **Spring Data JPA:** Abstração da persistência de dados que simplifica a implementação de repositórios usando JPA.
- **Lombok:** Biblioteca que gera automaticamente getters, setters, construtores e outros métodos com anotações simples.
- **H2 Database:** Banco de dados relacional em memória, ideal para testes e desenvolvimento local.
- **Validation:** Ferramenta para validar dados de entrada.

---

## 🚀 Como Usar

1. **Clone o repositório:**

   ```bash
   https://github.com/RodrygoYamasaki/corebank.git
   ```

2. **Utilize a IDE de sua escolha (IntelliJ, VS Code, Eclipse, etc.)**
3. **Executar a aplicação:**

   ```bash
   mvn spring-boot:run
   ```
4. **Testar a API: Use o Insomnia para enviar requisições HTTP.**

   ```bash
   GET http://localhost:8080/accounts
   ```

   ```bash
   GET http://localhost:8080/accounts/{id}
   ```

   ```bash
   POST http://localhost:8080/accounts
   ```

   ```bash
   POST http://localhost:8080/bank/deposit
   ```

   ```bash
   POST http://localhost:8080/bank/withdraw
   ```

   ```bash
   POST http://localhost:8080/bank/pix
   ```

   ```bash
   DELETE http://localhost:8080/accounts/{id}
   ```
