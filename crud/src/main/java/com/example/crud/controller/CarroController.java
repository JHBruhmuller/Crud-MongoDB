package com.example.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.model.Carro;
import com.example.crud.service.CarroService;

@RestController
@RequestMapping("/api/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    // Listar todos os carros (GET)
    @GetMapping
    public ResponseEntity<List<Carro>> listCarros() {
        List<Carro> carros = carroService.getAllCarros();
        return new ResponseEntity<>(carros, HttpStatus.OK);
    }

    // Buscar carro por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Carro> getCarroById(@PathVariable String id) {
        Optional<Carro> carro = carroService.getCarroById(id);
        return carro.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Criar novo carro (POST)
    @PostMapping
    public ResponseEntity<Carro> createCarro(@RequestBody Carro carro) {
        Carro newCarro = carroService.saveCarro(carro);
        return new ResponseEntity<>(newCarro, HttpStatus.CREATED);
    }

    // Atualizar carro (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Carro> updateCarro(@PathVariable String id, @RequestBody Carro carro) {
        Optional<Carro> existingCarro = carroService.getCarroById(id);
        if (existingCarro.isPresent()) {
            carro.setId(id); // Manter o mesmo ID do carro ao atualizar
            Carro updatedCarro = carroService.saveCarro(carro);
            return new ResponseEntity<>(updatedCarro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Deletar carro (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarro(@PathVariable String id) {
        Optional<Carro> existingCarro = carroService.getCarroById(id);
        if (existingCarro.isPresent()) {
            carroService.deleteCarro(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}