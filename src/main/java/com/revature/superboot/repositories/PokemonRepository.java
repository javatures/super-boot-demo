package com.revature.superboot.repositories;

import java.util.List;

import com.revature.superboot.models.Pokemon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    List<Pokemon> findByName(String name);
}
