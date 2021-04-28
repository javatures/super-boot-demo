package com.revature.superboot.controllers;

import java.util.List;

import com.revature.superboot.models.Person;
import com.revature.superboot.repositories.TrainerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class TrainerController {
    @Autowired
    private TrainerRepository trainerRepository;

    @GetMapping("trainers/all")
    @ResponseBody
    public List<Person> getAll() {
        return trainerRepository.getAll();
    }

    @RequestMapping(path = "trainers/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Person getOne(@PathVariable(name = "id") int id) {
        return null;
    }

    @PostMapping(path = "trainers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Person postOne(@RequestBody Person trainer) {
        return trainerRepository.postTrainer(trainer);
    }

    @GetMapping("trainers/hello/{name}")
    public ResponseEntity<String> helloTrainer(@PathVariable(name = "name") String name) {
        return ResponseEntity.ok("Hello, " + name);
    }

    @GetMapping("google")
    public String google() {
        return "redirect:https://www.google.com";
    }

    @GetMapping("home")
    public String forwardHome() {
        return "forward:/";
    }
}
