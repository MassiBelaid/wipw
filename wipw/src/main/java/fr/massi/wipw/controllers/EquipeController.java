package fr.massi.wipw.controllers;


import fr.massi.wipw.models.Equipe;
import fr.massi.wipw.repositories.EquipeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/equipes")
public class EquipeController {

    @Autowired
    private EquipeRepository equipeRepository;

    @GetMapping
    public List<Equipe> getEquipes(){
        return equipeRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Equipe> get(@PathVariable Long id){
        Optional<Equipe> equipeCherchee = equipeRepository.findById(id);

        if(equipeCherchee.isPresent()){
            return new ResponseEntity<Equipe>(equipeCherchee.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipe delete(@RequestBody final Equipe equipe){
        return equipeRepository.saveAndFlush(equipe);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        equipeRepository.deleteById(id);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Equipe> update(@PathVariable Long id, @RequestBody Equipe equipe){
        Optional<Equipe> equipeCherchee = equipeRepository.findById(id);

        if(equipeCherchee.isPresent()){
            Equipe equipeEx = equipeCherchee.get();
            BeanUtils.copyProperties(equipe, equipeEx, "id_equipe");
            equipeRepository.saveAndFlush(equipeEx);

            return new ResponseEntity<Equipe>(equipeEx, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
