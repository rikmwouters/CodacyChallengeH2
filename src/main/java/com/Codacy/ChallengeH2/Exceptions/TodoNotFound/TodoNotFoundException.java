package com.Codacy.ChallengeH2.Exceptions.TodoNotFound;

public class TodoNotFoundException extends RuntimeException {

    public TodoNotFoundException(Long id) {
        super("Could not find todo " + id);
    }
}
