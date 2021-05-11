package com.revature.superboot;

import java.util.ArrayList;
import java.util.List;

import com.revature.superboot.models.Person;
import com.revature.superboot.repositories.TrainerRepository;

public class MockTrainerRepository extends TrainerRepository{
    @Override
    public List<Person> getAll() {
        return new ArrayList<Person>();
    }
}
