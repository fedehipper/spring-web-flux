package com.example.servidorpersona.web.controller.rest;

import com.example.servidorpersona.domain.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaRestController {

    @GetMapping("/api/persona")
    public Persona buscarPersonaPorCuil(@RequestParam String dni) throws InterruptedException {

        Thread.sleep(2000L);

        return crearPersona(dni);

    }

    private Persona crearPersona(String dni) {
        Persona persona = new Persona();
        persona.setApellido("Hipperdinger");
        persona.setNombre("Federico");
        persona.setEdad("28");
        persona.setDni(dni);
        return persona;
    }

}
