package com.willner.mist_gaming_store.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/teste")  // http://localhost:8080/teste
public class TesteController {
    /**
     * MÉTODOS DE REQUISIÇÃO/ACESSO HTTP
     * GET: Buscar informação
     * POST: Adicionar dado/informação
     * PUT: Alterar dado/informação
     * DELETE: Remover dado/informação
     * PATCH: Alterar somente uma parte do dado/informação
     *
     */
    @GetMapping("/ping")  // GET http://localhost:8080/teste/hello-world
    public String ping() {
        return "pong";
    }
}
