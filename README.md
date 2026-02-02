# API DEMO

<p>Estudo de API REST com operações de CRUD utilizando Java e Spring Boot.</p>
<br>

## Apresentação

<p>Olá, tudo bem? Meu nome é Patrick e eu sou um desenvolvedor back-end Java no início da carreira.</p>

<p>No momento, estou estudando APIs REST com operações CRUD e integração com banco de dados utilizando JPA.</p>

<p>Em caso de qualquer dúvida, sugestão ou correção, por favor entre em contato comigo pelo LinkedIn. Todo
 tipo de comentário será muito bem-vindo.</p>
<br>

## Tecnologias usadas

- Sistema: Windows 11
- VS Code: 1.108.2
- Java: 21.0.9
- Maven: 3.9.11
- PostgreSQL: 18.1
- Spring Boot: 4.0.0
- Spring JPA (Hibernate)
- Spring Web
- Spring MVC
<br>

## Requisitos de funcionamento

<p>Para conseguir fazer uso da API é necessário que o usuário faça algumas configurações.</p>

1. Criar banco PostgreSQL;
2. Preencher os dados de configurações do banco no application-prod.properties;
3. Definir as configurações do JPA, Hibernate e logs no application-prod.properties. 
<br>

<p>OBS.: É possível utilizar outros profiles de configuração alterando o spring.profiles.active.</p>
<br>

## Funcionalidades

- GET /api/users: Retorna lista com todos os usuários salvos.
- GET /api/users/{id}: Retorna o usuário com ID indicado.
- POST /api/users: Salva usuário.
- PUT /api/users/{id}: Atualiza usuário.
- DELETE /api/users/{id}: Deleta usuário.
<br>

## Documentação
  
### Tabela de requisitos funcionais e não funcionais
![Requisitos](documents/requisitos.png)
<br>

### Diagrama de casos de uso
![diagrama de casos de uso](documents/casos_uso.png)
<br>

### Diagrama de camadas
![diagrama de camadas](documents/camadas.png)
<br>

## Objetivos futuros

<p>Como esse projeto tem o propósito de estudos, optei por fazer sua evolução aos poucos com atualizações constantes, 
com esse tópico servindo como um checklist guia para modificações futuras.</p>

- Implementar Spring JPA ✅
- Integrar banco de dados PostgreSQL ✅
- Implementar Spring Security
- Implementar Swagger
<br>

## Dados do projeto

- Autor: Patrick Silva
- Versão: 1.1
- Última atualização: 02/02/2026
- Contato: www.linkedin.com/in/patrick-rocha-149244289
<br>

## Notas de atualização - versão 1.1
- Mudança dos DTOs do pacote model para o pacote dto.
- Implementação do Spring JPA com o banco PostgreSQL.
- Armazenamento de dados sensíveis em arquivo de configurações local.
- Alterações no README.
<br>
 