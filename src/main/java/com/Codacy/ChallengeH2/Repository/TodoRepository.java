package com.Codacy.ChallengeH2.Repository;

import com.Codacy.ChallengeH2.Models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
