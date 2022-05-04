package com.Codacy.ChallengeH2.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Todo {
    private @Id @GeneratedValue Long id;
    private String title;
    private Boolean completed;

    Todo(){

    }

    public Todo(String title) {
        this.title = title;
        this.completed = false;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Boolean getCompleted() {
        return this.completed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Todo))
            return false;
        Todo todo = (Todo) o;
        return Objects.equals(this.id, todo.id) && Objects.equals(this.title, todo.title)
                && Objects.equals(this.completed, todo.completed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.title, this.completed);
    }

    @Override
    public String toString() {
        return "Todo{" + "id=" + this.id + ", name='" + this.title + '\'' + ", completed='" + this.completed + '\'' + '}';
    }
}

