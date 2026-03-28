# Streakify

## Project Overview

Streakify is a habit-tracking backend system designed to help users build consistent habits through streak tracking and productivity insights.

This project implements the **Version 1.0 MVP backend** using **Spring Boot REST APIs** and **PostgreSQL**.

---

## Features

Users can:

- Register and manage accounts
- Create and manage habits
- Log daily habit progress
- Track habit streaks (current & longest)
- View productivity analytics through a dashboard
- Handle errors with global exception handling

---

## System Architecture

The application follows **Layered Architecture**:
# Streakify

## Project Overview

Streakify is a habit-tracking backend system designed to help users build consistent habits through streak tracking and productivity insights.

This project implements the **Version 1.0 MVP backend** using **Spring Boot REST APIs** and **PostgreSQL**.

---

## Features

Users can:

- Register and manage accounts
- Create and manage habits
- Log daily habit progress
- Track habit streaks (current & longest)
- View productivity analytics through a dashboard
- Handle errors with global exception handling

---

## System Architecture

The application follows **Layered Architecture**:
```
Controller Layer
     ↓
Service Layer
     ↓
Repository Layer
     ↓
Database (PostgreSQL)
```

---

## Layers Description

| Layer      | Responsibility                      |
| ---------- | ---------------------------------- |
| Controller | Handles HTTP requests and responses |
| Service    | Contains business logic             |
| Repository | Handles database operations         |
| Database   | Stores application data             |

---

## Technology Stack

| Technology     | Purpose           |
| -------------- | ----------------- |
| Java 21        | Programming Language |
| Spring Boot    | Backend Framework |
| Spring Data JPA| ORM               |
| PostgreSQL     | Database          |
| Maven          | Build Tool        |
| Postman        | API Testing       |
| GitHub         | Version Control   |

---

# Database Design

Database Name: **streakify_db**

## users

| Column     | Type        |
| ---------- | ----------- |
| id         | Primary Key |
| name       | String      |
| email      | Unique      |
| created_at | Timestamp   |

---

## habits

| Column               | Type        |
| -------------------- | ----------- |
| id                   | Primary Key |
| name                 | String      |
| target_days_per_week | Integer     |
| user_id              | Foreign Key |
| created_at           | Timestamp   |

---

## habit_logs

| Column    | Type        |
| --------- | ----------- |
| id        | Primary Key |
| habit_id  | Foreign Key |
| log_date  | Date        |
| completed | Boolean     |

---

# Project Structure
## 📁 Project Structure
```
streakify
│
├── .gitattributes
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
│
├── .idea/
│   ├── .gitignore
│   ├── compiler.xml
│   ├── encodings.xml
│   ├── jarRepositories.xml
│   ├── misc.xml
│   ├── vcs.xml
│   ├── workspace.xml
│   └── inspectionProfiles/
│       └── Project_Default.xml
│
├── .mvn/
│   └── wrapper/
│       └── maven-wrapper.properties
│
├── postman/
│   └── Streakify.postman_collection.json
│
├── Screenshots/
│   ├── Screenshot 2026-03-11 171134.png
│   ├── Screenshot 2026-03-11 171344.png
│   ├── Screenshot 2026-03-11 171454.png
│   ├── Screenshot 2026-03-11 171715.png
│   ├── Screenshot 2026-03-11 171745.png
│   ├── Screenshot 2026-03-11 171933.png
│   ├── Screenshot 2026-03-11 173546.png
│   ├── Screenshot 2026-03-11 173849.png
│   ├── Screenshot 2026-03-11 175359.png
│   ├── Screenshot 2026-03-11 175635.png
│   ├── Screenshot 2026-03-12 105604.png
│   ├── Screenshot 2026-03-12 105616.png
│   ├── Screenshot 2026-03-12 105632.png
│   ├── Screenshot 2026-03-12 121620.png
│   ├── Screenshot 2026-03-12 121823.png
│   ├── Screenshot 2026-03-12 122053.png
│   ├── Screenshot 2026-03-12 122109.png
│   ├── Screenshot 2026-03-12 122312.png
│   ├── Screenshot 2026-03-12 122341.png
│   ├── Screenshot 2026-03-12 123116.png
│   ├── Screenshot 2026-03-12 124214.png
│   ├── Screenshot 2026-03-12 124227.png
│   └── Screenshot 2026-03-12 124256.png
│
├── sql/
│   └── schema.sql
│
├── src/
│   ├── main/
│   │   ├── java/com/streakify/
│   │   │   ├── StreakifyApplication.java
│   │   │
│   │   │   ├── controller/
│   │   │   │   ├── DashboardController.java
│   │   │   │   ├── HabitController.java
│   │   │   │   ├── HabitLogController.java
│   │   │   │   ├── StreakController.java
│   │   │   │   └── UserController.java
│   │   │
│   │   │   ├── dto/
│   │   │   │   ├── DashboardHabitStreakDTO.java
│   │   │   │   ├── DashboardResponseDTO.java
│   │   │   │   ├── ErrorResponseDTO.java
│   │   │   │   ├── HabitLogRequestDTO.java
│   │   │   │   ├── HabitLogResponseDTO.java
│   │   │   │   ├── HabitRequestDTO.java
│   │   │   │   ├── HabitResponseDTO.java
│   │   │   │   ├── StreakResponseDTO.java
│   │   │   │   ├── UserRequestDTO.java
│   │   │   │   └── UserResponseDTO.java
│   │   │
│   │   │   ├── exception/
│   │   │   │   ├── BadRequestException.java
│   │   │   │   ├── DatabaseException.java
│   │   │   │   ├── DuplicateResourceException.java
│   │   │   │   ├── GlobalExceptionHandler.java
│   │   │   │   ├── IllegalOperationException.java
│   │   │   │   └── ResourceNotFoundException.java
│   │   │
│   │   │   ├── model/
│   │   │   │   ├── Habit.java
│   │   │   │   ├── HabitLog.java
│   │   │   │   └── User.java
│   │   │
│   │   │   ├── repository/
│   │   │   │   ├── HabitLogRepository.java
│   │   │   │   ├── HabitRepository.java
│   │   │   │   └── UserRepository.java
│   │   │
│   │   │   └── service/
│   │   │       ├── DashboardService.java
│   │   │       ├── HabitLogService.java
│   │   │       ├── HabitService.java
│   │   │       ├── StreakService.java
│   │   │       └── UserService.java
│   │
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   │
│   └── test/java/com/streakify/
│       └── StreakifyApplicationTests.java
│
└── target/
    ├── classes/
    └── generated-sources/
```



