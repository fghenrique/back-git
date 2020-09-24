# CONSUMIR - GIT

Projeto de api para integração com o git

# Projeto

Projeto desenvolvido em `Java` sobre o `Spring Boot Framework`, com padrão
de comunicação `REST`. O projeto possui um embbeded do `Tomcat` para
proporcionar a execução em modo standalone do `.jar` ( visualizar os passos para a execução 
nos próximos tópicos )

## Implementação

- É possível incluir o `Api_Git.jar` diretamente em um container Web (`Tomcat`)

## Roteiro
Está aplicação é responsável por todo processamento.

Ela faz a consulta na API do Git através do método list, e também faz o CRUD do cadastro do usuário por ORM utilizando framework de persistência.

Também consome a API do GitHub, tendo como critério para buscar os 500 programadores que tenham mais de 50 repos e mais de 100 followers

Exemplos: 
https://api.github.com/search/users?q=repos:>50+followers:>100&page=1
