# 🧪 Software Testing Repository

Welcome to the **Software Testing** repository!  
This project demonstrates **automated testing techniques** using:

- **JUnit** – Java Unit Testing 🧬  
- **Robot Framework** – Keyword-Driven Testing 🤖  
- **Postman** – REST API Testing 📮

---

## 🧬 Java Testing — JUnit

### 🔹 Overview
This module covers unit testing for Java applications using **JUnit 5** (Jupiter).

### 🛠️ Tech Stack
- Java 17+
- JUnit 5
- Maven or Gradle

### 🚀 Running the Tests
```bash
cd JUnit
mvn test
# or
./gradlew test

🤖 Acceptance Testing — Robot Framework
🔹 Overview
This module features functional and acceptance testing via Robot Framework.

🛠️ Tech Stack
Python 3.10+

Robot Framework

SeleniumLibrary (for UI-based tests)

🚀 Running the Tests

cd Robot-Framework
robot tests/


📮 API Testing — Postman
🔹 Overview
This module includes Postman collections, environments, and scripts to test REST APIs.

🛠️ Tools Required
Postman App (for development)

Newman CLI (for automation)

🚀 Running API Tests via Newman

cd Postman
newman run LMS-API-Collection.json -e LMS-Environment.json
