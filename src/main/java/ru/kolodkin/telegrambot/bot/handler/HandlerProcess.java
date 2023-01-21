package ru.kolodkin.telegrambot.bot.handler;

import org.telegram.telegrambots.meta.api.interfaces.BotApiObject;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;

public interface HandlerProcess <T> {
    BotApiMethod<?> process(T apiObject);
}
