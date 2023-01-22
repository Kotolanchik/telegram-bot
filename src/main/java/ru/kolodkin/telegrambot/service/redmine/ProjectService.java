package ru.kolodkin.telegrambot.service.redmine;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.kolodkin.telegrambot.domain.User;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ProjectService {
    public BotApiMethod<?> startCreateProject(final User user, final Message message) {
        return null;
    }
}
