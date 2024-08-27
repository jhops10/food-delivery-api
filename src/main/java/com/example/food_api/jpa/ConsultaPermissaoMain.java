package com.example.food_api.jpa;

import com.example.food_api.FoodApiApplication;
import com.example.food_api.domain.model.FormaPagamento;
import com.example.food_api.domain.model.Permissao;
import com.example.food_api.domain.repository.FormaPagamentoRepository;
import com.example.food_api.domain.repository.PermissaoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaPermissaoMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        PermissaoRepository permissaoRepository = applicationContext.getBean(PermissaoRepository.class);

        List<Permissao> todasPermissoes = permissaoRepository.listar();

        for (Permissao permissao : todasPermissoes) {
            System.out.printf("%s - %s\n", permissao.getNome(), permissao.getDescricao());
        }
    }
}
