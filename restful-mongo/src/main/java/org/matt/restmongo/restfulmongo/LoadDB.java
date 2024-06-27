package org.matt.restmongo.restfulmongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDB {
    private static final Logger log = LoggerFactory.getLogger(LoadDB.class);

    @Bean
    CommandLineRunner initPlayer(FootballerRepo repo) {
        return  args -> {
            try {
                // Saving players to the database
/*                repo.save(new Footballer(7,"Michael", "Owen", "FW", 100000));
                repo.save(new Footballer(24,"Andre", "Onana", "GK", 100000));
                repo.save(new Footballer(10,"Lionel", "Messi", "FW", 100000));
                log.info("Initialized players for the first time");*/

                // Fetching and logging all players
                repo.findAll().forEach(player -> log.info("Player: {}", player));
            } catch (Exception e) {
                log.error("Error during database operation: {}", e.getMessage(), e);
            }
        };
    }

}
