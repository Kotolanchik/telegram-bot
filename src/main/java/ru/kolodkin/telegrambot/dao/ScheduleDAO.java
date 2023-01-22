package ru.kolodkin.telegrambot.dao;

import org.springframework.stereotype.Component;
import ru.kolodkin.telegrambot.domain.RedmineState;
import ru.kolodkin.telegrambot.domain.ScheduleState;
import ru.kolodkin.telegrambot.repository.RedmineStateRepository;
import ru.kolodkin.telegrambot.repository.ScheduleRepository;

import java.util.List;

@Component
public class ScheduleDAO {
    ScheduleRepository scheduleRepository;

    public ScheduleState findByUserId(final long id) {
        return scheduleRepository.findById(id);
    }

    public List<ScheduleState> findAllUsers() {
        return scheduleRepository.findAll();
    }

    public void removeUser(final ScheduleState scheduleState) {
        scheduleRepository.delete(scheduleState);
    }

    public void saveUser(final ScheduleState scheduleState) {
        scheduleRepository.save(scheduleState);
    }

    public boolean isExist(final long id) {
        return scheduleRepository.existsById(id);
    }
}
