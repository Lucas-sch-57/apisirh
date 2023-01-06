package com.lschiltz.apisirh.controller;

import com.lschiltz.apisirh.dao.TeamDao;
import com.lschiltz.apisirh.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TeamController {

    @Autowired
    TeamDao teamDao;

    @GetMapping("/team/{id}")
    public ResponseEntity<Team> getteam(@PathVariable int id){
        Optional<Team> response = teamDao.findById(id);
        if(response.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response.get(),HttpStatus.OK);
    }
    @PostMapping("/team/create")
    public ResponseEntity<Team> create(@RequestBody Team team){
        Team teamExistant = null;
        if(team.getId() != null){
            System.out.println("ok");
            teamExistant = teamDao.findById(team.getId()).orElse(null);

            if(teamExistant == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            teamDao.save(team);
            return new ResponseEntity<>(team,HttpStatus.OK);
        }
        teamDao.save(team);
        return new ResponseEntity<>(team,HttpStatus.CREATED);
    }
}
