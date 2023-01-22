package ru.kolodkin.telegrambot.service.client;

import lombok.val;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.objects.ApiResponse;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import ru.kolodkin.telegrambot.config.bot.WrapperBotConfig;
import ru.kolodkin.telegrambot.util.TelegramLinkUtils;

import java.net.URISyntaxException;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM;
import static ru.kolodkin.telegrambot.enums.Error.COULD_NOT_RESPONSE_FROM_SERVER;

@Service
public class TelegramFileClient {
    WrapperBotConfig wrapperBotConfig;
    RestTemplate restTemplate;


    public TelegramFileClient(WrapperBotConfig wrapperBotConfig) {
        this.wrapperBotConfig = wrapperBotConfig;
        this.restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(HttpClientBuilder.create().build()));
    }

    public byte[] getFileFromTelegram(final String fileId) throws URISyntaxException, TelegramApiRequestException {
        val headers = new HttpHeaders();
        headers.setAccept(singletonList(APPLICATION_OCTET_STREAM));
        return Optional.of(restTemplate.exchange(
                        getUrlPathFromTelegram(fileId),
                        HttpMethod.GET,
                        new HttpEntity<>(headers),
                        byte[].class))
                .map(HttpEntity::getBody)
                .orElseThrow(() -> new TelegramApiRequestException(COULD_NOT_RESPONSE_FROM_SERVER.getMessage()));
    }

    public String getFilePathFromTelegram(final String fileId) throws URISyntaxException, TelegramApiRequestException {
        return Optional.of(restTemplate.exchange(
                        TelegramLinkUtils.getFile(wrapperBotConfig.getUrl(), wrapperBotConfig.getToken(), fileId),
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<ApiResponse<File>>() {
                        }))
                .map(HttpEntity::getBody)
                .orElseThrow(() -> new TelegramApiRequestException(COULD_NOT_RESPONSE_FROM_SERVER.getMessage()))
                .getResult()
                .getFilePath();
    }

    public String getUrlPathFromTelegram(final String fileId) throws URISyntaxException, TelegramApiRequestException {
        return Optional.of(restTemplate.exchange(
                        TelegramLinkUtils.getFile(wrapperBotConfig.getUrl(), wrapperBotConfig.getToken(), fileId),
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<ApiResponse<File>>() {
                        }))
                .map(HttpEntity::getBody)
                .orElseThrow(() -> new TelegramApiRequestException(COULD_NOT_RESPONSE_FROM_SERVER.getMessage()))
                .getResult()
                .getFileUrl(wrapperBotConfig.getToken());
    }
}
