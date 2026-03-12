package com.streakify.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HabitLogRequestDTO {

    private LocalDate logDate;
    private Boolean completed;
}