# Implementing Microservices using Spring Boot

This is a sample project to demonstrate how to implement microservices using Spring Boot and give the good practices to build a microservice based on rest or graphql and it manage Bank accounts.

the dependencies used in this project are:

- Spring Web
- Spring Data JPA
- H2 Database
- spring data rest
- spring data graphql
- springdoc-openapi-ui

## How to run the project

- Clone the project
- Run the command `mvn clean install`
- Run the command `mvn spring-boot:run`

## Testing the project

### Testing dao layer:

![Testing dao layer](resources/test_h2.png)  

### Testing using rest client(POSTMAN)

- get all accounts:  
![get all accounts](resources/getaccounts_postman.png)  

- get account by id:  
![get account by id](resources/getaccount_postman.png)  

- create account:  
![create account](resources/save_postman.png)

- update account:
![update account](resources/update_postman.png)  

- delete account:
![delete account](resources/delete_postman.png)

### Generating and Testing Swagger Documentation

- generate swagger documentation:  
![generate swagger documentation](resources/generate_swagger.png)  

- get all accounts:  
![get all accounts](resources/getaccounts_swagger.png)  

- create account:  
![create account](resources/save_swagger.png)  

- update account:  
![update account](resources/update_swagger.png)

- get account by id:  
![get account by id](resources/getaccount_swagger.png)

### Testing projection, dtos, Mappers

- projection, pagination with spring data rest:  
![projection, pagination with spring data rest](resources/data_rest_projections.png)

- dto, mapper account creation:  
![dto, mapper account creation](resources/dto_Mapper_swagger.png)

### Testing graphql

- get all accounts:  
![get all accounts](resources/getaccounts_graphql.png)

- get account by id:  
![get account by id](resources/getaccount_graphql.png)  

- create account:  
![create account](resources/save_graphql.png)  

- relation between account and customer:
![relation between account and customer](resources/cutomers_graphql.png)



