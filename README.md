# CodacyChallengeH2

## Requirements

Please make sure the following dependencies are installed:

JDK - ``` sudo apt install openjdk-11-jdk```

Maven - ``` sudo apt install maven```

cURL - ``` sudo apt install curl```

Git - ``` sudo apt install git```

## Cloning the repository

Choose a folder in which the repository should be located. In that folder, open the terminal and use git to clone the repository.

``` git clone https://github.com/rikmwouters/CodacyChallengeH2.git ```

## Running the application

Make sure the current directory of the terminal is still in the same folder, which should now contain the pom.xml among other files. First compile the JAR file:
```mvn compile package```

Then run the JAR.
```java -cp target/ChallengeH2-0.0.1-SNAPSHOT.jar -Dloader.main=com.Codacy.ChallengeH2.ChallengeH2Application org.springframework.boot.loader.PropertiesLauncher```

If the application is now running, you can proceed to the next section. It's possible that the application is prevented from starting, if another application already uses port 8080. You can check whether the port is taken using the command ``` lsof -i:8080 ```. If a process on this port needs to be killed, the command ```kill $(lsof -t -i:8080)``` can be used for that.

## Interacting with the application

Open another terminal. During startup of the application, the H2 database is populated with 2 todos. We can view those todos using the following cURL command. 
```curl http://localhost:8080/ ```

In order to add a new todo, a PUT request can be sent.
``` curl -X PUT http://localhost:8080/?title=Do+laundry ```

To get a specific todo, use the following command where the number at the end is the ID of the todo.
``` curl http://localhost:8080/todo/1 ```

In order to update a todo, use a PATCH request like the following. Again, the number at the end is the ID of the todo.
``` curl -X PATCH http://localhost:8080/todo/1 -H "content-type: application/json" -d '{"id":1, "title":"Maintain garden", "completed":false}' ```

Finally, you can delete a todo with a DELETE request:
``` curl -X DELETE http://localhost:8080/todo/1 ```
