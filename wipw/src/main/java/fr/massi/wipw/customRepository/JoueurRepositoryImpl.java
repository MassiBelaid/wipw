package fr.massi.wipw.customRepository;


import fr.massi.wipw.models.Joueur;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JoueurRepositoryImpl implements JoueurRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<String> getNationalities() {
        Query query = entityManager.createQuery("SELECT DISTINCT(nationnalite) FROM joueur");
        return query.getResultList();
    }

    @Override
    public List<Joueur> getWithMultCriteres(String chaine) {
        chaine = '%'+chaine+'%';
        Query query = entityManager.createQuery("SELECT j FROM joueur j " +
                "WHERE j.nom LIKE ?1 " +
                "OR j.prenom LIKE ?2 " +
                "OR j.nationnalite LIKE ?3 " +
                "OR j.surnom LIKE ?4 ", Joueur.class);
        query.setParameter(1,chaine);
        query.setParameter(2,chaine);
        query.setParameter(3,chaine);
        query.setParameter(4,chaine);

        return query.getResultList();
    }

    @Override
    public List<Joueur> getWithNationality(String nationality) {
        Query query = entityManager.createQuery("SELECT j FROM joueur j " +
                "WHERE j.nationnalite = ?1 ", Joueur.class);
        query.setParameter(1,nationality);

        return query.getResultList();
    }
}
