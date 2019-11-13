# Trust Academy - API

**Trust Academy** é um sistema centralizado para gerenciamento de documentos acadêmicos com segurança via blockchain, e fácil compartilhamento entre instituições.

### Documentação

* [https://api.trustacademy.link/swagger-ui.html](https://api.trustacademy.link/swagger-ui.html#/)

### Integração com AWS Rekognition

1. No dashboard da AWS, crie usuário no serviço IAM com a permissão `AmazonRekognitionFullAccess`
2. Baixe o access key e secret key do usuário
3. Crie um arquivo em ~./aws/credentials se já não tiver e adicione as keys do usuário como no exemplo abaixo:

```
[some_profile_name]
aws_access_key_id = key_vai_aqui
aws_secret_access_key = secret_vai_aqui
```
4. Mude a linh 37 do arquivo `AWSRekognitionGateway` para

```
AWSCredentialsProvider credentialsProvider = new ProfileCredentialsProvider("trustacademy-api-rekognition");
```

### Projetos relacionados

- Trust Academy - landing page
    - [Repositório](https://github.com/fiap-winners/landing-page)
    - [Site](https://trustacademy.link/)
    
- Trust Academy - admin
    - [Repositório](https://github.com/fiap-winners/admin-frontend)
    - [Site](https://admin.trustacademy.link/)

### Guias

Os guias abaixo ilustram como utilizar as tecnologias empregadas nesse projeto

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)