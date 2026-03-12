package com.streakify.service;

import com.streakify.dto.HabitLogRequestDTO;
import com.streakify.dto.HabitLogResponseDTO;
import com.streakify.exception.BadRequestException;
import com.streakify.exception.IllegalOperationException;
import com.streakify.exception.ResourceNotFoundException;
import com.streakify.model.Habit;
import com.streakify.model.HabitLog;
import com.streakify.repository.HabitLogRepository;
import com.streakify.repository.HabitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class HabitLogService {

    private final HabitRepository habitRepository;
    private final HabitLogRepository habitLogRepository;

    public HabitLogService(HabitRepository habitRepository,
                           HabitLogRepository habitLogRepository) {
        this.habitRepository = habitRepository;
        this.habitLogRepository = habitLogRepository;
    }

    // POST /habits/{habitId}/logs

    public HabitLogResponseDTO createLog(Long habitId, LocalDate date, Boolean completed) {



        Habit habit = habitRepository.findById(habitId)
                .orElseThrow(() -> new ResourceNotFoundException("Habit not found"));

        habitLogRepository.findByHabitIdAndLogDate(habitId, date)
                .ifPresent(log -> {
                    throw new IllegalOperationException("Log already exists for this date");
                });
        if (date.isAfter(LocalDate.now())) {
            throw new IllegalOperationException("Cannot log future dates");
        }

        HabitLog log = new HabitLog();
        log.setHabit(habit);
        log.setLogDate(date);
        log.setCompleted(completed);

        HabitLog saved = habitLogRepository.save(log);

        return mapToDTO(saved);
    }

    // PUT /habits/{habitId}/logs
    @Transactional
    public HabitLogResponseDTO updateLog(Long habitId, LocalDate date, HabitLogRequestDTO dto) {
        if(date.isAfter(LocalDate.now())){
            throw new BadRequestException("Cannot log future dates");
        }
        HabitLog log = habitLogRepository
                .findByHabitIdAndLogDate(habitId, date)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Log not found"));

        log.setCompleted(dto.getCompleted());
        HabitLog updated =habitLogRepository.save(log);
        return mapToDTO(updated);
    }

    // GET /habits/{habitId}/logs
    public List<HabitLogResponseDTO> getLogsByHabit(Long habitId) {

        return habitLogRepository.findByHabitId(habitId)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }
    private String calculateWeeklyStatus(Habit habit) {

        List<HabitLog> logs =
                habitLogRepository.findByHabitId(habit.getId());

        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(java.time.DayOfWeek.MONDAY);
        LocalDate endOfWeek = today.with(java.time.DayOfWeek.SUNDAY);

        int completedCount = 0;

        for (HabitLog log : logs) {
            if (!log.getLogDate().isBefore(startOfWeek)
                    && !log.getLogDate().isAfter(endOfWeek)
                    && log.getCompleted()) {
                completedCount++;
            }
        }

        int target = habit.getTargetDaysPerWeek();

        if (completedCount < target) {
            return "In Progress";
        } else if (completedCount == target) {
            return "Target Achieved! ";
        } else {
            return "Target Exceeded! Keep Going!";
        }
    }

    private HabitLogResponseDTO mapToDTO(HabitLog log) {
        String weeklyStatus=calculateWeeklyStatus(log.getHabit());
        return new HabitLogResponseDTO(
                log.getId(),
                log.getHabit().getId(),
                log.getLogDate(),
                log.getCompleted(),
                weeklyStatus
        );
    }
}