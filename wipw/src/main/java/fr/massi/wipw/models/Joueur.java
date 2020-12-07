package fr.massi.wipw.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "joueur")
@Access(AccessType.FIELD)
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_joueur;
    private String nom;
    private String prenom;
    private Date date_naissance;
    private String url_image;
    private String nationnalite;
    private String surnom;
    private Date date_debut;
    private Date date_fin;

    @OneToMany(mappedBy = "joueur")
    @JsonIgnore
    private List<Joue> joues;

    @ManyToMany(mappedBy = "joueursDisp")
    @JsonIgnore
    private List<QuestionSimple> joueur_disp;


    public List<Joue> getJoues() {
        return joues;
    }

    public void setJoues(List<Joue> joues) {
        this.joues = joues;
    }

    public void setId_joueur(long id_joueur) {
        this.id_joueur = id_joueur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public void setNationnalite(String nationnalite) {
        this.nationnalite = nationnalite;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public long getId_joueur() {
        return id_joueur;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public String getUrl_image() {
        return url_image;
    }

    public String getNationnalite() {
        return nationnalite;
    }

    public String getSurnom() {
        return surnom;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }
}
