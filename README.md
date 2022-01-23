# SpringJspAppwithApi

Application that uses JSP for FrontEnd, Spring for BackEnd and PostgreSQL for database.
Application uses Spring Security.
Application has its simple API for goods.

STACK OF TECHNOLOGIES

 Backend:        Spring Boot
 Security:       Spring Security
 Infractructure: Maven
 Database:       PostgreSQL
 Frontend:       JSP

USE OF APPLICATION:

1 - Using Frontend
Application give access to its functionality after user was logged in successfully.

LOGIN:mad_dog
PASSWORD:12345

After successful Log in user can watch/add/edit information about goods.
User can log out from the application.

2 - Using the API

An example of request to use the API. 
http://localhost:8080/customer/goods/filter?limit=10&&minPrice=10000&maxPrice=150000&pageNo=1

The goods are filtered by minimum and maximum price.


