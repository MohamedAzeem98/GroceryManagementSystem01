# 🛒 Grocery Management System

A **role-based backend system** developed using **Spring Boot**, designed to handle a secure and modular grocery management process. It includes JWT-based authentication, role-based access (Admin & User), cart management, and clean layered architecture.

---

## 🔥 Features

- ✅ JWT Authentication & Authorization
- ✅ Role-based access control (Admin/User)
- ✅ Cart management (Many-to-Many relationship)
- ✅ DTOs with validation
- ✅ Exception Handling using @ControllerAdvice
- ✅ AOP Logging for Service Methods
- ✅ Layered Architecture (Controller, Service, Repository, Entity, DTO, Mapper)

---

## 👥 User Roles

### 👤 Admin

- Login with predefined credentials.
- Add, update, delete groceries.
- View all grocery items.

### 👥 User

- Register and login.
- View grocery items.
- Add grocery items to their cart.
- View and remove items from cart.

---

## 🔐 Security Flow

- JWT Token-based login.
- Token required in `Authorization` header for all secure endpoints.
- Role-based access enforced using Spring Security.

---

## 📂 Project Structure

```
Controller
   |
Service <--> Mapper <--> DTO
   |
Repository (JPA)
   |
Entity
```

---

## ⚙️ Tech Stack

| Layer            | Tech Used |
|------------------|-----------|
| Backend          | Java 21, Spring Boot 3.5.4 |
| Security         | Spring Security, JWT |
| Database         | MySQL |
| ORM              | Spring Data JPA |
| Validation       | Hibernate Validator |
| DTO Mapping      | Manual Mapper Classes |
| API Testing      | Postman |
| Logging          | Spring AOP |
| Error Handling   | @ControllerAdvice |
| Build Tool       | Maven |

---

## 🔁 API Workflow

### Admin

| Action          | Method | Endpoint                | Auth Required |
|-----------------|--------|-------------------------|----------------|
| Login           | POST   | `/admin/login`          | ❌             |
| Add Grocery     | POST   | `/admin/grocery/add`    | ✅             |
| Update Grocery  | PUT    | `/admin/grocery/update/{id}` | ✅        |
| Delete Grocery  | DELETE | `/admin/grocery/delete/{id}` | ✅       |
| View Groceries  | GET    | `/admin/groceries`      | ✅             |

### User

| Action            | Method | Endpoint                 | Auth Required |
|-------------------|--------|--------------------------|----------------|
| Register          | POST   | `/user/register`         | ❌             |
| Login             | POST   | `/user/login`            | ❌             |
| View Groceries    | GET    | `/user/groceries`        | ✅             |
| Add to Cart       | POST   | `/user/cart/add/{itemId}`| ✅             |
| View Cart         | GET    | `/user/cart`             | ✅             |
| Remove from Cart  | DELETE | `/user/cart/remove/{itemId}` | ✅         |

---

## 🧪 Sample Requests

### 🔐 Admin Login
`POST /admin/login`
```json
{
  "email": "admin@gmail.com",
  "password": "admin123"
}
```

### 🛒 Add Grocery Item
`POST /admin/grocery/add` (with token)
```json
{
  "name": "Milk",
  "price": 40,
  "quantity": 5
}
```

### 👤 Register User
`POST /user/register`
```json
{
  "name": "John",
  "email": "john@gmail.com",
  "password": "john123"
}
```

### ➕ Add to Cart
`POST /user/cart/add/1` (with token)

---

## ✅ Enhancements (Optional Ideas)

- Swagger UI for API documentation
- Dockerize the backend
- Frontend using React/Angular
- Email verification for user registration

---

## 🧠 Author

**Grocery Management System** was developed as a Spring Boot-based secure project with clean architecture and modularity in mind – perfect for showcasing skills at a 2+ year experience level.

---

**License:** MIT