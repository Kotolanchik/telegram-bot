package ru.kolodkin.telegrambot.presentation;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import ru.kolodkin.telegrambot.model.Button;
import ru.kolodkin.telegrambot.model.InlineButton;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class GenerateButtonMarkup {
    public ReplyKeyboard generateMenuButtons(final List<List<Button>> rowButtons) {
        return ReplyKeyboardMarkup.builder()
                .selective(true)
                .resizeKeyboard(true)
                .oneTimeKeyboard(false)
                .keyboard(rowButtons.stream()
                        .map(buttons -> new KeyboardRow(createRowButtons(buttons)))
                        .collect(toList())
                )
                .build();
    }

    public ReplyKeyboard generateInlineMenuButtons(final List<List<InlineButton>> rowButtons) {
        return InlineKeyboardMarkup.builder()
                .keyboard(rowButtons.stream()
                        .map(this::createRowInlineButtons)
                        .collect(toList())
                )
                .build();
    }

    private List<InlineKeyboardButton> createRowInlineButtons(final List<InlineButton> buttons) {
        return buttons.stream()
                .map(this::createSingleInlineButton)
                .collect(toList());
    }

    private List<KeyboardButton> createRowButtons(final List<Button> buttons) {
        return buttons.stream()
                .map(this::createSingleButton)
                .collect(toList());
    }

    private InlineKeyboardButton createSingleInlineButton(final InlineButton button) {
        return InlineKeyboardButton.builder()
                .text(button.getText())
                .callbackData(button.getCallbackData())
                .callbackGame(button.getCallbackGame())
                .url(button.getUrl())
                .pay(button.getPay())
                .switchInlineQueryCurrentChat(button.getSwitchInlineQueryCurrentChat())
                .switchInlineQuery(button.getSwitchInlineQuery())
                .webApp(button.getWebApp())
                .build();
    }

    private KeyboardButton createSingleButton(final Button button) {
        return KeyboardButton.builder()
                .text(button.getText())
                .requestContact(button.getRequestContact())
                .requestLocation(button.getRequestLocation())
                .requestPoll(button.getRequestPoll())
                .webApp(button.getWebApp())
                .build();
    }
}
