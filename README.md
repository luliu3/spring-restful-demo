# spring-restful-demo
spring4+mybatis+mysql

# Requirements

- Spring 4.3.2.RELEASE
- Maven 3
- Tomcat 9
- Servlet 3
- [Postman](http://www.getpostman.com/) (optional): to build POST/PUT/DELETE request

# Installation

- Git clone https://github.com/luliu3/Spring4-REST-demo
- Use Maven build and package it
- Deploy RESTDemo.war to your Tomcat webapp directory `your_tomcat_dir/Tomcat 9.0/webapps`

# Usage

# 1. JDBC

## Paste the following link into your browser

- GET:  `http://localhost:8080/rest/jdbc/user`
- GET:  `http://localhost:8080/rest/jdbc/user/1`

## Use Postman to do following test

- POST: `http://localhost:8080/rest/jdbc/user/new`
with body
```
{

    "id": 100,
    "firstName": "lu",
    "lastName": "liu",
    "email": "luliu3@iflytek.com",
    "mobile": "131-0000-0000"

}
```
- PUT: `http://localhost:8080/rest/jdbc/user/update/100`
with body
```
{

    "id": 100,
    "firstName": "lu1",
    "lastName": "liu1",
    "email": "luliu1@iflytek.com",
    "mobile": "131-1111-1111"

}
```
- DEL: `http://localhost:8080/rest/jdbc/user/delete/100`

# 2. mybatis

## Paste the following link into your browser

- GET:  `http://localhost:8080/rest/mybatis/user`
- GET:  `http://localhost:8080/rest/mybatis/user/1`

## Use Postman to do following test

- POST: `http://localhost:8080/rest/mybatis/user/new`
with body
```
{

    "id": 100,
    "firstName": "lu",
    "lastName": "liu",
    "email": "luliu3@iflytek.com",
    "mobile": "131-0000-0000"

}
```
- PUT: `http://localhost:8080/rest/mybatis/user/update/100`
with body
```
{

    "id": 100,
    "firstName": "lu1",
    "lastName": "liu1",
    "email": "luliu1@iflytek.com",
    "mobile": "131-1111-1111"

}
```
- DEL: `http://localhost:8080/rest/mybatis/user/delete/100`