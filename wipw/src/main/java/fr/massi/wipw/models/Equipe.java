package fr.massi.wipw.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "equipe")
@Access(AccessType.FIELD)
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_equipe;

    private String nom;
    private String type;
    private String championnat;
    private Date date_creation;
    private String nom_stade;

    @OneToMany(mappedBy = "equipe")
    private List<Joue> joues;


    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public void setNom_stade(String nom_stade) {
        this.nom_stade = nom_stade;
    }

    /*public List<Joue> getJoues() {
        return joues;
    }*/

    public void setJoues(List<Joue> joues) {
        this.joues = joues;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public String getNom_stade() {
        return nom_stade;
    }


    public void setId_equipe(long id_equipe) {
        this.id_equipe = id_equipe;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setChampionnat(String championnat) {
        this.championnat = championnat;
    }

    public long getId_equipe() {
        return id_equipe;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public String getChampionnat() {
        return championnat;
    }
}
