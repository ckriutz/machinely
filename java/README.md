# Simple Java REST API Project that uses PostgresSQL as backend db

## Build Instructions

To build the project, run the following command:
```sh
mvn clean package -DskipTests
```

## launch the svc and backend database as containers
```sh
docker-compose up
```

## Test the API endpoints in the test.http file
1. Invoke the POST request to create an employee
2. Invoke the GET request to search an employee
