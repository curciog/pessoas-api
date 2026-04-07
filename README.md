# API de Pessoas

API REST desenvolvida com Spring Boot para gerenciamento de pessoas.

---

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- JUnit (testes)

---

## Funcionalidades

- Criar pessoa
- Listar pessoas
- Buscar pessoa por ID
- Atualizar pessoa
- Deletar pessoa
- Validação de CPF único

---

## Estrutura do banco

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

## Relacionamentos

- Uma pessoa possui **um estado civil**
- Uma pessoa possui **um grau de instrução**
- Várias pessoas podem ter o mesmo estado civil
- Várias pessoas podem ter o mesmo grau de instrução

---

## ▶️ Como rodar o projeto

1. Clone o repositório:

```bash
git clone https://github.com/curciog/pessoas-api.git
```

2. Abra o projeto no IntelliJ

3. Configure o banco de dados no arquivo:

`src/main/resources/application.properties`

Exemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/api_db
spring.datasource.username=root
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

4. Execute a aplicação

---

## Endpoints

### Criar pessoa
POST /pessoas

Exemplo de body:
```json
{
  "nome": "Gabriel Oliveira",
  "cpf": "12345678900",
  "rg": "1234567",
  "estadoCivilId": 1,
  "grauInstrucaoId": 3
}
```

---

### Listar pessoas
GET /pessoas

---

### Buscar por ID
GET /pessoas/{id}

---

### Atualizar pessoa
PUT /pessoas/{id}

---

### Deletar pessoa
DELETE /pessoas/{id}

---

## Regras de negócio

- CPF não pode ser duplicado
- Retorna erro **409 (Conflict)** quando CPF já existe

---

## Testes

O projeto possui testes automatizados utilizando JUnit para validar:

- Criação de pessoa com sucesso
- Bloqueio de CPF duplicado
- Listagem de pessoas

---

## Demonstração

### Criando uma pessoa (POST)
<img width="1919" height="1079" alt="Screenshot_1" src="https://github.com/user-attachments/assets/bac8f0ec-f7ce-4b7f-a6d4-1f89a6313c24" />


---

### Listando pessoas (GET)
<img width="1919" height="1079" alt="getPostman" src="https://github.com/user-attachments/assets/95502678-be70-41c4-8ccd-c8a3e29130e4" />


---

### Testes passando no IntelliJ
<img width="1919" height="1079" alt="testeJUnit" src="https://github.com/user-attachments/assets/d2f7a2fc-9222-4f2a-af86-b8a9b268fb09" />


---

## 👨‍💻 Autor

Gabriel Curcio  
https://www.linkedin.com/in/curciogabriel/
