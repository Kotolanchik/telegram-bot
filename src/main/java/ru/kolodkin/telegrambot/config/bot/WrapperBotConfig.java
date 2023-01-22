package ru.kolodkin.telegrambot.config.bot;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Component
@FieldDefaults(level = PRIVATE)
@ConfigurationProperties(prefix = "telegram-bot")
public class WrapperBotConfig {
    String name;
    String token;
    String webhook;
    String url;
}
