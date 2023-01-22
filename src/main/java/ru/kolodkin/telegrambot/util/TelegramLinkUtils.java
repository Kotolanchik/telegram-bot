package ru.kolodkin.telegrambot.util;

import lombok.experimental.UtilityClass;

import java.net.URI;
import java.net.URISyntaxException;

@UtilityClass
public class TelegramLinkUtils {
    private final String GET_FILE = "getFile";
    private final String FILE_ID = "file_id";
    private final String BOT = "bot";
    private final String FORWARD_SLASH = "/";
    private final String QUESTION = "?";
    private final String EQUAL = "=";

    public String getBotUrl(final String url, final String token) {
        return url + FORWARD_SLASH + BOT + token;
    }

    public URI getFile(final String url, final String token, final String fileId) throws URISyntaxException {
        return new URI(url + FORWARD_SLASH + BOT + token + FORWARD_SLASH + GET_FILE + QUESTION + FILE_ID + EQUAL + fileId);
    }
}
