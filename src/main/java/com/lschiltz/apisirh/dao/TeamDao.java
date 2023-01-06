package com.lschiltz.apisirh.dao;

import com.lschiltz.apisirh.model.Team;
import com.lschiltz.apisirh.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDao extends JpaRepository<Team,Integer> {
}
