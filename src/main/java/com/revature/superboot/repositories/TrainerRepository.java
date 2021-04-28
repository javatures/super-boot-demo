package com.revature.superboot.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.revature.superboot.models.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TrainerRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public List<Person> getAll() {
        return entityManager.createQuery("from Person", Person.class).getResultList();
    }

    @Transactional
    public Person postTrainer(Person trainer) {
        Person newTrainer = trainer;
        entityManager.persist(newTrainer.getPokemon());
        entityManager.persist(newTrainer);
        return newTrainer;
    }
}
