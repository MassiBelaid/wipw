package fr.massi.wipw.services;

public interface AdminAuthentificationService {
    String getJWTToken(String username);
}
