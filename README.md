# Spring Boot JPA Application

A comprehensive Spring Boot application demonstrating the JPA (Java Persistence API) layer with a complete RESTful API.

## Features

- **Spring Boot 3.1.5** with Spring Data JPA
- **H2 Database** for development and testing
- **Entity Models** - User and Product entities with JPA annotations
- **Repository Layer** - Spring Data JPA repositories with custom queries
- **Service Layer** - Business logic with transaction management
- **REST Controllers** - Complete CRUD operations for Users and Products
- **Lombok** - Reduce boilerplate code
- **Comprehensive Logging** - Debug and trace logging enabled

## Project Structure

```
src/main/java/com/example/springbootjpa/
├── entity/
│   ├── User.java           # User entity
│   └── Product.java        # Product entity
├── repository/
│   ├── UserRepository.java
│   └── ProductRepository.java
├── service/
│   ├── UserService.java
│   └── ProductService.java
├── controller/
│   ├── UserController.java
│   └── ProductController.java
└── SpringBootJpaApplication.java
```

## Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+

### Installation

1. Clone the repository:
```bash
git clone https://github.com/karnatakapuvenkat-dot/spring-boot-jpa.git
cd spring-boot-jpa
```

2. Build the project:
```bash
mvn clean build
```

3. Run the application:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### User API

- **Create User**: `POST /api/users`
- **Get User**: `GET /api/users/{id}`
- **Get All Users**: `GET /api/users`
- **Search Users**: `GET /api/users/search?term=<search_term>`
- **Update User**: `PUT /api/users/{id}`
- **Delete User**: `DELETE /api/users/{id}`

### Product API

- **Create Product**: `POST /api/products`
- **Get Product**: `GET /api/products/{id}`
- **Get All Products**: `GET /api/products`
- **Get by Category**: `GET /api/products/category/{category}`
- **Get by Price Range**: `GET /api/products/price-range?minPrice=<min>&maxPrice=<max>`
- **Search Products**: `GET /api/products/search?keyword=<keyword>`
- **Update Product**: `PUT /api/products/{id}`
- **Delete Product**: `DELETE /api/products/{id}`

## Database

The application uses H2 in-memory database by default. You can access the H2 console at:

```
http://localhost:8080/h2-console
```

### Switching to Another Database

To use a different database (MySQL, PostgreSQL, etc.), update `application.properties`:

**For MySQL:**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/springbootjpa
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

**For PostgreSQL:**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/springbootjpa
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.username=postgres
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

Don't forget to add the corresponding driver dependency to `pom.xml`.

## Example Requests

### Create a User
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "phoneNumber": "123-456-7890",
    "address": "123 Main St"
  }'
```

### Create a Product
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Laptop",
    "description": "High-performance laptop",
    "price": 999.99,
    "quantity": 10,
    "category": "Electronics"
  }'
```

## Testing

Run the tests using Maven:

```bash
mvn test
```

## Dependencies

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- H2 Database
- Lombok
- Spring Boot Starter Test

## License

This project is open source and available under the MIT License.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.