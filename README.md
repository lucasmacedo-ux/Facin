# Facin – Fácil Informação

Sistema de gestão acadêmica para cadastro digital e seguro de dados de alunos, desenvolvido para a **Unitins** como parte do Projeto Extensionista Integrador II.

## Identificação do projeto

| Item | Descrição |
|---|---|
| **Projeto** | Facin (Fácil Informação) |
| **Instituição parceira** | Unitins |
| **Disciplina** | Projeto Extensionista Integrador II |
| **Integrante** | Lucas Macedo Leal |

## Problema atendido

Hoje o cadastro dos alunos é feito de forma manual, escrito em papel. Isso torna o processo lento, sujeito a erros de digitação e leitura, difícil de consultar e vulnerável a perda ou extravio de documentos.

## Objetivo da solução

Digitalizar o cadastro de alunos, permitindo que cada aluno registre seus dados pessoais em um sistema web/desktop e que essas informações sejam armazenadas com segurança no banco de dados da instituição, com acesso controlado pelo administrador. O foco é facilitar o cadastro e reduzir o risco de vazamento de dados.

## Funcionalidades

### Planejadas

- [x] Tela de login do administrador
- [x] Tela de cadastro/inserção de dados pessoais do aluno (Incremento I, em teste; campos: dados pessoais, filiação, formação e contato)
- [x] Painel do administrador com listagem, busca por nome, detalhes e exclusão de cadastros
- [x] Validação dos campos (CPF, e-mail, telefone, campos obrigatórios)
- [x] Gravação em banco de dados MySQL
- [x] Senhas armazenadas com hash BCrypt (nunca em texto puro)

### Em desenvolvimento

Incremento I: cadastro de aluno com validação e gravação no banco (em fase de testes).

### Concluídas

_A preencher conforme os incrementos forem entregues._

## Fluxo principal

Ação do usuário → entrada dos dados → processamento e validação → armazenamento no banco → retorno apresentado

## Tecnologias

- **Linguagem:** Java 17
- **Framework:** Spring Boot 3 (Web, Data JPA, Validation, Security)
- **Interface:** HTML com Thymeleaf
- **Banco de dados:** MySQL
- **Controle de versão:** Git e GitHub

## Como executar

Pré-requisitos: JDK 17+, Maven e MySQL em execução.

```bash
# 1. Clonar o repositório
git clone https://github.com/SEU_USUARIO/facin.git
cd facin

# 2. Definir as credenciais do banco (variáveis de ambiente)
export DB_USER=seu_usuario
export DB_PASSWORD=sua_senha

# 2.1 Definir o administrador inicial (criado na primeira execução)
export ADMIN_USER=nome_do_admin
export ADMIN_PASSWORD=senha_do_admin

# 3. Executar
mvn spring-boot:run
```

Depois acesse http://localhost:8080/cadastro (formulário do aluno) ou http://localhost:8080/login (área do administrador).

## Segurança e privacidade

- Não versionar senhas, tokens, chaves de acesso nem dados reais de alunos.
- Configurações sensíveis devem ficar em arquivo local ignorado pelo `.gitignore`.
- Dados de teste devem ser fictícios.

## Status do projeto

🚧 Em desenvolvimento – Incrementos I (cadastro) e II (login e painel do administrador).

## Autor

**Lucas Macedo Leal**
Projeto Extensionista Integrador II – Unitins
