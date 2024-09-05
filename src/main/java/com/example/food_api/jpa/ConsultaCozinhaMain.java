package com.example.food_api.jpa;


import com.example.food_api.FoodApiApplication;
import com.example.food_api.domain.model.Cozinha;
import com.example.food_api.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCozinhaMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);

        List<Cozinha> cozinhas = cozinhaRepository.findAll();

        for(Cozinha cozinha : cozinhas) {
            System.out.println(cozinha.getNome());
        }
    }
}
