package com.example.sympathy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
