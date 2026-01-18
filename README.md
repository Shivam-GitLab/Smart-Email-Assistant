# Smart Email

A Java \ Spring Boot application built with Maven. This repository includes the Maven Wrapper (`mvnw`, `mvnw.cmd`) so you can build and run the project without installing Maven globally.

## Requirements

- Java 17\+ (recommended)
- Git
- (Optional) Docker


<img width="1368" height="782" alt="Screenshot from 2026-01-18 16-02-33" src="https://github.com/user-attachments/assets/bf7d7b4e-22c6-42f5-a0bd-accaa0d45588" />


## Quick start

Clone the repo and build:

```bash
git clone <repo-url>
cd <repo-dir>
./mvnw clean package     # Linux / macOS
.\mvnw.cmd clean package # Windows

# run with wrapper
./mvnw spring-boot:run

# or run the packaged jar
java -jar target/*.jar./mvnw test# run with a profile
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
