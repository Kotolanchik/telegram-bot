package ru.kolodkin.telegrambot.config.bot;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import ru.kolodkin.telegrambot.bot.TelegramBot;
import ru.kolodkin.telegrambot.bot.api.TelegramFacade;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BotConfig {
    final WrapperBotConfig wrapperBotConfig;

    public BotConfig(WrapperBotConfig wrapperBotConfig) {
        this.wrapperBotConfig = wrapperBotConfig;
    }

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder()
                .url(wrapperBotConfig.getWebHookPath())
                .build();
    }

    @Bean
    public TelegramBot getWebhookBot(SetWebhook webhook, TelegramFacade telegramFacade) {
        TelegramBot telegramBot = new TelegramBot(telegramFacade, webhook);
        telegramBot.setBotPath(wrapperBotConfig.getWebHookPath());
        telegramBot.setBotToken(wrapperBotConfig.getBotToken());
        telegramBot.setBotUsername(wrapperBotConfig.getBotUserName());
        return telegramBot;
    }
}
