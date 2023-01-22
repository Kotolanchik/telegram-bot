package ru.kolodkin.telegrambot.dao;

import org.springframework.stereotype.Component;
import ru.kolodkin.telegrambot.domain.RedmineState;
import ru.kolodkin.telegrambot.repository.RedmineStateRepository;

import java.util.List;

@Component
public class RedmineStateDAO {
    RedmineStateRepository redmineStateRepository;

    public RedmineState findByUserId(final long id) {
        return redmineStateRepository.findById(id);
    }

    public List<RedmineState> findAllUsers() {
        return redmineStateRepository.findAll();
    }

    public void removeUser(final RedmineState redmineState) {
        redmineStateRepository.delete(redmineState);
    }

    public void saveUser(final RedmineState redmineState) {
        redmineStateRepository.save(redmineState);
    }

    public boolean isExist(final long id) {
        return redmineStateRepository.existsById(id);
    }
}
