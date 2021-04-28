package com.revature.superboot.controllers;

import java.util.List;

import com.revature.superboot.models.Pokemon;
import com.revature.superboot.repositories.PokemonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pokemon")
public class PokemonController {
    @Autowired
    PokemonRepository pokemonRepository;

    @GetMapping
    public List<Pokemon> getAll() {
        return pokemonRepository.findAll();
    }

    @GetMapping(params = "name")
    public List<Pokemon> getByName(@RequestParam(name="name") String name) {
        return pokemonRepository.findByName(name);
    }

    @PostMapping
    public Pokemon newPokemon(@RequestBody Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }
}
