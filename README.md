# Expenses API (Test problem for Intelliarts)

Personal expenses management application that allows users to track how much money have they spent. 

## Requirements
- [JDK 14](https://jdk.java.net/14/)
- [Maven 3.6.3](https://maven.apache.org/download.cgi)
- [PostgreSQL 2.4.1](https://postgresapp.com/downloads.html)

In Postgres start server and:
```sql
CREATE DATABASE expensesdb;
```
Open application.properties in:
```bas
 expenses-api/src/main/resources/application.properties 
```
and edit this lines of code(mark as '???') for you:
```java
spring.datasource.url=jdbc:postgresql://localhost:5432/expensesdb
spring.datasource.username=???
spring.datasource.password=???
```
## Build and run project

Clone the repository:
```bash
git clone https://github.com/YuriiP1/expenses-api
```
Navigate to the newly created folder:
```bash
cd expenses-api
```
Run the project with:
```bash
./mvnw spring-boot:run
