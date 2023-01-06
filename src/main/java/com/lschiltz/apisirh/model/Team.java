package com.lschiltz.apisirh.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.lschiltz.apisirh.view.TeamView;
import com.lschiltz.apisirh.view.UtilisateurView;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({UtilisateurView.class, TeamView.class})
    private Integer id;
    @JsonView({UtilisateurView.class, TeamView.class})

    private String nom;

    @OneToMany(mappedBy = "team")
    @JsonView(TeamView.class)
    Set<Utilisateur> listeUtilisateur = new HashSet<>();
}
