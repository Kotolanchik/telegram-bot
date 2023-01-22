package ru.kolodkin.telegrambot.domain;

import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.kolodkin.telegrambot.enums.BotState;
import ru.kolodkin.telegrambot.enums.redmine.BotStateProject;
import ru.kolodkin.telegrambot.enums.redmine.BotStateUser;
import ru.kolodkin.telegrambot.enums.redmine.GlobalRedmineBotState;

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
    @Column(name = "global_redmine_bot_state")
    GlobalRedmineBotState globalRedmineBotState;
    @Column(name = "redmine_user_bot_state")
    BotStateUser redmineUserBotState;
    @Column(name = "redmine_project_bot_state")
    BotStateProject redmineProjectBotState;
    @Column(name = "redmine_issue_bot_state")
    BotStateProject redmineIssueBotState;
    // TODO: 22.01.2023 вынести состояния в другую сущность
}
