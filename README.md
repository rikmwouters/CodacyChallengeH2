# CodacyChallengeH2

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

Open another terminal. The H2 database has been populated with 2 example todos at startup. We can view those todos using the cURL command. 

```
curl http://localhost:8080/ 
```

In order to add a new todo, a PUT request can be sent.

``` 
curl -X PUT http://localhost:8080/?title=Do+laundry 
```

To get a specific todo, use the following command where the number at the end is the ID of the todo.

``` 
curl http://localhost:8080/todo/1 
```

In order to update a todo, use a PATCH request like the following. Again, the number at the end is the ID of the todo.

``` 
curl -X PATCH http://localhost:8080/todo/1 -H "content-type: application/json" -d '{"id":1, "title":"Maintain garden", "completed":false}' 
```

Finally, you can delete a todo with a DELETE request:

``` 
curl -X DELETE http://localhost:8080/todo/1 
```

## Troubleshooting

### The servlet won't start
If another application is already running on port 8080, the servlet is prevented from running. You can check whether the port is taken using the command ``` lsof -i:8080 ```. If a process on this port needs to be killed, the command ```kill $(lsof -t -i:8080)``` can be used for that.
