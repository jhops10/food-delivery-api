package com.example.food_api.domain.repository;

import com.example.food_api.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {


   //List<Cozinha> consultarPorNome(String nome);


}
