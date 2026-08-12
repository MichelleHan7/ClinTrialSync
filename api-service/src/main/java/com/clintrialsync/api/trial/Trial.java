package com.clintrialsync.api.trial;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "trials")
public class Trial {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "trial_code", nullable = false, unique = true)
    private String trialCode;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phase;

    @Column(nullable = false)
    private String status;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    protected Trial() {
    }

    public Trial(
            String trialCode,
            String name,
            String phase,
            String status,
            LocalDate startDate
    ) {
        this.trialCode = trialCode;
        this.name = name;
        this.phase = phase;
        this.status = status;
        this.startDate = startDate;
    }

    @PrePersist
    void onCreate() {
        this.createdAt = Instant.now();
    }

    public UUID getId() {
        return id;
    }

    public String getTrialCode() {
        return trialCode;
    }

    public String getName() {
        return name;
    }

    public String getPhase() {
        return phase;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}