package com.example.fifotech.services;

import com.example.fifotech.entity.JobPosting;
import com.example.fifotech.entity.Team;
import com.example.fifotech.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    //    create
    public Team createNewTeamMember(Team team) {
        return teamRepository.save(team);
    }

    // show from db to website
    public List<Team> getAllTeamMember() {
        return (List<Team>) teamRepository.findAll();

    }
    // delete by id
    public void deleteTeamMember(Integer id) {
        teamRepository.deleteById(id);
    }

    // edit
    public Team getTeamMemberById(Integer id) {
        return teamRepository.findById(id).get();
    }

}
