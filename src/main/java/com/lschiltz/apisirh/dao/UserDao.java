package com.lschiltz.apisirh.dao;

import com.lschiltz.apisirh.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<Utilisateur,Integer> {
}
