# CodacyChallengeH2

## Introduction

The Codacy Challenge H2 application is an API that stores TODOs on an H2 in-memory database and can be interacted with using HTTP requests. The database is pre-populated with two example TODOs, and the user can add new TODOs, modify existing TODOs and delete TODOs. When a TODO is added or modified, the API will return the TODO to the user as a JSON object.

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

Please make sure the following dependencies are installed:

Maven - ``` sudo apt install maven```

cURL - ``` sudo apt install curl```

Git - ``` sudo apt install git```

## Cloning the repository

Choose a folder in which the repository should be located. In that folder, open the terminal and use git to clone the repository.

```
git clone https://github.com/rikmwouters/CodacyChallengeH2.git
```

## Running the application

Make sure the current directory of the terminal is in the main folder of the project (```cd CodacyChallengeH2```), which should contain the pom.xml among other files. Compile the JAR file:

```
mvn compile package
```

Then run the JAR.

```
java -cp target/ChallengeH2-0.0.1-SNAPSHOT.jar -Dloader.main=com.Codacy.ChallengeH2.ChallengeH2Application org.springframework.boot.loader.PropertiesLauncher
```

## Interacting with the application

Open another terminal. The H2 database has been populated with 2 example TODOs at startup. We can view those TODOs using the cURL command. 

```
curl http://localhost:8080/ 
```

In order to add a new TODO, a PUT request can be sent as follows.

``` 
curl -X PUT http://localhost:8080/?title=Do+laundry 
```

To view a specific TODO, use the following command where the number at the end is the ID of the TODO.

``` 
curl http://localhost:8080/todo/1 
```

In order to update a TODO, use a PATCH request like the following. Again, the number at the end of the URL is the ID of the TODO.

``` 
curl -X PATCH http://localhost:8080/todo/1 -H "content-type: application/json" -d '{"id":1, "title":"Cut grass", "completed":true}' 
```

Finally, you can delete a TODO with a DELETE request as follows, ending with the TODO ID.

``` 
curl -X DELETE http://localhost:8080/todo/1 
```

## Troubleshooting

### The servlet won't start
If another application is already running on port 8080, the servlet is prevented from running. You can check whether the port is taken by using the command ``` lsof -i:8080 ```. If a process needs to be killed, the command ```kill $(lsof -t -i:8080)``` can be used for that.
