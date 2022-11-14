package ru.kolodkin.telegrambot.model;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TelegramFacade {
    public BotApiMethod<?> handleUpdate(Update update) {
        SendMessage replyMessage = null;
        if (update.hasMessage() && update.getMessage().hasText()) {
            log.info(String.format(
                    "Message: %s \n User: %s\n Id: %s \n",
                    update.getMessage(),
                    update.getMessage().getFrom().getUserName(),
                    update.getMessage().getFrom().getId())
            );
            replyMessage.setText("good");
        }
        replyMessage.setText("f");
        return replyMessage;
    }


}
