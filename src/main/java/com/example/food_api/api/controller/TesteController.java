package com.example.food_api.api.controller;

import com.example.food_api.domain.model.Cozinha;
import com.example.food_api.domain.model.Restaurante;
import com.example.food_api.domain.repository.CozinhaRepository;
import com.example.food_api.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static com.example.food_api.infrastructure.spec.RestauranteSpecs.comFreteGratis;
import static com.example.food_api.infrastructure.spec.RestauranteSpecs.comNomeSemelhante;

@RestController
@RequestMapping(value = "/teste")
public class TesteController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/cozinhas/por-nome")
    public List<Cozinha> cozinhasPorNome(@RequestParam("nome") String nome) {
        return cozinhaRepository.findTodasByNomeContaining(nome);
    }

    @GetMapping("/cozinhas/primeiro")
    public Optional<Cozinha> cozinhaPrimeiro() {
        return cozinhaRepository.buscarPrimeiro();
    }

    @GetMapping("/restaurantes/por-taxa-frete")
    public List<Restaurante> restaurantesPorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal) {
        return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
    }

    @GetMapping("/restaurantes/por-nome")
    public List<Restaurante> restaurantesPorNome(String nome, Long cozinhaId) {
        return restauranteRepository.consultarPorNome(nome, cozinhaId);
    }

    @GetMapping("/restaurantes/primeiro-por-nome")
    public Optional<Restaurante> primeiroRestaurante(String nome) {
        return restauranteRepository.findFirstByNomeContaining(nome);
    }

    @GetMapping("/restaurantes/top2-por-nome")
    public List<Restaurante> restauranteTop2PorNome(String nome) {
        return restauranteRepository.findTop2ByNomeContaining(nome);
    }

    @GetMapping("/cozinhas/existe-por-nome")
    public boolean cozinhaExists(@RequestParam("nome") String nome) {
        return cozinhaRepository.existsByNome(nome);
    }

    @GetMapping("/restaurantes/com-frete-gratis")
    public List<Restaurante> restaurantesComFreteGratis(String nome) {
        return restauranteRepository.findComFreteGratis(nome);
    }

    @GetMapping("/restaurantes/primeiro")
    public Optional<Restaurante> restaurantePrimeiro() {
        return restauranteRepository.buscarPrimeiro();
    }


}
