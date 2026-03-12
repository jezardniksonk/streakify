package com.streakify.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "habits")
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Habit name cannot be null")
    private String name;

    @Column(name = "target_days_per_week", nullable = false)
    @NotNull(message = "Target days per week is required")
    @Min(value = 1, message = "Target days per week must be at least 1")
    @Max(value = 7, message = "Target days per week cannot exceed 7")
    private Integer targetDaysPerWeek;

    @Column(name = "created_at", updatable = false)
    private LocalDate createdAt;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // ⭐ THIS FIELD IS MISSING
    @OneToMany(
            mappedBy = "habit",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<HabitLog> habitLogs;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDate.now();
    }
}