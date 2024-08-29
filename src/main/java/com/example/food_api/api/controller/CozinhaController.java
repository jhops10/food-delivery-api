package com.example.food_api.api.controller;

import com.example.food_api.domain.model.Cozinha;
import com.example.food_api.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping
    public List<Cozinha> listar() {
        return cozinhaRepository.listar();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long id) {
        Cozinha cozinha =  cozinhaRepository.buscar(id);

        if (cozinha != null) {
            return ResponseEntity.ok(cozinha);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
