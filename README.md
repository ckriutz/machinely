# machinely
Demo for Dev Containers

## What are Dev Containers?
Dev containers are Docker containers that are specifically configured to provide a fully featured development environment. They are used to define an environment in which you develop your application before you are ready to deploy. Dev containers are structured metadata format and are defined in a devcontainer.json file. You can use the default dev container configuration, a predefined dev container configuration, or create a custom dev container configuration.

Microsoft's spot for existing definitions, and instructions for developing your own can be found at [https://containers.dev/](containers.dev).

### Which Dev Projects are featured here?
In this repository, we are focused on five types of Dev Containers.
1) C++
2) Dotnet with c#
3) Java
4) Azure Functions with node.js
5) Cloud Native development

## The C++ Dev Project

In order to run the c++ file, type the following in the command line in the Dev Container.

```
g++ hello.cpp -o hello
```

...then, run the project with the command:
```
./hello
```

Enter your name and the prompt, and watch as it's returned to you backwards!

Verifying this works:

✔️ Local Dev Container

❓Codespaces

## The Dotnet Project

This is a fun web page that will show a random scientist.

In order to run this project, type the following in the command line in the Dev Container.

```
dotnet run
```

Verifying this works:

✔️ Local Dev Container

✔️ Codespaces


## The Java Project

This is a simple Java REST API using Spring Boot, maven and a backend postgreSQL db

In order to run this project, type the following in the command line in the Dev Container.

```bash
mvn clean package -DskipTests
docker-compose up
```

## The Azure Functions node.js Project


Verifying this works:

This is a fun Azure Functions project in node.js that when run, it will display an random scientist in the console every minute.

In order to get this project to run,  type the following in the command line in the Dev Container.
```
func start
```

❓Local Dev Container

❓Codespaces

## The Cloud-Native development project

This dev container has toolong for Java 21, Kubernetes/kubectl, Docker, Helm & Azure Cli