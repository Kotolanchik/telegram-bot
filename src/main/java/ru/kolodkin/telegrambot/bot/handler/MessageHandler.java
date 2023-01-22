package ru.kolodkin.telegrambot.bot.handler;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.kolodkin.telegrambot.dao.*;
import ru.kolodkin.telegrambot.domain.*;
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
    ConverterStateDAO converterStateDAO;
    GlobalStateDAO globalStateDAO;
    ScheduleDAO scheduleDAO;
    RedmineStateDAO redmineStateDAO;
    IssueService issueService;
    ProjectService projectService;
    UserService userService;

    public BotApiMethod<?> process(final Message message) {
        val user = userDAO.findByUserId(message.getFrom().getId());
        if (user.getId() != message.getFrom().getId()) {
            throw new RuntimeException();
        }

        if (user.getBotState() == REDMINE) {
            return processRedmine(globalStateDAO.findByUserId(user.getId()), message);
        }

        if (user.getBotState() == SCHEDULE) {
            return processSchedule(scheduleDAO.findByUserId(user.getId()), message);
        }

        if (user.getBotState() == CONVERTER) {
            return processConverter(converterStateDAO.findByUserId(user.getId()), message);
        }

        throw new RuntimeException();
    }

    private BotApiMethod<?> processRedmine(final GlobalState globalState, final Message message) {
        return switch (globalState.getGlobalRedmineBotState()) {
            case USER -> null;
            case ISSUE -> null;
            case PROJECT -> null;
            default -> throw new RuntimeException();
        };
    }

    private BotApiMethod<?> processSchedule(final ScheduleState scheduleState, final Message message) {
        return null; // TODO: 22.01.2023 расписание вятгу
    }

    private BotApiMethod<?> processConverter(final ConverterState converterState, final Message message) {
        return null; // TODO: 22.01.2023 конвертер файлов
    }

    private BotApiMethod<?> transitionForUserRedmine(final RedmineState redmineState, final Message message) {
        return switch (redmineState.getRedmineUserBotState()) {
            case START_CREATE -> userService.startCreateUser(redmineState, message);
            case CHOICE_NAME -> null;
            case CHECK -> null;
            case SAVE -> null;
            default -> throw new RuntimeException();
        };
    }

    private BotApiMethod<?> transitionForIssueRedmine(final RedmineState redmineState, final Message message) {
        return switch (redmineState.getRedmineIssueBotState()) {
            case START_CREATE -> issueService.startCreateIssue(redmineState, message);
            case CHOICE_NAME -> null;
            case CHECK -> null;
            case SAVE -> null;
            default -> throw new RuntimeException();
        };
    }

    private BotApiMethod<?> transitionForProjectRedmine(final RedmineState redmineState, final Message message) {
        return switch (redmineState.getRedmineProjectBotState()) {
            case START_CREATE -> projectService.startCreateProject(redmineState, message);
            case CHOICE_NAME -> null;
            case CHECK -> null;
            case SAVE -> null;
            default -> throw new RuntimeException();
        };
    }
}
