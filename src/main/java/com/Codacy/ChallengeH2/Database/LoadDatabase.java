package com.Codacy.ChallengeH2.Database;

import com.Codacy.ChallengeH2.Models.Todo;
import com.Codacy.ChallengeH2.Repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TodoRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Todo("Wash dishes")));
            log.info("Preloading " + repository.save(new Todo("Mop floor")));
        };
    }
}