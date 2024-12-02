package com.golfclub.golfclubmanagement.services;

import com.golfclub.golfclubmanagement.models.Tournament;
import com.golfclub.golfclubmanagement.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    // Get all tournaments
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    // Add a new tournament
    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    // Get a tournament by ID
    public Tournament getTournamentById(Long id) {
        Optional<Tournament> tournament = tournamentRepository.findById(id);
        return tournament.orElse(null);
    }

    // Delete a tournament by ID
    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }
}
