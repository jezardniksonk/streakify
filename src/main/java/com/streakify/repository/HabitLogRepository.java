package com.streakify.repository;

import com.streakify.model.HabitLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HabitLogRepository extends JpaRepository<HabitLog, Long> {

    List<HabitLog> findByHabitId(Long habitId);
    List<HabitLog> findByHabitIdAndCompletedTrue(Long habitId);
    Optional<HabitLog> findByHabitIdAndLogDate(Long habitId, LocalDate date);

    // ✅ REQUIRED for dashboard
    long countByHabit_User_IdAndLogDateAndCompletedTrue(
            Long userId,
            LocalDate logDate
    );
}