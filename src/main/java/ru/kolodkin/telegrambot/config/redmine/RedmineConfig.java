package ru.kolodkin.telegrambot.config.redmine;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "redmine.api")
public class RedmineConfig {
    String uri;
    String key;
}
