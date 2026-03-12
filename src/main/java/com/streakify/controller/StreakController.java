package com.streakify.controller;

import com.streakify.dto.StreakResponseDTO;
import com.streakify.service.StreakService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habits")
public class StreakController {

    private final StreakService streakService;

    public StreakController(StreakService streakService) {
        this.streakService = streakService;
    }

    // GET /habits/{habitId}/streak
    @GetMapping("/{habitId}/streak")
    public ResponseEntity<StreakResponseDTO> getStreak(
            @PathVariable Long habitId) {

        return ResponseEntity.ok(
                streakService.getStreak(habitId)
        );
    }
}