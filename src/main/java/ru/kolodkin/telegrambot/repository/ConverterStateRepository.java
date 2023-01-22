package ru.kolodkin.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolodkin.telegrambot.domain.ConverterState;

@Repository
public interface ConverterStateRepository extends JpaRepository<ConverterState, Long> {
    ConverterState findById(final long id);

}
