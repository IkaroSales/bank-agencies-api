# Coding Challenge Backend
Bem vindo! Se você está aqui é porque gostamos do seu perfil e queremos conhecer um pouco mais sobre suas habilidades como desenvolvedor.

# Pré-requisitos
* Java 11
* Maven
* Git
* Intellij, Visual Studio Code, Eclipse ou a IDE de sua preferência

# Critérios de avaliação
* Compreensão dos requistos
* Fornecer documentação explicando como rodar e testar localmente
* Engenharia de Software
* Cobertura de Testes
* Versionamento
* Arquitetura do Código
* Separação de Responsabilidades
* Manutenabilidade
* Modelagem de dados (Estruturas de dados utilizadas, etc)

# Swagger
* Projeto contém o Swagger como documentação da API e para teste, basta acessar o endereço abaixo:
```
http://localhost:8080/swagger-ui.html
```

# Sobre o projeto
Esse projeto é uma API REST com SpringBoot, Maven em JAVA 11 usando uma adaptação do modelo 'Clean Architecture'.

O endpoint exposto(/agencies) retorna uma lista com informações de todas as agências da instituição bancária "Banco do Brasil" de toda a extensão nacional.

Dados obtidos através do Portal de Dados do Banco Central do Brasil:
https://dadosabertos.bcb.gov.br/dataset/agencias
