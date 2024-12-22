# Desafio de Criptografia

Este repositório é uma implementação do desafio de criptografia proposto no [repositório oficial de desafios da Backend BR](https://github.com/backend-br/desafios/blob/master/cryptography/PROBLEM.md). O objetivo deste desafio é desenvolver uma API que realiza operações de criptografia e descriptografia.

## Como Executar o Projeto

Para executar este projeto, você precisará ter o Docker instalado em sua máquina. Este projeto utiliza o PostgreSQL como banco de dados.

### Passo 1: Baixar a Imagem do PostgreSQL

Execute o seguinte comando para baixar a imagem mais recente do PostgreSQL:

```
docker pull postgres
```
### Passo 2: Criar e Executar o Contêiner do PostgreSQL
Após baixar a imagem, você pode criar um contêiner do PostgreSQL com o seguinte comando:
```


docker run --name postgres-cryptography-challenge -e POSTGRES_PASSWORD=admin -e POSTGRES_DB=postgres_cryptography_challenge -p 5433:5432 -d postgres
--name: Nomeia o contêiner.
-e POSTGRES_PASSWORD=admin: Define a senha do usuário postgres.
-e POSTGRES_DB=postgres_cryptography_challenge: Cria um banco de dados chamado postgres_cryptography_challenge.
-p 5433:5432: Mapeia a porta 5432 do contêiner para a porta 5433 da sua máquina local.
```
### Passo 3: Clonar o Repositório
Clone este repositório para sua máquina local:

```
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio
```
### Passo 4: Configurar o Projeto
Certifique-se de que o arquivo application.properties está configurado corretamente para conectar ao seu banco de dados PostgreSQL. A configuração deve ser semelhante a esta:

```
spring.datasource.url=jdbc:postgresql://localhost:5433/postgres_cryptography_challenge
spring.datasource.username=postgres
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=none
```
### Passo 5: Executar o Projeto
Para executar o projeto, você pode usar o Maven ou o Gradle, dependendo do que estiver configurado no seu projeto. Exemplo usando Maven:

bash
Copy code
./mvnw spring-boot:run
Melhorias Futuras
Adicionar Logs: Implementar uma estratégia de logging para monitorar as operações da aplicação e facilitar a depuração.
Implementar Migrations: Utilizar ferramentas como Flyway ou Liquibase para gerenciar as migrações do banco de dados.
Implementar Testes Unitários Restantes: Criar testes unitários para garantir que todas as funcionalidades estejam funcionando conforme o esperado e para facilitar a manutenção do código.
Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou pull request.

Licença
Este projeto está sob a licença MIT.
