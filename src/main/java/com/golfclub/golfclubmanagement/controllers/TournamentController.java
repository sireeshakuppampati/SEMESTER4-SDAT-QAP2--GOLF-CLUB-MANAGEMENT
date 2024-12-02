package com.golfclub.golfclubmanagement.controllers;

import com.golfclub.golfclubmanagement.dto.TournamentDTO;
import com.golfclub.golfclubmanagement.models.Tournament;
import com.golfclub.golfclubmanagement.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    private final TournamentService tournamentService;

    @Autowired
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    // Get all tournaments
    @GetMapping
    public ResponseEntity<List<TournamentDTO>> getAllTournaments() {
        return ResponseEntity.ok(tournamentService.getAllTournaments());
    }

    // Get a tournament by ID
    @GetMapping("/{id}")
    public ResponseEntity<TournamentDTO> getTournamentById(@PathVariable Long id) {
        return ResponseEntity.ok(tournamentService.getTournamentById(id));
    }

    // Add a new tournament
    @PostMapping
    public ResponseEntity<Tournament> addTournament(@RequestBody Tournament tournament) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tournamentService.addTournament(tournament));
    }

    // Add a member to a tournament
    @PostMapping("/{tournamentId}/add-member/{memberId}")
    public ResponseEntity<TournamentDTO> addMemberToTournament(
            @PathVariable Long tournamentId,
            @PathVariable Long memberId) {
        return ResponseEntity.ok(tournamentService.addMemberToTournament(tournamentId, memberId));
    }

    // Delete a tournament
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTournament(@PathVariable Long id) {
        tournamentService.deleteTournament(id);
        return ResponseEntity.noContent().build();
    }
}
