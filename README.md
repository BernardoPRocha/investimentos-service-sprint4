# 📊 Investimentos Service (Sprint 4)

Projeto da Sprint 4 - Arquitetura Orientada a Serviços e Web Services.

## LINK DO GITHUB 
- Acesse: `https://github.com/BernardoPRocha/investimentos-service-sprint4.git`

## 📌 Integrantes do Grupo
1. Bernardo Pinto Rocha - RM99209  
2. Gabriel Diegues - RM550788  
3. Luiza Cristina - RM99367  
4. Pedro Palladino - RM551180  
5. Renato Izumi - RM99242

   
## 🚀 Funcionalidades
- Cadastro e listagem de clientes.
- Validações de entrada.
- API REST com camadas (Controller, Service, Repository).
- Banco de dados em memória (H2).
- Documentação automática com Swagger.

## 🛠️ Tecnologias
- Java 21
- Spring Boot 3
- Spring Data JPA
- Spring Security + JWT (JSON Web Token)
- SpringDoc 
- H2 Database
- Swagger/OpenAPI
- Lombok
- JUnit 5 + Mockito

## 🔐 Autenticação e Segurança

- Autenticação **stateless** com `SessionCreationPolicy.STATELESS`.
- Geração e validação de tokens via **`JwtUtil`**.
- Filtro JWT implementado em **`JwtAuthenticationFilter`**.
- Senhas criptografadas com **BCryptPasswordEncoder**.
- Usuários carregados pelo **CustomUserDetailsService**.
- Permissões liberadas para rotas públicas:
    - `/auth/**`
    - `/swagger-ui/**`
    - `/v3/api-docs/**`
    - `/h2-console/**`


## Estrutura do Projeto 
<img width="515" height="1006" alt="image" src="https://github.com/user-attachments/assets/afd90bd8-4b9c-4210-a251-cf2d57584608" />


## ▶️ Como Executar
```bash
mvn spring-boot:run
```

## APERTE NA SETA VERDE 

<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/f7a6ed84-6b02-404a-b819-033ede8d91ad" />

Acesse:
- API: `http://localhost:8080/h2-console/login.jsp`
- Swagger: `http://localhost:8080/swagger-ui/index.html`

## 📌 Exemplos

## Login H2-Console
<img width="511" height="367" alt="image" src="https://github.com/user-attachments/assets/0d702fc6-ad6c-4262-aa20-45a52408d800" /> 

<img width="911" height="378" alt="image" src="https://github.com/user-attachments/assets/badfc29c-1adf-4d89-bc41-f90d1fcc4737" />

## POST 
<img width="1419" height="938" alt="image" src="https://github.com/user-attachments/assets/7508fd2a-0dc8-49c8-8ddc-b031f7c18e56" />

## GET
<img width="1448" height="802" alt="image" src="https://github.com/user-attachments/assets/e1ad1758-3c26-47ab-ad93-a5c27a4fc954" />

## PUT
<img width="1417" height="967" alt="image" src="https://github.com/user-attachments/assets/ed9def4f-b74c-47d8-b0a4-e3df22e930a0" />

<img width="1434" height="812" alt="image" src="https://github.com/user-attachments/assets/f8703419-bddd-4af8-9530-8508b65150dc" />

## DELETE
<img width="1418" height="761" alt="image" src="https://github.com/user-attachments/assets/7c03c2c2-e6eb-4624-a182-436129ed3333" />

<img width="910" height="370" alt="image" src="https://github.com/user-attachments/assets/f01036de-fb5a-4c26-8b95-86bdca3a254f" />


---

<img width="1484" height="894" alt="image" src="https://github.com/user-attachments/assets/c19d95c4-a5d9-44c4-a28b-d53c50c972e7" />



---

# Sprint 4 — Autenticação & Segurança (adicionados)
Este repositório foi atualizado para Sprint 4: adicionamos autenticação JWT stateless, criptografia de senhas com BCrypt, filtros de requisição, documentação OpenAPI aprimorada e testes de integração/unitários.

## Endpoints novos/importantes
- `POST /auth/register` — registra usuário (body: `{ "username": "user", "password": "senha" }`)
- `POST /auth/login` — autentica e retorna `{ "token": "..." }`
- `GET /clientes` — endpoint protegido (exige header `Authorization: Bearer <token>`)
- `POST /investimentos/avaliar` — avalia investimento por perfil (CONSERVADOR/ARROJADO)


## Como usar (exemplos)
Registrar:
```bash
curl -X POST http://localhost:8080/auth/register -H "Content-Type: application/json" -d '{"username":"user1","password":"senha123"}'
```

Login:
```bash
curl -X POST http://localhost:8080/auth/login -H "Content-Type: application/json" -d '{"username":"user1","password":"senha123"}'
# resposta: {"token":"<JWT_TOKEN>"}
```

Acessar endpoint protegido:
```bash
curl -H "Authorization: Bearer <JWT_TOKEN>" http://localhost:8080/clientes
```

Avaliar investimento:
```bash
curl -X POST http://localhost:8080/investimentos/avaliar -H "Content-Type: application/json" -d '{"valor":10000,"anos":2,"perfil":"ARROJADO"}'
```

## Testes
Executar todos os testes:
```bash
mvn test
```

