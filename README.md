# 🧪 Software Testing Repository

Welcome to the **Software Testing** repository! This project showcases automated testing strategies using three powerful tools:

- **JUnit** for Java unit testing 🧬  
- **Robot Framework** for keyword-driven acceptance testing 🤖  
- **Postman** for RESTful API testing 📮

---

## 📁 Repository Structure

Software-Testing/
├── JUnit/
│ └── 📌 Java-based unit tests using JUnit 5
├── Robot-Framework/
│ └── ⚙️ Acceptance tests written in Robot syntax
└── Postman/
└── 🔁 Collections and environments for API testing


---

## 🧬 1. JUnit

### 🔹 Description
This directory contains unit tests for Java applications using **JUnit 5**.

### 🛠️ Tech Stack
- Java 17+
- JUnit 5 (Jupiter)
- Maven / Gradle

### 🚀 How to Run
```bash
cd JUnit
mvn test
# or
./gradlew test

🤖 2. Robot Framework
🔹 Description
Contains automated acceptance and functional tests written using Robot Framework syntax.

🛠️ Tech Stack
Python 3.10+

Robot Framework

SeleniumLibrary (for UI testing)

🚀 How to Run

cd Robot-Framework
robot tests/
📮 3. Postman
🔹 Description
Includes Postman collections, environments, and test scripts for RESTful API testing.

🛠️ Tools
Postman App

Newman (CLI tool for Postman)

🚀 How to Run

cd Postman
newman run your-collection.json -e your-environment.json


🧠 Goals
✅ Learn and apply different testing strategies

✅ Maintain a clean testing structure

✅ Improve test automation across unit, integration, and system levels

