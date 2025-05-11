# Carteira

Este é um projeto de exemplo para gerenciar uma aplicação de carteira digital. Ele utiliza **Spring Boot**, **PostgreSQL**, **Flyway** para migração de banco de dados e **Docker** para facilitar o ambiente de desenvolvimento.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.4.5**
    - Spring Data JPA
    - Spring Web
- **PostgreSQL**
- **Flyway** (para migração de banco de dados)
- **Docker** e **Docker Compose**
- **H2 Database** (para testes)
- **Lombok** (para reduzir boilerplate de código)

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas:

- **Java 17**
- **Maven**
- **Docker** e **Docker Compose**

## Configuração do Banco de Dados

O projeto utiliza **PostgreSQL** como banco de dados principal. As configurações estão definidas no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/carteira
spring.datasource.username=user
spring.datasource.password=senhafraca
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

Você pode iniciar o banco de dados localmente usando o Docker Compose:

```bash
docker-compose up -d
```

O serviço será iniciado na porta 5432 com as seguintes credenciais:

- **Usuário**: user  
- **Senha**: senhafraca  
- **Banco de Dados**: carteira  

## Migração de Banco de Dados

O projeto utiliza **Flyway** para gerenciar as migrações do banco de dados. Certifique-se de adicionar os scripts de migração no diretório:

```
src/main/resources/db/migration/
```

As migrações serão aplicadas automaticamente ao iniciar a aplicação.

## Como Executar o Projeto

1. Clone o repositório:

     ```bash
     git clone <URL_DO_REPOSITORIO>
     cd carteira
     ```

2. Inicie o banco de dados com Docker Compose:

     ```bash
     docker-compose up -d
     ```

3. Compile e execute o projeto com Maven:

     ```bash
     ./mvnw spring-boot:run
     ```

A aplicação estará disponível em: [http://localhost:8080](http://localhost:8080)

## Testes

Para executar os testes, utilize o comando:

```bash
./mvnw test
```

## Endpoints da API

Os endpoints da API serão definidos nos controladores localizados no pacote `com.jcbs.carteira`. Certifique-se de implementar os controladores para expor as funcionalidades da aplicação.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

## Licença

Este projeto está licenciado sob a [Licença Apache 2.0](LICENSE).
