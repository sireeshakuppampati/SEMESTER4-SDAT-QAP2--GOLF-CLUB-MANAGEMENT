package com.golfclub.golfclubmanagement.repositories;

import com.golfclub.golfclubmanagement.models.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Members, Long> {
    // You can add custom query methods here if needed
    //MEMBER REPOSITORY
}
