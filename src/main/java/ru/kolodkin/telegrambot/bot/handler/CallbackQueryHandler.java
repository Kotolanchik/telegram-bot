package ru.kolodkin.telegrambot.bot.handler;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import static lombok.AccessLevel.PRIVATE;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class CallbackQueryHandler implements HandlerProcess<CallbackQuery> {

    public BotApiMethod<?> process(final CallbackQuery callbackQuery) {
        return null;
    }
}
