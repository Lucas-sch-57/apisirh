package com.lschiltz.apisirh.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.lschiltz.apisirh.view.TeamView;
import com.lschiltz.apisirh.view.UtilisateurView;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({UtilisateurView.class, TeamView.class})
    private Integer id;
    @JsonView({UtilisateurView.class, TeamView.class})
    private String nom;
    @JsonView({UtilisateurView.class, TeamView.class})
    private String prenom;
    @JsonView({UtilisateurView.class, TeamView.class})
    private String mail;
    @JsonView({UtilisateurView.class, TeamView.class})
    private String password;
    @JsonView({UtilisateurView.class, TeamView.class})
    private boolean isSuperAdmin;
    @Temporal(TemporalType.DATE)
    @JsonView({UtilisateurView.class, TeamView.class})
    private Date dateEmbauche;
    @ManyToOne()
    @JsonView(UtilisateurView.class)
    private Team team;

}
