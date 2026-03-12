package com.streakify.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DashboardHabitStreakDTO {


        private String habitName;
        private int currentStreak;
        private int longestStreak;

        public DashboardHabitStreakDTO(String habitName, int currentStreak, int longestStreak) {
            this.habitName = habitName;
            this.currentStreak = currentStreak;
            this.longestStreak = longestStreak;
        }


    }

