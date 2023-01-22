package ru.kolodkin.telegrambot.domain;

import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.kolodkin.telegrambot.enums.redmine.GlobalRedmineBotState;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@Table(name = "global_state")
@FieldDefaults(level = PRIVATE)
public class GlobalState {
    @Id
    private long id;
    @Column(name = "global_redmine_bot_state")
    GlobalRedmineBotState globalRedmineBotState;
    @MapsId
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
