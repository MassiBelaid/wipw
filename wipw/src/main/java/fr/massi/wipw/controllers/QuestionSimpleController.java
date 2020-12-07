package fr.massi.wipw.controllers;

import fr.massi.wipw.models.QuestionSimple;
import fr.massi.wipw.repositories.QuestionSimpleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/squestions")
public class QuestionSimpleController {

    @Autowired
    private QuestionSimpleRepository questionSimpleRepository;



    @GetMapping
    public List<QuestionSimple> getQuestions(){
        return questionSimpleRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<QuestionSimple> get(@PathVariable Long id){
        Optional<QuestionSimple> questionCherchee = questionSimpleRepository.findById(id);

        if(questionCherchee.isPresent()){
            return new ResponseEntity<QuestionSimple>(questionCherchee.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QuestionSimple delete(@RequestBody final QuestionSimple questionSimple){
        return questionSimpleRepository.saveAndFlush(questionSimple);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        questionSimpleRepository.deleteById(id);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<QuestionSimple> update(@PathVariable Long id, @RequestBody QuestionSimple questionSimple){
        Optional<QuestionSimple> questionCherchee = questionSimpleRepository.findById(id);

        if(questionCherchee.isPresent()){
            QuestionSimple questEx = questionCherchee.get();
            BeanUtils.copyProperties(questionSimple, questEx, "id_question");
            questionSimpleRepository.saveAndFlush(questEx);

            return new ResponseEntity<QuestionSimple>(questEx, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
