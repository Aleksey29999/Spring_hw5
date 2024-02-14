package com.example.Spring_hw5.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data  // добавление к ломбоку
@Entity  // блок JPA

@Table(name = "tasks") // наименование таблицы
public class Task {


    public enum TaskStatus {NOT_STARTED, IN_PROGRESS, COMPLETED;} // тип данных с набором констант

    @jakarta.persistence.Id
//    Создание id с автозаполнение и чередованием
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//создание столбцов таблицы
    @Column(nullable = false)
    private String description;
    @Column
    private TaskStatus status;
    @Column
    private LocalDateTime data=LocalDateTime.now();


}
