package fr.massi.wipw.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "question")
@Access(AccessType.FIELD)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_equipe;

    private String enonce;
    private String textReponse;


    public void setId_equipe(long id_equipe) {
        this.id_equipe = id_equipe;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public void setTextReponse(String textReponse) {
        this.textReponse = textReponse;
    }

    public long getId_equipe() {
        return id_equipe;
    }

    public String getEnonce() {
        return enonce;
    }

    public String getTextReponse() {
        return textReponse;
    }
}
