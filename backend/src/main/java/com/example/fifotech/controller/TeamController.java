package com.example.fifotech.controller;

import com.example.fifotech.entity.Team;
import com.example.fifotech.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class TeamController {


    @Autowired
    private TeamService teamService;


    // create
    @PostMapping({"/postNewTeamMember"})
    public Team addNewTeamMember(@RequestBody Team team) {
        return teamService.createNewTeamMember(team);
    }

    // show
    @GetMapping({"/getAllTeamMember"})
    public List<Team> getAllTeamMember() {
        return teamService.getAllTeamMember();
    }

    ;

    // delete
    @DeleteMapping({"/deleteTeamMember/{id}"})
    public void deleteTeamMember(@PathVariable("id") Integer id) {
        teamService.deleteTeamMember(id);
    }

    //edit
    @GetMapping({"/getTeamMemberById/{id}"})
    public Team getTeamMemberById(@PathVariable("id") Integer id) {
        return teamService.getTeamMemberById(id);
    } ;

}
