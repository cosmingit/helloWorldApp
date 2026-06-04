# Hello World Application

A complete full-stack web application demonstrating best practices with **Spring Boot** backend and **React** frontend.

## 📋 Table of Contents

1. [Project Overview](#project-overview)
2. [Project Structure](#project-structure)
3. [Technology Stack](#technology-stack)
4. [Prerequisites](#prerequisites)
5. [Installation Instructions](#installation-instructions)
6. [Build Instructions](#build-instructions)
7. [Running the Application](#running-the-application)
8. [API Documentation](#api-documentation)
9. [Development Setup Guide](#development-setup-guide)
10. [Common Issues and Troubleshooting](#common-issues-and-troubleshooting)

## 🎯 Project Overview

This project is a simple yet comprehensive full-stack application that demonstrates:

- **Backend**: REST API built with Spring Boot 3.1.5 and Java 17
- **Frontend**: Modern React application with hooks and error boundaries
- **Architecture**: Proper layering with Controllers, Services, and DTOs
- **Communication**: HTTP-based API with CORS configuration
- **Quality**: Comprehensive logging, error handling, and clean code practices

The application features a single REST endpoint that returns a "Hello World" message, showcasing best practices for both backend and frontend development.

## 📁 Project Structure

```
helloWorldApp/
├── backend/                           # Spring Boot application
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/helloworld/
│   │       │       ├── HelloWorldApplication.java
│   │       │       ├── controller/
│   │       │       │   └── HelloController.java
│   │       │       ├── service/
│   │       │       │   └── HelloService.java
│   │       │       ├── dto/
│   │       │       │   └── HelloResponse.java
│   │       │       └── config/
│   │       │           └── WebConfig.java
│   │       └── resources/
│   │           └── application.properties
│   └── pom.xml                        # Maven configuration
│
├── frontend/                          # React application
│   ├── src/
│   │   ├── components/
│   │   │   ├── HelloMessage.jsx       # Main component
│   │   │   ├── HelloMessage.css
│   │   │   ├── ErrorBoundary.jsx
│   │   ├── App.jsx
│   │   ├── App.css
│   │   ├── main.jsx
│   │   └── index.css
│   ├── index.html
│   ├── package.json
│   └── vite.config.js
│
├── .gitignore
└── README.md                          # This file
```

## 🛠️ Technology Stack

### Backend
- **Framework**: Spring Boot 3.1.5
- **Language**: Java 17
- **Build Tool**: Maven 3.8+
- **Logging**: SLF4J with Logback
- **Additional**: Lombok for reducing boilerplate

### Frontend
- **Framework**: React 18.2.0
- **Build Tool**: Vite 4.5.0
- **HTTP Client**: Axios 1.5.0
- **Styling**: CSS3 with animations
- **Node**: 16.0 or higher

## 📦 Prerequisites

### Required Software
- **Java Development Kit (JDK)**: Version 17 or higher
  - Download: https://www.oracle.com/java/technologies/downloads/#java17
  - Verify: `java -version`

- **Maven**: Version 3.8 or higher
  - Download: https://maven.apache.org/download.cgi
  - Verify: `mvn -version`

- **Node.js**: Version 16.0 or higher
  - Download: https://nodejs.org/
  - Verify: `node -v` and `npm -v`

- **Git**: For version control
  - Download: https://git-scm.com/
  - Verify: `git --version`

## 💻 Installation Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/helloWorldApp.git
cd helloWorldApp
```

### 2. Set Up Backend

```bash
cd backend

# Verify Maven installation
mvn --version

# Install dependencies and build
mvn clean install
```

### 3. Set Up Frontend

```bash
cd frontend

# Verify npm installation
npm --version

# Install dependencies
npm install
```

## 🔨 Build Instructions

### Backend Build

```bash
cd backend

# Clean and build
mvn clean package

# This generates: target/hello-world-app-1.0.0.jar
```

### Frontend Build

```bash
cd frontend

# Build for production
npm run build

# This generates: dist/ directory with optimized files
```

## ▶️ Running the Application

### Step 1: Start the Backend Server

```bash
cd backend

# Run with Maven
mvn spring-boot:run

# OR run the compiled JAR
java -jar target/hello-world-app-1.0.0.jar
```

**Expected Output:**
```
2024-01-15 10:30:45,123 - com.helloworld.HelloWorldApplication - Started HelloWorldApplication in 2.341 seconds (JVM running for 2.789)
```

The backend will start on: **http://localhost:8080**

### Step 2: Start the Frontend Development Server

```bash
cd frontend

npm run dev
```

**Expected Output:**
```
VITE v4.5.0  ready in 245 ms

➜  Local:   http://localhost:5173/
➜  press h to show help
```

The frontend will be available at: **http://localhost:3000** or **http://localhost:5173**

### Step 3: Access the Application

Open your browser and navigate to:
- **Development**: http://localhost:3000 (Vite dev server)
- **Backend API**: http://localhost:8080/api/hello

You should see the "Hello World" message displayed in the React component!

## 📡 API Documentation

### GET /api/hello

Returns a hello message from the backend.

#### Request

```bash
curl -X GET http://localhost:8080/api/hello \
  -H "Content-Type: application/json"
```

#### Response

**Status Code:** `200 OK`

```json
{
  "message": "Hello World",
  "timestamp": 1705318245123
}
```

#### cURL Examples

```bash
# Simple GET request
curl http://localhost:8080/api/hello

# With verbose output
curl -v http://localhost:8080/api/hello

# With pretty-print JSON (requires jq)
curl http://localhost:8080/api/hello | jq .
```

## 🚀 Development Setup Guide

### Backend Development

1. **IDE Setup** (IntelliJ IDEA recommended)
   - Open the `backend` folder as a project
   - Ensure JDK 17 is selected
   - Maven should auto-detect pom.xml

2. **Running Tests**
   ```bash
   mvn test
   ```

3. **Enable Debug Mode**
   - Add to `application.properties`:
     ```properties
     logging.level.com.helloworld=DEBUG
     ```

### Frontend Development

1. **IDE Setup** (VSCode recommended)
   - Install extensions for React development

2. **Running Dev Server**
   ```bash
   npm run dev
   ```

3. **Debugging**
   - Use browser DevTools (F12)

## 🐛 Common Issues and Troubleshooting

### Backend Issues

#### Port 8080 Already in Use

**Solution:**
- Change port in `application.properties`: `server.port=8081`
- Or kill the process using the port

#### Maven Build Failure

**Solution:**
```bash
mvn clean
mvn install
```

### Frontend Issues

#### Cannot Connect to Backend

**Error Message:**
```
Cannot connect to backend. Make sure the server is running on http://localhost:8080
```

**Solution:**
- Verify backend is running
- Check CORS configuration
- Clear browser cache

#### Port Already in Use

**Solution:**
- Change port in `vite.config.js`
- Or kill the process using the port

## 📝 Additional Notes

### Production Deployment

1. **Backend**: Build JAR and deploy to cloud platform
2. **Frontend**: Build dist folder and deploy to static hosting
3. **Update CORS**: Configure for production domain

## 📄 License

This project is provided as-is for educational purposes.

---

**Last Updated**: January 2024
**Version**: 1.0.0