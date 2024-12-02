package com.golfclub.golfclubmanagement.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.golfclub.golfclubmanagement.models.Members;
import com.golfclub.golfclubmanagement.services.MemberService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/members") // Base path for member-related actions
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // Display all members (GET endpoint)
    @GetMapping
    public ResponseEntity<List<Members>> getMembers() {
        List<Members> membersList = memberService.getAllMembers(); // Fetch data from service
        if (membersList.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content if no members found
        }
        return ResponseEntity.ok(membersList); // 200 OK with the list of members
    }
//Add anew member
    // Add a new member (POST endpoint)
    @PostMapping
    public ResponseEntity<?> addMember(@Valid @RequestBody Members members) {
        try {
            Members createdMember = memberService.addMember(members);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdMember); // 201 Created
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error creating member: " + e.getMessage()); // 400 Bad Request
        }
    }

    // Get a specific member by ID (GET endpoint)
    @GetMapping("/{id}")
    public ResponseEntity<?> getMemberById(@PathVariable Long id) {
        Members member = memberService.getMemberById(id);
        if (member == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Member with ID " + id + " not found."); // 404 Not Found
        }
        return ResponseEntity.ok(member); // 200 OK with the member data
    }

    // Update a specific member by ID (PUT endpoint)
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMember(@PathVariable Long id, @Valid @RequestBody Members updatedMember) {
        Members existingMember = memberService.getMemberById(id);
        if (existingMember == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Member with ID " + id + " not found."); // 404 Not Found
        }
        try {
            Members savedMember = memberService.updateMember(id, updatedMember);
            return ResponseEntity.ok(savedMember); // 200 OK with the updated member
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating member: " + e.getMessage()); // 500 Internal Server Error
        }
    }

    // Delete a specific member by ID (DELETE endpoint)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable Long id) {
        Members member = memberService.getMemberById(id);
        if (member == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Member with ID " + id + " not found."); // 404 Not Found
        }
        try {
            memberService.deleteMember(id);
            return ResponseEntity.noContent().build(); // 204 No Content on successful deletion
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting member: " + e.getMessage()); // 500 Internal Server Error
        }
    }
}
