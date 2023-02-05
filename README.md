# Spring Boot with JPA

## What's available in this repo?
* Rest APIs
* Three layers
* Define 1-to-1 relationship 
* Define 1-to-many relationship
* Define many-to-many relationship
* Create Indexes
* Create unique key constraints

## Entity Relationship Diagram
![alt text](https://github.com/nadisha/spring-boot-with-jpa/blob/main/ERD.jpg?raw=true)


## APIs 
[Postman Collection](https://github.com/nadisha/spring-boot-with-jpa/blob/main/postman_collection.json)
### Save a student with books
```
curl --location --request POST 'http://localhost:8080/v1/students' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "Simon",
    "lastName": "Sinek",
    "email": "simon.sinek@gmail.com",
    "age": 55,
    "books": [
        {
            "bookName": "Introduction To JAVA"
        },
        {
            "bookName": "Angular for Dummies"   
        }
    ]
}'
```
### Get all students excluding books
```
curl --location --request GET 'http://localhost:8080/v1/students'
```
### Get all students by age (greater than or equal) (excluding books)
```
curl --location --request GET 'http://localhost:8080/v1/students?age=20'
```
### Save a book and assign to a student
```
curl --location --request POST 'http://localhost:8080/v1/books' \
--header 'Content-Type: application/json' \
--data-raw '{
    "bookName": "HTML in 24 Hours",
    "student": {
        "id": 1
    }
}'
```
### Create a student card id for a student
```
curl --location --request POST 'http://localhost:8080/v1/students/1/student-id-card' \
--header 'Content-Type: application/json' \
--data-raw '{
    "cardNumber": "123-456-7890"
}'
```
### Get a student detail with associated books and student card id.
```
curl --location --request GET 'http://localhost:8080/v1/students/1'
```
### Save a new course
```
curl --location --request POST 'http://localhost:8080/v1/courses' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Spring Boot with JPA",
    "department": "IT"
}'
```
### Get all courses
```
curl --location --request GET 'http://localhost:8080/v1/courses'
```
### Get course by course name
```
curl --location --request GET 'http://localhost:8080/v1/courses?name=JAVA'
```
### Create a new enrolment
```
curl --location --request POST 'http://localhost:8080/v1/enrolments' \
--header 'Content-Type: application/json' \
--data-raw '{
    "studentId": 1,
    "courseId": 1
}'
```
### Get enrolments by course
```
curl --location --request GET 'http://localhost:8080/v1/enrolments/courses/1'
```
### Get enrolments by student
```
curl --location --request GET 'http://localhost:8080/v1/enrolments/students/1'
```
