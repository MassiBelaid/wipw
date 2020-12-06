package fr.massi.wipw.controllers;


import fr.massi.wipw.models.Joue;
import fr.massi.wipw.repositories.JoueRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/joues")
public class JoueController {

    @Autowired
    JoueRepository joueRepository;

    @GetMapping
    public List<Joue> getJoues(){
        return  joueRepository.findAll();
    }


    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Joue> get(@PathVariable Long id){
        Optional<Joue> joueCherche = joueRepository.findById(id);

        if(joueCherche.isPresent()){
            //System.out.println("========================================"+joueCherche.get().getEquipe());
            return new ResponseEntity<Joue>(joueCherche.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Joue create(@RequestBody final Joue joue){
        return joueRepository.saveAndFlush(joue);
    }



    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        joueRepository.deleteById(id);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Joue> update(@PathVariable Long id, @RequestBody Joue joue){
        Optional<Joue> existingJoue = joueRepository.findById(id);
        if(existingJoue.isPresent()){
            Joue joueEx = existingJoue.get();

            BeanUtils.copyProperties(joue, joueEx, "id_joueur");
            joueRepository.saveAndFlush(joueEx);
            return new ResponseEntity<Joue>(joueEx, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
