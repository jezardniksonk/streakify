package com.streakify.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HabitResponseDTO {

    private Long id;
    private String name;
    private Integer targetDaysPerWeek;
    private LocalDateTime createdAt;
}