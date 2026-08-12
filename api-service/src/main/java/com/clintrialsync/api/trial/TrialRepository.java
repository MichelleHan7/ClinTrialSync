package com.clintrialsync.api.trial;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TrialRepository extends JpaRepository<Trial, UUID> {

    boolean existsByTrialCode(String trialCode);

    List<Trial> findAllByOrderByCreatedAtDesc();
}