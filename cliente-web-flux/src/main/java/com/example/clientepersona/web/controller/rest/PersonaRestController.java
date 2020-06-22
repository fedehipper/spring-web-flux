package com.example.clientepersona.web.controller.rest;

import com.example.clientepersona.business.service.PersonaService;
import com.example.clientepersona.vo.DetallePersonaVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PersonaRestController {

    private final PersonaService personaService;

    public PersonaRestController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/api/detalle-persona")
    public  Mono<DetallePersonaVo> PersonaRestController(
            @RequestParam String numeroLinea, 
            @RequestParam String numeroTarjeta, 
            @RequestParam String dni) {
        return personaService.buscar(numeroLinea, numeroTarjeta, dni);
    }

}
