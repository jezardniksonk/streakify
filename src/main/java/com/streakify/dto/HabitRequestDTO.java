package com.streakify.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HabitRequestDTO {

    private Long userId;
    private String name;
    private Integer targetDaysPerWeek;
}
