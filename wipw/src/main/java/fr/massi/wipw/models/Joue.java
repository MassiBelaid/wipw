package fr.massi.wipw.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "joue")
@Access(AccessType.FIELD)
public class Joue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_joue;


    @ManyToOne(fetch = FetchType.LAZY)
    private Joueur joueur;

    @ManyToOne(fetch = FetchType.LAZY)
    private Equipe equipe;

    private Date date_debut;
    private Date date_fin;

    public long getId_joue() {
        return id_joue;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public Equipe getEquipe() {
        return equipe;
    }


    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setId_joue(long id_joue) {
        this.id_joue = id_joue;
    }


}
