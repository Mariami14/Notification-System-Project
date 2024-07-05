# Notification-System-Project
This project involves creating a Customer Notification Address Facade System, a microservice to centralize and manage customer contact information and preferences for notifications. This system will act as a single source of truth for all recipient addresses and delivery statuses.

# Notification System

This project is a Notification System application built with Spring Boot, Spring Data JPA, Elasticsearch, and other technologies. It allows tracking notification statuses, searching and filtering customers, and managing customer notification preferences.

**Git Instructions - on this branch there is only readme and on Master's branch the whole application is uploaded**

## Table of Contents

- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Running the Application](#running-the-application)


## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 11
- Maven 3.6+
- MySQL Server
- An IDE such as IntelliJ IDEA or Eclipse

## Setup

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/notification-system.git
cd notification-system

spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=notificationSys
spring.datasource.username=notificationSys
spring.datasource.password=mari1234
spring.jpa.hibernate.ddl-auto=update

**Install dependencies**
mvn clean install
check their compatibility mvn dependency:tree

mvn spring-boot:run
After starting the application, it will be accessible at http://localhost:8080.

