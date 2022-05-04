package com.Codacy.ChallengeH2;

class TodoNotFoundException extends RuntimeException {

    TodoNotFoundException(Long id) {
        super("Could not find todo " + id);
    }
}
