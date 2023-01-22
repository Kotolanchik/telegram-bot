package ru.kolodkin.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kolodkin.telegrambot.domain.GlobalState;

public interface GlobalStateRepository extends JpaRepository<GlobalState, Long> {
    GlobalState findById(final long id);
}
