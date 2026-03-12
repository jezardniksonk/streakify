package com.streakify.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public class DashboardResponseDTO {

    private int totalHabits;
    private int activeHabits;
    private int completedToday;
    private List<DashboardHabitStreakDTO> currentStreaks;
    private int consistencyScore;

    public DashboardResponseDTO(
            int totalHabits,
            int activeHabits,
            int completedToday,
            List<DashboardHabitStreakDTO> currentStreaks,
            int consistencyScore) {

        this.totalHabits = totalHabits;
        this.activeHabits = activeHabits;
        this.completedToday = completedToday;
        this.currentStreaks = currentStreaks;
        this.consistencyScore = consistencyScore;
    }


}