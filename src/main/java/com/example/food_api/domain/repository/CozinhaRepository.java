package com.example.food_api.domain.repository;

import com.example.food_api.domain.model.Cozinha;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CozinhaRepository extends CustomJpaRepository<Cozinha, Long> {


   List<Cozinha> findTodasByNomeContaining(String nome);

   boolean existsByNome(String nome);


}
