package fr.massi.wipw.repositories;

import fr.massi.wipw.models.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {
}
