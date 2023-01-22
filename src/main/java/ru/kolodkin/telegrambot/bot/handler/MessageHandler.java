package ru.kolodkin.telegrambot.bot.handler;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.kolodkin.telegrambot.dao.UserDAO;
import ru.kolodkin.telegrambot.domain.User;
import ru.kolodkin.telegrambot.service.redmine.IssueService;
import ru.kolodkin.telegrambot.service.redmine.ProjectService;
import ru.kolodkin.telegrambot.service.redmine.UserService;

import static lombok.AccessLevel.PRIVATE;
import static ru.kolodkin.telegrambot.enums.BotState.*;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class MessageHandler implements HandlerProcess<Message> {
    UserDAO userDAO;
    IssueService issueService;
    ProjectService projectService;
    UserService userService;

    public BotApiMethod<?> process(final Message message) {
        val user = userDAO.findByUserId(message.getFrom().getId());
        if (user.getId() != message.getFrom().getId()) {
            throw new RuntimeException();
        }

        if (user.getBotState() == REDMINE) {
            return processRedmine(user, message);
        }

        if (user.getBotState() == SCHEDULE) {
            return processSchedule(user, message);
        }

        if (user.getBotState() == CONVERTER) {
            return processConverter(user, message);
        }

        throw new RuntimeException();
    }

    private BotApiMethod<?> processRedmine(final User user, final Message message) {
        return switch (user.getGlobalRedmineBotState()) {

            case USER -> null;
            case ISSUE -> null;
            case PROJECT -> null;
            default -> throw new RuntimeException();
        };
    }

    private BotApiMethod<?> processSchedule(final User user, final Message message) {
        return null; // TODO: 22.01.2023 расписание вятгу
    }

    private BotApiMethod<?> processConverter(final User user, final Message message) {
        return null; // TODO: 22.01.2023 конвертер файлов
    }

    private BotApiMethod<?> transitionForUserRedmine(final User user, final Message message) {
        return switch (user.getRedmineUserBotState()) {
            case START_CREATE -> userService.startCreateUser(user, message);
            case CHOICE_NAME -> null;
            case CHECK -> null;
            case SAVE -> null;
            default -> throw new RuntimeException();
        };
    }

    private BotApiMethod<?> transitionForIssueRedmine(final User user, final Message message) {
        return switch (user.getRedmineIssueBotState()) {
            case START_CREATE -> issueService.startCreateIssue(user, message);
            case CHOICE_NAME -> null;
            case CHECK -> null;
            case SAVE -> null;
            default -> throw new RuntimeException();
        };
    }

    private BotApiMethod<?> transitionForProjectRedmine(final User user, final Message message) {
        return switch (user.getRedmineProjectBotState()) {
            case START_CREATE -> projectService.startCreateProject(user, message);
            case CHOICE_NAME -> null;
            case CHECK -> null;
            case SAVE -> null;
            default -> throw new RuntimeException();
        };
    }
}
