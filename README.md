# Employee Management System

A modern Employee Management System built using Java Swing and MySQL with a clean dark dashboard UI.

---

## Features

- Employee Login Authentication
- Add Employee
- View Employees
- Update Employee
- Remove Employee
- Search Employees
- Print Employee Records
- Modern Dark Dashboard UI
- MySQL Database Integration

---

## Tech Stack

- Java
- Java Swing
- AWT
- JDBC
- MySQL
- NetBeans IDE

---

## UI Highlights

- Modern SaaS-inspired dark theme
- Clean dashboard layout
- Responsive table styling
- Flat modern buttons
- Premium admin-panel design
- Segoe UI typography

---

## Project Structure

```bash
src/
 ├── employee/management/system/
 │    ├── Splash.java
 │    ├── Login.java
 │    ├── Home.java
 │    ├── AddEmployee.java
 │    ├── ViewEmployee.java
 │    ├── UpdateEmployee.java
 │    ├── RemoveEmployee.java
 │    └── Conn.java
 │
 └── icons/
      ├── front.jpg
      ├── second.jpg
      ├── add_employee.jpg
      ├── delete.png
      └── home.jpg
```

---

## Database Setup

Create database:

```sql
create database employeemanagementsystem;
```

Use database:

```sql
use employeemanagementsystem;
```

Create login table:

```sql
create table login(
    username varchar(20),
    password varchar(20)
);
```

Insert admin login:

```sql
insert into login values('admin', '12345');
```

Create employee table:

```sql
create table employee(
    name varchar(40),
    fname varchar(40),
    dob varchar(30),
    salary varchar(20),
    address varchar(100),
    phone varchar(20),
    email varchar(40),
    education varchar(40),
    designation varchar(40),
    aadhar varchar(20),
    empId varchar(20)
);
```

---

## Default Login Credentials

```txt
Username: admin
Password: 12345
```

---

## Screenshots

### Splash Screen
![Splash Screen](screenshots/splash.png)

### Login Screen
![Login Screen](screenshots/login.png)

### Dashboard
![Dashboard](screenshots/dashboard.png)

### Add Employee
![Add Employee](screenshots/add-employee.png)

### View Employee
![View Employee](screenshots/view-employee.png)

### Remove Employee
![Remove Employee](screenshots/remove-employee.png)

---

## Future Improvements

- PreparedStatement for SQL security
- Dashboard analytics
- Employee profile pictures
- Search filters
- Pagination
- Export to PDF
- Role-based authentication

---

## Author

Krishna Sharma

GitHub:
https://github.com/krishnash648