# Establishing Springboot connection with MySQL Databases
## Project Overview
This project establishes a connection between Spring Boot and MySQL to manage customer-related data. The database `Cust174` contains the following tables:
- CustomerDetails (CUST_DET)
- CustomerIdentification (CUST_IDENTI)
- CustomerContactInformation (CUST_CONT)
- CustomerProofOfId (CUST_PROOF)

## Technologies Used
- Spring Boot (Spring Data JPA, Spring Web)
- MySQL (Database)
- Postman (API Testing)
- Maven (Dependency Management)
- Java (Backend Development)

## Project Structure
```
Springboot-Mysql-Project/
│-- src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── controller/
│   │   │   ├── entity/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   ├── DemoApplication.java
│   │   ├── resources/
│   │   │   ├── application.properties
│   ├── test/
│-- pom.xml
│-- README.md
```


# API Endpoints

## CustomerDetails (CUST_DET)
| HTTP Method | Endpoint                        | Description                     |
|------------|--------------------------------|---------------------------------|
| GET        | `/api/customers-details`               | Fetch all customers            |
| GET        | `/api/customers-details/{id}`          | Fetch customer by ID           |
| POST       | `/api/customers-details`               | Create a new customer          |
| PUT        | `/api/customers-details/{id}`          | Update an existing customer    |
| DELETE     | `/api/customers-details/{id}`          | Delete a customer              |

## CustomerIdentification (CUST_IDENTI)
| HTTP Method | Endpoint                               | Description                           |
|------------|--------------------------------------|---------------------------------------|
| GET        | `/api/customer-identification`      | Fetch all customer identifications   |
| GET        | `/api/customer-identification/{id}` | Fetch customer identification by ID  |
| POST       | `/api/customer-identification`      | Create a new customer identification |
| PUT        | `/api/customer-identification/{id}` | Update customer identification       |
| DELETE     | `/api/customer-identification/{id}` | Delete customer identification       |

## CustomerContactInformation (CUST_CONT)
| HTTP Method | Endpoint                                 | Description                       |
|------------|----------------------------------------|-----------------------------------|
| GET        | `/api/customer-contact-information`               | Fetch all customer contacts      |
| GET        | `/api/customer-contact-information/{id}`          | Fetch customer contact by ID     |
| POST       | `/api/customer-contact-information`               | Create a new customer contact    |
| PUT        | `/api/customer-contact-information/{id}`          | Update customer contact          |
| DELETE     | `/api/customer-contact-information/{id}`          | Delete customer contact          |

## CustomerProofOfId (CUST_PROOF)
| HTTP Method | Endpoint                           | Description                         |
|------------|----------------------------------|-------------------------------------|
| GET        | `/api/customer-proof-of-id`           | Fetch all customer proofs          |
| GET        | `/api/customer-proof-of-id/{id}`      | Fetch customer proof by ID         |
| POST       | `/api/customer-proof-of-id`           | Create a new customer proof        |
| PUT        | `/api/customer-proof-of-id/{id}`      | Update customer proof              |
| DELETE     | `/api/customer-proof-of-id/{id}`      | Delete customer proof              |

