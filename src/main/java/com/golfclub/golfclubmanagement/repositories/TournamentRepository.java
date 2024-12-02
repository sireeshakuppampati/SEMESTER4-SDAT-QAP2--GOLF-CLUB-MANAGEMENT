package com.golfclub.golfclubmanagement.repositories;

import com.golfclub.golfclubmanagement.models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    // Additional custom queries can be added here if necessary
}
