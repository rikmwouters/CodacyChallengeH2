# CodacyChallengeH2

## Introduction

The Codacy Challenge H2 application is an API that stores TODOs in an H2 in-memory database and can be interacted with using HTTP requests. The user can add new TODOs, modify existing TODOs and delete TODOs. When a TODO is added or modified, the API will return the TODO to the user as a JSON object. The application pre-loads two example TODOs into the database at startup.

The TODO model consists of the following fields:

| Field      | Data type | Description |
| ----------- | ----------- | ----------- |
| id      | Long       | Unique identifier |
| title   | String        | Description of the TODO |
| completed   | Boolean        | Whether or not the TODO has been completed |

The API has the following endpoints:

| Functionality      | Request type | URL Path | Notes |
| ----------- | ----------- | ----------- | ----------- |
| List all TODOs      | GET       | / | |
| Add new TODO   | PUT        | / | |
| View specific TODO   | GET        | /todo/:id | Instead of ':id', use the TODO's identifier. |
| Modify TODO   | PATCH        | /todo/:id | Instead of ':id', use the TODO's identifier. Include the modified TODO as a JSON in the request body, and add "content-type: application/json" to the request header. |
| Delete TODO   | DELETE        | /todo/:id | Instead of ':id', use the TODO's identifier. |

## Requirements

While Windows can be used to run and use the application, this guide is limited to Linux environments.

Please make sure the following dependencies are installed (Ubuntu installation commands are shown):

Maven - ``` sudo apt install maven```

cURL - ``` sudo apt install curl```

Git - ``` sudo apt install git```

## Cloning the repository

Choose a folder in which the repository should be located. In that folder, open the terminal and use git to clone the repository.

```
git clone https://github.com/rikmwouters/CodacyChallengeH2.git
```

## Compiling and running the application

Make sure the current directory of the terminal is in the main folder of the project (```cd CodacyChallengeH2```), which should contain the pom.xml among other files. Compile the JAR file.

```
mvn compile package
```

Then run the JAR file as follows.

```
java -cp target/ChallengeH2-0.0.1-SNAPSHOT.jar -Dloader.main=com.Codacy.ChallengeH2.ChallengeH2Application org.springframework.boot.loader.PropertiesLauncher
```

## Interacting with the application

Please see the API endpoints table in the introduction section of this guide.

Open another terminal. The pre-loaded TODOs can be viewed using the following cURL command. 

```
curl http://localhost:8080/ 
```

The following command adds a new TODO to the database.

``` 
curl -X PUT http://localhost:8080/?title=Do+laundry 
```

To view a specific TODO (id=1 in this example), the following command can be used.

``` 
curl http://localhost:8080/todo/1 
```

In order to update a TODO (again id=1), use a PATCH request such as the following. Note that the TODO is selected using the number in the URL path, NOT the ```id``` field in the request body JSON.

``` 
curl -X PATCH http://localhost:8080/todo/1 -H "content-type: application/json" -d '{"id":1, "title":"Cut grass", "completed":true}' 
```

Finally, a TODO can be deleted with a DELETE request such as the following, ending with the TODO ```id``` field.

``` 
curl -X DELETE http://localhost:8080/todo/1 
```

## Troubleshooting

### The servlet won't start
If another application is already running on port 8080, the servlet is prevented from running. You can check whether the port is taken by using the command ``` lsof -i:8080 ```. If a process needs to be killed, the command ```kill $(lsof -t -i:8080)``` can be used for that.
