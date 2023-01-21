package ru.kolodkin.telegrambot.model;

import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButtonPollType;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class Button {
    @NonNull String text;
    Boolean requestContact;
    Boolean requestLocation;
    KeyboardButtonPollType requestPoll;
    WebAppInfo webApp;
}
