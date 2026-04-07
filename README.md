# API de Pessoas

API REST desenvolvida com Spring Boot para gerenciamento de pessoas.

---

## 🚀 Tecnologias utilizadas

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

---

## 📌 Funcionalidades

- Criar pessoa
- Listar pessoas
- Buscar pessoa por ID
- Atualizar pessoa
- Deletar pessoa
- Validação de CPF único

---

## 📊 Estrutura do banco

### Pessoa
- id
- nome
- cpf (único)
- rg
- estado_civil_id (FK)
- grau_instrucao_id (FK)

### Estado Civil
- id
- nome

### Grau de Instrução
- id
- descricao

---

## ▶️ Como rodar o projeto

1. Clone o repositório:

    git clone https://github.com/curciog/pessoas-api.git

2. Abra no IntelliJ

3. Configure o banco de dados no arquivo `application.properties`

4. Execute a aplicação

---

## 🔗 Endpoints

### Criar pessoa
POST /pessoas

Exemplo de body:
{
  "nome": "Gabriel Oliveira",
  "cpf": "12345678900",
  "rg": "1234567",
  "estadoCivilId": 1,
  "grauInstrucaoId": 3
}

---

### Listar pessoas
GET /pessoas

---

### Buscar por ID
GET /pessoas/{id}

---

### Atualizar
PUT /pessoas/{id}

---

### Deletar
DELETE /pessoas/{id}

---

## ⚠️ Regras de negócio

- CPF não pode ser duplicado
- Retorna erro 409 quando CPF já existe

---

## 👨‍💻 Autor

Gabriel Curcio
https://www.linkedin.com/in/curciogabriel/
