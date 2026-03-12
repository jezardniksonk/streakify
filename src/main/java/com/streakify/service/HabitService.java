package com.streakify.service;

import com.streakify.dto.HabitRequestDTO;
import com.streakify.dto.HabitResponseDTO;
import com.streakify.exception.ResourceNotFoundException;
import com.streakify.model.Habit;
import com.streakify.model.User;
import com.streakify.repository.HabitRepository;
import com.streakify.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {

    private final HabitRepository habitRepository;
    private final UserRepository userRepository;

    public HabitService(HabitRepository habitRepository,
                        UserRepository userRepository) {
        this.habitRepository = habitRepository;
        this.userRepository = userRepository;
    }

    // POST /habits
    public HabitResponseDTO createHabit(HabitRequestDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id " + dto.getUserId()));

        Habit habit = new Habit();
        habit.setName(dto.getName());
        habit.setTargetDaysPerWeek(dto.getTargetDaysPerWeek());
        habit.setUser(user);

        Habit saved = habitRepository.save(habit);

        return mapToResponse(saved);
    }

    // GET /users/{userId}/habits
    public List<HabitResponseDTO> getHabitsByUser(Long userId) {

        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id " + userId);
        }

        return habitRepository.findByUserId(userId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // DELETE /habits/{id}
    public void deleteHabit(Long habitId) {

        if (!habitRepository.existsById(habitId)) {
            throw new ResourceNotFoundException("Habit not found with id " + habitId);
        }

        habitRepository.deleteById(habitId);

    }

    // Helper mapper
    private HabitResponseDTO mapToResponse(Habit habit) {
        return new HabitResponseDTO(
                habit.getId(),
                habit.getName(),
                habit.getTargetDaysPerWeek(),
                habit.getCreatedAt().atStartOfDay()
        );
    }
}