package fr.massi.wipw.repositories;

import fr.massi.wipw.customRepository.JoueurRepositoryCustom;
import fr.massi.wipw.models.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JoueurRepository extends JpaRepository<Joueur, Long>, JoueurRepositoryCustom {
    public List<Joueur> findByNom(String nom);
}
