package com.example.blog.osiv.service;

import com.example.blog.osiv.dto.TeamRequest;
import com.example.blog.osiv.entity.Member;
import com.example.blog.osiv.entity.Team;
import com.example.blog.osiv.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final MemberRepository memberRepository;

    @Transactional
    public void createTeam(TeamRequest teamRequest) {
        Long id = teamRequest.getId();
        Member member = memberRepository.findById(id)
                .orElseThrow();

        Set<Team> teams = teamRequest.getTeams()
                .stream()
                .map(Team::of)
                .collect(Collectors.toSet());

        member.createTeam(teams);
    }

    @Transactional
    public Set<Team> getTeam(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow();
        Set<Team> teams = member.getTeams();
        
        return teams;
    }

}
