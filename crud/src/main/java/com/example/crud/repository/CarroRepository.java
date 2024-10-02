package com.example.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.model.Carro;

@Repository
public interface CarroRepository extends MongoRepository<Carro, String> {
}
