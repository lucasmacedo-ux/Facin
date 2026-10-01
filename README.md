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

- [ ] Tela de login (aluno e administrador)
- [x] Tela de cadastro/inserção de dados pessoais do aluno (Incremento I, em teste)
- [ ] Painel do administrador com listagem, busca, edição e exclusão de cadastros
- [x] Validação dos campos (CPF, e-mail, telefone, campos obrigatórios)
- [x] Gravação em banco de dados MySQL
- [ ] Senhas armazenadas com hash (nunca em texto puro)

### Em desenvolvimento

Incremento I: cadastro de aluno com validação e gravação no banco (em fase de testes).

### Concluídas

_A preencher conforme os incrementos forem entregues._

## Fluxo principal

Ação do usuário → entrada dos dados → processamento e validação → armazenamento no banco → retorno apresentado

## Tecnologias

- **Linguagem:** Java 17
- **Framework:** Spring Boot 3 (Web, Data JPA, Validation)
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

# 3. Executar
mvn spring-boot:run
```

Depois acesse http://localhost:8080/cadastro.

## Segurança e privacidade

- Não versionar senhas, tokens, chaves de acesso nem dados reais de alunos.
- Configurações sensíveis devem ficar em arquivo local ignorado pelo `.gitignore`.
- Dados de teste devem ser fictícios.

## Status do projeto

🚧 Em desenvolvimento – Incremento I.

## Autor

**Lucas Macedo Leal**
Projeto Extensionista Integrador II – Unitins
