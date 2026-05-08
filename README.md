# 🎓 Student Skill Tracker System

A simple Spring Boot REST API project to manage students and their technical skills.

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven

---

## 📁 Project Structure

```bash
src/main/java/com/
├── Controller/
├── Entity/
├── Repository/
├── Service/
├── Projection/
└── StudentSkillTrackerSystemApplication.java
```

---

## ⚙️ Setup

### 1️⃣ Create Database

```sql
CREATE DATABASE StudenSkillTracker;
```

---

### 2️⃣ Configure application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/StudenSkillTracker
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
```

---

### 3️⃣ Run Project

```bash
./mvnw spring-boot:run
```

Server runs on:

```bash
http://localhost:8080
```

---

# 📦 Entities

## Student

- id
- name
- email
- experiance
- skills

## Skill

- skillId
- skillName
- level

---

# 🔌 API Endpoints

## ➕ Add Student

```http
POST /addstudents
```

### Request Body

```json
{
  "name": "Sachin",
  "email": "sachin@example.com",
  "experiance": "1 year",
  "skills": [
    {
      "skillName": "Java",
      "level": "Advanced"
    }
  ]
}
```

---

## 🔍 Find Student By ID

```http
GET /findbyid?id=1
```

---

## 🔍 Find Student By Name

```http
GET /findbyname?name=Sachin
```

---

## 🔍 Find Student By Experience

```http
GET /findbyexperiance?experiance=1 year
```

---

## 📄 Get All Students

```http
GET /findall?pageindex=0&pagesize=5&column=name&order=asc
```

Supports:
- Pagination
- Sorting

---

## 📊 Projection API

```http
GET /getallstudentnameskilllevel
```

Returns:
- Student Name
- Skill Name
- Skill Level

---

## ✏️ Update Student

```http
PUT /updatestudent?id=1
```

### Request Body

```json
{
  "name": "Sachin Updated"
}
```

---

##  Delete Student

```http
DELETE /deletebyid?id=1
```

---

# ✨ Features

- CRUD Operations
- Pagination & Sorting
- JPA Projection
- Partial Update
- Cascade Save
- One-to-Many Mapping

---

# 👨‍💻 Author

Sachin Dev

GitHub: https://github.com/sachin-dev45
