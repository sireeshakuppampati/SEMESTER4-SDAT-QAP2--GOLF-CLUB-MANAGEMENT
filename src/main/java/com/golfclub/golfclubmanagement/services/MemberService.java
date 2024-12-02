package com.golfclub.golfclubmanagement.services;

import com.golfclub.golfclubmanagement.models.Members;
import com.golfclub.golfclubmanagement.repositories.MemberRepository;
import com.golfclub.golfclubmanagement.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // Get all members
    public List<Members> getAllMembers() {
        return memberRepository.findAll();
    }

    // Add a new member
    public Members addMember(Members member) {
        // Perform validation if necessary (e.g., duplicate email check)
        return memberRepository.save(member);
    }

    // Get a member by ID
    public Members getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member with ID " + id + " not found."));
    }

    // Update an existing member
    public Members updateMember(Long id, Members updatedMember) {
        Members existingMember = getMemberById(id); // Reuse method to check existence and fetch the member

        // Update fields
        existingMember.setName(updatedMember.getName());
        existingMember.setAddress(updatedMember.getAddress());
        existingMember.setEmail(updatedMember.getEmail());
        existingMember.setPhoneNumber(updatedMember.getPhoneNumber());
        existingMember.setStartDate(updatedMember.getStartDate());
        existingMember.setDuration(updatedMember.getDuration());

        return memberRepository.save(existingMember); // Save updated member to the database
    }

    // Delete a member by ID
    public void deleteMember(Long id) {
        Members existingMember = getMemberById(id); // Reuse method to check existence
        memberRepository.delete(existingMember);
    }
}
