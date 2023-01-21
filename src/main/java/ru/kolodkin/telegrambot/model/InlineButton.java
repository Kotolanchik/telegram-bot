package ru.kolodkin.telegrambot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.telegram.telegrambots.meta.api.objects.LoginUrl;
import org.telegram.telegrambots.meta.api.objects.games.CallbackGame;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class InlineButton {
    @NonNull String text;
    String url;
    String callbackData;
    CallbackGame callbackGame;
    String switchInlineQuery;
    String switchInlineQueryCurrentChat;
    Boolean pay;
    LoginUrl loginUrl;
    WebAppInfo webApp;
}
