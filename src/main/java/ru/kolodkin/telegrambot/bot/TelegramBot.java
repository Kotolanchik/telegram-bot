package ru.kolodkin.telegrambot.bot;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;
import ru.kolodkin.telegrambot.bot.api.TelegramFacade;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TelegramBot extends SpringWebhookBot {
    String botPath;
    String botUsername;
    String botToken;
    TelegramFacade telegramFacade;

    public TelegramBot(TelegramFacade telegramFacade, DefaultBotOptions options, SetWebhook webhook) {
        super(options, webhook);
        this.telegramFacade = telegramFacade;
    }

    public TelegramBot(TelegramFacade telegramFacade, SetWebhook webhook) {
        super(webhook);
        this.telegramFacade = telegramFacade;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        if (update == null) {
            throw new RuntimeException();
        }

        return telegramFacade.handleUpdate(update);
    }
}
