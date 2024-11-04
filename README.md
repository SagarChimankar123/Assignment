# Assignement

### Overview
A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

### Technologies Used
- Spring Boot
- Spring Data JPA
- Mysql db
- RESTful API
- Swagger open api
- Logger
- spring security

### Prerequisites
- Java 17 
- spring boot 3.3.5

### Clone the repository
git clone https://github.com/SagarChimankar123/Assignment

### Build project
mvn clean install

### Configuration .property file
spring.application.name=Assignment
-MySQL Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/assignment
spring.datasource.username=root
spring.datasource.password=Click@12345
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
-JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
-swagger-ui custom path
springdoc.swagger-ui.path=/swagger-ui.html
-security 
spring.security.user.name=sagar
spring.security.user.password=sagar@123
-logger file name 
logging.file.name=Assignment_log.log

