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
- [ ] Tela de cadastro/inserção de dados pessoais do aluno
- [ ] Painel do administrador com listagem, busca, edição e exclusão de cadastros
- [ ] Validação dos campos (CPF, e-mail, telefone, campos obrigatórios)
- [ ] Armazenamento seguro em banco de dados
- [ ] Senhas armazenadas com hash (nunca em texto puro)

### Em desenvolvimento

_Nenhuma funcionalidade concluída até o momento._

### Concluídas

_A preencher conforme os incrementos forem entregues._

## Fluxo principal

Ação do usuário → entrada dos dados → processamento e validação → armazenamento no banco → retorno apresentado

## Tecnologias

- **Linguagem:** Java (versão a definir)
- **Banco de dados:** a definir
- **Interface:** a definir
- **Controle de versão:** Git e GitHub

## Como executar

_Será preenchido quando a primeira versão executável estiver pronta._

```bash
# 1. Clonar o repositório
git clone https://github.com/SEU_USUARIO/facin.git
cd facin

# 2. Instruções de compilação e execução (a definir)
```

## Segurança e privacidade

- Não versionar senhas, tokens, chaves de acesso nem dados reais de alunos.
- Configurações sensíveis devem ficar em arquivo local ignorado pelo `.gitignore`.
- Dados de teste devem ser fictícios.

## Status do projeto

🚧 Em fase inicial de planejamento.

## Autor

**Lucas Macedo Leal**
Projeto Extensionista Integrador II – Unitins
