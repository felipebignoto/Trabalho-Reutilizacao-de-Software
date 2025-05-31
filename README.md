# Sistema de Gerenciamento de Produtos e Pedidos

## Descrição

API REST desenvolvida com Spring Boot que demonstra conceitos de reutilização de software através de componentes modulares para gerenciamento de produtos e pedidos.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.1.2
- Spring Data JPA
- H2 Database
- Maven

## Componentes Reutilizáveis

### Camada Common

Componentes utilitários que podem ser reutilizados em qualquer parte do sistema:

- **ApiResponse**: Padronização de respostas da API
- **IdValidator**: Validação genérica de IDs de recursos
- **GlobalExceptionHandler**: Tratamento centralizado de exceções
- **ResourceNotFoundException**: Exceção personalizada para recursos não encontrados

### Entidades

Modelos de dados reutilizáveis:

- **Produto**: Representação de produtos com atributos básicos
- **Pedido**: Gerenciamento de pedidos com cálculo automático de valores

## Endpoints da API

### Produtos

- GET /produtos - Lista todos os produtos
- GET /produtos/{id} - Busca um produto por ID
- POST /produtos - Cria um novo produto
- PUT /produtos/{id} - Atualiza um produto
- DELETE /produtos/{id} - Remove um produto

### Pedidos

- GET /api/pedidos - Lista todos os pedidos
- GET /api/pedidos/{id} - Busca um pedido por ID
- POST /api/pedidos - Cria um novo pedido
- PUT /api/pedidos/{id} - Atualiza um pedido
- DELETE /api/pedidos/{id} - Remove um pedido

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/exemplo/api/
│   │       ├── common/          # Componentes reutilizáveis
│   │       ├── controller/      # Controllers REST
│   │       ├── model/          # Entidades JPA
│   │       ├── repository/     # Interfaces de repositório
│   │       └── service/        # Camada de serviços
│   └── resources/
│       └── application.properties
└── test/
    └── java/                  # Testes unitários
```

## Exemplos de Uso

### Criando um Produto

```json
POST /produtos
{
    "nome": "Produto Teste",
    "preco": 99.99
}
```

### Criando um Pedido

```json
POST /api/pedidos
{
    "cliente": "Cliente Teste",
    "produtos": [
        {"id": 1},
        {"id": 2}
    ]
}
```

## Documentação dos Componentes

Todos os componentes do sistema estão documentados usando JavaDoc, demonstrando:

- Propósito e funcionalidades
- Como podem ser reutilizados
- Exemplos de uso
- Relacionamentos entre componentes
