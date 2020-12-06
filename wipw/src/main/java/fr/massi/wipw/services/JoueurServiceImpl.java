package fr.massi.wipw.services;


import fr.massi.wipw.models.Joueur;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class JoueurServiceImpl implements  JoueurService{

    @Autowired
    private EntityManagerFactory emFactory;


    @Override
    public Joueur getJoueurWithName(String name) {
        Session session = emFactory.unwrap(Session.class);
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Joueur> query = builder.createQuery(Joueur.class);
        Root<Joueur> root = query.from(Joueur.class);

        query.select(root).where(builder.equal(root.get("nom"),name));

        Query<Joueur> joueurs = session.createQuery(query);
        List<Joueur> results = joueurs.getResultList();

        return  results.get(0);
    }
}
