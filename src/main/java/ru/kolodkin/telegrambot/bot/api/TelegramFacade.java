package ru.kolodkin.telegrambot.bot.api;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.kolodkin.telegrambot.bot.handler.CallbackQueryHandler;
import ru.kolodkin.telegrambot.bot.handler.EditedMessageHandler;
import ru.kolodkin.telegrambot.bot.handler.MessageHandler;

import static lombok.AccessLevel.PRIVATE;

@Component
@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TelegramFacade {
    CallbackQueryHandler callbackQueryHandler;
    EditedMessageHandler editedMessageHandler;
    MessageHandler messageHandler;

    public BotApiMethod<?> handleUpdate(Update update) {
        if (update.hasCallbackQuery()) {
            return callbackQueryHandler.process(update.getCallbackQuery());
        }

        if (update.hasEditedMessage()) {
            return editedMessageHandler.process(update.getEditedMessage());
        }

        if (update.hasMessage()) {
            return messageHandler.process(update.getMessage());

        }

        throw new RuntimeException();
    }
}
