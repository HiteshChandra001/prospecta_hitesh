# 1. Coding Challenge

## *Tech stacks:*
Spring boot, MySql, Maven.

## *Database Credentials:*
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver<br/>
spring.datasource.url=jdbc:mysql://localhost/clientdb <br/>
spring.datasource.username=root <br/>
spring.datasource.password=root <br/>
Default Port: 8080 <br/>


## *APIs:*
### i.    Get/client/category:cat  <br/>
an API that lists the title, description based on the category passed as an input
parameter

### ii.   Get/client/entries  <br/>
an API that would save a new entry with all the relevant properties which
retrieves values from the endpoint GET /entries

When creating or consuming an API to ensure it is secure and reliable, there are several key considerations: <br/>
Authentication and Authorization <br/>
Error Handling <br/>
Documentation and API Contracts <br/>


# 2. CSV Challenge

### i.  First I thought about data structure, where I can store calculated data (hashmap), after then methods to calculate (extract value and cell address from input ) the result   <br>
### ii. type of errors wrong input as invalid cell and invalid value  <br>
### ii. user can break the code my giving the wrong cell address whose value is not calculated and by giving the wrong number value.  <be>
### limitation : only working with + operator for now.



