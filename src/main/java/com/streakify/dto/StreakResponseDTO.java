package com.streakify.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StreakResponseDTO {

    private Long habitId;
    private int currentStreak;
    private int longestStreak;


}