package br.com.fiap.corebank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {
        return """
                Nome do projeto: corebank
                Integrantes: Rodrigo Yamasaki
                """;
    }
}
