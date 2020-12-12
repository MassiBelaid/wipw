package fr.massi.wipw.controllers;


import fr.massi.wipw.models.Joueur;
import fr.massi.wipw.repositories.JoueurRepository;
import fr.massi.wipw.services.JoueurService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/joueurs")
public class JoueurController {

    @Autowired
    private JoueurRepository joueurRepository;

    @Autowired
    private JoueurService joueurService;



    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Joueur> getJoueurs(){
        return  joueurRepository.findAll();
    }


    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Joueur> get(@PathVariable Long id){
        Optional<Joueur> joueurCherche = joueurRepository.findById(id);

        if(joueurCherche.isPresent()){
            return new ResponseEntity<Joueur>(joueurCherche.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping
    @RequestMapping("nom/{nom}")
    public ResponseEntity<List<Joueur>> getWithName(@PathVariable String nom){
        System.out.println("joueur avec nom == "+nom);
        List<Joueur> joueurs =  joueurRepository.findByNom(nom);

        return new ResponseEntity<List<Joueur>>(joueurs, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Joueur create(@RequestBody final Joueur joueur){
        return joueurRepository.saveAndFlush(joueur);
    }



    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        joueurRepository.deleteById(id);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Joueur> update(@PathVariable Long id, @RequestBody Joueur joueur){
        Optional<Joueur> existingJoueur = joueurRepository.findById(id);
        if(existingJoueur.isPresent()){
            Joueur joueurEx = existingJoueur.get();

            BeanUtils.copyProperties(joueur, joueurEx, "id_joueur");
            joueurRepository.saveAndFlush(joueurEx);
            return new ResponseEntity<Joueur>(joueurEx, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


}
