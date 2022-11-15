package com.example.blog.osiv.repository;

import com.example.blog.osiv.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
