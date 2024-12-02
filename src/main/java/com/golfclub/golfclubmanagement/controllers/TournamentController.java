package com.golfclub.golfclubmanagement.controllers;

import com.golfclub.golfclubmanagement.models.Tournament;
import com.golfclub.golfclubmanagement.services.TournamentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    // GET all tournaments
    @GetMapping
    public ResponseEntity<List<Tournament>> getAllTournaments() {
        List<Tournament> tournaments = tournamentService.getAllTournaments();
        if (tournaments.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tournaments);
    }

    // GET a specific tournament by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getTournamentById(@PathVariable Long id) {
        Tournament tournament = tournamentService.getTournamentById(id);
        if (tournament == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tournament with ID " + id + " not found.");
        }
        return ResponseEntity.ok(tournament);
    }

    // POST - Add a new tournament
    @PostMapping
    public ResponseEntity<?> addTournament(@RequestBody Tournament tournament) {
        try {
            Tournament createdTournament = tournamentService.addTournament(tournament);
            return new ResponseEntity<>(createdTournament, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    // DELETE - Remove a tournament by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTournament(@PathVariable Long id) {
        Tournament tournament = tournamentService.getTournamentById(id);
        if (tournament == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tournament with ID " + id + " not found.");
        }
        try {
            tournamentService.deleteTournament(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}
