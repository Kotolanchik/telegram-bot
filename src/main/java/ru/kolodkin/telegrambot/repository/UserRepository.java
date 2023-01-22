package ru.kolodkin.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kolodkin.telegrambot.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(final long id);
}
