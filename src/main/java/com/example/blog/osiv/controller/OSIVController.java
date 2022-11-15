package com.example.blog.osiv.controller;

import com.example.blog.osiv.dto.MemberRequest;
import com.example.blog.osiv.dto.TeamRequest;
import com.example.blog.osiv.entity.Team;
import com.example.blog.osiv.service.MemberService;
import com.example.blog.osiv.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/osiv/")
public class OSIVController {

    private final MemberService memberService;
    private final TeamService teamService;

    @PostMapping("member")
    public void createMember(@RequestBody MemberRequest memberRequest) {
        memberService.createMember(memberRequest);
    }

    @PostMapping("team")
    public void createTeam(@RequestBody TeamRequest teamRequest) {
        teamService.createTeam(teamRequest);
    }

    @GetMapping("team/{id}")
    public Set<Team> getTeam(@PathVariable Long id) {
        Set<Team> teams = teamService.getTeam(id);
        return teams;
    }

}
