package fr.massi.wipw.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "questionsimple")
@Access(AccessType.FIELD)
public class QuestionSimple {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_question;

    @ManyToMany
    @JoinTable(name="joueur_disp",
            joinColumns = @JoinColumn(name = "id_question"),
            inverseJoinColumns = @JoinColumn(name="id_joueur"))
    private List<Joueur> joueursDisp;

    public List<Joueur> getJoueursDisp() {
        return joueursDisp;
    }

    public void setJoueursDisp(List<Joueur> joueursDisp) {
        this.joueursDisp = joueursDisp;
    }

    private String enonce;
    private String text_reponse;


    public void setId_question(long id_question) {
        this.id_question = id_question;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public void setTextReponse(String textReponse) {
        this.text_reponse = textReponse;
    }

    public long getId_question() {
        return id_question;
    }

    public String getEnonce() {
        return enonce;
    }

    public String getTextReponse() {
        return text_reponse;
    }
}
