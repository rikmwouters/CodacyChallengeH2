package com.Codacy.ChallengeH2;

import com.Codacy.ChallengeH2.Exceptions.TodoNotFound.TodoNotFoundException;
import com.Codacy.ChallengeH2.Models.Todo;
import com.Codacy.ChallengeH2.Repository.TodoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ChallengeH2Application.class)
@WebAppConfiguration
public class SpringBootJPATest {

    @Autowired
    private TodoRepository repository;

    @Test
    public void givenTodoRepository_whenSaveAndRetrieveEntity_thenOK() {
        Todo todo =
                repository.save(new Todo("test"));
        Todo savedTodo =
                repository.findById(todo.getId())
                        .orElseThrow(() -> new TodoNotFoundException(todo.getId()));

        assertNotNull(savedTodo);
        assertEquals(todo.getTitle(), savedTodo.getTitle());
    }
}
