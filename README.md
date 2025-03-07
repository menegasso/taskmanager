# Task Manager - Clean Architecture

## Overview
This project implements a **Task Manager** following the principles of **Clean Architecture**. The goal is to maintain organized, decoupled, and easy-to-maintain code.

## Architecture
The application is structured in layers, each with a specific responsibility:

- **Domain:** Contains the core business entities and repository interfaces.
- **Application:** Implements the use cases, converting data and orchestrating business logic.
- **Infrastructure:** Handles data persistence, configurations, and interactions with external technologies.
- **Interfaces:** Defines the REST API endpoints and other ways to interact with the system.

### Project Structure
```plaintext
task-manager/
├── src/main/java/com/example/taskmanager
│   ├── domain
│   │   ├── entity
│   │   │   └── Task.java
│   │   └── repository
│   │       └── TaskRepository.java
│   ├── application
│   │   ├── dto
│   │   │   └── TaskDTO.java
│   │   └── service
│   │       └── TaskService.java
│   ├── infrastructure
│   │   ├── persistence
│   │   │   ├── TaskEntity.java
│   │   │   ├── TaskRepositoryImpl.java
│   │   │   └── SpringTaskRepository.java
│   │   └── configuration
│   │       └── PersistenceConfig.java
│   └── interfaces
│       └── rest
│           └── TaskController.java
└── pom.xml
```

## Technologies Used
- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database** (for development/testing environment)
- **Maven**

## Setup and Execution
### Prerequisites
Make sure you have installed:
- [JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)

### Steps to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/task-manager.git
   ```
2. Navigate to the project directory:
   ```bash
   cd task-manager
   ```
3. Compile and run the application:
   ```bash
   mvn spring-boot:run
   ```
4. The API will be available at:
   ```
   http://localhost:8080
   ```

## API Endpoints
The REST API exposes the following endpoints:

### Create a new task
```http
POST /tasks
```
**Example Payload:**
```json
{
  "title": "New Task",
  "description": "Task description",
  "status": "PENDING"
}
```

### Get all tasks
```http
GET /tasks
```

### Get a task by ID
```http
GET /tasks/{id}
```

### Update a task
```http
PUT /tasks/{id}
```
**Example Payload:**
```json
{
  "title": "Updated Task",
  "description": "Updated description",
  "status": "COMPLETED"
}
```

### Delete a task
```http
DELETE /tasks/{id}
```

## Contribution
If you want to contribute to the project:
1. **Fork** the repository.
2. Create a **branch** for your feature (`git checkout -b feature-new`).
3. Make the changes and commit (`git commit -m 'Add new feature'`).
4. Push your changes (`git push origin feature-new`).
5. Open a **Pull Request**.

## License
This project is distributed under the MIT license. See the `LICENSE` file for more details.

