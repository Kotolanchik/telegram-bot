package ru.kolodkin.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolodkin.telegrambot.domain.RedmineState;
@Repository
public interface RedmineStateRepository extends JpaRepository<RedmineState, Long> {
    RedmineState findById(final long id);
}
