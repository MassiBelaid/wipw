package fr.massi.wipw.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "admin")
@Access(AccessType.FIELD)
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_admin;
    private String email;
    private String password;


    public void setId_admin(long id_admin) {
        this.id_admin = id_admin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId_admin() {
        return id_admin;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
