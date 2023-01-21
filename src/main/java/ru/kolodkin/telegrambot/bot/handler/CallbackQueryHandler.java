package ru.kolodkin.telegrambot.bot.handler;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

public class CallbackQueryHandler implements HandlerProcess<CallbackQuery> {
    public BotApiMethod<?> process(final CallbackQuery callbackQuery) {
        return null;
    }
}
