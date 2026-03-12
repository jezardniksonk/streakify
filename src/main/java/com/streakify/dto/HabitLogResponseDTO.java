package com.streakify.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class HabitLogResponseDTO {

    private Long id;
    private Long habitId;
    private LocalDate logDate;
    private Boolean completed;
    private String weeklyStatus;
}