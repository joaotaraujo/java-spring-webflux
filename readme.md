# Projeto para coleção de músicas (WebFlux e DynamoDB/AWS)

Nesta sessão vamos desenvolver uma API de gerenciamento de heróis utilizando Spring WebFlux, utilizada por empresas como Netflix e Pivotal, junto com a library reativa Reactor que atualmente é mantida pela VmWare. Além disso, usaremos o banco DynamoDb localmente para armazenar nossos dados e demonstrarei como realizar testes unitários da sua API com Junit e como gerar documentações simples por meio do Postman e também do Swagger.

# Execução:

**Inicializar o DynamoDB:**
```bash
java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
```

**Checar tabelas:**
```bash
aws dynamodb list-tables --endpoint-url http://localhost:8000
```

**Link para o Swagger / Documentação:**
```bash
http://localhost:8080/swagger-ui.html
```
