package com.streakify.repository;

import com.streakify.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitRepository extends JpaRepository<Habit, Long> {

    // get all habits of a user
    List<Habit> findByUserId(Long userId);

    //  REQUIRED for dashboard
    int countByUserId(Long userId);
}