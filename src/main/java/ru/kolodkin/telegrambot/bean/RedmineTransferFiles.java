package ru.kolodkin.telegrambot.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@FieldDefaults(level = PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class RedmineTransferFiles {
    List<RedmineTransferFile> files = new ArrayList<>();
}
