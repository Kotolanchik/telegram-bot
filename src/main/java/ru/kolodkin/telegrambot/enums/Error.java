package ru.kolodkin.telegrambot.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum Error {
    COULD_NOT_RESPONSE_FROM_SERVER("Не удалось получить ответ от сервера.");

    String message;
}
