# 🧩 API de Vendas

API REST desenvolvida em **Java + Spring Boot**, com persistência em **SQLite**, projetada para gerenciar **produtos** e **pessoas (clientes e fornecedores)**.  
O projeto foi criado com foco em **boas práticas de arquitetura**, **facilidade de integração** e **baixo acoplamento**, servindo como backend para uma aplicação React.

---

## 🚀 Tecnologias Utilizadas

![Java](https://img.shields.io/badge/Java-17-red?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0-brightgreen?style=for-the-badge&logo=springboot)
![SQLite](https://img.shields.io/badge/SQLite-DB-blue?style=for-the-badge&logo=sqlite)
![Maven](https://img.shields.io/badge/Maven-Build-orange?style=for-the-badge&logo=apachemaven)
![Lombok](https://img.shields.io/badge/Lombok-Annotation-yellow?style=for-the-badge)

---

## 🧱 Estrutura da Aplicação
```
src/
├── main/
│ ├── java/com/vendas/api/
│ │ ├── controller/ # Endpoints REST
│ │ ├── model/ # Entidades JPA
│ │ ├── repository/ # Repositórios de dados
│ │ ├── service/ # Regras de negócio
│ │ └── SpringbootApplication.java
│ └── resources/
│ ├── application.properties
│ └── db/
│ └── meu_banco_de_dados.db (SQLite)
└── test/
└── ...
```
---
## 🔗 Endpoints da API
### 👤 Pessoas (/pessoas)
| Método     | Endpoint              | Descrição                            |
| :--------- | :-------------------- | :----------------------------------- |
| **GET**    | `/pessoas`            | Retorna todas as pessoas cadastradas |
| **POST**   | `/pessoas`            | Cadastra uma nova pessoa             |
| **POST**   | `/pessoas/salvarlote` | Cadastra uma lista de pessoas        |
| **PUT**    | `/pessoas/{id}`       | Atualiza os dados de uma pessoa      |
| **DELETE** | `/pessoas/{id}`       | Remove uma pessoa pelo ID            |


### 🧾 Exemplo de Pessoa (JSON)
```JSON
{
  "nome": "Cliente 1",
  "doc": "12345678900",
  "type": "Cliente",
  "email": "cliente1@email.com"
}
```
---
### 📦 Produtos (/produtos)

| Método     | Endpoint                | Descrição                             |
| :--------- | :---------------------- | :------------------------------------ |
| **GET**    | `/produtos`             | Retorna todos os produtos cadastrados |
| **GET**    | `/produtos/{id}`        | Retorna um produto específico         |
| **POST**   | `/produtos`             | Cadastra um novo produto              |
| **POST**   | `/produtos/salvarlista` | Cadastra vários produtos de uma vez   |
| **PUT**    | `/produtos/{id}`        | Atualiza os dados de um produto       |
| **DELETE** | `/produtos/{id}`        | Remove um produto pelo ID             |

### 🧾 Exemplo de Produto (JSON)

```JSON
{
  "nome": "Monitor LG Ultrawide 29”",
  "descricao": "Tela ultrawide Full HD ideal para produtividade",
  "quantidade": 8,
  "preco": 1249.99,
  "status": "disponível",
  "imagem": null
}
```







