package com.golfclub.golfclubmanagement.services;

import com.golfclub.golfclubmanagement.dto.MemberDTO;
import com.golfclub.golfclubmanagement.dto.TournamentDTO;
import com.golfclub.golfclubmanagement.models.Members;
import com.golfclub.golfclubmanagement.models.Tournament;
import com.golfclub.golfclubmanagement.repositories.MemberRepository;
import com.golfclub.golfclubmanagement.repositories.TournamentRepository;
import com.golfclub.golfclubmanagement.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository, MemberRepository memberRepository) {
        this.tournamentRepository = tournamentRepository;
        this.memberRepository = memberRepository;
    }

    public List<TournamentDTO> getAllTournaments() {
        return tournamentRepository.findAll().stream()
                .map(tournament -> {
                    List<MemberDTO> memberDTOs = tournament.getMembers().stream()
                            .map(member -> new MemberDTO(member.getId(), member.getName(), member.getEmail()))
                            .collect(Collectors.toList());

                    return new TournamentDTO(
                            tournament.getId(),
                            tournament.getStartDate(),
                            tournament.getEndDate(),
                            tournament.getLocation(),
                            tournament.getEntryFee(),
                            tournament.getCashPrize(),
                            memberDTOs
                    );
                })
                .collect(Collectors.toList());
    }

    public TournamentDTO getTournamentById(Long id) {
        Tournament tournament = tournamentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tournament not found with id " + id));
        return convertToDTO(tournament);
    }

    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    @Transactional
    public TournamentDTO addMemberToTournament(Long tournamentId, Long memberId) {
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new ResourceNotFoundException("Tournament not found with id " + tournamentId));

        Members member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id " + memberId));

        if (!tournament.getMembers().contains(member)) {
            tournament.getMembers().add(member);
        }

        return convertToDTO(tournamentRepository.save(tournament));
    }

    public void deleteTournament(Long id) {
        Tournament tournament = tournamentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tournament not found with id " + id));
        tournamentRepository.delete(tournament);
    }

    private TournamentDTO convertToDTO(Tournament tournament) {
        List<MemberDTO> memberDTOs = tournament.getMembers().stream()
                .map(member -> new MemberDTO(member.getId(), member.getName(), member.getEmail()))
                .collect(Collectors.toList());

        return new TournamentDTO(
                tournament.getId(),
                tournament.getStartDate(),
                tournament.getEndDate(),
                tournament.getLocation(),
                tournament.getEntryFee(),
                tournament.getCashPrize(),
                memberDTOs
        );
    }

}

