package fr.massi.wipw.customRepository;

import fr.massi.wipw.models.Joueur;

import java.util.List;

public interface JoueurRepositoryCustom {
    List<String> getNationalities();
    List<Joueur> getWithMultCriteres(String chaine);
    List<Joueur> getWithNationality(String nationality);
}