#### Create User
POST /users  

```json
{
  "name": "Jezard",
  "email": "jezard@gmail.com"
}
```
#### Get User
**GET** 
`/users/{id}`

#### Delete User
**DELETE** 
`/users/{id}`
## 📋 Habit APIs

### Create Habit
**POST** `/habits`

```json
{
  "name": "Read 20 minutes",
  "targetDaysPerWeek": 3,
  "userId": 1
}
```
### Get User Habits
**GET** `/users/{userId}/habits`

##  Habit Log APIs

### Log Habit
**POST** `/habits/{habitId}/logs`

```json
{
  "logDate": "2026-03-10",
  "completed": true
}
```
###  Business Rules
- Cannot log future dates  
- Only one log per day  
- Habit must belong to the user  

### Habit Logs
**GET** `/habits/{habitId}/logs`

## Streak API

### Get Habit Streak
**GET** `/habits/{habitId}/streak`

```json
{
  "currentStreak": 4,
  "longestStreak": 4
}
```
## Dashboard API
### Productivity Dashboard

**GET** `/users/{userId}/dashboard`
```
{
  "totalHabits": 1,
  "activeHabits": 1,
  "completedToday": 1,
  "currentStreaks": [
    {
      "habitName": "Read 20 minutes",
      "currentStreak": 4,
      "longestStreak": 4
    }
  ],
  "consistencyScore": 100
}
```
### Setup Instructions
1. Clone Repository  
```
git clone https://github.com/yourusername/streakify.git
```
3. Setup PostgreSQL
```
CREATE DATABASE streakify_db;
```
5. Configure Database
```spring.datasource.url=jdbc:postgresql://localhost:5432/streakify_db
spring.datasource.username=postgres
spring.datasource.password=yourpassword
```
Run Application
mvn spring-boot:run

Application runs at:

```
http://localhost:8080
```
### Postman Testing

## Test cases covered:

- Positive
- Create User
- Create Habit
- Log Habit
- Fetch Streak
- Dashboard
- Negative
- Duplicate log
- Future date
- Invalid email
- User not found

### Features Implemented
- User Management
- Habit Management
- Habit Logging
- Streak Calculation
- Dashboard Analytics
- Validation
- Exception Handling
- PostgreSQL Integration
### Future Improvements
- JWT Authentication
- Swagger API Documentation
- Frontend Integration
- Notifications System
- Advanced Analytics

### Author
Jezard Nikson K

B.Tech Computer Science Engineering
