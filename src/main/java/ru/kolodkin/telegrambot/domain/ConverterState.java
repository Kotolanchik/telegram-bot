package ru.kolodkin.telegrambot.domain;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@Table(name = "converter_state")
@FieldDefaults(level = PRIVATE)
public class ConverterState {
    @Id
    private long id;
    @MapsId
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
