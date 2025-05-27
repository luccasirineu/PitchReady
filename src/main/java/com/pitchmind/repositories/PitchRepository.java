package com.pitchmind.repositories;

import com.pitchmind.models.Pitch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PitchRepository extends JpaRepository<Pitch, Long> {
}
