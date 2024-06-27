package org.matt.restmongo.restfulmongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FootballerRepo extends MongoRepository<Footballer,Long> {
    List<Footballer> getByFirstName(String FirstName);
    Footballer getByShirtNumber(int num);
    List<Footballer> getByPosition(String pos);
    void deleteByShirtNumber(int num);

}
