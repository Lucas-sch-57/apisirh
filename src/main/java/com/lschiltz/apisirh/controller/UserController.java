package com.lschiltz.apisirh.controller;

import com.lschiltz.apisirh.dao.UserDao;
import com.lschiltz.apisirh.model.Utilisateur;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("/utilisateur/{id}")
    public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable int id){
        Optional<Utilisateur> response = userDao.findById(id);
        if(response.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response.get(),HttpStatus.OK);

    }
    @PostMapping("/utilisateur/create")
    public ResponseEntity<Utilisateur> create(@RequestBody Utilisateur user){

        Utilisateur utilisateurExistant = null;
        if(user.getId() != null){
            System.out.println("ok");
            utilisateurExistant = userDao.findById(user.getId()).orElse(null);

            if(utilisateurExistant == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            user.setPassword(PasswordHasher.hashPassword(user.getPassword()));
            userDao.save(user);
            return new ResponseEntity<>(user,HttpStatus.OK);

        }
        user.setPassword(PasswordHasher.hashPassword(user.getPassword()));
        userDao.save(user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);

    }



}
