package ru.kolodkin.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolodkin.telegrambot.domain.ScheduleState;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleState, Long> {
    ScheduleState findById(final long id);
}
