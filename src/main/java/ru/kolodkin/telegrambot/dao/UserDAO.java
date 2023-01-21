package ru.kolodkin.telegrambot.dao;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import ru.kolodkin.telegrambot.domain.User;
import ru.kolodkin.telegrambot.repository.UserRepository;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserDAO {
    UserRepository userRepository;

    public User findByUserId(final long id) {
        return userRepository.findById(id);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void removeUser(final User user) {
        userRepository.delete(user);
    }

    public void saveUser(final User user) {
        userRepository.save(user);
    }

    public boolean isExist(final long id) {
        return userRepository.existsById(id);
    }
}
