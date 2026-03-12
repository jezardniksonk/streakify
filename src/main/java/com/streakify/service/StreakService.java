package com.streakify.service;

import com.streakify.dto.StreakResponseDTO;
import com.streakify.exception.ResourceNotFoundException;
import com.streakify.model.Habit;
import com.streakify.model.HabitLog;
import com.streakify.repository.HabitLogRepository;
import com.streakify.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StreakService {

    private final HabitRepository habitRepository;
    private final HabitLogRepository habitLogRepository;

    public StreakService(HabitRepository habitRepository,
                         HabitLogRepository habitLogRepository) {
        this.habitRepository = habitRepository;
        this.habitLogRepository = habitLogRepository;
    }

    // 🔥 THIS is where your logic goes
    public StreakResponseDTO getStreak(Long habitId) {

        Habit habit = habitRepository.findById(habitId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Habit not found"));

        // Fetch all completed logs for this habit
        Set<LocalDate> completedDates =
                habitLogRepository.findByHabitIdAndCompletedTrue(habitId)
                        .stream()
                        .map(HabitLog::getLogDate)
                        .collect(Collectors.toSet());

        LocalDate today = LocalDate.now();

        // ✅ YOUR LOGIC STARTS HERE
        LocalDate startDate =
                completedDates.contains(today)
                        ? today
                        : today.minusDays(1);

        int currentStreak = 0;

        while (completedDates.contains(startDate)) {
            currentStreak++;
            startDate = startDate.minusDays(1);
        }

        // 🔹 Longest streak calculation (simple version)
        int longestStreak = calculateLongestStreak(completedDates);

        return new StreakResponseDTO(
                habitId,
                currentStreak,
                longestStreak
        );
    }

    // Helper method
    private int calculateLongestStreak(Set<LocalDate> dates) {
        int longest = 0;

        for (LocalDate date : dates) {
            int streak = 1;
            LocalDate prev = date.minusDays(1);

            while (dates.contains(prev)) {
                streak++;
                prev = prev.minusDays(1);
            }

            longest = Math.max(longest, streak);
        }

        return longest;
    }
}