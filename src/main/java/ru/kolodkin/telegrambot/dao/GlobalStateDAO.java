package ru.kolodkin.telegrambot.dao;

import org.springframework.stereotype.Component;
import ru.kolodkin.telegrambot.domain.GlobalState;
import ru.kolodkin.telegrambot.domain.RedmineState;
import ru.kolodkin.telegrambot.repository.GlobalStateRepository;

import java.util.List;

@Component
public class GlobalStateDAO {
    GlobalStateRepository globalStateRepository;

    public GlobalState findByUserId(final long id) {
        return globalStateRepository.findById(id);
    }

    public List<GlobalState> findAllUsers() {
        return globalStateRepository.findAll();
    }

    public void removeUser(final GlobalState globalState) {
        globalStateRepository.delete(globalState);
    }

    public void saveUser(final GlobalState globalState) {
        globalStateRepository.save(globalState);
    }

    public boolean isExist(final long id) {
        return globalStateRepository.existsById(id);
    }
}
