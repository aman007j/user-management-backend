# User Management Backend - Spring Boot
A RESTful API built with Spring Boot for managing user information. This backend provides endpoints to create and retrieve users with in-memory storage.

## 📁 Project Structure
```
+---.mvn
|   \---wrapper
|           maven-wrapper.properties
|           
+---src
|   +---main
|   |   +---java
|   |   |   \---com
|   |   |       \---atomtech
|   |   |           \---usermanagement
|   |   |               |   UsermanagementApplication.java
|   |   |               |   
|   |   |               +---controller
|   |   |               |       UserController.java
|   |   |               |       
|   |   |               +---dto
|   |   |               |       UserRequest.java
|   |   |               |       
|   |   |               +---entities
|   |   |               |       User.java
|   |   |               |       
|   |   |               \---service
|   |   |                       UserService.java
|   |   |                       
|   |   \---resources
|   |       |   application.properties
|   |       |   
|   |       +---static
|   |       \---templates
|   \---test
|       \---java
|           \---com
|               \---atomtech
|                   \---usermanagement
|                           UsermanagementApplicationTests.java
```

## 🚀 Prerequisites

Java 17 or higher
Maven 3.6+
IDE (IntelliJ IDEA, Eclipse, or VS Code with Java extensions)

## 🛠️ Setup Instructions
**1. Clone the Repository**
   
   ```
    git clone https://github.com/aman007j/user-management-backend.git
    cd user-management-backend
   ```

**2. Build the Project**

```
mvn clean install
```

**3. Run the Application**
```
mvn spring-boot:run
```

The application will start on http://localhost:8080

## 📡 API Endpoints

### Get All Users
**GET** `/users`

**Response:**
```json
[
  {
    "id": 1,
    "firstName": "Aman",
    "lastName": "Jain"
  },
  {
    "id": 2,
    "firstName": "Kuldeep",
    "lastName": "Verma"
  }
]
```

### Create User
**POST** `/users`

**Request Body:**
```json
{
  "firstName": "Aman",
  "lastName": "Jain"
}
```

**Response:**
```json
{
  "id": 1,
  "firstName": "Aman",
  "lastName": "Jain"
}
```

**Status Codes:**
- `201 Created` - User successfully created
- `400 Bad Request` - Invalid input (missing or empty fields)
- `500 Internal Server Error` - Server error

## 🏗️ Architecture

### Layered Architecture
1. **Controller Layer** (`UserController.java`)
   - Handles HTTP requests and responses
   - Validates incoming data
   - Maps endpoints to service methods

2. **Service Layer** (`UserService.java`)
   - Contains business logic
   - Manages in-memory user storage
   - Uses AtomicLong for thread-safe ID generation

3. **Model Layer** (`User.java`)
   - Defines the User entity structure
   - Contains getters, setters, and constructors

4. **DTO Layer** (`UserRequest.java`)
   - Data Transfer Object for incoming requests
   - Separates external API contract from internal model

## 🔧 Technologies Used

- **Spring Boot 3.2.0** - Framework for building the REST API
- **Spring Web** - For creating RESTful web services
- **Maven** - Dependency management and build tool
- **Java 17** - Programming language

## 💾 Data Storage

This application uses **in-memory storage** (ArrayList) for storing users. Data will be lost when the application restarts. This is intentional as per the assignment requirements.

## 🧪 Testing the API

### Using cURL

**Get all users:**
```bash
curl http://localhost:8080/users
```

**Create a user:**
```bash
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"firstName":"Aman","lastName":"Jain"}'
```

### Using Postman or Thunder Client
Import the following requests:
- GET: `http://localhost:8080/users`
- POST: `http://localhost:8080/users` with JSON body

## 🔍 Code Quality Features

- ✅ Clear separation of concerns (MVC pattern)
- ✅ Meaningful variable and method names (camelCase)
- ✅ Proper Java naming conventions (PascalCase for classes)
- ✅ Input validation in controller
- ✅ CORS enabled for frontend integration
- ✅ Comprehensive comments and documentation
- ✅ Thread-safe ID generation using AtomicLong

## 🚧 Future Enhancements

- Add database persistence (H2, PostgreSQL, MySQL)
- Implement update and delete operations
- Add pagination for large datasets
- Implement proper exception handling with custom exceptions
- Add unit and integration tests
- Add validation annotations (@Valid, @NotBlank)
- Implement logging with SLF4J

## 📝 Notes

- CORS is enabled for all origins (`@CrossOrigin(origins = "*")`) to allow frontend access
- Server runs on port 8080 by default (configurable in application.properties)
- All users are stored in memory and reset on application restart
