package ru.kolodkin.telegrambot.config;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import ru.kolodkin.telegrambot.model.TelegramBot;
import ru.kolodkin.telegrambot.model.TelegramFacade;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BotConfig {
    final TelegramBotConfig telegramBotConfig;

    public BotConfig(TelegramBotConfig telegramBotConfig) {
        this.telegramBotConfig = telegramBotConfig;
    }

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder()
                .url(telegramBotConfig.getWebHookPath())
                .build();
    }

    @Bean
    public TelegramBot getWebhookBot(SetWebhook webhook, TelegramFacade telegramFacade) {
        TelegramBot telegramBot = new TelegramBot(telegramFacade, webhook);
        telegramBot.setBotPath(telegramBotConfig.getWebHookPath());
        telegramBot.setBotToken(telegramBotConfig.getBotToken());
        telegramBot.setBotUsername(telegramBotConfig.getBotUserName());
        return telegramBot;
    }
}
