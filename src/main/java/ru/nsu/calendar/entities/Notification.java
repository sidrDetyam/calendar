package ru.nsu.calendar.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    @GenericGenerator(name = "pet_seq", strategy = "increment")
    private Long id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "count_of_repeat")
    private Short countOfRepeat;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
