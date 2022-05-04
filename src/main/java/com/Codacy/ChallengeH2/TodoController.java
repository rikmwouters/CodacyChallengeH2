package com.Codacy.ChallengeH2;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
class TodoController {

    private final TodoRepository repository;

    TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    List<Todo> viewAll() {
        return repository.findAll();
    }

    @PutMapping("/")
    Todo createOne(@RequestParam String title) {
        return repository.save(new Todo(title));
    }

    @GetMapping("/todo/{id}")
    Todo viewOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @PatchMapping("/todo/{id}")
    Todo updateOne(@RequestBody Todo newTodo, @PathVariable Long id) {

        return repository.findById(id)
                .map(todo -> {
                    todo.setTitle(newTodo.getTitle());
                    todo.setCompleted(newTodo.getCompleted());
                    return repository.save(todo);
                })
                .orElseGet(() -> {
                    newTodo.setId(id);
                    return repository.save(newTodo);
                });
    }

    @DeleteMapping("/todos/{id}")
    void deleteTodo(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
