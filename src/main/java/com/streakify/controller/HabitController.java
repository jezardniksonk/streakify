package com.streakify.controller;

import com.streakify.dto.HabitRequestDTO;
import com.streakify.dto.HabitResponseDTO;
import com.streakify.service.HabitService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    // POST /habits
    @PostMapping("/habits")
    public ResponseEntity<HabitResponseDTO> createHabit(
            @RequestBody @Valid HabitRequestDTO dto) {

        return new ResponseEntity<>(
                habitService.createHabit(dto),
                HttpStatus.CREATED
        );
    }

    // GET /users/{userId}/habits
    @GetMapping("/users/{userId}/habits")
    public ResponseEntity<List<HabitResponseDTO>> getHabitsByUser(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                habitService.getHabitsByUser(userId)
        );
    }

    // DELETE /habits/{id}
    @DeleteMapping("/habits/{id}")
    public String deleteHabit(@PathVariable Long id) {
        habitService.deleteHabit(id);
        return "Habit deleted Successfully";
    }
}