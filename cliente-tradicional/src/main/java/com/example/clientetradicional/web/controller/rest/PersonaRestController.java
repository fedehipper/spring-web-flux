package com.example.clientetradicional.web.controller.rest;

import com.example.clientetradicional.business.service.PersonaService;
import com.example.clientetradicional.vo.DetallePersonaVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaRestController {

    private final PersonaService personaService;

    public PersonaRestController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/api/detalle-persona")
    public DetallePersonaVo PersonaRestController(
            @RequestParam String numeroLinea, 
            @RequestParam String numeroTarjeta, 
            @RequestParam String dni) {
        return personaService.buscar(numeroLinea, numeroTarjeta, dni);
    }

}
