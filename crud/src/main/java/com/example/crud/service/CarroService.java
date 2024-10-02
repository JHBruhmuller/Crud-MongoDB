package com.example.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.model.Carro;
import com.example.crud.repository.CarroRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    // criar ou atualizar
    public Carro saveCarro(Carro carro) {
        return carroRepository.save(carro);
    }

    // listar todos
    public List<Carro> getAllCarros() {
        return carroRepository.findAll();
    }

    // buscar por id
    public Optional<Carro> getCarroById(String id) {
        return carroRepository.findById(id);
    }

    // deletar
    public void deleteCarro(String id) {
        carroRepository.deleteById(id);
    }
}