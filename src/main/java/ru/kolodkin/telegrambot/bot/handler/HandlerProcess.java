package ru.kolodkin.telegrambot.bot.handler;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;

interface HandlerProcess<T> {
    BotApiMethod<?> process(T botApiObject);

}
