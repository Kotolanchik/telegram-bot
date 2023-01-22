package ru.kolodkin.telegrambot.domain;

import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.kolodkin.telegrambot.enums.redmine.BotStateProject;
import ru.kolodkin.telegrambot.enums.redmine.BotStateUser;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@Table(name = "redmine_state")
@FieldDefaults(level = PRIVATE)
public class RedmineState {
    @Id
    private long id;
    @Column(name = "redmine_user_bot_state")
    BotStateUser redmineUserBotState;
    @Column(name = "redmine_project_bot_state")
    BotStateProject redmineProjectBotState;
    @Column(name = "redmine_issue_bot_state")
    BotStateProject redmineIssueBotState;
    @MapsId
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
