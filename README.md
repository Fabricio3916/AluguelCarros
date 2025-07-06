# 🚗 Sistema de Aluguel de Carros

Este é um projeto Java desenvolvido com **Spring Boot**, que demonstra um sistema simples de aluguel de carros, utilizando as tecnologias **JPA/Hibernate**, banco de dados **H2** (em memória) e **Thymeleaf** para renderização de páginas HTML.

O sistema implementa um CRUD básico com duas entidades principais:

- **Cliente**: Representa os clientes cadastrados.
- **Carro**: Representa os carros disponíveis para aluguel.

---

## 📋 Funcionalidades

- ✅ Cadastro de clientes
- ✅ Cadastro de carros
- ✅ Associação entre clientes e carros alugados
- ✅ Listagem de clientes e carros
- ✅ Edição de registros
- ✅ Exclusão de registros
- ✅ Interface web simples com **Thymeleaf**

---

## 🏷️ Modelagem das Entidades

### Cliente

- **id**: Identificador único
- **nome**: Nome do cliente
- **telefone**: Telefone de contato
- **dataCriacao**: Data de cadastro
- **carrosAlugados**: Lista de carros alugados pelo cliente

### Carro

- **id**: Identificador único
- **marca**: Enum de marcas de carros
- **modelo**: Modelo do carro
- **placa**: Placa do carro
- **cor**: Cor do carro
- **status**: Enum de status (ex.: DISPONÍVEL, ALUGADO)
- **dataAlocacao**: Data de início do aluguel
- **cliente**: Cliente que alugou o carro (relacionamento ManyToOne)

---

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA (Hibernate)**
- **H2 Database (In-Memory)**
- **Thymeleaf**
- **Lombok**

---

## 🚀 Como Executar o Projeto

```bash
# Clone o repositório
git clone https://github.com/Fabricio3916/AluguelDeCarros.git

# Acesse o diretório do projeto
cd seu-repositorio

# Execute o projeto (via Maven)
./mvnw spring-boot:run
```

> A aplicação estará disponível em: [http://localhost:8080](http://localhost:8080)

---

## 🎨 Interface

A aplicação possui controllers especificos para serem usados com Thymeleaf(WIP) que futuramente serão modificados para integrar React ou Angular

---

## 💄 Banco de Dados H2

Após executar o projeto, você pode acessar o console do banco H2:

- **URL:** `jdbc:h2:file:./data/AluguelDB`
- **Usuário:** `admin`
- **Senha:** (deixe em branco)

Acesse: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

---

## 💡 Possíveis Melhorias Futuras

- Validações de formulários
- Upload de imagens dos carros
- Paginação de listagens
- Autenticação de usuários (Spring Security)
- FrontEnd 

---

## 📝 Licença

Este projeto está sob a licença MIT.\
Sinta-se à vontade para usar e modificar!

