package ru.kolodkin.telegrambot.dao;

import org.springframework.stereotype.Component;
import ru.kolodkin.telegrambot.domain.ConverterState;
import ru.kolodkin.telegrambot.repository.ConverterStateRepository;

import java.util.List;

@Component
public class ConverterStateDAO {
    ConverterStateRepository converterStateRepository;

    public ConverterState findByUserId(final long id) {
        return converterStateRepository.findById(id);
    }

    public List<ConverterState> findAllUsers() {
        return converterStateRepository.findAll();
    }

    public void removeUser(final ConverterState scheduleState) {
        converterStateRepository.delete(scheduleState);
    }

    public void saveUser(final ConverterState scheduleState) {
        converterStateRepository.save(scheduleState);
    }

    public boolean isExist(final long id) {
        return converterStateRepository.existsById(id);
    }
}
