package com.streakify.service;

import com.streakify.dto.DashboardHabitStreakDTO;
import com.streakify.dto.DashboardResponseDTO;
import com.streakify.dto.StreakResponseDTO;
import com.streakify.model.Habit;
import com.streakify.repository.HabitLogRepository;
import com.streakify.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DashboardService {

    private final HabitRepository habitRepository;
    private final HabitLogRepository habitLogRepository;
    private final StreakService streakService;

    public DashboardService(
            HabitRepository habitRepository,
            HabitLogRepository habitLogRepository,
            StreakService streakService) {

        this.habitRepository = habitRepository;
        this.habitLogRepository = habitLogRepository;
        this.streakService = streakService;
    }

    public DashboardResponseDTO getDashboard(Long userId) {

        LocalDate today = LocalDate.now();

        // 1️⃣ Total habits
        int totalHabits = habitRepository.countByUserId(userId);

        // 2️⃣ Active habits (same as total for now)
        int activeHabits = totalHabits;

        // 3️⃣ Completed today
        int completedToday = (int)
                habitLogRepository
                        .countByHabit_User_IdAndLogDateAndCompletedTrue(userId, today);

        // 4️⃣ Streak details per habit
        List<DashboardHabitStreakDTO> currentStreaks =
                habitRepository.findByUserId(userId)
                        .stream()
                        .map(habit -> {
                            StreakResponseDTO streak =
                                    streakService.getStreak(habit.getId());

                            return new DashboardHabitStreakDTO(
                                    habit.getName(),
                                    streak.getCurrentStreak(),
                                    streak.getLongestStreak()
                            );
                        })
                        .toList();

        // 5️⃣ Consistency score
        int consistencyScore =
                totalHabits == 0 ? 0 :
                        (completedToday * 100) / totalHabits;

        return new DashboardResponseDTO(
                totalHabits,
                activeHabits,
                completedToday,
                currentStreaks,
                consistencyScore
        );
    }
}