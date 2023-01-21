package ru.kolodkin.telegrambot.domain;

import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.kolodkin.telegrambot.enums.BotState;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@Table(name = "users")
@FieldDefaults(level = PRIVATE)
public class User {
    @Id
    @Column(name = "id")
    long id;
    @Column(name = "username")
    long username;
    @Column(name = "bot_state")
    BotState botState;
}
