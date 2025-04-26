# Sistema de Gerenciamento de Produtos

## Descrição

API REST para gerenciamento de produtos desenvolvida com Spring Boot.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Maven

## Endpoints da API

- GET /api/produtos - Lista todos os produtos
- GET /api/produtos/{id} - Busca um produto por ID
- POST /api/produtos - Cria um novo produto
- PUT /api/produtos/{id} - Atualiza um produto
- DELETE /api/produtos/{id} - Remove um produto

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/exemplo/api/
│   │       ├── controller/
│   │       ├── model/
│   │       ├── repository/
│   │       └── service/
│   └── resources/
└── test/
```
