# Log Ingestor and Query Interface

## Overview
This project is a Log Ingestor and Query Interface built using Java, Spring Boot, and MySQL. It allows efficient handling of log data and provides a query interface (CLI) for querying logs based on various filters

## Features
- A mechanism to ingest logs in a specific format and implement different options to retrieve data.

## Filters based on:
- level
- message
- resourceId
- traceId
- spanId
- commit
- metadata.parentResourceId


 ### Project Setup
 - Prerequisites
  - Java Development Kit (JDK)
  - Spring Tool Suite (STS) or any Java IDE
  - MySQL Database

- To Clone the repository
- Open the project in your preferred Java IDE.
- Set up your MySQL database and update the database configuration :
```
#db specific properties
spring.datasource.url=jdbc:mysql://localhost:3306/database_name
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=username
spring.datasource.password=password

#ORM s/w specific properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
- Run the application.
- Access the Log Ingestor via HTTP on port 3000.
- Use "http://localhost:3000/logs".

## API Endpoints
```
POST /logs/ingestLog: Ingests log data into the system.
GET /logs/: Retrieves all logs.
GET /logs/level/{level}: Retrieves logs by level.
GET /logs/search?message={message}: Searches logs by message.
GET /logs/resource/{resourceId}: Retrieves logs by resourceId.
GET /logs/traceId/{traceId}: Retrieves logs by traceId.
GET /logs/spanId/{spanId}: Retrieves logs by spanId.
GET /logs/commit/{commit}: Retrieves logs by commit.
GET /logs/metadata/parentResourceId/{parentResourceId}: Retrieves logs by metadata.parentResourceId.
```

