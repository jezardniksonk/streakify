package com.streakify.controller;

import com.streakify.dto.HabitLogRequestDTO;
import com.streakify.dto.HabitLogResponseDTO;
import com.streakify.service.HabitLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/habits")
public class HabitLogController {

    private final HabitLogService habitLogService;

    public HabitLogController(HabitLogService habitLogService) {
        this.habitLogService = habitLogService;
    }

    // ✅ POST /habits/{habitId}/logs  (JSON BODY)
    @PostMapping("/{habitId}/logs")
    public ResponseEntity<HabitLogResponseDTO> createLog(
            @PathVariable Long habitId,
            @RequestBody HabitLogRequestDTO request) {

        HabitLogResponseDTO response =
                habitLogService.createLog(
                        habitId,
                        request.getLogDate(),
                        request.getCompleted()
                );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // PUT /habits/{habitId}/logs/{date}
    @PutMapping("/{habitId}/logs/{date}")
    public ResponseEntity<HabitLogResponseDTO> updateLog(
            @PathVariable Long habitId,
            @PathVariable LocalDate date,
            @RequestBody HabitLogRequestDTO dto) {

        return ResponseEntity.ok(
                habitLogService.updateLog(habitId, date, dto)
        );
    }

    // GET /habits/{habitId}/logs
    @GetMapping("/{habitId}/logs")
    public ResponseEntity<List<HabitLogResponseDTO>> getLogs(
            @PathVariable Long habitId) {

        return ResponseEntity.ok(
                habitLogService.getLogsByHabit(habitId)
        );
    }
}