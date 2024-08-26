package com.example.food_api.jpa;


import com.example.food_api.FoodApiApplication;
import com.example.food_api.domain.model.Cozinha;
import com.example.food_api.domain.model.Restaurante;
import com.example.food_api.domain.repository.CozinhaRepository;
import com.example.food_api.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaRestauranteMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

        List<Restaurante> restaurantes = restauranteRepository.listar();

        for(Restaurante restaurante : restaurantes) {
            System.out.printf("%s - %f - %s\n",restaurante.getNome(), restaurante.getTaxaFrete(), restaurante.getCozinha().getNome());
        }
    }
}
