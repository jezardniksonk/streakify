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

# Screenshots

### Create User

<img width="1362" height="717" alt="Screenshot 2026-03-11 171134" src="https://github.com/user-attachments/assets/2db29ae3-9aa4-44d7-a690-17391ec7227a" />


### Get User

<img width="1360" height="723" alt="Screenshot 2026-03-11 171715" src="https://github.com/user-attachments/assets/3661a56e-9f11-4e97-8c6d-73235fb8befb" />


### Delete User

<img width="1365" height="609" alt="Screenshot 2026-03-11 171933" src="https://github.com/user-attachments/assets/e8c0ffd5-576b-4d7a-8dd5-b90b522569d3" />


### Create Habit

<img width="1348" height="701" alt="Screenshot 2026-03-11 173546" src="https://github.com/user-attachments/assets/1af9a43f-c5f3-4eb7-84c2-4fe840326111" />


### Get User Habit

<img width="1346" height="744" alt="Screenshot 2026-03-11 173849" src="https://github.com/user-attachments/assets/74ef6438-ad2d-4c63-b373-b6b326fae627" />



### Delete Habit

<img width="1368" height="596" alt="Screenshot 2026-03-11 175635" src="https://github.com/user-attachments/assets/837076b6-835f-4334-a68d-63a950113753" />



### Habit Log Day1

<img width="1098" height="629" alt="Screenshot 2026-03-12 105604" src="https://github.com/user-attachments/assets/3e037e0b-de78-4644-bdd8-1cc23bdc30e1" />


### Habit Log Day2

<img width="1451" height="790" alt="image" src="https://github.com/user-attachments/assets/3348fd74-7314-45a0-9aab-36bca8027ddd" />

### Habit Log Day3


<img width="1450" height="819" alt="image" src="https://github.com/user-attachments/assets/be93dd19-80c3-4742-883a-30e09ee65561" />


### Habit Log Day4

<img width="1444" height="867" alt="image" src="https://github.com/user-attachments/assets/b12e6f6c-0113-46b3-b879-d9bda9d12511" />

### Fetch Streak


<img width="1114" height="579" alt="Screenshot 2026-03-12 122341" src="https://github.com/user-attachments/assets/c35266f8-72b1-4fb9-a2c9-6594b4406866" />

### Dashboard

<img width="1096" height="803" alt="Screenshot 2026-03-12 124227" src="https://github.com/user-attachments/assets/25a16b85-7521-442d-bd1c-2adeaf4b8362" />

## Negative Cases

### Duplicate Email

<img width="1434" height="617" alt="Screenshot 2026-03-11 171338" src="https://github.com/user-attachments/assets/0ac3521b-9ffc-4980-9b7f-643adda0c321" />


### Invalid Email


<img width="1455" height="707" alt="Screenshot 2026-03-11 171447" src="https://github.com/user-attachments/assets/c30c111e-9dce-4989-8269-6e3179b821d5" />

### User Not Found

<img width="1453" height="723" alt="Screenshot 2026-03-11 171653" src="https://github.com/user-attachments/assets/40ec7a31-dcbc-491d-b259-a67b8eec2fa3" />

### User Not Found With Habit Id


<img width="1440" height="742" alt="image" src="https://github.com/user-attachments/assets/543f4439-a202-4fb4-81e1-e49578e61c33" />

### Deleting a Non Exsisting Habit


<img width="1451" height="783" alt="image" src="https://github.com/user-attachments/assets/193d347e-e277-47d1-b5ab-0915a61fb1de" />

### Future Date Not Allowed


<img width="1451" height="826" alt="Screenshot 2026-03-12 105429" src="https://github.com/user-attachments/assets/91bc2f01-682d-4921-845c-03a592620ebd" />


### Habit Not Found


<img width="1443" height="733" alt="image" src="https://github.com/user-attachments/assets/6e97e777-a1b2-4a50-b881-2db369e10428" />


### Duplicate Logs


<img width="1453" height="829" alt="Screenshot 2026-03-12 105154" src="https://github.com/user-attachments/assets/2de9c487-774a-45e8-a7d2-72969190a42f" />


---

### Author
Jezard Nikson K

B.Tech Computer Science Engineering
